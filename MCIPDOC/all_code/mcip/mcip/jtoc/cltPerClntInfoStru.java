package jtoc;

public class cltPerClntInfoStru{
//Total 29 properties

    public java.lang.String c_clnt_cde;     /*12客户编码*/
    public java.lang.String c_dpt_cde;      /*11 机构部门*/
    public java.lang.String c_clnt_nme;     /*60 客户名称*/
    public java.lang.String c_chn_abr;      /*12 简称*/
    public java.lang.String c_auth_mrk;     /*1 授权标志*/
    public java.lang.String c_brd_enm;      /*60 英文名称/客户单位*/
    public java.lang.String c_rgst_no;      /*20 工商登记号/身份证号*/
    public java.lang.String c_sex;          /*1 性别*/
    public java.lang.String c_hmtwn;        /*20 籍贯*/
    public java.lang.String c_ntn_cde;      /*2 民族*/
    public java.lang.String t_birthday;     /*date 出生日期*/
    public java.lang.String c_mrg_cde;      /*2 婚姻状况*/
    public java.lang.String c_grdt;         /*30 毕业院校*/
    public java.lang.String c_edu_cde;	     /*2 学历*/
    public java.lang.String c_major_cde;    /*2 专业*/
    public java.lang.String c_title_cde;    /*2 职称*/
    public java.lang.String c_duty;         /*20	职务*/
    public java.lang.String c_tel;          /*20 电话*/
    public java.lang.String c_fax;          /*20	传真*/
    public java.lang.String c_email;        /*30 E-MAIL*/
    public java.lang.String c_clnt_addr;    /*60 地址*/
    public java.lang.String c_zip_cde;      /*6 邮编*/
    public java.lang.String c_remark;       /*500 备注*/
    public java.lang.String c_clnt_mrk;     /* 1 客户标志 '0'-机构,'1'-个人*/
    public java.lang.String c_emp_cde;      /*10 员工编码 作为创建人或者修改人*/
    public java.lang.String c_impt_clnt_cde;/*Update on 8-25*/
    public java.lang.String t_upd_tm;       /*TIME hh:mm:ss  修改时间，用于并发控制*/
    public java.lang.String c_province;	     /*20 送单省、市*/
    public java.lang.String c_city;	        /*20 送单县/市/区*/
    public java.lang.String c_place;	       /*100 送单详细位置*/
    public cltPerClntInfoStru(){}
//Added for debug;
    public cltPerClntInfoStru(String[] temp) throws Exception{
           for (int i=0;i<temp.length;i++){
               temp[i]=""+i;
           }
           c_clnt_cde =temp[0];
           c_dpt_cde  =temp[1];      /*11 机构部门*/
           c_clnt_nme =temp[2];     /*60 客户名称*/
           c_chn_abr  =temp[3];      /*12 简称*/
           c_auth_mrk =temp[4];     /*1 授权标志*/
           c_brd_enm  =temp[5];      /*60 英文名称/客户单位*/
           c_rgst_no  =temp[6];      /*20 工商登记号/身份证号*/
           c_sex      =temp[7];          /*1 性别*/
           c_hmtwn    =temp[8];        /*20 籍贯*/
           c_ntn_cde  =temp[9];      /*2 民族*/
           t_birthday =temp[10];     /*date 出生日期*/
           c_mrg_cde  =temp[11];      /*2 婚姻状况*/
           c_grdt     =temp[12];         /*30 毕业院校*/
           c_edu_cde  =temp[13];	     /*2 学历*/
           c_major_cde=temp[14];    /*2 专业*/
           c_title_cde=temp[15];    /*2 职称*/
           c_duty     =temp[16];         /*20	职务*/
           c_tel      =temp[17];          /*20 电话*/
           c_fax      =temp[18];          /*20	传真*/
           c_email    =temp[19];        /*30 E-MAIL*/
           c_clnt_addr=temp[20];    /*60 地址*/
           c_zip_cde  =temp[21];      /*6 邮编*/
           c_remark   =temp[22];       /*500 备注*/
           c_clnt_mrk =temp[23];     /* 1 客户标志 '0'-机构,'1'-个人*/
           c_emp_cde  =temp[24];      /*10 员工编码 作为创建人或者修改人*/
           t_upd_tm   =temp[25];       /*TIME hh:mm:ss  修改时间，用于并发控制*/
           c_province  =temp[26];	     /*20 送单省、市*/
           c_city     =temp[27];	        /*20 送单县/市/区*/
           c_place    =temp[28];	       /*100 送单详细位置*/

    }

    public cltPerClntInfoStru(com.mcip.cus.orb.CustPrsn custprsnobj) throws Exception{
           c_clnt_cde =custprsnobj.c_clnt_cde;      /*12客户编码*/
           c_dpt_cde  =custprsnobj.c_dpt_cde;      /*11 机构部门*/
           c_clnt_nme =custprsnobj.c_clnt_nme;     /*60 客户名称*/
           c_chn_abr  =custprsnobj.c_chn_abr;      /*12 简称*/
           c_auth_mrk =custprsnobj.c_auth_mrk;     /*1 授权标志*/
           c_brd_enm  =custprsnobj.c_brd_enm;      /*60 英文名称/客户单位*/
           c_rgst_no  =custprsnobj.c_rgst_no;      /*20 工商登记号/身份证号*/
           c_sex      =custprsnobj.c_sex;          /*1 性别*/
           c_hmtwn    =custprsnobj.c_hmtwn;        /*20 籍贯*/
           c_ntn_cde  =custprsnobj.c_ntn_cde;      /*2 民族*/
           t_birthday =custprsnobj.t_birthday;     /*date 出生日期*/
           c_mrg_cde  =custprsnobj.c_mrg_cde;      /*2 婚姻状况*/
           c_grdt     =custprsnobj.c_grdt;         /*30 毕业院校*/
           c_edu_cde  =custprsnobj.c_edu_cde;	     /*2 学历*/
           c_major_cde=custprsnobj.c_major_cde;    /*2 专业*/
           c_title_cde=custprsnobj.c_title_cde;    /*2 职称*/
           c_duty     =custprsnobj.c_duty;         /*20	职务*/
           c_tel      =custprsnobj.c_tel;          /*20 电话*/
           c_fax      =custprsnobj.c_fax;          /*20	传真*/
           c_email    =custprsnobj.c_email;        /*30 E-MAIL*/
           c_clnt_addr=custprsnobj.c_clnt_addr;    /*60 地址*/
           c_zip_cde  =custprsnobj.c_zip_cde;      /*6 邮编*/
           c_remark   =custprsnobj.c_remark;       /*500 备注*/
           c_clnt_mrk =custprsnobj.c_clnt_mrk;     /* 1 客户标志 '0'-机构,'1'-个人*/
           c_emp_cde  =custprsnobj.c_clnt_cde;      /*10 员工编码 作为创建人或者修改人*/
           t_upd_tm   ="22:22:22";       /*TIME hh:mm:ss  修改时间，用于并发控制*/
           c_province  =custprsnobj.c_province;	     /*20 送单省、市*/
           c_city     =custprsnobj.c_city;	        /*20 送单县/市/区*/
           c_place    =custprsnobj.c_place;	       /*100 送单详细位置*/

    }
}

