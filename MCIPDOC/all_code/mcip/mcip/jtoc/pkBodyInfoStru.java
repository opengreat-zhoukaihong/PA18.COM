package jtoc;

public class pkBodyInfoStru{
    public java.lang.String NPktNum0;
    public java.lang.String NPktNum1;
    public java.lang.String NPktNum2;
    public java.lang.String NPktNum3;
    public java.lang.String NPktNum4;
    public java.lang.String NPktNum5;
    public java.lang.String NPktNum6;
    public java.lang.String NPktNum7;
    public java.lang.String NPktNum8;
    public java.lang.String NPktNum9;
    public java.lang.String NPktNum10;
    public java.lang.String NPktNum11;        
    public java.lang.String NPktNum12;
    public java.lang.String NPktNum13;
    public java.lang.String NPktNum14;
    public java.lang.String NPktNum15;
    public java.lang.String NPktNum16;
    public java.lang.String NPktNum17;
    public java.lang.String NPktNum18;
    public java.lang.String NPktNum19;


    public pkBodyInfoStru(){
        NPktNum0="";
        NPktNum1="";
        NPktNum2="";
        NPktNum3="";
        NPktNum4="";
        NPktNum5="";
        NPktNum6="";
        NPktNum7="";
        NPktNum8="";
        NPktNum9="";
        NPktNum10="";
        NPktNum11="";        
        NPktNum12="";
        NPktNum13="";        
        NPktNum14="";
        NPktNum15="";        
        NPktNum16="";        
        NPktNum17="";
        NPktNum18="";        
        NPktNum19="";
    }

//Accept or Update Policy
    public pkBodyInfoStru(String Num8_plyRdrStruCnt){
        this();
        NPktNum0="1";
        NPktNum1="1";
        NPktNum2="1";
        NPktNum9="1";
        NPktNum13="1";
        NPktNum8=Num8_plyRdrStruCnt;
    }

    public pkBodyInfoStru(int position,String value) throws Exception{
        this();
        switch (position){
               case 0:
                    NPktNum0=value;break;
               case 1:
                    NPktNum1=value;break;
               case 2:
                    NPktNum2=value;break;
               case 3:
                    NPktNum3=value;break;
               case 4:
                    NPktNum4=value;break;
               case 5:
                    NPktNum5=value;break;
               case 6:
                    NPktNum6=value;break;
               case 7:
                    NPktNum7=value;break;
               case 8:
                    NPktNum8=value;break;
               case 9:
                    NPktNum9=value;break;
               case 10:
                    NPktNum10=value;break;
               case 11:
                    NPktNum11=value;break;
               case 12:
                    NPktNum12=value;break;
               case 13:
                    NPktNum13=value;break;
               case 14:
                    NPktNum14=value;break;
               case 15:
                    NPktNum15=value;break;
               case 16:
                    NPktNum16=value;break;
               case 17:
                    NPktNum17=value;break;
               case 18:
                    NPktNum18=value;break;
               case 19:
                    NPktNum19=value;break;
               default:
                    throw new Exception("Input position parameters error");
        }

    }
    

//Withdrawal policy
    public pkBodyInfoStru(int[] position,String[] value) throws Exception{
        this();
        if (position.length!=value.length){
           throw new Exception("Input array length are not the same!");
        }
        for (int i=0;i<position.length;i++){
            switch (position[i]){
               case 0:
                    NPktNum0=value[i];break;
               case 1:
                    NPktNum1=value[i];break;
               case 2:
                    NPktNum2=value[i];break;
               case 3:
                    NPktNum3=value[i];break;
               case 4:
                    NPktNum4=value[i];break;
               case 5:
                    NPktNum5=value[i];break;
               case 6:
                    NPktNum6=value[i];break;
               case 7:
                    NPktNum7=value[i];break;
               case 8:
                    NPktNum8=value[i];break;
               case 9:
                    NPktNum9=value[i];break;
               case 10:
                    NPktNum10=value[i];break;
               case 11:
                    NPktNum11=value[i];break;
               case 12:
                    NPktNum12=value[i];break;
               case 13:
                    NPktNum13=value[i];break;
               case 14:
                    NPktNum14=value[i];break;
               case 15:
                    NPktNum15=value[i];break;
               case 16:
                    NPktNum16=value[i];break;
               case 17:
                    NPktNum17=value[i];break;
               case 18:
                    NPktNum18=value[i];break;
               case 19:
                    NPktNum19=value[i];break;
               default:
                    throw new Exception("Input position parameters error");
            }
        }
    }           

}
