package ken;

import java.io.OutputStreamWriter; 
import java.io.PrintWriter; 
import java.io.UnsupportedEncodingException;
import java.util.*;

import org.w3c.dom.Attr; 
import org.w3c.dom.Document; 
import org.w3c.dom.NamedNodeMap; 
import org.w3c.dom.Node; 
import org.w3c.dom.NodeList; 
import com.ibm.xml.parsers.*; 

public class xmlDocOperator {

  private String fileName;
  private Hashtable hashData = new Hashtable();
  private String[] array = new String[0];
  public xmlDocOperator() {
  }

  /**
  * 设置要解析的文件名称（包括路径）
  */
  public void setFileName(String _fileName){
    this.fileName = new String();
    this.fileName = _fileName;
  }

  /*
  *
  */
  public void parseFile(){
    Document doc = null;        
    try{
      DOMParser parser = new DOMParser();
      parser.parse(this.fileName);
      doc = parser.getDocument();
    }catch (Exception e){
      System.err.println("Sorry, an error occurred: " + e);
    }

    if (doc != null){
      //printDOMTree(doc);
      processDoc(doc);
    }else{
      System.out.println("Some Exception occured:can't not parse the file.");
    }
  }

  /*解析xml文件*/
  private void processDoc(Node node){
    //第一层的处理
    Node firstNode =  ((Document)node).getDocumentElement();
    System.out.println(firstNode.getNodeName());

    //第二层的处理
    NodeList secondNodes = firstNode.getChildNodes();
    int len = secondNodes.getLength();
    for (int i = 0; i < len; i++){
      Node currNode = secondNodes.item(i);
      /*将附加险列表存入到数组中去*/
      if (currNode.hasChildNodes() && currNode.getNodeName().equals("C_ADD_INSURANCES")){
				save2Array(currNode);
		        continue;
			}
      /*将其他的保单项存入到散列表中*/
			if (currNode.hasChildNodes()){				save2Hash(currNode);      }    }

  }

  private void save2Array(Node node){
		Node currElement = null;    int childCount = 0;		NodeList nodeList = node.getChildNodes();		if (nodeList != null){			for (int i=0;i<nodeList.getLength();i++){				currElement = nodeList.item(i);				if ( currElement.hasChildNodes()){          childCount ++;          System.out.println("Child's value is "+currElement.getFirstChild().getNodeValue());				}			}      array = new String[childCount];      childCount = 0;      for (int i=0;i<nodeList.getLength();i++){				currElement = nodeList.item(i);				if ( currElement.hasChildNodes()){					array[childCount] = currElement.getFirstChild().getNodeValue();          childCount ++;        }			}		}    //下面是调试打印    /*for(int i=0;i<array.length;i++){      System.out.println(array[i]);    }*/		return;  	}
	private void save2Hash(Node node){		String name = node.getNodeName();		String value = node.getFirstChild().getNodeValue();    hashData.put(name,value);    System.out.println("name is :"+name);    System.out.println("value is :"+value);		return;	}  /*  * 取得附加险的值  */  public String[] getInsuranceAddCodeList(){		return this.array;	}
  /*  * 取得其他信息  */	public Hashtable getPolicyHash(){		return this.hashData;        	}
  /*
  * For debug.
  */

  public static void main(String argv[])
  {
    xmlDocOperator d1 = new xmlDocOperator();
    d1.setFileName("simple.xml");
    d1.parseFile();
  }
  
}