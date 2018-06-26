////////////////////////////////////////////////////////
// Author:     ZhanYB
// Function:   Provide const define in java to c module
// Update Date:2000/09/12
////////////////////////////////////////////////////////
// Change Log
//     Zhanyb: 10/25 Add new user case 22125;22120
//     Zhanyb: 11/14 Add new user case 22128
//     YiJF:   12/27 Add new user case 22105
//     YiJF:   04/16 Add new user case 22126
////////////////////////////////////////////////////////

package jtoc;

/**
 * JCConstant is a class used to stored the constant
 * used in jtoc package.So the module can easily be
 * maintained
 *
 * @author 	  Jeb Zhan
 * @version 	%I%, %G%
 * @since     JDK1.3
 */


public class JCConstant
{

    public static final boolean JTOC_DEBUGINFO=false;

    ////////////////////////////////////////////////////////
    // Data Packet header constant defination
    ////////////////////////////////////////////////////////

    //For acceptPrsnCust
    public static final String ACCEPTPRSNCUST_PACKET_ID="13003";
    public static final String ACCEPTPRSNCUST_RECORD_NUM="1";
    public static final String ACCEPTPRSNCUST_SERVICE_NO="13";
    //For aupdatePrsnCust
    public static final String UPDATEPRSNCUST_PACKET_ID="13004";
    public static final String UPDATEPRSNCUST_RECORD_NUM="1";
    public static final String UPDATEPRSNCUST_SERVICE_NO="13";
    //For acceptOrgnCust
    public static final String ACCEPTORGACUST_PACKET_ID="13008";
    public static final String ACCEPTORGACUST_RECORD_NUM="1";
    public static final String ACCEPTORGACUST_SERVICE_NO="13";
    //For updateOrgnCust
    public static final String UPDATEORGACUST_PACKET_ID="13009";
    public static final String UPDATEORGACUST_RECORD_NUM="1";
    public static final String UPDATEORGACUST_SERVICE_NO="13";


    //For acceptPolicyApp
    public static final String ACCEPTPOLICYAPP_PACKET_ID="22151";
    public static final String ACCEPTPOLICYAPP_RECORD_NUM="1";
    public static final String ACCEPTPOLICYAPP_SERVICE_NO="10";

    public static final String C_SEND_DPT_CDE="01";


    //For updatePolicyApp
    public static final String UPDATEPOLICYAPP_PACKET_ID="22151";
    public static final String UPDATEPOLICYAPP_RECORD_NUM="1";
    public static final String UPDATEPOLICYAPP_SERVICE_NO="10";

    //For confirmPolicyAppProposal
    public static final String CONFIRMPOLICYAPP_PACKET_ID="22114";
    public static final String CONFIRMPOLICYAPP_RECORD_NUM="1";
    public static final String CONFIRMPOLICYAPP_SERVICE_NO="10";
    public static final String CONFIRMPOLICYAPP_RESERVED="1";


    //For withdrawalPolicyApp
    public static final String WITHDRAWALPOLICYAPP_PACKET_ID="22106";
    public static final String WITHDRAWALPOLICYAPP_RECORD_NUM="1";
    public static final String WITHDRAWALPOLICYAPP_SERVICE_NO="10";

    //For accept case report
    public static final String ACCEPTCASEREPORT_PACKET_ID="2024";
    public static final String ACCEPTCASEREPORT_RECORD_NUM="1";
    public static final String ACCEPTCASEREPORT_SERVICE_NO="11";

    //For add policy endorsement
    public static final String ADDPOLICYEDR_PACKET_ID="22125";
    public static final String ADDPOLICYEDR_RECORD_NUM="1";
    public static final String ADDPOLICYEDR_SERVICE_NO="10";

    //For get policy endorsement
    public static final String GETPOLICYFOREDR_PACKET_ID="22120";
    public static final String GETPOLICYFOREDR_RECORD_NUM="1";
    public static final String GETPOLICYFOREDR_SERVICE_NO="10";

    //For withdrawal policy endorsement
    public static final String WITHDRAWALPLYFOREDR_PACKET_ID="22128";
    public static final String WITHDRAWALPLYFOREDR_RECORD_NUM="1";
    public static final String WITHDRAWALPLYFOREDR_SERVICE_NO="10";

    //For get edrappinfo for update endorsement
    public static final String GETEDRAPPINFO_PACKET_ID="22123";
    public static final String GETEDRAPPINFO_RECORD_NUM="1";
    public static final String GETEDRAPPINFO_SERVICE_NO="10";

    //For deletePolicyApp
    public static final String DELETEPOLICYAPP_PACKET_ID="22105";
    public static final String DELETEPOLICYAPP_RECORD_NUM="1";
    public static final String DELETEPOLICYAPP_SERVICE_NO="10";

    //For cancel or delete policy endorsement
    public static final String DELETEPLYFOREDR_PACKET_ID="22126";
    public static final String DELETEPLYFOREDR_RECORD_NUM="1";
    public static final String DELETEPLYFOREDR_SERVICE_NO="10";

	//For get policy print info
	public static final String GETPRINTINFO_PACKET_ID="22660";
	public static final String GETPRINTINFO_RECORD_NUM="1";
	public static final String GETPRINTINFO_SERVICE_NO="14";

	//For get policy print format
	public static final String GETPRINTFMT_PACKET_ID="22669";
	public static final String GETPRINTFMT_RECORD_NUM="0";
	public static final String GETPRINTFMT_SERVICE_NO="12";
}
