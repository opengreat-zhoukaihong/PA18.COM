#include "db_macro.h"

typedef struct _PacketHead {
    unsigned short iPacketID;     /* 服务ID	     */
    unsigned short iRetPktID;     /* 处理的服务ID   */
    int      lPacketSize;        /* 服务数据包大小 */
    short    iRecordNum;       /* 包中记录的个数 */
    short    iRecordSize;       /* 每个记录的长度 */
    short    iPriority;	        /* 服务的优先级   */
    short    iServiceNo;        /* 服务类型的编号 */
    char     cRetCode;         /* 服务的返回值	*/
    int      iReserved;	        /* 保留未用      */
} PacketHead;


typedef  struct _cltPerClntInfoStru  {
    char sClntCde[C_CLNT_CDE_LEN];    /*12客户编码*/
    char sDptCde[C_DPT_CDE_LEN];      /*11 机构部门*/
    char sClntNme[C_CLNT_NME_LEN];    /*60 客户名称*/
    char sChnAbr[C_CHN_ABR_LEN];      /*12 简称*/
    char sAuthMrk[C_AUTH_MRK_LEN];    /*1 授权标志*/
    char sBrdEnm[C_BRD_ENM_LEN];    /*60 英文名称/客户单位*/
    char sRgstNo[C_RGST_NO_LEN];    /*20 工商登记号/身份证号*/
    char sSex[C_SEX_LEN];         /*1 性别*/
    char sHmtwn[C_HMTWN_LEN];    /*20 籍贯*/
    char sNtnCde[C_NTN_CDE_LEN];    /*2 民族*/
    char sBirthday[DATE_LEN];    /*date 出生日期*/
    char sMrgCde[C_MRG_CDE_LEN];    /*2 婚姻状况*/
    char sGrdt[C_GRDT_LEN];    /*30 毕业院校*/
    char sEduCde[C_EDU_CDE_LEN];	/*2 学历*/
    char sMajorCde[C_MAJOR_CDE_LEN];    /*2 专业*/
    char sTitlCde[C_TITLE_CDE_LEN];    /*2 职称*/
    char sDuty[C_DUTY_LEN];    /*20	职务*/
    char sTel[C_TEL_LEN];    /*20 电话*/
    char sFax[C_FAX_LEN];    /*20	传真*/
    char sEmail[C_EMAIL_LEN];    /*30 E-MAIL*/
char sClntAddr[C_CLNT_ADDR_LEN];    /*60 地址*/
    char sZipCde[C_ZIP_CDE_LEN];    /*6 邮编*/
    char sRemark[C_REMARK_LEN];    /*500 备注*/
    char sClntMrk[C_CLNT_MRK_LEN];    /* 1 客户标志 '0'-机构,'1'-个人*/
    char sEmpCde[C_EMP_CDE_LEN];     /*10 员工编码 作为创建人或者修改人*/
char sUpdTm[TIME_LEN];	/*TIME hh:mm:ss  修改时间，用于并发控制*/
char sProvince[C_PROVINCE_LEN];	/*20 送单省、市*/
char sCity[C_CITY_LEN];	/*20 送单县/市/区*/
char sPlace[C_PLACE_LEN];	/*100 送单详细位置*/
} cltPerClntInfoStru;

typedef  struct _cltOrgClntInfoStru  {
    char sClntCde[C_CLNT_CDE_LEN];    /*12客户编码*/
    char sDptCde[C_DPT_CDE_LEN];      /*11 机构部门*/
    char sClntNme[C_CLNT_NME_LEN];    /*60 客户名称*/
    char sChnAbr[C_CHN_ABR_LEN];      /*12 简称*/
    char sAuthMrk[C_AUTH_MRK_LEN];    /*1 授权标志*/
    char sBrdEnm[C_BRD_ENM_LEN];    /*60 英文名称/客户单位*/
    char sRgstNo[C_RGST_NO_LEN];    /*20 工商登记号/身份证*/
    char sTaxNo[C_TAX_NO_LEN];    /*16 税务号*/
    double  fRgstMny;    /*16	注册资本*/
    char sChief[C_CHIEF_LEN];    /*8 单位负责人*/
    double  fEmlyNum;    /*8 员工人数*/
    char sOwnershipCde[C_OWNERSHIP_CDE_LEN];    /*1所有制*/
    char	sOrgzTypCde[C_ORGZ_TYP_CDE_LEN]; /*1 企业组织形式*/
    char sTrdCde[C_TRD_CDE_LEN];    /*1行业*/
    char sAraCde[C_ARA_CDE_LEN];    /*10 国家地区*/
    char 	sClntScleCde[C_CLNT_SCLE_CDE_LEN];    /*1 保费规模*/
    char sScaleCde[C_SCALE_CDE_LEN];    /*1 企业规模*/
    char sUprDptCde[C_UPR_DPT_CDE_LEN];    /*12 上级单位代码*/
    char sImptClntCde[C_IMPT_CLNT_CDE_LEN];    /*	12 大客户码*/
    char sCntctPrsnNme[C_CNTCT_PRSN_NME_LEN];   /*20	联系人*/
    char sTel[C_TEL_LEN];    /*20 电话*/
    char sFax[C_FAX_LEN];    /*20	传真*/
    char sEmail[C_EMAIL_LEN];    /*30 E-MAIL*/
    char sClntAddr[C_CLNT_ADDR_LEN];    /*60 地址*/
    char sZipCde[C_ZIP_CDE_LEN];    /*6 邮编*/
    char sRemark[C_REMARK_LEN];    /*500 备注*/
    char sClntMrk[C_CLNT_MRK_LEN];    /* 1 客户标志*/
    char sEmpCde[C_EMP_CDE_LEN];     /*10 员工编码，作为创建人或者修改人*/
    char sUpdTm[TIME_LEN];	/*TIME hh:mm:ss  修改时间*/
    char sBank[C_BANK_LEN];   /*20 开户银行 */
    char sAccntNo[C_ACCNT_NO_LEN];    /*20 银行帐号 */
char sEngAbr[C_ENG_ABR_LEN];      /*英文简称*/
char sProvince[C_PROVINCE_LEN];	/*20 送单省、市*/
char sCity[C_CITY_LEN];	/*20 送单县/市/区*/
char sPlace[C_PLACE_LEN];	/*100 送单详细位置*/
} cltOrgClntInfoStru;
