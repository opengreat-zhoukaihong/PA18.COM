////////////////////////////////////////////////////////
// Change Log
//     YiJF: 10/23 Create for Policy Modifying Apply
////////////////////////////////////////////////////////

package jtoc;

public class plyEdrGridStru{
    public java.lang.String c_crt_cde;     /*创建人员*/
    public java.lang.String c_crt_tm;      /*创建时间*/
    public java.lang.String c_upd_cde;     /*修改人员*/
    public java.lang.String c_upd_tm;      /*修改时间*/
    public java.lang.String c_edr_app_no;  /*单据号*/
    public java.lang.String c_send_tm;     /*发送时间*/
    public java.lang.String c_dpt_cde;     /*所属机构*/
    public java.lang.String c_source;      /*产生源[0]='0'*/
    public java.lang.String c_send_dpt_cde;/*网站编码*/
    public java.lang.String c_send_cde;    /*发送人*/
    public java.lang.String c_des_dpt_cde; /*目标机构*/
    public java.lang.String c_emergency;   /*紧急程度*/
    public java.lang.String c_authprn_cde; /*授权人*/
    public java.lang.String c_udr_mrk;     /*核保标志*/
    public java.lang.String c_send_mrk;    /*发送标志*/
    public java.lang.String c_udr_opn_mrk; /*核保意见标志*/
    public java.lang.String c_vrfy_mrk;    /*审核标志*/
    public java.lang.String c_mdfy_tm;     /*修改时间*/
    public java.lang.String c_insrnc_cde;  /*险种*/
    public java.lang.String c_undr_prsn;   /*核保人*/
    public java.lang.String c_undr_dpt;    /*核保机构*/
    public java.lang.String c_prn_typ;     /*单证类型[0]='5'*/
    public java.lang.String c_rinsrnc_mrk; /*分保类型*/
    public java.lang.String c_coinsrnc_mrk;/*共保标志*/
    public java.lang.String c_ply_no;      /*保单号*/
    public java.lang.String c_edr_no;      /*批单号*/
    public java.lang.String c_read_tm;     /*读取时间， 用于并发控制*/
    public java.lang.String c_rec_no;      /*暂存记录号*/
//    public java.lang.String c_work_mrk;    /*工作栏标志	0-暂存,1-待修改，2-已申请核保*/
    public java.lang.String c_flag;        /*提交处理标志=2*/
    public java.lang.String c_insrnc_dfn_typ; /*(险种表)险种定义类别*/
    public java.lang.String c_insrnc_cnm;   /*(险种表)险种中文名称*/
    public java.lang.String c_edr_typ;      /*(申请单主档)批改类型*/
    public java.lang.String c_app_nme;      /*(申请单主档)投保人名称*/
    public java.lang.String n_amt;          /*(申请单主档)保险金额*/
    public java.lang.String t_sign_tm;      /*签单日期*/
    public java.lang.String c_rpt_desc;    /*上报说明*/
    public java.lang.String c_risk_lvl_cde;/*风险等级代码*/
    public java.lang.String c_lcn_no;      /*牌照号码*/
    public java.lang.String c_eng_no;      /*发动机号*/
    public java.lang.String c_insrnc_cls;  /*险种大类*/
//    public java.lang.String c_app_typ;     /*投保分类*/
    public java.lang.String c_use_atr;     /*使用性质*/
    public java.lang.String c_undr_opn;    /*核保意见*/
    public java.lang.String c_internet_typ;/*网上业务标志[0]='1'*/

    public plyEdrGridStru(){}

    public plyEdrGridStru(String nullstring){

          c_crt_cde="";     /*创建人员*/
          c_crt_tm="";      /*创建时间*/
          c_upd_cde="";     /*修改人员*/
          c_upd_tm="";      /*修改时间*/
          c_edr_app_no="";  /*单据号*/
          c_send_tm="";     /*发送时间*/
          c_dpt_cde="";     /*所属机构*/
          c_source="";      /*产生源[0]='0'*/
          c_send_dpt_cde="";/*网站编码*/
          c_send_cde="";    /*发送人*/
          c_des_dpt_cde=""; /*目标机构*/
          c_emergency="";   /*紧急程度*/
          c_authprn_cde=""; /*授权人*/
          c_udr_mrk="";     /*核保标志*/
          c_send_mrk="";    /*发送标志*/
          c_udr_opn_mrk=""; /*核保意见标志*/
          c_vrfy_mrk="";    /*审核标志*/
          c_mdfy_tm="";     /*修改时间*/
          c_insrnc_cde="";  /*险种*/
          c_undr_prsn="";   /*核保人*/
          c_undr_dpt="";    /*核保机构*/
          c_prn_typ="";     /*单证类型[0]='5'*/
          c_rinsrnc_mrk=""; /*分保类型*/
          c_coinsrnc_mrk="";/*共保标志*/
          c_ply_no="";      /*保单号*/
          c_edr_no="";      /*批单号*/
          c_read_tm="";     /*读取时间， 用于并发控制*/
          c_rec_no="";      /*暂存记录号*/
//          c_work_mrk="";    /*工作栏标志	0-暂存,1-待修改，2-已申请核保*/
          c_flag="";        /*提交处理标志=2*/
          c_insrnc_dfn_typ="";/*(险种表)险种定义类别*/
          c_insrnc_cnm="";    /*(险种表)险种中文名称*/
          c_edr_typ="";       /*(申请单主档)批改类型*/
          c_app_nme="";       /*(申请单主档)投保人名称*/
          n_amt="";           /*(申请单主档)保险金额*/
          t_sign_tm="";     /*签单日期*/
          c_rpt_desc="";    /*上报说明*/
          c_risk_lvl_cde="";/*风险等级代码*/
          c_lcn_no="";      /*牌照号码*/
          c_eng_no="";      /*发动机号*/
          c_insrnc_cls="";  /*险种大类*/
//          c_app_typ="";     /*投保分类*/
          c_use_atr="";     /*使用性质*/
          c_undr_opn="";    /*核保意见*/
          c_internet_typ="";/*网上业务标志[0]='1'*/

    }
}
