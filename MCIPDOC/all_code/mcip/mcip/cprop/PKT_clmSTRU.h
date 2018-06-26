#ifndef _PKT_CLMSTRU_H_
#define _PKT_CLMSTRU_H_


 
/*  报案录入，报案查看，报案修改界面的数据结构（服务器找到的信息放于此结构）*/
typedef    struct  _clmInListChangeStru{
char    sPlcyNo[C_PLY_NO_LEN];                 /* 保单号 */
char    sRptNo[C_RPT_NO_LEN];                   /* 报案号 */
char    sClmNo[C_CLM_NO_LEN]; 
char    sInsrntName[C_INSRNT_NME_LEN];          /* 被保险人名称*/
char    sInsrntCde[C_INSRNT_CDE_LEN];          /* 被保险人名称*/
char    sInsrncTgt[C_INSRNC_TGT_LEN];           /* 保险标的 */
char    sRptNme[C_RPT_NME_LEN];                 /* 报案人姓名 */
char    sBigClm[2];
char    sRptAddrTel[C_RPT_ADDR_TEL_LEN];        /* 报案人地址电话 */
char    sRptTm[TIME_LEN];                       /* 报案时间 */
char    sAccdntTm[TIME_LEN];                    /* 出险时间 */
char    sAccdntSpot[C_ACCDNT_SPOT_LEN];         /* 出险地点*/
char    sAccdntCaus[C_ACCDNT_CAUS_LEN];         /* 出险原因 */
char    sLosDtl[C_LOS_DTL_LEN];                 /*损失情况*/       /*(后来追加）*/
char    sCurTyp[C_CUR_TYP_LEN];                 /* 币种*/
double  dRptAmt;                                /* 报损金额*/
char    sInsrncCde[C_INSRNC_CDE_LEN];           /* 险种*/
char    sRcvrCde[C_RCVR_CDE_LEN];               /* 受理人姓名*/
char    sOpinion[C_OPINION_LEN];                /* 处理意见*/
char    sRemark[C_REMARK_LEN];                  /* 备注*/
char    sTgtLosDtl[C_TGT_LOS_DTL_LEN];          /* 标的损失情况 */
char    sHlpLos[C_HLP_EXP_LEN];                 /* 施救情况及费用*/
char    sThdLos[C_THD_LOS_LEN];                 /* 第三者损失情况*/
char    sClmPrcsDtl[C_CLM_PRCS_DTL_LEN];        /* 赔案处理情况*/
char    sSrsCaseOpinion[C_SRS_CASE_OPINION_LEN];/* 重大赔案处理意见 */
char    sDptCde[C_DPT_CDE_LEN];                 /* 机构部门编码*/
char    sRptRgstMdfyTm[TIME_LEN];               /* 报案修改日期*/
char    sPrcsDptCde[C_DPT_CDE_LEN];
char    sRptRgstCde[C_RPT_RGST_CDE_LEN];
/******add begin 车险*****/
char 	sInsrncBgnTm[DATE_LEN];		/*保险起期*/
char 	sInsrncEndTm[DATE_LEN];		/*保险止期*/
double 	dTgtAmt;			/*投保金额*/
char 	sInsCurTyp[C_CUR_TYP_LEN];	/*保额币种*/
char 	sCarNo[C_CAR_NO_LEN];		/*车辆序号*/
char 	sLcnNo[C_LCN_NO_LEN];		/*牌照号*/
char 	sBrndCde[C_BRND_CDE_LEN];	/*厂牌车型*/
char 	sEngNo[C_ENG_NO_LEN];		/*发动机号*/
char 	sAccdntDtl[C_ACCDNT_DTL_LEN];   /*出险经过*/
char 	sRptPrcsMrk[2];/*'0'-受理,'1'-不受理,'2'-暂缓受理*/
char 	sBrndCnm[C_BRND_CNM_LEN];/*厂牌车型名称99.11.19Wugb*/
/******add end 车险*****/
char	sInternetTyp[2];	/*网上报案标志:'0' 否,'1' 是*/
}clmInListChangeStru;   /* 注：对应于报案表t_clmrpt表。*/





/*  给出保单号和报案号则检索与此相应的报案信息（请求报案修改，报案详细，报删除）：*/
typedef  struct  _clmPlcyNoStru
{
	char    sRptNo[C_RPT_NO_LEN];                   /*报案号*/
	char    sPlcyNo[C_PLY_NO_LEN];                 /*保单号  */
	char    sDptCde[C_DPT_CDE_LEN];                 /* 机构部门编码*/
	/******add begin 车险*****/
	char    sAccdntTime[TIME_LEN];	/*出险时间*/
	char sLcnNo[C_LCN_NO_LEN];	    /*牌照号码*/
	char sEgnNo[C_ENG_NO_LEN];		    /*发动机号*/
	char sInsrntName[C_INSRNT_NME_LEN];	/*被保险人名称*/
	char sCarNo[C_CAR_NO_LEN]; /*车险标的add 99.7.26*/
	char    sRptRgstMdfyTm[TIME_LEN];               /* 报案修改日期*/
	char cDelorClr;/*是注销'C'还是删除'D' 99/11/18*/
	/******add end 车险*****/
}clmPlcyNoStru;      /*注：对应于报案表t_clmrpt表*/





#endif
