////////////////////////////////////////////////////////
// Author:     ZhanYB
// Function:   packet header used in java call c module
// Update Date:2000/7/20
////////////////////////////////////////////////////////
// Change Log
//     Zhanyb: 10/25 Add new user case 22125;22120
//     Zhanyb: 11/14 Add new user case 22128
//     YiJF:   12/27 Add new user case 22105
//     YiJF:   04/16 Add new user case 22126
////////////////////////////////////////////////////////

package jtoc;

/**
 * PacketHead is a class corresponding with the
 * package header in c program
 * The structure of this will change if c structure
 * change
 *
 * @author 	  Jeb Zhan
 * @version 	%I%, %G%
 * @since     JDK1.3
 */

public class PacketHead{
    public java.lang.String iPacketID;     /* 服务ID         */
    public java.lang.String iRetPktID;     /* 处理的服务ID   */
    public java.lang.String lPacketSize;        /* 服务数据包大小 */
    public java.lang.String iRecordNum;       /* 包中记录的个数 */
    public java.lang.String iRecordSize;       /* 每个记录的长度 */
    public java.lang.String iPriority;          /* 服务的优先级   */
    public java.lang.String iServiceNo;        /* 服务类型的编号 */
    public java.lang.String cRetCode;         /* 服务的返回值   */
    public java.lang.String iReserved;          /* 保留未用      */
    public PacketHead(){}
    public PacketHead(String s_ipacketid,String s_iretpktid,
                           String s_lpacketsize,String s_irecordnum,
                           String s_irecordsize,String s_ipriority,
                           String s_iserviceno,String s_cretcode,
                           String s_ireserved){
          iPacketID=s_ipacketid;
          iRetPktID=s_iretpktid;
          lPacketSize=s_lpacketsize;
          iRecordNum=s_irecordnum;
          iRecordSize=s_irecordsize;
          iPriority=s_ipriority;
          iServiceNo=s_iserviceno;
          cRetCode=s_cretcode;
          iReserved=s_ireserved;
    }
    public PacketHead(String s_ipacketid,String s_irecordnum,String s_iserviceno){
          iPacketID=s_ipacketid;
          iRetPktID="";
          lPacketSize="";
          iRecordNum=s_irecordnum;
          iRecordSize="";
          iPriority="";
          iServiceNo=s_iserviceno;
          cRetCode="";
          iReserved="";
    }

    public PacketHead(String s_ipacketid){


        iRetPktID="";
        lPacketSize="";
        iRecordSize="";
        iPriority="";
        cRetCode="";
        iReserved="";

    //For acceptPrsnCust
        if (s_ipacketid==JCConstant.ACCEPTPRSNCUST_PACKET_ID){
            iPacketID=JCConstant.ACCEPTPRSNCUST_PACKET_ID;
            iRecordNum=JCConstant.ACCEPTPRSNCUST_RECORD_NUM;
            iServiceNo=JCConstant.ACCEPTPRSNCUST_SERVICE_NO;
        };
    //For aupdatePrsnCust
        if (s_ipacketid==JCConstant.UPDATEPRSNCUST_PACKET_ID){
            iPacketID=JCConstant.UPDATEPRSNCUST_PACKET_ID;
            iRecordNum=JCConstant.UPDATEPRSNCUST_RECORD_NUM;
            iServiceNo=JCConstant.UPDATEPRSNCUST_SERVICE_NO;
        };
    //For acceptOrgnCust
        if (s_ipacketid==JCConstant.ACCEPTORGACUST_PACKET_ID){
            iPacketID=JCConstant.ACCEPTORGACUST_PACKET_ID;
            iRecordNum=JCConstant.ACCEPTORGACUST_RECORD_NUM;
            iServiceNo=JCConstant.ACCEPTORGACUST_SERVICE_NO;
        };
    //For updateOrgnCust
        if (s_ipacketid==JCConstant.UPDATEORGACUST_PACKET_ID){
            iPacketID=JCConstant.UPDATEORGACUST_PACKET_ID;
            iRecordNum=JCConstant.UPDATEORGACUST_RECORD_NUM;
            iServiceNo=JCConstant.UPDATEORGACUST_SERVICE_NO;
        };


    //For acceptPolicyApp
        if (s_ipacketid==JCConstant.ACCEPTPOLICYAPP_PACKET_ID){
            iPacketID=JCConstant.ACCEPTPOLICYAPP_PACKET_ID;
            iRecordNum=JCConstant.ACCEPTPOLICYAPP_RECORD_NUM;
            iServiceNo=JCConstant.ACCEPTPOLICYAPP_SERVICE_NO;
        };

    //For updatePolicyApp
        if (s_ipacketid==JCConstant.UPDATEPOLICYAPP_PACKET_ID){
            iPacketID=JCConstant.UPDATEPOLICYAPP_PACKET_ID;
            iRecordNum=JCConstant.UPDATEORGACUST_RECORD_NUM;
            iServiceNo=JCConstant.UPDATEPOLICYAPP_SERVICE_NO;
        };


    //For confirmPolicyAppProposal
        if (s_ipacketid==JCConstant.CONFIRMPOLICYAPP_PACKET_ID){
            iPacketID=JCConstant.CONFIRMPOLICYAPP_PACKET_ID;
            iRecordNum=JCConstant.CONFIRMPOLICYAPP_RECORD_NUM;
            iServiceNo=JCConstant.CONFIRMPOLICYAPP_SERVICE_NO;
//          iReserved=JCConstant.CONFIRMPOLICYAPP_RESERVED;
        };

    //For withdrawalPolicyApp
        if (s_ipacketid==JCConstant.WITHDRAWALPOLICYAPP_PACKET_ID){
            iPacketID=JCConstant.WITHDRAWALPOLICYAPP_PACKET_ID;
            iRecordNum=JCConstant.WITHDRAWALPOLICYAPP_RECORD_NUM;
            iServiceNo=JCConstant.WITHDRAWALPOLICYAPP_SERVICE_NO;
        };

    //For acceptReportCase
        if (s_ipacketid==JCConstant.ACCEPTCASEREPORT_PACKET_ID){
            iPacketID=JCConstant.ACCEPTCASEREPORT_PACKET_ID ;
            iRecordNum=JCConstant.ACCEPTCASEREPORT_RECORD_NUM;
            iServiceNo=JCConstant.ACCEPTCASEREPORT_SERVICE_NO;
        };

    //For add policy endorsement
        if (s_ipacketid==JCConstant.ADDPOLICYEDR_PACKET_ID){
            iPacketID=JCConstant.ADDPOLICYEDR_PACKET_ID ;
            iRecordNum=JCConstant.ADDPOLICYEDR_RECORD_NUM;
            iServiceNo=JCConstant.ADDPOLICYEDR_SERVICE_NO;
        };

    //For get policy endorsement
        if (s_ipacketid==JCConstant.GETPOLICYFOREDR_PACKET_ID){
            iPacketID=JCConstant.GETPOLICYFOREDR_PACKET_ID ;
            iRecordNum=JCConstant.GETPOLICYFOREDR_RECORD_NUM;
            iServiceNo=JCConstant.GETPOLICYFOREDR_SERVICE_NO;
        };

    //For withdrawal policy endorsement
        if (s_ipacketid==JCConstant.WITHDRAWALPLYFOREDR_PACKET_ID ){
            iPacketID=JCConstant.WITHDRAWALPLYFOREDR_PACKET_ID ;
            iRecordNum=JCConstant.WITHDRAWALPLYFOREDR_RECORD_NUM;
            iServiceNo=JCConstant.WITHDRAWALPLYFOREDR_SERVICE_NO;
        };


    //For get edrappinfo for update endorsement
        if (s_ipacketid==JCConstant.GETEDRAPPINFO_PACKET_ID){
            iPacketID=JCConstant.GETEDRAPPINFO_PACKET_ID;
            iRecordNum=JCConstant.GETEDRAPPINFO_RECORD_NUM;
            iServiceNo=JCConstant.GETEDRAPPINFO_SERVICE_NO;
        };

    //For deletePolicyApp
        if (s_ipacketid==JCConstant.DELETEPOLICYAPP_PACKET_ID){
            iPacketID=JCConstant.DELETEPOLICYAPP_PACKET_ID;
            iRecordNum=JCConstant.DELETEPOLICYAPP_RECORD_NUM;
            iServiceNo=JCConstant.DELETEPOLICYAPP_SERVICE_NO;
        };

    //For withdrawal policy endorsement
        if (s_ipacketid==JCConstant.DELETEPLYFOREDR_PACKET_ID ){
            iPacketID=JCConstant.DELETEPLYFOREDR_PACKET_ID ;
            iRecordNum=JCConstant.DELETEPLYFOREDR_RECORD_NUM;
            iServiceNo=JCConstant.DELETEPLYFOREDR_SERVICE_NO;
        };

	//For print policy 
        if (s_ipacketid.equals(JCConstant.GETPRINTINFO_PACKET_ID)){
            iPacketID=JCConstant.GETPRINTINFO_PACKET_ID ;
            iRecordNum=JCConstant.GETPRINTINFO_RECORD_NUM;
            iServiceNo=JCConstant.GETPRINTINFO_SERVICE_NO;
        };

	//For print policy format 
        if (s_ipacketid.equals(JCConstant.GETPRINTFMT_PACKET_ID)){
            iPacketID=JCConstant.GETPRINTFMT_PACKET_ID ;
            iRecordNum=JCConstant.GETPRINTFMT_RECORD_NUM;
            iServiceNo=JCConstant.GETPRINTFMT_SERVICE_NO;
        };
    }


}
