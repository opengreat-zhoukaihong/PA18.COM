/********************************************************************
 * NAME         : PKT_STRU.h
 * FUNCTION     : 数据包结构定义
 * PROGRAMMED   : aisoft/aisoft
 * DATE(ORG)    : 98/08/19
 * PROJECT      : aisoft
 * OS           : WINDOWS 95 AND UNIX
 * HISTORY      :
 * ID  -- DATE -------- NOTE-----------------------------------------
 * 00   97/07/03  Created By WTQ  
 ********************************************************************/
/*************本文件的维护人：LZZ ********************************/
/********************************************************************
 *                     数据包ID的定义								*
 ********************************************************************/
/******************************************************************
 *	  关于各 ID 的取值范围的说明：为了确保系统的可扩充性，须给每种
 *类型的ID一定的取值范围，使其既具有灵活的扩充性，又便于系统的维护。
 *各部分的范围规定如下：
 *画面及菜单ID的编号：	10000~20000
 *画面公共控件ID的编号：20001~22000
 *数据通信包ID的编号：	22001~23000
******************************************************************/
/********************************************************************
*	平安产险信息系统数据包 ID 的定义,各部分的编号范围分配如下：
*	系统：22001~22100
*	承保：22101~22200										*
*	批改：22201~22300										*
*	理赔：22301~22400										*
*	客户：22401~22500										*
*	单证：22501~22600										*
*	报表：22601~22700										*
*	财务：22701~22800										*
*	再保：22801~22900										*
*	设置：22901~22950										*
*	权限：22951~23000										*
********************************************************************/
/*---------------		系统：22001~22100 开始		---------------*/
/****************		系统：22001~22100 结束		****************/
/*---------------		承保：22101~22200 开始		---------------*/
#ifndef PKT_plySTRU_H
#define PKT_plySTRU_H

#include "db_macro.h"


#define PP_GET_INSRNC_DFN			22101	/*获取险种*/
#define PP_GET_APPPOLY_GRID			22102	/*获取投保单一览*/
#define	PP_GET_APPPOLICY			22103	/*获取投保单内容*/
#define	PP_UPDATE_APPPOLICY			22104	/*修改投保单*/
#define	PP_DELETE_APPPOLICY			22105	/*删除投保单*/
#define	PP_RETNUNDR_APPPOLICY		22106	/*撤回投保单*/
#define PS_UPD_INSRNC_DFN			22107	/*修改险种定义*/
#define PP_GET_WORK					22110	/*获取受理业务和上报业务工作栏索引信息*/
#define PP_GET_UDRPOLICY			22111	/*审核或查询投保单*/
#define PP_UPDATE_CLRPOLICY			22112	/*清除投保单*/
#define PP_UPDATE_RCLPOLICY			22113	/*撤回投保单*/
#define PP_UPDATE_UDRDEAL			22114	/*核保处理*/
#define PP_UPDATE_UDRUPD			22115	/*核保更新处理*/
#define PP_GET_CHECK_APPPLY			22116	/*取投保单 */
#define PP_GET_EDRPLY				22120	/*根据保单号批改*/
#define PP_INSERT_BACK_EDR			22121	/*生成退费批单*/
#define PP_GET_EDR_GRID				22122	/*获取申请单一览*/
#define PP_GET_APPEDR				22123	/*获取申请单内容*/
#define PP_UPDATE_CLREDR			22124	/*清除已核保申请单*/
#define PP_UPDATE_UDREDR			22125	/*申请单申请核保*/
#define PP_DELETE_APPEDR			22126	/*删除申请单*/
#define PP_GET_EDR_INFO				22127	/*获取申请单、批单信息*/
#define PP_UPDATE_RCLEDRAPP			22128	/*撤回投保单*/
#define PP_GET_POLY_EDR_GRID		22130	/*获取批量批改一览*/
#define PP_INSERT_EDR				22131	/*批量批改处理*/
#define PP_GET_POLY_AGT_GRID		22132	/*代理费 直接业务的检索*/
#define PP_AGENCY_FEE_PROC			22133	/*代理费 直接业务的确认*/
#define PP_GET_CANCEL_RENEW_GRID	22134	/*获取需恢复注销、退保的保单一览*/
#define PP_CANCEL_RENEW				22135	/*注销、退保恢复处理*/
/**********/
                                                                                                 
#define PP_GET_CPLY_GRID_INFO       22140   /*获取保单一览信息*/
#define PP_GET_VHL_BRND_INFO        22141   /*F9键获取厂牌车型码信息*/
#define PP_GET_HOME_RICH_GRID		22142	/*家财长效保费计提查询*/
#define PP_INSERT_HOME_RICH_GRID	22143	/*家财长效保费计提处理*/
/****************		承保：22101~22200 结束		****************/
/*---------------		批改：22201~22300 开始		---------------*/
/****************		批改：22201~22300 结束		****************/
/*---------------		理赔：22301~22400 开始		---------------*/
/****************		理赔：22301~22400 结束		****************/
/*---------------		客户：22401~22500 开始		---------------*/
/****************		客户：22401~22500 结束		****************/
#define  PA_GET_CONFER           13037
/*---------------		单证：22501~22600 开始		---------------*/
/****************		单证：22501~22600 结束		****************/
/*---------------		报表：22601~22700 开始		---------------*/
/****************		报表：22601~22700 结束		****************/
/*---------------		财务：22701~22800 开始		---------------*/
/****************		财务：22701~22800 结束		****************/
/*---------------		再保：22801~22900 开始		---------------*/
/****************		再保：22801~22900 结束		****************/
/*---------------		设置：22901~22950 开始		---------------*/
/****************		设置：22901~22950 结束		****************/
/*---------------		权限：22951~23000 开始		---------------*/
/****************		权限：22951~23000 结束		****************/
/********************************************************************
 *						结构定义									*
********************************************************************/
/*------------------------承保部分----------------------------------*/
#undef    L_TGT_FLD1_LEN                               
#define   L_TGT_FLD1_LEN           501     
#define      C_REC_NO_LEN          10
#define      C_APP_KINDS_LEN       20
/* *** 附加的头文件结构 *** */
typedef struct _PktBodyInfoStru 
{
	int nPktNum[C_APP_KINDS_LEN];
} PktBodyInfoStru;
/* *** 险种信息数据结构 *** */ 
typedef struct _plyInsrncDfnStru
{
	char sCrtCde[C_CRT_CDE_LEN];					/*创建人员*/
	char sCrtTm[TIME_LEN];    						/*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];					/*修改人员*/
	char sUpdTm[TIME_LEN];							/*修改时间*/
	int  nInsrncNo;									/*序号*/
	char sAmtDef[C_AMT_DEF_LEN];					/*保险金额计算定义*/
	char sTgtMrk[C_TGT_MRK_LEN];					/*标的物标志*/
	char sPrmDef[C_PRM_DEF_LEN];					/*保费计算定义*/
	char sRdrPrmDef[C_RDR_PRM_DEF_LEN];				/*附加险保费计算定义*/
	char sDvdPayMrk[C_DVD_PAY_MRK_LEN];				/*分期付款标志*/
	char sAdbTm[DATE_LEN];							/*失效日期*/
	char sInsrncCde[C_INSRNC_CDE_LEN];				/*险种*/
	char sInsrncCls[C_INSRNC_CLS_LEN];				/*险种大类*/
	char sInsrncTyp[C_INSRNC_TYP_LEN];				/*险种分类*/
	char sInsrncCnm[C_INSRNC_CNM_LEN];				/*险种中文名称*/
	char sInsrncAbr[C_INSRNC_ABR_LEN];				/*险种简称*/
	double fInsrncRte;								/*险种费率*/
	double fNclmPropAuth;							/*无赔款退费比例权限*/
	double fAppntPropAuth;							/*约定退费比例权限*/
	double fCmmRteAuth;								/*手续费比例权限*/
	double fBrkrRteAuth;							/*经纪费比例权限*/
	char sPrnMrk[C_PRN_MRK_LEN];					/*印刷单证标志*/
	double fEmProp;									/*上报赔款额度*/
	char sInsrncEnm[C_INSRNC_ENM_LEN];				/*险种英文名称*/
	char sUdrDsc[C_UDR_DSC_LEN];                    /*核保指南*/
	char sInsrncDfn[C_INSRNC_DFN_LEN];				/*险种基本定义*/
	char sSumPrmDef[C_SUM_PRM_DEF_LEN];				/*保费合计公式定义*/
	char sInsrncDfnTyp[C_INSRNC_DFN_TYP_LEN];		/*险种定义类别*/
    char sTgtobjMrk[C_TGTOBJ_MRK_LEN];				/*标的标志*/
    int  nTerm1;									/*应收保费期限*/
    int  nTerm2;									/*应收保费起止期缺省天数*/
    double fRmbAmt;									/*重大金额人民币*/
    double fHkdAmt;									/*重大金额港币*/	
    double fUsdAmt;									/*重大金额美金*/
	char sInsrncMrk[C_INSRNC_MRK_LEN];				/*共用标志*/
    int  nTerm3;									/*应收保费期限最大值*/
    int  nTerm4;									/*保险天数期限*/
} plyInsrncDfnStru;
    
/* *** 标的描述项定义表(其他险) *** */
typedef  struct  _plyTgtDescStru
{
	char sCrtCde[C_CRT_CDE_LEN];                /*创建人员*/
	char sCrtTm[TIME_LEN];    		            /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];                /*修改人员*/
	char sUpdTm[TIME_LEN];			            /*修改时间*/
	char sInsrncCde[C_INSRNC_CDE_LEN];          /*险种编码*/
	char sTgtFld[C_TGT_FLD_LEN];                /*标的字段*/
	char sFldEnm[C_FLD_ENM_LEN];                /*字段英文名*/
	char sDesNme[C_DES_NME_LEN];                /*描述项名*/
	char sType[C_TYPE_LEN];                     /*类型*/
	int  nLength;					            /*长度*/
	int  nPresion;                     			/*小数点位数*/
	char sSrchCde[C_SRCH_CDE_LEN];              /*查询码*/
	char sCaluFmul[C_CALU_FMUL_LEN];            /*计算公式*/
	char sMaxVal[C_MAX_VAL_LEN];                /*最大值*/
	char sMinVal[C_MIN_VAL_LEN];                /*最小值*/
	char sDefaultVal[C_DEFAULT_VAL_LEN];        /*缺省值*/
	char sMdfyAble[C_MDFY_ABLE_LEN];            /*可修改*/
	char sNullAble[C_NULL_ABLE_LEN];            /*可空*/
	char sRelaData[C_RELA_DATA_LEN];            /*相关数据*/
	char sAdbTm[DATE_LEN];                      /*失效时间*/
	int  nDispNo;                               /*显示序号*/
} plyTgtDescStru; 
/* *** 标的物描述项定义表(其他险) *** */
typedef  struct _plyTgtobjdefStru 
{
	char sCrtCde[C_CRT_CDE_LEN];                /*创建人员*/
	char sCrtTm[TIME_LEN];    		            /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];                /*修改人员*/
	char sUpdTm[TIME_LEN];			            /*修改时间*/
	char sInsrncCde[C_INSRNC_CDE_LEN];          /*险种编码*/
	char sTgtObjFld[C_TGT_OBJ_FLD_LEN];         /*标的物字段*/
	char sFldEnm[C_FLD_ENM_LEN];                /*字段英文名*/
	char sDesNme[C_DES_NME_LEN];                /*描述项名*/
	char sType[C_TYPE_LEN];                     /*类型*/
	int  nLength;						        /*长度*/
	int  nPresion;                     			/*小数点位数*/
	char sSrchCde[C_SRCH_CDE_LEN];              /*查询码*/
	char sCaluFmul[C_CALU_FMUL_LEN];            /*计算公式*/
	char sMaxVal[C_MAX_VAL_LEN];                /*最大值*/
	char sMinVal[C_MIN_VAL_LEN];                /*最小值*/
	char sDefaultVal[C_DEFAULT_VAL_LEN];        /*缺省值*/
	char sMdfyAble[C_MDFY_ABLE_LEN];            /*可修改*/
	char sNullAble[C_NULL_ABLE_LEN];            /*可空*/
	char sRelaData[C_RELA_DATA_LEN];            /*相关数据*/
	char sAdbTm[DATE_LEN];			            /*失效时间*/
	int  nDispNo;                               /*显示序号*/
} plyTgtobjdefStru;
    
/* *** 查询参数表(其他险) *** */
typedef  struct _plyQryparatlbStru 
{
	char sCrtCde[C_CRT_CDE_LEN];               /*创建人员*/
	char sCrtTm[TIME_LEN];    		           /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];               /*修改人员*/
	char sUpdTm[TIME_LEN];			           /*修改时间*/
	char sSrchCde[C_SRCH_CDE_LEN];             /*查询码*/
	char sSrchNme[C_SRCH_NME_LEN];             /*名称*/
	char sSrchVal[C_SRCH_VAL_LEN];             /*取值*/
 	char sSrchCdeNme[C_SRCH_CDE_NME_LEN];      /*查询码名称*/
} plyQryparatlbStru;
/* *** 投保单、保单主档数据结构 *** */
typedef  struct _plyAppPolicyStru                      
{
	char sCrtCde[C_CRT_CDE_LEN];                    /*创建人员*/
	char sCrtTm[TIME_LEN];    		                /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];                    /*修改人员*/
	char sUpdTm[TIME_LEN];			                /*修改时间*/
	char sCplyAppNo[C_PLY_APP_NO_LEN];              /*投保单号*/
	char sCplyNo[C_PLY_NO_LEN];                     /*保单号*/
	char sOrigCplyNo[C_ORIG_PLY_NO_LEN];            /*续保原保单号*/
	char sDptCde[C_DPT_CDE_LEN];                    /*机构部门*/
	char sBsnsTyp[C_BSNS_TYP_LEN];                  /*业务来源*/
	char sCmpnyAgtCde[C_CMPNY_AGT_CDE_LEN];         /*代理人编码*/
	char sAgtAbr[C_AGT_ABR_LEN];					/*代理人名称*/
	char sAgtAgrNo[C_AGT_AGR_NO_LEN];               /*代理协议号*/
	int  nSubCoNo;                                  /*补充协议号*/
	char sBrkrCde[C_BRKR_CDE_LEN];                  /*经纪人编码*/
	char sBrkrCnm[C_BRKR_CNM_LEN];			        /*经纪人名称*/
	char sSlsCde[C_SLS_CDE_LEN];                    /*业务员编码*/
	char sSlsNme[C_EMP_CNM_LEN];					/*业务员姓名*/
	char sInsrncCmpnyCde[C_INSRNC_CMPNY_CDE_LEN];   /*保险公司*/
	char sInsrncCmpnyCnm[C_BRKR_CNM_LEN];           /*保险公司名称*/
	char sInsrntCde[C_INSRNT_CDE_LEN];              /*被保险人编码*/
	char sInsrntNme[C_INSRNT_NME_LEN];              /*被保险人名称*/
	char sInsrntAddr[C_INSRNT_ADDR_LEN];            /*被保险人地址*/
	char sBnfcCde[C_BNFC_CDE_LEN];                  /*受益人编码*/
	char sBnfcNme[C_BNFC_NME_LEN];                  /*受益人名称*/
	char sAppCde[C_APP_CDE_LEN];                    /*投保人编码*/
	char sAppNme[C_APP_NME_LEN];                    /*投保人名称*/
	char sAppAddr[C_APP_ADDR_LEN];                  /*投保人地址*/
	char sAppTel[C_APP_TEL_LEN];                    /*投保人电话*/
	char sInsrncCde[C_INSRNC_CDE_LEN];              /*险种代码*/
	char sClausCde[C_CLAUS_CDE_LEN];                /*主险条款*/
	char sAppTm[DATE_LEN];                          /*投保日期*/
/*6.18修改*/
	char sInsrncBgnTm[TIME_LEN];                    /*保险起期*/
	char sInsrncEndTm[TIME_LEN];                    /*保险止期*/
	char sSignTm[TIME_LEN];                         /*签单日期*/
	char sAmtCur[C_AMT_CUR_LEN];                    /*保额币种*/
	double fInsrncVlu; 			                    /*保险价值*/
	double fAmt;                 			        /*保险金额*/
	double fRate;                         			/*费率*/
	double fPrm;                          			/*保费*/
	double fRdrPrm;              			        /*附加险保费*/
	double fSumPrm;                          		/*保费合计*/
	char sPrmCur[C_PRM_CUR_LEN];                    /*应收保费币种*/
	double fNclmProp;                     		    /*无赔退费比例*/
	double fAppntProp;                    		    /*约定退费比例*/
	double fCmmProp;                     		    /*手续费比例*/
	double fBrkProp;                     		    /*经纪费比例*/
	int  nPayTms;				                    /*缴费期数*/
	char sAppnt[C_APPNT_LEN];                       /*特别约定*/
	char sRemark[C_REMARK_LEN];                     /*备注*/
	char sCrtPrsn[C_CRT_PRSN_LEN];                  /*录入人*/
	char sUndrPrsn[C_UNDR_PRSN_LEN];                /*核保人*/
	char sUndrTm[TIME_LEN];                        	/*核保日期*/
	char sRinsrncMrk[C_RINSRNC_MRK_LEN];            /*分保类型*/
	char sCoinsrncMrk[C_COINSRNC_MRK_LEN];          /*共保标志*/
	char sInputTm[DATE_LEN];                        /*录入日期*/
	char sUndrDpt[C_UNDR_DPT_LEN];                  /*核保机构*/
	char sOprTyp[C_OPR_TYP_LEN];                    /*出单方式*/
	int  nEdrPrjNo;                                 /*序号*/
	char sNextEdrUndrTm[TIME_LEN];                  /*下次批改核保日期*/
	char sUdrMrk[C_UDR_MRK_LEN];                    /*核保标志*/
	char sRecNo[C_REC_NO_LEN];						/*暂存记录号*/
	char sDptCnm [C_DPT_CNM_LEN];                   /*机构部门名称*/
	char sInsrncCnm[C_INSRNC_CNM_LEN];              /*险种中文名称*/
	char sUndrPrsnCnm[C_EMP_CNM_LEN];               /*核保人名称*/
	char sUndrDptCnm[C_DPT_CNM_LEN];                /*核保机构名称*/
	char sCrtPrsnCnm[C_EMP_CNM_LEN];                /*录入人名称*/
	char sAmtCurCnm[C_CUR_CNM_LEN];                 /*保额币种名称*/
  char sAgeLongMrk[C_AGELONG_MRK_LEN];            /*多年期标志*/
	char sCeprnMrk[C_CEPRN_MRK_LEN];                /*中英文打印标志*/
  char sSalegrpCde[C_SALEGRP_CDE_LEN];            /*销售团队代码*/
/*车险新增*/
	double fSumNclm;		                        /*无赔优待金额合计*/
	char sZipCde[C_ZIP_CDE_LEN];                    /*邮政编码*/
	char sSttl[C_STTL_LEN];							/*争议解决方式*/
	double fRatio;                                  /*短期费率系数*/
  char sCntctPrsnNme[C_CNTCT_PRSN_NME_LEN];       /*联系人*/
  char sAppTyp[C_APP_TYP_LEN];                    /*投保分类*/
/*1999.9.7 ZQM */
	char sQueryMrk[C_QUERY_MRK_LEN];									/* 查询标志*/
/*1999.10.8 Zdh */
	char sFstUndrPrsn[ C_FST_UNDR_PRSN_LEN ];                           /*初核人编码*/
  char sFstOpn[ C_FST_OPN_LEN ];                           /*初核人意见*/
  char sChkPrsn[ C_CHK_PRSN_LEN ];                           /*验车人*/
  char sChkRec[ C_CHK_REC_LEN ];                           /*验车记录*/
	char sChkTm[ TIME_LEN ];                           /*验车时间*/
	char sFstUndrTm[ TIME_LEN ];                           /*初核时间*/
/*2000.07.24 zdh*/
	char sOpenCoverNo[ C_OPEN_COVER_NO_LEN ];              /*Open cover协议号*/
	char sInternetTyp[ C_INTERNET_TYP_LEN ];              /*网上业务标志'0'-网下，'1'-网上无建议书,'2'-网上有建议书*/
} plyAppPolicyStru; 
/* *** 投保单、保单附加险处理数据结构 *** */
typedef struct _plyRdrStru
{
	char sCrtCde[C_CRT_CDE_LEN];			/*创建人员*/
	char sCrtTm[TIME_LEN];    				/*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];			/*修改人员*/
	char sUpdTm[TIME_LEN];					/*修改时间*/
	char sCplyAppNo[C_PLY_APP_NO_LEN];		/*投保单号*/
	char sRdrCde[C_RDR_CDE_LEN];			/*险别代码*/
	char sRdrNme[C_RDR_NME_LEN];			/*附别名称*/
	double fRdrAmt;							/*保险金额/赔偿限额*/
	double fRdrPerAmt;						/*每次赔偿限额*/
	double fRate;                  			/*费率*/
	double fRdrPrm;							/*保费*/
	char sDesc[C_DESC_LEN];					/*描述/备注*/
	char sNclmDesc[C_NCLM_DESC_LEN];		/*免赔说明*/
	char sDelMrk[C_DEL_MRK_LEN];			/*注退标志*/
	char sRecNo[C_REC_NO_LEN];				/*暂存记录号*/
/*车险新增*/
	char sObjNo[C_OBJ_NO_LEN];				/*标的序号*/
	double fSeatdayNum;						/*座(天)*/
	double fRdrPrmVar;						/*保费变化*/
	double fRdrDis;							/*附加险约定退费*/
	double fRdrNclm;						/*附加险无赔退费*/
	double fRdrDisAmt;						/*最新附加险约定退费*/
	double fRdrNclmAmt;						/*最新附加险无赔退费*/
/*6.18增加*/
	double fRdrdisPrm;						/*打折前保费*/
	double fRdrnclmProp;					/*无赔比例*/
}plyRdrStru;
/*约定司机(车险新增)*/
typedef  struct _plyDrvStru 
{
	char sCrtCde[C_CRT_CDE_LEN];                   /*创建人员*/
	char sCrtTm[TIME_LEN];    		               /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];                   /*修改人员*/
	char sUpdTm[TIME_LEN];			               /*修改时间*/
	char sEdrAppNo[C_EDR_APP_NO_LEN];              /*单    号*/
	char sObjNo[C_OBJ_NO_LEN];                     /*标的序号*/
	char sDsqnNo[C_DSQN_NO_LEN];                   /*约定司机序号*/
	char sDrvNme[C_DRV_NME_LEN];                   /*司机姓名*/
	char sIdCde[C_ID_CDE_LEN];                     /*身份证号码*/
	char sBirthday[DATE_LEN];                      /*出生日期*/
	char sSex[C_SEX_LEN];                          /*性别*/
	char sMrgCde[C_MRG_CDE_LEN];                   /*婚姻状况*/
	char sLcnNo[C_LCN_NO_LEN];                     /*驾驶执照号码*/
	char sProfessionCde[C_PROFESSION_CDE_LEN];     /*职业*/
	char sIssOrg[C_ISS_ORG_LEN];                   /*发照机关*/
	char sIssDte[DATE_LEN];                        /*发照日期*/
	char sDrkMrk[C_DRK_MRK_LEN];                   /*饮酒嗜好标志*/
	char sEduCde[C_EDU_CDE_LEN];                   /*学历*/
	char sRemark[C_REMARK_LEN];                    /*备注*/
	char sDelMrk[C_DEL_MRK_LEN];                   /*注退标志*/
	char sRecNo[C_REC_NO_LEN];					   /*暂存记录号*/
/*3.23--WQ--新增*/
	char sDrvTyp[C_DRV_TYP_LEN];				   /*准驾车型*/
}plyDrvStru;
/* *** 投保单、保单标的物处理数据结构*** */ 
typedef struct _plyTgtObjStru
{
	char sCrtCde[C_CRT_CDE_LEN];				/*创建人员*/
	char sCrtTm[TIME_LEN];    					/*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];				/*修改人员*/
	char sUpdTm[TIME_LEN];						/*修改时间*/
	char sCplyAppNo[C_PLY_APP_NO_LEN];			/*投保单号*/
	int  nTgtObjNo;         					/*标的物序号*/
	char sItmCls[C_ITM_CLS_LEN];				/*项目类别*/
	double fTgtObjAmt;							/*保额*/
	char sNclmDesc[C_NCLM_DESC_LEN];			/*免赔说明*/
	char sRecNo[C_REC_NO_LEN];					/*暂存记录号*/
	char sItmClsNme[C_ITM_CLS_NME_LEN];			/*项目类别名称*/
}plyTgtObjStru;
/* *** 投保单、保单标的物表(其他险) *** */
typedef  struct _plyTgtobjtlbStru 
{
	char sCrtCde[C_CRT_CDE_LEN];				/*创建人员*/
	char sCrtTm[TIME_LEN];    					/*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];				/*修改人员*/
	char sUpdTm[TIME_LEN];						/*修改时间*/
	char sCplyAppNo[C_PLY_APP_NO_LEN];			/*投保单号*/
	int  nTgtObjNo;								/*标的物序号*/
	char sTgtObjFld1[L_TGT_OBJ_FLD1_LEN];       /*标的物字段1*/
	char sTgtObjFld2[L_TGT_OBJ_FLD1_LEN];       /*标的物字段2*/
	char sTgtObjFld3[L_TGT_OBJ_FLD1_LEN];       /*标的物字段3*/
	char sTgtObjFld4[L_TGT_OBJ_FLD1_LEN];       /*标的物字段4*/
	char sTgtObjFld5[L_TGT_OBJ_FLD1_LEN];       /*标的物字段5*/
	char sTgtObjFld6[L_TGT_OBJ_FLD1_LEN];       /*标的物字段6*/
	char sTgtObjFld7[L_TGT_OBJ_FLD1_LEN];       /*标的物字段7*/
	char sTgtObjFld8[L_TGT_OBJ_FLD1_LEN];       /*标的物字段8*/
	char sTgtObjFld9[L_TGT_OBJ_FLD1_LEN];       /*标的物字段9*/
	char sTgtObjFld10[L_TGT_OBJ_FLD1_LEN];      /*标的物字段10*/
	char sRecNo[C_REC_NO_LEN];					/*暂存记录号*/               
} plyTgtobjtlbStru ;
/* *** 投保单付款处理数据结构 *** */ 
typedef struct _plyPayStru
{
	char sCrtCde[C_CRT_CDE_LEN];              /*创建人员*/
	char sCrtTm[TIME_LEN];    		          /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];              /*修改人员*/
	char sUpdTm[TIME_LEN];			          /*修改时间*/
	char sCplyAppNo[C_PLY_APP_NO_LEN];        /*投保单号*/
	int  nTms;				                  /*缴费期别*/
	char sRcptNo[C_RCPT_NO_LEN];              /*收据号*/
	char sPayPrsnCde[C_PAY_PRSN_CDE_LEN];     /*付款人编码*/
	char sPayPrsnNme[C_PAY_PRSN_NME_LEN];     /*付款人姓名*/
	double fGetPrm;					          /*应收保费*/
	char sPayMdeCde[C_PAY_MDE_CDE_LEN];       /*付款方式*/
	char sAccntNo[C_ACCNT_NO_LEN];            /*银行帐号*/
	char sPayLmtTm[DATE_LEN];                 /*缴费截止日期*/
	double fGotPrm;                           /*实收保费*/
	char sPayStrtTm[DATE_LEN];                /*缴费起始日期*/
	char sPayTm[DATE_LEN];                    /*收费日期*/
	char sInsrncCde[C_INSRNC_CDE_LEN];        /*险种*/
	char sCurTyp[C_CUR_TYP_LEN];              /*币种*/
	char sRecNo[C_REC_NO_LEN];				  /*暂存记录号*/
/*新增*/
	char sPrnTyp[C_PRN_TYP_LEN];              /*单证类型*/
}plyPayStru;
/*车险--标的(新增)*/
typedef  struct _plyVhlStru 
{
	char sCrtCde[C_CRT_CDE_LEN];           /*创建人员*/
	char sCrtTm[TIME_LEN];    		       /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];           /*修改人员*/
	char sUpdTm[TIME_LEN];			       /*修改时间*/
	char sCplyAppNo[C_PLY_APP_NO_LEN];     /*单    号*/
	char sObjNo[C_OBJ_NO_LEN];             /*标的序号*/
	char sBrndCde[C_BRND_CDE_LEN];         /*厂牌车型码*/
	double fSetNum;						   /*座位数*/
	double fTonNum;						   /*吨位数*/
	char sLcnNo[C_LCN_NO_LEN];             /*牌照号码/移动证号*/
	char sFrnlcn[C_FRNLCN_LEN];            /*国外牌照*/
	char sEngNo[C_ENG_NO_LEN];             /*发动机号*/
	char sVhlFrm[C_VHL_FRM_LEN];           /*车架号*/
	double fExtMsr;						   /*排汽量*/
	char sFitCnt[C_FIT_CNT_LEN];           /*重要配件*/
	char sColour[C_COLOUR_LEN];            /*车身颜色*/
	char sFlwMrk[C_FLW_MRK_LEN];           /*瑕疵注记*/
	char sBuyDte[DATE_LEN];                /*购置日期*/
	char sBldYear[C_BLD_YEAR_LEN];         /*制造年份*/
	char sVhlTyp[C_VHL_TYP_LEN];           /*车辆种类*/
	char sOwnAtr[C_OWN_ATR_LEN];           /*所属性质*/
	char sUseAtr[C_USE_ATR_LEN];           /*使用性质*/
	char sRgnCde[C_RGN_CDE_LEN];           /*行驶区域*/
	char sDrvApt[C_DRV_APT_LEN];           /*约定司机标志*/
	char sChkCde[C_CHK_CDE_LEN];           /*验车情况*/
	char sDevCde[C_DEV_CDE_LEN];           /*防盗装置*/
	double fTgtAmt;                        /*车损险投保金额*/
	double fInsrncVlu;                     /*车损险保险价值(重置价值)*/
	double fBbscPrm;                       /*车损险基本保费*/
	double fRate;                          /*车损险费率*/
	double fTgtPrm;                        /*车损险保费*/
	char sNclmDesc[C_NCLM_DESC_LEN];       /*免赔描述*/
	double fTplPrm;                        /*第三者责任险保费*/
	double fTplclmLmt;                     /*第三者责任险赔偿限额*/
	char sTnclmDesc[C_TNCLM_DESC_LEN];     /*第三者责任免赔描述*/
	char sAppMrk[C_APP_MRK_LEN];           /*足额投保标记*/
	char sRemark[C_REMARK_LEN];            /*备注*/
    char sFstRegDte[DATE_LEN];             /*初次登记年月*/
	double fNdrvPrm;                       /*不约定司机保费*/
	double fBinsNclmAmt;                   /*车损险无赔优待金额*/
	double fTplpNclmAmt;                   /*第三者责任险无赔优待金额*/
	double fSumPrm;                        /*保费合计*/
	char sBuyvhlNo[C_BUYVHL_NO_LEN];       /*购车发票号*/
	char sInsCrd[C_INS_CRD_LEN];           /*保卡号*/
	double fObjDis;                        /*约定退费*/
	double fObjNclm;                       /*无赔退费*/
	double fNbdisAmt;                      /*车损险最新约定退费*/
	double fTgtAmtVar;                     /*车损险保额变化*/
	double fTgtPrmVar;                     /*车损险保费变化*/
	double fTplPrmVar;                     /*第三者责任险保费变化*/
	double fNtpldisAmt;                    /*第三者责任险最新约定退费*/
	double fNtplclmAmt;                    /*第三者责任险最新无赔退费*/
	double fNbclmAmt;                      /*车损险最新无赔退费*/
	char sRecNo[C_REC_NO_LEN];			   /*暂存记录号*/
/*5.19增加*/
	double fTgtdisPrm;                     /*打折前车损险保费*/
	double fTpldisPrm;                     /*打折前第三者责任险保费*/
	double fSumdisPrm;                     /*打折前保费合计*/
	double fSumTgtNclm;                    /*无赔优待金额合计*/
/*6.18增加*/
    double fTgtnclmProp;				   /*车损险无赔比例*/
    double fTplnclmProp;				   /*第三者责任险无赔比例*/
/*6.30增加*/
	char sBrndCnm[C_BRND_CNM_LEN];         /*厂牌车型中文名称*/
	char sDelMrk[C_DEL_MRK_LEN];		/*注退标志*/
}plyVhlStru;
/* *** 投保单、保单货运险标的处理数据结构 *** */
typedef struct _plyGoTgtStru
{
	char sCrtCde[C_CRT_CDE_LEN];                /*创建人员*/
	char sCrtTm[TIME_LEN];    		            /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];                /*修改人员*/
	char sUpdTm[TIME_LEN];			            /*修改时间*/
	char sCplyAppNo[C_PLY_APP_NO_LEN];          /*投保单号*/
	char sCrgoCde[C_CRGO_CDE_LEN];              /*货物类型编码*/
	char sCrgoCnm[C_CRGO_CNM_LEN];				/*货物名称*/
	char sCrgoDesc[C_CRGO_DESC_LEN];            /*货物描述*/
	char sInvcNo[C_INVC_NO_LEN];                /*发票提单号*/
	char sSailNo[C_SAIL_NO_LEN];                /*航次*/
	char sPrnFrm[C_PRN_FRM_LEN];                /*起运日期打印格式*/
	char sCarriageCde[C_CARRIAGE_CDE_LEN];      /*运输方式*/                        
	char sVslLvlCde[C_VSL_LVL_CDE_LEN];         /*船级编码*/
	char sFromPrt[C_FROM_PRT_LEN];              /*起运港*/
	char sToPrt[C_TO_PRT_LEN];                  /*目的港*/
	char sFrmPrtAra[C_FRM_PRT_ARA_LEN];         /*起运港所在国家地区编码*/
	char sToPrtAra[C_TO_PRT_ARA_LEN];           /*目的港所在国家地区编码*/
	char sPassPrt[C_PASS_PRT_LEN];              /*途经港*/
	char sSrvyCde[C_SRVY_CDE_LEN];              /*查勘代理人编码*/
	char sSrvyCnm[C_SRVY_CNM_LEN];              /*查勘代理人名称*/
	char sUndrCndtn[C_UNDR_CNDTN_LEN];          /*承保条件*/
	double fTgtAmt;                        	    /*保险金额*/
	double fRate;                               /*费率*/
	double fTgtPrm;                     		/*保费*/
	char sPayAddr[C_PAY_ADDR_LEN];              /*赔款偿付地点*/
	char sRecNo[C_REC_NO_LEN];					/*暂存记录号*/
/*2000.07.24 zdh*/
	char sReceiptNo[ C_RECEIPT_NO_LEN ];                           /*提单号*/
	char sCrgoCls[ C_CRGO_CLS_LEN ];                           /*货物大类编码*/
	char sCrgoName[ C_CRGO_NAME_LEN ];                           /*品名描述 */
	char samount[ C_AMOUNT_LEN ];                           /*数量+单位*/
	char sPackCde[ C_PACK_CDE_LEN ];                           /*包装方式代码*/
	char sMark[ C_MARK_LEN ];                           /*唛头*/
	double fInvcAmt                     ;                           /*发票金额*/
	char sInvcAmtCur[ C_INVC_AMT_CUR_LEN ];                           /*发票金额币种*/
	char sNoRepay[ C_NO_REPAY_LEN ];                           /*免赔*/
	char sCreditId[ C_CREDIT_ID_LEN ];                           /*信用证标识*/
	char sLostDesc[ C_LOST_DESC_LEN ];                           /*以往赔付记录*/
	char sContainer[ C_CONTAINER_LEN ];                           /*集装箱*/
	char sAddRisk[ C_ADD_RISK_LEN ];                           /*其他附加风险*/
	char sPackCnm[C_PACK_CNM_LEN];
	char sSrvyAddr[ C_SRVY_ADDR_LEN ];                           /*查勘地址*/
	char sEdrInfo[ C_EDR_INFO_LEN ];                           /*批改信息*/
}plyGoTgtStru;
/* *** 投保单、保单企业财产险标的处理数据结构 *** */ 
typedef struct _plyEmpTgtStru
{
	char sCrtCde[C_CRT_CDE_LEN];				/*创建人员*/
	char sCrtTm[TIME_LEN];    					/*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];				/*修改人员*/
	char sUpdTm[TIME_LEN];						/*修改时间*/
	char sCplyAppNo[C_PLY_APP_NO_LEN];          /*投保单号*/
	char sTgtAddr[C_TGT_ADDR_LEN];              /*标的地址*/
	char sTgtZipCde[C_TGT_ZIP_CDE_LEN];         /*标的地址邮编*/
	char sMaterial[C_MATERIAL_LEN];             /*主要原材料及辅料*/
	char sTech[C_TECH_LEN];                     /*生产工艺*/
	char sTrdClsCde[C_TRD_CLS_CDE_LEN];         /*行业类型编码*/
	char sSafeDev[C_SAFE_DEV_LEN];              /*安全设施情况*/
	char sBldTypCde[C_BLD_TYP_CDE_LEN];         /*建筑类型编码*/
	char sEnvirAround[C_ENVIR_AROUND_LEN];      /*周围情况*/
	double fFromFireh;                			/*消防队距离*/
	int   nLostTms;                      		/*以往损失情况之次数*/
	double fLostAmt;       					    /*以往损失情况之金额*/
	char sLostCaus[C_LOST_CAUS_LEN];            /*以往损失情况之原因*/
	double fTgtAmt;                 			/*保险金额*/
	double fTgtPrm;            				    /*保    费*/
	double fRate;                				/*费    率*/
	char sNclmDesc[C_NCLM_DESC_LEN];            /*免赔说明*/
	char sRecNo[C_REC_NO_LEN];					/*暂存记录号*/
    char sRiskLvlCde[C_RISK_LVL_CDE_LEN];       /*风险等级代码*/
    double fKeepAmt;                            /*自留额*/
	double fCoeff;                              /*系  数*/
} plyEmpTgtStru;
/* *** 投保单、保单家庭财产长效还本险标的处理数据结构 *** */ 
typedef struct _plyFamTgtStru
{
	char sCrtCde[C_CRT_CDE_LEN];                 /*创建人员*/
	char sCrtTm[TIME_LEN];    		             /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];                 /*修改人员*/
	char sUpdTm[TIME_LEN];			             /*修改时间*/
	char sCplyAppNo[C_PLY_APP_NO_LEN];           /*投保单号*/
	char sBsnsAtrb[C_BSNS_ATRB_LEN];             /*业务性质*/
	char sHseStrc[C_HSE_STRC_LEN];               /*房屋建筑结构*/
	char sPrptyAddr[C_PRPTY_ADDR_LEN];           /*财产座落地址*/
	double fTgtAmt;                        		 /*保险金额*/
	double fSaveRate;                        	 /*保险储金率*/
	double fSaveAmt;                    		 /*保险储金*/
	double fCnvrtProp;                			 /*折算比例*/
	double fTgtPrm;                   			 /*保    费*/
	char   sPerNclmDecl[C_PER_NCLM_DECL_LEN];    /*每次事故免赔说明*/
	char sRecNo[C_REC_NO_LEN];					 /*暂存记录号*/
}	plyFamTgtStru;
/* *** 投保单、保单标的表(其他险) *** */
typedef  struct _plyTgttlbStru 
{
	char sCrtCde[C_CRT_CDE_LEN];			  /*创建人员*/
	char sCrtTm[TIME_LEN];    				  /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];			  /*修改人员*/
	char sUpdTm[TIME_LEN];					  /*修改时间*/
	char sCplyAppNo[C_PLY_APP_NO_LEN];        /*投保单号*/
	char sTgtFld1[L_TGT_FLD1_LEN];            /*标的字段1*/
	char sTgtFld2[L_TGT_FLD1_LEN];            /*标的字段2*/
	char sTgtFld3[L_TGT_FLD1_LEN];            /*标的字段3*/
	char sTgtFld4[L_TGT_FLD1_LEN];            /*标的字段4*/
	char sTgtFld5[L_TGT_FLD1_LEN];            /*标的字段5*/
	char sTgtFld6[L_TGT_FLD1_LEN];            /*标的字段6*/
	char sTgtFld7[L_TGT_FLD1_LEN];            /*标的字段7*/
	char sTgtFld8[L_TGT_FLD1_LEN];            /*标的字段8*/
	char sTgtFld9[L_TGT_FLD1_LEN];            /*标的字段9*/
	char sTgtFld10[L_TGT_FLD1_LEN];           /*标的字段10*/
	char sTgtFld11[L_TGT_FLD1_LEN];           /*标的字段11*/
	char sTgtFld12[L_TGT_FLD1_LEN];           /*标的字段12*/
	char sTgtFld13[L_TGT_FLD1_LEN];           /*标的字段13*/
	char sTgtFld14[L_TGT_FLD1_LEN];           /*标的字段14*/
	char sTgtFld15[L_TGT_FLD1_LEN];           /*标的字段15*/
	char sTgtFld16[L_TGT_FLD1_LEN];           /*标的字段16*/
	char sTgtFld17[L_TGT_FLD1_LEN];           /*标的字段17*/
	char sTgtFld18[L_TGT_FLD1_LEN];           /*标的字段18*/
	char sTgtFld19[L_TGT_FLD1_LEN];           /*标的字段19*/
	char sTgtFld20[L_TGT_FLD1_LEN];           /*标的字段20*/
	char sTgtFld21[L_TGT_FLD1_LEN];           /*标的字段21*/
	char sTgtFld22[L_TGT_FLD1_LEN];           /*标的字段22*/
	char sTgtFld23[L_TGT_FLD1_LEN];           /*标的字段23*/
	char sTgtFld24[L_TGT_FLD1_LEN];           /*标的字段24*/
	char sTgtFld25[L_TGT_FLD1_LEN];           /*标的字段25*/
	char sTgtFld26[L_TGT_FLD1_LEN];           /*标的字段26*/
	char sTgtFld27[L_TGT_FLD1_LEN];           /*标的字段27*/
	char sTgtFld28[L_TGT_FLD1_LEN];           /*标的字段28*/
	char sTgtFld29[L_TGT_FLD1_LEN];           /*标的字段29*/
	char sTgtFld30[L_TGT_FLD1_LEN];           /*标的字段30*/
	char sTgtFld31[L_TGT_FLD1_LEN];           /*标的字段31*/
	char sTgtFld32[L_TGT_FLD1_LEN];           /*标的字段32*/
	char sTgtFld33[L_TGT_FLD1_LEN];           /*标的字段33*/
	char sTgtFld34[L_TGT_FLD1_LEN];           /*标的字段34*/
	char sTgtFld35[L_TGT_FLD1_LEN];           /*标的字段35*/
	char sTgtFld36[L_TGT_FLD1_LEN];           /*标的字段36*/
	char sTgtFld37[L_TGT_FLD1_LEN];           /*标的字段37*/
	char sTgtFld38[L_TGT_FLD1_LEN];           /*标的字段38*/
	char sTgtFld39[L_TGT_FLD1_LEN];           /*标的字段39*/
	char sTgtFld40[L_TGT_FLD1_LEN];           /*标的字段40*/
	char sRecNo[C_REC_NO_LEN];				  /*暂存记录号*/
} plyTgttlbStru ;
/* *** 核保意见一览Grid数据结构 *** */ 
typedef struct _plyUndrStru
{
	char sCrtCde[C_CRT_CDE_LEN];            /*创建人员*/
	char sCrtTm[TIME_LEN];    		        /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];            /*修改人员*/
	char sUpdTm[TIME_LEN];			        /*修改时间*/
	char sDocNo[C_DOC_NO_LEN];              /*单据号*/
	char sPrnTyp[C_PRN_TYP_LEN];            /*单证类型*/
	char sUndrTm[TIME_LEN];                 /*核保日期*/
	char sDptCde[C_DPT_CDE_LEN];            /*机构部门*/
	char sUndrPrsn[C_UNDR_PRSN_LEN];        /*核保人*/
	char sUndrOpn[C_UNDR_OPN_LEN];          /*核保意见*/
	int  nSubCoNo;                          /*补充协议号*/
	char sDptCnm[C_DPT_CNM_LEN];           /*机构部门名称*/
	char sUndrPrsnCnm[C_EMP_CNM_LEN];       /*核保人名称*/
} plyUndrStru;
        
/* *** 申请单、批改单主档 *** */
typedef  struct _plyEdrappStru 
{
	char sCrtCde[C_CRT_CDE_LEN];                       /*创建人员*/
	char sCrtTm[TIME_LEN];    		                   /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];                       /*修改人员*/
	char sUpdTm[TIME_LEN];			                   /*修改时间*/
	char sEdrAppNo[C_EDR_APP_NO_LEN];                  /*申请单号*/
	char sEdrNo[C_EDR_NO_LEN];                         /*批单号*/
	char sCplyNo[C_PLY_NO_LEN];                        /*保单号*/
	char sEdrTyp[C_EDR_TYP_LEN];                       /*批改类型*/
	char sAppPrsnCde[C_APP_PRSN_CDE_LEN];              /*申请人编码*/
	char sAppPrsnNme[C_APP_PRSN_NME_LEN];              /*申请人名称*/
	char sAppPrsnAddr[C_APP_PRSN_ADDR_LEN];            /*地址*/
	char sAppPrsnTel[C_APP_PRSN_TEL_LEN];              /*电话*/
	char sEdrAppTm[DATE_LEN];                          /*申请日期*/
	char sEdrRsn[C_EDR_RSN_LEN];                       /*批改原因*/
	char sEdrCtnt[C_EDR_CTNT_LEN];                     /*批改内容*/
	double fAmtVar;                                    /*保额变化*/
	double fPrmVar;                           		   /*保费变化*/ 
	double fNclmAmt;                                   /*无赔退费*/
	double fAppntAmt;                                  /*约定退费*/
	double fNdisAmt;                      		       /*最新约定退费*/
	double fNnclmAmt;                           	   /*最新无赔退费*/
	char sOrigCplyNo[C_ORIG_PLY_NO_LEN];			   /*续保原保单号*/
	char sDptCde[C_DPT_CDE_LEN];                       /*机构部门*/
	char sBsnsTyp[C_BSNS_TYP_LEN];                     /*业务来源*/
	char sCmpnyAgtCde[C_CMPNY_AGT_CDE_LEN];            /*代理人编码*/
	int  nSubCoNo;                                     /*补充协议号*/
	char sAgtAgrNo[C_AGT_AGR_NO_LEN];                  /*代理协议号*/
	char sBrkrCde[C_BRKR_CDE_LEN];                     /*经纪人编码*/
	char sSlsCde[C_SLS_CDE_LEN];                       /*业务员编码*/
	char sInsrncCmpnyCde[C_INSRNC_CMPNY_CDE_LEN];      /*保险公司*/
	char sInsrntCde[C_INSRNT_CDE_LEN];                 /*被保险人编码*/
	char sInsrntNme[C_INSRNT_NME_LEN];                 /*被保险人名称*/
	char sInsrntAddr[C_INSRNT_ADDR_LEN];               /*被保险人地址*/
	char sBnfcCde[C_BNFC_CDE_LEN];                     /*受益人编码*/
	char sBnfcNme[C_BNFC_NME_LEN];                     /*受益人名称*/
	char sAppCde[C_APP_CDE_LEN];                       /*投保人编码*/
	char sAppNme[C_APP_NME_LEN];                       /*投保人名称*/
	char sAppAddr[C_APP_ADDR_LEN];                     /*投保人地址*/
	char sAppTel[C_APP_TEL_LEN];                       /*投保人电话*/
	char sInsrncCde[C_INSRNC_CDE_LEN];                 /*险种代码*/
	char sClausCde[C_CLAUS_CDE_LEN];                   /*主险条款*/
	char sAppTm[DATE_LEN];                             /*投保日期*/
/*6.18修改*/
	char sInsrncBgnTm[TIME_LEN];                       /*保险起期*/
	char sInsrncEndTm[TIME_LEN];                       /*保险止期*/
	char sSignTm[TIME_LEN];                            /*签单日期*/
	char sAmtCur[C_AMT_CUR_LEN];                       /*保额币种*/
	double fInsrncVlu;                                 /*保险价值*/
	double fAmt;                                       /*保险金额*/
	double fRate;                                      /*费率*/
	double fPrm;                                       /*保费*/
	double fRdrPrm;                                    /*附加险保费*/
	double fSumPrm;                                    /*保费合计*/
	char   sPrmCur[C_PRM_CUR_LEN];                     /*应收保费币种*/
	double fNclmProp;                                  /*无赔退费比例*/
	double fAppntProp;                                 /*约定退费比例*/
	double fCmmProp;                                   /*手续费比例*/
	double fBrkProp;                                   /*经纪费比例*/
	int  nPayTms;                                      /*缴费期数*/
	char sAppnt[C_APPNT_LEN];                          /*特别约定*/
	char sRemark[C_REMARK_LEN];                        /*备注*/
	char sCrtPrsn[C_CRT_PRSN_LEN];                     /*录入人*/
	char sUndrPrsn[C_UNDR_PRSN_LEN];                   /*核保人*/
	char sUndrTm [TIME_LEN];                           /*核保日期*/
	char sRinsrncMrk[C_RINSRNC_MRK_LEN];               /*分保类型*/
	char sCoinsrncMrk[C_COINSRNC_MRK_LEN];             /*共保标志*/
	char sInputTm [DATE_LEN];                          /*录入日期*/
	char sUndrDpt[C_UNDR_DPT_LEN];                     /*核保机构*/
	char sOprTyp[C_OPR_TYP_LEN];                       /*出单方式*/
	int  nEdrPrjNo;                                    /*序号*/
	char sNextEdrUndrTm[TIME_LEN];                     /*下次批改核保日期*/
	char sDptCnm [C_DPT_CNM_LEN];                      /*机构部门名称*/
	char sInsrncCnm[C_INSRNC_CNM_LEN];                 /*险种中文名称*/
	char sUndrPrsnCnm[C_EMP_CNM_LEN];                  /*核保人名称*/
	char sUndrDptCnm[C_DPT_CNM_LEN];                   /*核保机构名称*/
	char sCrtPrsnCnm[C_EMP_CNM_LEN];                   /*录入人名称*/
	char sSlsCnm [C_EMP_CNM_LEN];                      /*业务员名称*/
	char sAgtNme [C_AGT_NME_LEN];                      /*代理人名称*/
	char sAmtCurCnm[C_CUR_CNM_LEN];                    /*保额币种名称*/
  	char sAgeLongMrk[C_AGELONG_MRK_LEN];				/*多年期标志*/
	char sCeprnMrk[C_CEPRN_MRK_LEN];					/*中英文打印标志*/
   	char sUdrMrk[C_UDR_MRK_LEN];						/*核保标志*/
   	char sSalegrpCde[C_SALEGRP_CDE_LEN];				/*销售团队代码*/
	double fGotPrm;                                     /*实收保费*/
/*车险新增*/
	double fSumNclm;		                            /*无赔优待金额合计*/
	char sZipCde[C_ZIP_CDE_LEN];                        /*邮政编码*/
	char sSttl[C_STTL_LEN];								/*争议解决方式*/
	double fRatio;                                      /*短期费率系数*/
  char sCntctPrsnNme[C_CNTCT_PRSN_NME_LEN];           /*联系人*/
  char sAppTyp[C_APP_TYP_LEN];                        /*投保分类*/
/*1999.9.7 ZQM*/
	char sQueryMrk[C_QUERY_MRK_LEN];					/* 查询标志*/
	/*1999.10.8 Zdh */
	char sFstUndrPrsn[ C_FST_UNDR_PRSN_LEN ];                           /*初核人编码*/
  char sFstOpn[ C_FST_OPN_LEN ];                           /*初核人意见*/
  char sChkPrsn[ C_CHK_PRSN_LEN ];                           /*验车人*/
  char sChkRec[ C_CHK_REC_LEN ];                           /*验车记录*/
	char sChkTm[ TIME_LEN ];                           /*验车时间*/
	char sFstUndrTm[ TIME_LEN ];                           /*初核时间*/
  double fSaveAmtVar;										/* 储金变化  zdh1222*/
  /*2000.07.24 zdh*/
	char sOpenCoverNo[ C_OPEN_COVER_NO_LEN ];              /*Open cover协议号*/
	char sInternetTyp[ C_INTERNET_TYP_LEN ];              /*网上业务标志'0'-网下，'1'-网上无建议书,'2'-网上有建议书*/
} plyEdrappStru; 
/* *** 批改险别(申请单、批改单附档) *** */
typedef  struct _plyEdrapprdrStru 
{
	char sCrtCde[C_CRT_CDE_LEN];		/*创建人员*/
	char sCrtTm[TIME_LEN];    			/*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];		/*修改人员*/
	char sUpdTm[TIME_LEN];				/*修改时间*/
	char sEdrAppNo[C_EDR_APP_NO_LEN];	/*申请单号*/
	char sRdrCde[C_RDR_CDE_LEN];		/*险别代码*/
	char sRdrNme[C_RDR_NME_LEN];		/*附别名称*/
	double fRdrAmt;						/*保险金额/赔偿限额*/
	double fRdrPerAmt;				    /*每次赔偿限额*/
	double fRate;                  		/*费率*/
	double fRdrPrm;						/*保费*/
	char sDesc[C_DESC_LEN];             /*描述*/
	char sNclmDesc[C_NCLM_DESC_LEN];    /*免赔说明*/
	char sDelMrk[C_DEL_MRK_LEN];		/*注退标志*/
	char sRecNo[C_REC_NO_LEN];			/*暂存记录号*/
/*车险新增*/
	char sObjNo[C_OBJ_NO_LEN];          /*标的序号*/
	double fSeatdayNum;                 /*座(天)*/
	double fRdrPrmVar;                  /*保费变化*/
	double fRdrDis;                     /*附加险约定退费*/
	double fRdrNclm;                    /*附加险无赔退费*/
	double fRdrDisAmt;                  /*最新附加险约定退费*/
	double fRdrNclmAmt;                 /*最新附加险无赔退费*/
/*6.18增加*/
	double fRdrdisPrm;					/*打折前保费*/
	double fRdrnclmProp;				/*无赔比例*/
} plyEdrapprdrStru;
/* *** 批改标的物(申请单、批改单附档) *** */ 
typedef  struct _plyCplytgtobjAppStru 
{
	char sCrtCde[C_CRT_CDE_LEN];				/*创建人员*/
	char sCrtTm[TIME_LEN];    					/*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];				/*修改人员*/
	char sUpdTm[TIME_LEN];						/*修改时间*/
	char sEdrAppNo[C_EDR_APP_NO_LEN];			/*申请单号*/
	int  nTgtObjNo;         					/*标的物序号*/
	char sItmCls[C_ITM_CLS_LEN];				/*项目类别*/
	double fTgtObjAmt;							/*保额*/
	char sNclmDesc[C_NCLM_DESC_LEN];			/*免赔说明*/
	char sRecNo[C_REC_NO_LEN];					/*暂存记录号*/
	char sItmClsNme[C_ITM_CLS_NME_LEN];			/*项目类别名称*/
} plyCplytgtobjAppStru;
/* *** 申请单、批改单标的物表(其他险) *** */
typedef  struct _plyEdrapptgtobjStru 
{
	char sCrtCde[C_CRT_CDE_LEN];                 /*创建人员*/
	char sCrtTm[TIME_LEN];    		             /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];                 /*修改人员*/
	char sUpdTm[TIME_LEN];			             /*修改时间*/
	char sEdrAppNo[C_EDR_APP_NO_LEN];			 /*申请单号*/
	int  nTgtObjNo;						         /*标的物序号*/
	char sTgtObjFld1[L_TGT_OBJ_FLD1_LEN];        /*标的物字段1*/
	char sTgtObjFld2[L_TGT_OBJ_FLD1_LEN];        /*标的物字段2*/
	char sTgtObjFld3[L_TGT_OBJ_FLD1_LEN];        /*标的物字段3*/
	char sTgtObjFld4[L_TGT_OBJ_FLD1_LEN];        /*标的物字段4*/
	char sTgtObjFld5[L_TGT_OBJ_FLD1_LEN];        /*标的物字段5*/
	char sTgtObjFld6[L_TGT_OBJ_FLD1_LEN];        /*标的物字段6*/
	char sTgtObjFld7[L_TGT_OBJ_FLD1_LEN];        /*标的物字段7*/
	char sTgtObjFld8[L_TGT_OBJ_FLD1_LEN];        /*标的物字段8*/
	char sTgtObjFld9[L_TGT_OBJ_FLD1_LEN];        /*标的物字段9*/
	char sTgtObjFld10[L_TGT_OBJ_FLD1_LEN];       /*标的物字段10*/
	char sRecNo[C_REC_NO_LEN];					 /*暂存记录号*/
} plyEdrapptgtobjStru ;
/* *** 付款处理(申请单、批改单附档) *** */ 
typedef  struct _plyEdrapppayStru 
{
	char sCrtCde[C_CRT_CDE_LEN];               /*创建人员*/
	char sCrtTm[TIME_LEN];    	               /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];               /*修改人员*/
	char sUpdTm[TIME_LEN];		               /*修改时间*/
	char sEdrAppNo[C_EDR_APP_NO_LEN];          /*申请单号*/
	int  nTms;				                   /*缴费期别*/
	char sRcptNo[C_RCPT_NO_LEN];               /*收据号*/
	char sPayPrsnCde[C_PAY_PRSN_CDE_LEN];      /*付款人编码*/
	char sPayPrsnNme[C_PAY_PRSN_NME_LEN];      /*付款人姓名*/
	double fGetPrm;					           /*应收保费*/
	char sPayMdeCde[C_PAY_MDE_CDE_LEN];        /*付款方式*/
	char sAccntNo[C_ACCNT_NO_LEN];             /*银行帐号*/
	char sPayLmtTm[DATE_LEN];                  /*缴费截止日期*/
	double fGotPrm;                            /*实收保费*/
	char sPayStrtTm[DATE_LEN];                 /*缴费起始日期*/
	char sPayTm[DATE_LEN];					   /*收费日期*/
	char sInsrncCde[C_INSRNC_CDE_LEN];         /*险种*/
	char sCurTyp[C_CUR_TYP_LEN];               /*币种*/
	char sRecNo[C_REC_NO_LEN];				   /*暂存记录号*/
/*新增*/
	char sPrnTyp[C_PRN_TYP_LEN];               /*单证类型*/
}plyEdrapppayStru;
/*货运标的(申请单、批改单附档)*/
typedef  struct _plyEdrappcrgoStru 
{
	char sCrtCde[C_CRT_CDE_LEN];               /*创建人员*/
	char sCrtTm[TIME_LEN];    		           /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];               /*修改人员*/
	char sUpdTm[TIME_LEN];			           /*修改时间*/
	char sEdrAppNo[C_EDR_APP_NO_LEN];          /*申请单号*/
	char sCrgoCde[C_CRGO_CDE_LEN];             /*货物类型编码*/
	char sCrgoCnm[C_CRGO_CNM_LEN];		 	   /*货物名称*/
	char sCrgoDesc[C_CRGO_DESC_LEN];           /*货物描述*/
	char sInvcNo[C_INVC_NO_LEN];               /*发票提单号*/
	char sSailNo[C_SAIL_NO_LEN];               /*航次*/
	char sPrnFrm[C_PRN_FRM_LEN];               /*起运日期打印格式*/
	char sCarriageCde[C_CARRIAGE_CDE_LEN];     /*运输方式*/                      
	char sVslLvlCde[C_VSL_LVL_CDE_LEN];        /*船级编码*/
	char sFromPrt[C_FROM_PRT_LEN];             /*起运港*/
	char sToPrt[C_TO_PRT_LEN];                 /*目的港*/
	char sFrmPrtAra[C_FRM_PRT_ARA_LEN];        /*起运港所在国家地区编码*/
	char sToPrtAra[C_TO_PRT_ARA_LEN];          /*目的港所在国家地区编码*/
	char sPassPrt[C_PASS_PRT_LEN];             /*途经港*/
	char sSrvyCde[C_SRVY_CDE_LEN];             /*查勘代理人编码*/
	char sSrvyCnm[C_SRVY_CNM_LEN];             /*查勘代理人名称*/
	char sUndrCndtn[C_UNDR_CNDTN_LEN];         /*承保条件*/
	double fTgtAmt;                        	   /*保险金额*/
	double fRate;                              /*费率*/
	double fTgtPrm;                     	   /*保费*/
	char sPayAddr[C_PAY_ADDR_LEN];             /*赔款偿付地点*/
	char sRecNo[C_REC_NO_LEN];				   /*暂存记录号*/

	char sReceiptNo[ C_RECEIPT_NO_LEN ];                          /*提单号*/
	char sCrgoCls[ C_CRGO_CLS_LEN ];                       /*货物大类编码*/
	char sCrgoName[ C_CRGO_NAME_LEN ];                      /*品名描述 */
	char samount[ C_AMOUNT_LEN ];                           /*数量+单位*/
	char sPackCde[ C_PACK_CDE_LEN ];                       /*包装方式代码*/
	char sMark[ C_MARK_LEN ];                           /*唛头*/
	double fInvcAmt;                       /*发票金额*/
	char sInvcAmtCur[ C_INVC_AMT_CUR_LEN ];               /*发票金额币种*/
	char sNoRepay[ C_NO_REPAY_LEN ];                           /*免赔*/
	char sCreditId[ C_CREDIT_ID_LEN ];                        /*信用证标识*/
	char sLostDesc[ C_LOST_DESC_LEN ];                     /*以往赔付记录*/
	char sContainer[ C_CONTAINER_LEN ];                           /*集装箱*/
	char sAddRisk[ C_ADD_RISK_LEN ];                       /*其他附加风险*/
	char sPackCnm[ C_PACK_CNM_LEN ];                         /*包装方式*/
	char sSrvyAddr[ C_SRVY_ADDR_LEN ];                           /*查勘地址*/
	char sEdrInfo[ C_EDR_INFO_LEN ];                           /*批改信息*/
} plyEdrappcrgoStru ;
/*家财长效还本险标的(申请单、批改单附档)*/
typedef  struct _plyEdrappfmlprptStru 
{
	char sCrtCde[C_CRT_CDE_LEN];              /*创建人员*/
	char sCrtTm[TIME_LEN];    		          /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];              /*修改人员*/
	char sUpdTm[TIME_LEN];			          /*修改时间*/
	char sEdrAppNo[C_EDR_APP_NO_LEN];         /*申请单号*/
	char sBsnsAtrb[C_BSNS_ATRB_LEN];          /*业务性质*/
	char sHseStrc[C_HSE_STRC_LEN];            /*房屋建筑结构*/
	char sPrptyAddr[C_PRPTY_ADDR_LEN];        /*财产座落地址*/
	double fTgtAmt;                        	  /*保险金额*/
	double fSaveRate;                         /*保险储金率*/
	double fSaveAmt;                    	  /*保险储金*/
	double fCnvrtProp;                		  /*折算比例*/
	double fTgtPrm;                   		  /*保费*/
	char sPerNclmDecl[C_PER_NCLM_DECL_LEN];   /*每次事故免赔说明*/
	char sRecNo[C_REC_NO_LEN];				  /*暂存记录号*/
} plyEdrappfmlprptStru; 
/*企财标的（申请单、批改单附档）*/
typedef  struct _plyEdrapporgprptStru 
{
	char sCrtCde[C_CRT_CDE_LEN];             /*创建人员*/
	char sCrtTm[TIME_LEN];    	             /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];             /*修改人员*/
	char sUpdTm[TIME_LEN];			         /*修改时间*/
	char sEdrAppNo[C_EDR_APP_NO_LEN];        /*申请单号*/
	char sTgtAddr[C_TGT_ADDR_LEN];           /*标的地址*/
	char sTgtZipCde[C_TGT_ZIP_CDE_LEN];      /*标的地址邮编*/
	char sMaterial[C_MATERIAL_LEN];          /*主要原材料及辅料*/
	char sTech[C_TECH_LEN];                  /*生产工艺*/
	char sTrdClsCde[C_TRD_CLS_CDE_LEN];      /*行业类型编码*/
	char sSafeDev[C_SAFE_DEV_LEN];           /*安全设施情况*/
	char sBldTypCde[C_BLD_TYP_CDE_LEN];      /*建筑类型编码*/
	char sEnvirAround[C_ENVIR_AROUND_LEN];   /*周围情况*/
	double fFromFireh;                		 /*消防队距离*/
	int   nLostTms;                    		 /*以往损失情况之次数*/
	double fLostAmt;       				     /*以往损失情况之金额*/
	char sLostCaus[C_LOST_CAUS_LEN];         /*以往损失情况之原因*/
	double fTgtAmt;                 		 /*保险金额*/
	double fTgtPrm;            				 /*保费*/
	double fRate;                			 /*费率*/
	char sNclmDesc[C_NCLM_DESC_LEN];         /*免赔说明*/
	char sRecNo[C_REC_NO_LEN];				 /*暂存记录号*/
	char sRiskLvlCde[C_RISK_LVL_CDE_LEN];    /*风险等级代码*/
	double fKeepAmt;                         /*自留额*/
	double fCoeff;							 /*系  数*/
} plyEdrapporgprptStru ;
/*申请单、批改单标的表(其他险)*/
typedef  struct _plyEdrapptgtStru 
{
	char sCrtCde[C_CRT_CDE_LEN];             /*创建人员*/
	char sCrtTm[TIME_LEN];    		         /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];             /*修改人员*/
	char sUpdTm[TIME_LEN];			         /*修改时间*/
	char sEdrAppNo[C_EDR_APP_NO_LEN];        /*申请单号*/
	char sTgtFld1[L_TGT_FLD1_LEN];           /*标的字段1*/
	char sTgtFld2[L_TGT_FLD1_LEN];           /*标的字段2*/
	char sTgtFld3[L_TGT_FLD1_LEN];           /*标的字段3*/
	char sTgtFld4[L_TGT_FLD1_LEN];           /*标的字段4*/
	char sTgtFld5[L_TGT_FLD1_LEN];           /*标的字段5*/
	char sTgtFld6[L_TGT_FLD1_LEN];           /*标的字段6*/
	char sTgtFld7[L_TGT_FLD1_LEN];           /*标的字段7*/
	char sTgtFld8[L_TGT_FLD1_LEN];           /*标的字段8*/
	char sTgtFld9[L_TGT_FLD1_LEN];           /*标的字段9*/
	char sTgtFld10[L_TGT_FLD1_LEN];          /*标的字段10*/
	char sTgtFld11[L_TGT_FLD1_LEN];          /*标的字段11*/
	char sTgtFld12[L_TGT_FLD1_LEN];          /*标的字段12*/
	char sTgtFld13[L_TGT_FLD1_LEN];          /*标的字段13*/
	char sTgtFld14[L_TGT_FLD1_LEN];          /*标的字段14*/
	char sTgtFld15[L_TGT_FLD1_LEN];          /*标的字段15*/
	char sTgtFld16[L_TGT_FLD1_LEN];          /*标的字段16*/
	char sTgtFld17[L_TGT_FLD1_LEN];          /*标的字段17*/
	char sTgtFld18[L_TGT_FLD1_LEN];          /*标的字段18*/
	char sTgtFld19[L_TGT_FLD1_LEN];          /*标的字段19*/
	char sTgtFld20[L_TGT_FLD1_LEN];          /*标的字段20*/
	char sTgtFld21[L_TGT_FLD1_LEN];          /*标的字段21*/
	char sTgtFld22[L_TGT_FLD1_LEN];          /*标的字段22*/
	char sTgtFld23[L_TGT_FLD1_LEN];          /*标的字段23*/
	char sTgtFld24[L_TGT_FLD1_LEN];          /*标的字段24*/
	char sTgtFld25[L_TGT_FLD1_LEN];          /*标的字段25*/
	char sTgtFld26[L_TGT_FLD1_LEN];          /*标的字段26*/
	char sTgtFld27[L_TGT_FLD1_LEN];          /*标的字段27*/
	char sTgtFld28[L_TGT_FLD1_LEN];          /*标的字段28*/
	char sTgtFld29[L_TGT_FLD1_LEN];          /*标的字段29*/
	char sTgtFld30[L_TGT_FLD1_LEN];          /*标的字段30*/
	char sTgtFld31[L_TGT_FLD1_LEN];          /*标的字段31*/
	char sTgtFld32[L_TGT_FLD1_LEN];          /*标的字段32*/
	char sTgtFld33[L_TGT_FLD1_LEN];          /*标的字段33*/
	char sTgtFld34[L_TGT_FLD1_LEN];          /*标的字段34*/
	char sTgtFld35[L_TGT_FLD1_LEN];          /*标的字段35*/
	char sTgtFld36[L_TGT_FLD1_LEN];          /*标的字段36*/
	char sTgtFld37[L_TGT_FLD1_LEN];          /*标的字段37*/
	char sTgtFld38[L_TGT_FLD1_LEN];          /*标的字段38*/
	char sTgtFld39[L_TGT_FLD1_LEN];          /*标的字段39*/
	char sTgtFld40[L_TGT_FLD1_LEN];          /*标的字段40*/
	char sRecNo[C_REC_NO_LEN];				 /*暂存记录号*/
} plyEdrapptgtStru ;
/*批改原因表*/
typedef  struct _plyEdrrsnStru 
{
	char sCrtCde[C_CRT_CDE_LEN];            /*创建人员*/
	char sCrtTm[TIME_LEN];    		        /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];            /*修改人员*/
	char sUpdTm[TIME_LEN];			        /*修改时间*/ 
	char sEdrRsn[C_EDR_RSN_LEN];            /*批改原因*/
	char sInsrncCde[C_INSRNC_CDE_LEN];  	/*险种码*/
	char sEdrRsnCnm[C_EDR_RSN_CNM_LEN]; 	/*批改原因中文名称*/
	char sEdrRsnEnm[C_EDR_RSN_ENM_LEN]; 	/*批改原因英文名称*/
	char sEdrTyp[C_EDR_TYP_LEN]; 			/*批单类型*/
	char sEdrTxt[C_EDR_TXT_LEN];   			/*批文范本*/
	char t_adb_tm[TIME_LEN];				/*失效时间*/
} plyEdrrsnStru;
/*批改项目表*/
typedef  struct _plyEdrprjStru 
{
	char sCrtCde[C_CRT_CDE_LEN];           /*创建人员*/
	char sCrtTm[TIME_LEN];    		       /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];           /*修改人员*/
	char sUpdTm[TIME_LEN];			       /*修改时间*/ 
	char sEdrRsn[C_EDR_RSN_LEN];           /*批改原因*/
	int  nEdrPrjNo;				           /*序号*/
	char sEdrTlbNme[C_EDR_TLB_NME_LEN];    /*批改项对应表名*/
	char sEdrFldCnm[C_EDR_FLD_CNM_LEN];    /*批改域中文名*/
	char sEdrFldNme[C_EDR_FLD_NME_LEN];    /*批改域字段名*/
} plyEdrprjStru ;
/*投保单Grid一览数据结构：*/
typedef struct _plyAppPolyGridStru
{
	char sCrtCde[C_CRT_CDE_LEN];               /*创建人员*/
	char sCrtTm[TIME_LEN];    		           /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];               /*修改人员*/
	char sUpdTm[TIME_LEN];			           /*修改时间*/
	char sDocNo[C_DOC_NO_LEN];                 /*单据号*/
	char sSendTm[TIME_LEN];                    /*发送时间*/
	char sBlgDptCde[C_BLG_DPT_CDE_LEN];        /*所属机构*/
	char sSource[C_SOURCE_LEN];                /*产生源*/
	char sSendDptCde[C_SEND_DPT_CDE_LEN];      /*发送机构*/
	char sSendCde[C_SEND_CDE_LEN];             /*发送人*/
	char sDesDptCde[C_DES_DPT_CDE_LEN];        /*目标机构*/
	char sEmergency[C_EMERGENCY_LEN];          /*紧急程度*/
	char sAuthPrnCde[C_AUTH_PRN_CDE_LEN];      /*授权人*/
	char sUdrMrk[C_UDR_MRK_LEN];               /*核保标志*/
	char sSendMrk[C_SEND_MRK_LEN];             /*发送标志*/
	char sUdrOpnMrk[C_UDR_OPN_MRK_LEN];        /*核保意见标志*/
 	int  nVrfyMrk;                             /*审核标志*/
    char sMdfyTm[TIME_LEN];   			       /*修改时间*/
	char sInsrncCde[C_INSRNC_CDE_LEN];         /*险种*/
	char sUndrPrsn[C_UNDR_PRSN_LEN];           /*核保人*/
	char sUndrDpt[C_UNDR_DPT_LEN];             /*核保机构*/
	char sPrnTyp[C_PRN_TYP_LEN];               /*单证类型*/
	char sRinsrncMrk[C_RINSRNC_MRK_LEN];       /*分保类型*/
	char sCoinsrncMrk[C_COINSRNC_MRK_LEN];     /*共保标志*/
	char sCplyNo[C_PLY_NO_LEN];                /*保单号*/
	char sEdrNo[C_EDR_NO_LEN];                 /*批单号*/
	char sReadTime[TIME_LEN];      			   /*读取时间， 用于并发控制*/
	char sRecNo[C_REC_NO_LEN];				   /*暂存记录号*/
	char cWorkMrk;						/*工作栏标志	0-暂存,1-待修改，2-已申请核保*/
	char cFlag;		/*提交处理标志 0-不提交 1-保存 2-申请核保 3-撤回  4-查询  5-删除*/
	char sAppNme[C_APP_NME_LEN];               /*投保人名称*/
	char sApptTm[DATE_LEN];					   /*投保日期*/
	char sSignTm[TIME_LEN];					   /*签单日期*/
	char sInsrntNme[C_INSRNT_NME_LEN];         /*被保险人名称*/
    char sRptDesc[C_RPT_DESC_LEN];             /*上报说明*/
	char sEdrTyp[C_EDR_TYP_LEN];               /*批改类型*/
	char sRiskLvlCde[C_RISK_LVL_CDE_LEN];      /*风险等级代码*/
/*车险新增*/
	char sLcnNo[C_LCN_NO_LEN];				   /*牌照号码*/
	char sEngNo[C_ENG_NO_LEN];				   /*发动机号*/
	char sInsrncCls[C_INSRNC_CLS_LEN];		   /*险种大类*/
/*7.13增加*/
    char	sAppTyp[C_APP_TYP_LEN];             /*投保分类*/
/*8。11zdh增*/
	char sUseAtr[C_USE_ATR_LEN];             /*使用性质*/
/*10。16zdh增*/
	char sUndrOpn[C_UNDR_OPN_LEN];          /*核保意见*/
	char sInternetTyp[ C_INTERNET_TYP_LEN ];              /*网上业务标志'0'-网下，'1'-网上无建议书,'2'-网上有建议书*/
}plyAppPolyGridStru;
/*核保工作栏数据结构：*/
typedef struct _plyCheckGridStru
{
	char sCrtCde[C_CRT_CDE_LEN];              /*创建人员*/
	char sCrtTm[TIME_LEN];    		          /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];              /*修改人员*/
	char sUpdTm[TIME_LEN];			          /*修改时间*/
	char sDocNo[C_DOC_NO_LEN];                /*单 据 号*/
	char sSendTm[TIME_LEN];                   /*发送时间*/
	char sBlgDptCde[C_BLG_DPT_CDE_LEN];       /*所属机构*/
	char sSource[C_SOURCE_LEN];               /*产 生 源*/
	char sSendDptCde[C_SEND_DPT_CDE_LEN];     /*发送机构*/
	char sSendCde[C_SEND_CDE_LEN];            /*发 送 人*/
	char sDesDptCde[C_DES_DPT_CDE_LEN];       /*目标机构*/
	char sEmergency[C_EMERGENCY_LEN];         /*紧急程度*/
	char sAuthPrnCde[C_AUTH_PRN_CDE_LEN];     /*授 权 人*/
	char sUdrMrk[C_UDR_MRK_LEN];              /*核保标志*/
	char sSendMrk[C_SEND_MRK_LEN];            /*发送标志*/
	char sUdrOpnMrk[C_UDR_OPN_MRK_LEN];       /*核保意见标志*/
	int  nVrfyMrk;                            /*审核标志*/
    char sMdfyTm[TIME_LEN];   			      /*时间戳*/
	char sInsrncCde[C_INSRNC_CDE_LEN];        /*险    种*/
	char sUndrPrsn[C_UNDR_PRSN_LEN];          /*核 保 人*/
	char sUndrDpt[C_UNDR_DPT_LEN];            /*核保机构*/
	char sPrnTyp[C_PRN_TYP_LEN];              /*单证类型*/
	char sRinsrncMrk[C_RINSRNC_MRK_LEN];      /*分保类型*/
	char sCoinsrncMrk[C_COINSRNC_MRK_LEN];    /*共保标志*/
	char sCplyNo[C_PLY_NO_LEN];               /*保单号*/
	char sEdrNo[C_EDR_NO_LEN];                /*批单号*/
	char cRead;                      /*读取标志  0-投保单未读入 1-投保单已读入 */ 
	char cFlag; /* 提交处理标志  0-不提交  1 -查询 2-查询并审核  3-撤回  4-核保处理  5-清除*/
	char sInsrntNme[C_INSRNT_NME_LEN];        /*被保险人名称*/
	char sInsrncCnm[C_INSRNC_CNM_LEN];		  /*险种名称*/
	char sBlgDptCnm[C_DPT_CNM_LEN];           /*所属机构名称*/
	char sSendDptCnm[C_DPT_CNM_LEN];          /*发送机构名称*/
	char sDesDptCnm[C_DPT_CNM_LEN];           /*目标机构名称*/
	char sUndrDptCnm[C_DPT_CNM_LEN];          /*核保机构名称*/
	char sSignTm[TIME_LEN];					  /*签单日期*/
    char sRptDesc[C_RPT_DESC_LEN];            /*上报说明*/
	char sEdrTyp[C_EDR_TYP_LEN];              /*批改类型*/
	char sRiskLvlCde[C_RISK_LVL_CDE_LEN];     /*风险等级代码*/
/*车险新增*/
	char sLcnNo[C_LCN_NO_LEN];				  /*牌照号码*/
	char sEngNo[C_ENG_NO_LEN];				  /*发动机号*/
	char sInsrncCls[C_INSRNC_CLS_LEN];		  /*险种大类*/
/*8。11zdh增*/
	char sUseAtr[C_USE_ATR_LEN];             /*使用性质*/
	char sAppTyp[C_APP_TYP_LEN];                    /*投保分类*/
	char sAppTm[DATE_LEN];                             /*投保日期*/
	char sInputTm [DATE_LEN];                          /*录入日期*/
	char sAppNme[C_APP_NME_LEN];               /*投保人名称*/
	char sUndrOpn[C_UNDR_OPN_LEN];          /*核保意见*/
	char	sEdrAppTm[DATE_LEN];				/*申请日期*/
	char sInternetTyp[ C_INTERNET_TYP_LEN ];     /*网上业务标志'0'-网下，'1'-网上无建议书,'2'-网上有建议书*/
}plyCheckGridStru;
/*申请单Grid一览数据结构*/
typedef struct _plyEdrGridStru
{
	char sCrtCde[C_CRT_CDE_LEN];               /*创建人员*/
	char sCrtTm[TIME_LEN];    		           /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];               /*修改人员*/
	char sUpdTm[TIME_LEN];			           /*修改时间*/
	char sDocNo[C_DOC_NO_LEN];                 /*单据号*/
	char sSendTm[TIME_LEN];                    /*发送时间*/
	char sBlgDptCde[C_BLG_DPT_CDE_LEN];        /*所属机构*/
	char sSource[C_SOURCE_LEN];                /*产生源*/
	char sSendDptCde[C_SEND_DPT_CDE_LEN];      /*发送机构*/
	char sSendCde[C_SEND_CDE_LEN];             /*发送人*/
	char sDesDptCde[C_DES_DPT_CDE_LEN];        /*目标机构*/
	char sEmergency[C_EMERGENCY_LEN];          /*紧急程度*/
	char sAuthPrnCde[C_AUTH_PRN_CDE_LEN];      /*授权人*/
	char sUdrMrk[C_UDR_MRK_LEN];               /*核保标志*/
	char sSendMrk[C_SEND_MRK_LEN];             /*发送标志*/
	char sUdrOpnMrk[C_UDR_OPN_MRK_LEN];        /*核保意见标志*/
	int  nVrfyMrk;                             /*审核标志*/
    char sMdfyTm[TIME_LEN];   			       /*时间戳*/
	char sInsrncCde[C_INSRNC_CDE_LEN];         /*险种*/
	char sUndrPrsn[C_UNDR_PRSN_LEN];           /*核保人*/
	char sUndrDpt[C_UNDR_DPT_LEN];             /*核保机构*/
	char sPrnTyp[C_PRN_TYP_LEN];               /*单证类型*/
	char sRinsrncMrk[C_RINSRNC_MRK_LEN];       /*分保类型*/
	char sCoinsrncMrk[C_COINSRNC_MRK_LEN];     /*共保标志*/
	char sCplyNo[C_PLY_NO_LEN];                /*保单号*/
	char sEdrNo[C_EDR_NO_LEN];                 /*批单号*/
	char sReadTime[TIME_LEN];      			   /*读取时间,用于并发控制*/
	char sRecNo[C_REC_NO_LEN];				   /*暂存记录号*/
	char cFlag;  /*提交处理标志 0-不提交 1-保存 2-申请核保 3-撤回  4-查询  5-删除*/
	char sInsrncDfnTyp[C_INSRNC_DFN_TYP_LEN];  /*(险种表)险种定义类别*/
	char sInsrncCnm[C_INSRNC_CNM_LEN];         /*(险种表)险种中文名称*/
	char sEdrTyp[C_EDR_TYP_LEN];               /*(申请单主档)批改类型*/  
	char sAppNme[C_APP_NME_LEN];               /*(申请单主档)投保人名称*/
	double fAmt;                 			   /*(申请单主档)保险金额*/
	char sSignTm[TIME_LEN];					   /*签单日期*/
    char sRptDesc[C_RPT_DESC_LEN];             /*上报说明*/
	char sRiskLvlCde[C_RISK_LVL_CDE_LEN];      /*风险等级代码*/
/*车险新增*/
	char sLcnNo[C_LCN_NO_LEN];				   /*牌照号码*/
	char sEngNo[C_ENG_NO_LEN];				   /*发动机号*/
	char sInsrncCls[C_INSRNC_CLS_LEN];		   /*险种大类*/
/*8.11 zdh*/
	char sUseAtr[C_USE_ATR_LEN];             /*使用性质*/
	char sUndrOpn[C_UNDR_OPN_LEN];          /*核保意见*/
	char sInternetTyp[C_INTERNET_TYP_LEN];

}plyEdrGridStru;
 /*	批量批改保单Grid一览数据结构 */
typedef struct _plyPolyGridStru
{
	char	sCrtCde[C_CRT_CDE_LEN];             /*创建人员*/
	char	sCrtTm[TIME_LEN];    		        /*创建时间*/
	char	sUpdCde[C_UPD_CDE_LEN];             /*修改人员*/
	char	sUpdTm[TIME_LEN];			        /*修改时间*/
	char	cWorkMrk;					/*工作栏标志 0-费率批改，1-约定退费批改	
										2-家财长效保费增加 3-批量自动注销*/
	char	cFlag;		/*处理标志 0-未选定，1-选定，2-已处理*/
	char	sCplyNo[C_PLY_NO_LEN];				/*保 单 号*/
	char	sEdrNo[C_EDR_NO_LEN];               /*批 单 号*/
	char	sInsrntNme[C_INSRNT_NME_LEN];		/*被保险人名称*/
	char	sInsrncCde[C_INSRNC_CDE_LEN];		/*险种代码*/
	double	fAmt;								/*保险金额*/
	double 	fRate;								/*费    率*/
	double	fPrm;								/*保    费*/
	double	fSumPrm;							/*保费合计*/
	char	sPrmCur[C_PRM_CUR_LEN];				/*应收保费币种*/
	double	fAppntProp;							/*约定退费比例*/
	char	sAppPrsnCde[C_APP_PRSN_CDE_LEN];    /*申请人编码*/
	char	sAppPrsnNme[C_APP_PRSN_NME_LEN];    /*申请人名称*/
	char	sEdrAppTm[DATE_LEN];				/*申请日期*/
	char	sEdrTyp[C_EDR_TYP_LEN];             /*批改类型*/
	double	fAmtVar;                            /*保额变化*/
	double	fPrmVar;							/*保费变化*/
	double	fAppntAmt;                          /*约定退费*/
	char	sInsrncBgnTm[DATE_LEN];				/*保险起期*/
	char	sInsrncEndTm[DATE_LEN];				/*保险止期*/
	double	fSaveAmt;							/*保险储金*/
	double	fEndSumPrm;							/*改后保费*/
	char	sInsrncCnm[C_INSRNC_CNM_LEN];		/*险种名称*/
	char	sDptCde[C_DPT_CDE_LEN];             /*机构部门*/
/*1999.08.04新增*/
	char	sOldEdrNo[C_EDR_NO_LEN];            /*注退前批单号*/
}plyPolyGridStru;
/* 批量批改保单查询条件数据结构 */
typedef struct _plyPolyFdCondStru
{
	char	cWorkMrk;			/*工作栏标志 0-费率批改，1-约定退费批改
											2-家财长效保费增加 3-批量自动注销*/
	char	sInsrncCde[C_INSRNC_CDE_LEN];	/*险    种*/
	char	sAppCde[C_APP_CDE_LEN];			/*投保人编码*/
	char 	sDptCde[C_DPT_CDE_LEN];			/*机构部门*/
	char	sPrmCur[C_PRM_CUR_LEN];			/*应收币种*/
	char	sSignTm0[DATE_LEN];				/*出单起期*/
	char	sSignTm1[DATE_LEN];				/*出单止期*/
	char	cLowDpt;						/*下级机构*/
/*8.02增加*/
	char	sInsrncCls[C_INSRNC_CLS_LEN];	/*险种大类*/
  char  sInsrntNme[C_INSRNT_NME_LEN];   /*被保险人名称*/
	char	sCplyNo[C_PLY_NO_LEN];				/*保单号*/
/*2000.7.03增加*/
}plyPolyFdCondStru;
/* *** 手续费处理保单查询条件数据结构 *** */
typedef struct _plyPolyAgtFdCondStru
{
	char	cWorkMrk;			/*工作栏标志 0-直接业务，1-代理人 2-经纪人 3-其他保险公司*/
	char	sCplyNo[C_PLY_NO_LEN];				/*起始保单号*/
    char	sCplyNo2[C_PLY_NO_LEN];				/*截止保单号*/
	char	sInsrncCde[C_INSRNC_CDE_LEN];		/*险    种*/
	char	sAppCde[C_BRKR_CDE_LEN];			/*保险公司、经纪人、代理人*/
	char 	sDptCde[C_DPT_CDE_LEN];				/*机构部门*/
	char	sPrmCur[C_PRM_CUR_LEN];				/*应收币种*/
	char	sSignTm0[DATE_LEN];					/*出单起期*/
	char	sSignTm1[DATE_LEN];					/*出单止期*/
	char	cLowDpt;							/*下级机构*/
/*车险新增*/
	char	sLcnNo[C_LCN_NO_LEN];               /*牌照号码*/
	char	sEngNo[C_ENG_NO_LEN];               /*发动机号*/
	char	cFlag;								/*查询标志*/
/*6.18增加*/
	char	sInsrncCls[C_INSRNC_CLS_LEN];		/*险种大类*/
	char	sInsrntNme[C_INSRNT_NME_LEN];		/*被保险人名称*/
} plyPolyAgtFdCondStru;
/* *** 手续费处理保单Grid一览数据结构 *** */
typedef struct _plyPolyAgtGridStru
{
	char	cWorkMrk;			/*工作栏标志 0-直接业务，1-代理人 2-经纪人 3-其他保险公司*/
	char	cFlag;				/*处理标志 0-未选定，1-选定，2-已处理*/
	char	crctNo[CRCTNO_LEN];                     /*收据号*/
	char	sCplyNo[C_PLY_NO_LEN];					/*保 单 号*/
	char	sInsrncCde[C_INSRNC_CDE_LEN];			/*险种代码*/
	char	sDptCde[C_DPT_CDE_LEN];					/*机构部门*/
	char	sPrmCur[C_PRM_CUR_LEN];					/*应收保费币种*/
	double	fGotAmt;								/*实收保费*/
	double	fGetAmt;								/*应收净保费*/
	double	fCmmProp;								/*手续费比例*/
	double	fCmmLmt;								/*手续费限额*/
	double	fGotCmm;								/*已付手续费*/
	double	fGetCmm;								/*本次手续费*/
	double  fGotAmtLmt;                             /*实收保费限额*/
/*车险新增(5/26)*/    
	char    sBsnsTyp[C_BSNS_TYP_LEN];                /*业务来源*/
    char	sDoprDte[DATE_LEN];                     /*凭证日期*/
    char	sSlsCde[C_SLS_CDE_LEN];                 /*业务员*/
    char	sCrtPrsn[C_CRT_PRSN_LEN];               /*录入人*/
    char	sUndrPrsn[C_UNDR_PRSN_LEN];             /*审核人*/
    char	sUdrMrk[C_UDR_MRK_LEN];                 /*审核标志*/
    char	sVrfyTm[TIME_LEN];                      /*审核日期*/
    char	sRemark[C_REMARK_LEN];                  /*备注*/
    int		nEdrPrjNo;                              /*序号*/
    char	sNextEdrUndrTm[TIME_LEN];               /*下次审核日期*/
    char	sCmpnyAgtCde[C_CMPNY_AGT_CDE_LEN];      /*代理人编码*/
    char	sEngNo[C_ENG_NO_LEN];                   /*发动机号*/
    char	sLcnNo[C_LCN_NO_LEN];                   /*牌照号码*/
    char	sUndrTm[DATE_LEN];                      /*核保日期*/
	char	sInsrntNme[C_INSRNT_NME_LEN];		    /*被保险人名称*/
/*8.11zdh增*/
	double	fSumProp;								/*已付比例*/
	double	fThisProp;								/*本次比例*/
/*11.4lzz增*/
	char sAppNme[C_APP_NME_LEN];                    /*投保人名称、代理人名称、经纪人名称*/
}plyPolyAgtGridStru;
/* *** 查询多条核保信息记录的数据结构 *** */
typedef struct _plyCheckSchCondStru
{
    char	cWorkMrk;						/*工作栏标志	DEAL_WORK   -受理业务,
															REPORT_WORK -已上报业务*/
	char	sOwnDptCde[C_DPT_CDE_LEN];		/*本机构代码*/
	char	sCplyAppNo[C_PLY_APP_NO_LEN];	/*投保单号*/
	char	sInsrncCde[C_INSRNC_CDE_LEN];	/*险种代码*/
	char 	sDptCde[C_DPT_CDE_LEN];			/*机构部门代码*/
	char	sBeginDate[DATE_LEN];			/*起始时间*/
	char	sEndDate[DATE_LEN];				/*截止时间*/
	char	cChecked;						/*已核保*/
	char	cNotChecked;					/*未核保*/
	char	sPrnTyp[C_PRN_TYP_LEN];			/*单证类型*/
	char	cLowDpt;						/*下级机构*/
    char    sInsrntNme[C_INSRNT_NME_LEN];   /*被保险人名称*/
/*车险新增*/
	char	sLcnNo[C_LCN_NO_LEN];           /*牌照号码*/
	char	sEngNo[C_ENG_NO_LEN];           /*发动机号*/
/*6.18增加*/
	char	sInsrncCls[C_INSRNC_CLS_LEN];	/*险种大类*/
/*8。11zdh增*/
    char	sUid[C_UID_LEN];                /*用户ID*/
/*lzzSep*/
	char    sAlarmMrk[C_ALARM_MRK_LEN];             /*报警标志*/
/*2000.07.24 zdh*/
	char sInternetTyp[ C_INTERNET_TYP_LEN ];      /*网上业务标志'0'-网下，'1'-网上无建议书,'2'-网上有建议书*/
} plyCheckSchCondStru;
/* *** 投保单查询条件数据结构 *** */
typedef struct _plyAppPolyFdCondStru
{
	char	 cWorkMrk;							/*工作栏标志	SAVE_WORK  -暂存
																ALTER_WORK -待修改
																APP_WORK   -已申请核保*/
	char	 sInsrncCde[C_INSRNC_CDE_LEN];		/*险种代码*/
	char	 sCplyAppNo[C_PLY_APP_NO_LEN];		/*投保单号*/
	char	 sCplyNo[C_PLY_NO_LEN];			    /*保 单 号*/
	char	 sDptCde[C_DPT_CDE_LEN];			/*机构部门*/
	char	 sApptTm0[DATE_LEN];				/*投保日期0*/
	char	 sApptTm1[DATE_LEN];				/*投保日期1*/
	char	 cLowDpt;							/*下级机构*/
	char     sInsrntNme[C_INSRNT_NME_LEN];      /*被保险人名称*/
	char	 sInputTm0[DATE_LEN];				/*录入日期0*/
	char	 sInputTm1[DATE_LEN];				/*录入日期1*/
/*车险新增*/
	char	sLcnNo[C_LCN_NO_LEN];				/*牌照号码*/
	char	sEngNo[C_ENG_NO_LEN];				/*发动机号*/
/*6.18增加*/
	char	sInsrncCls[C_INSRNC_CLS_LEN];		/*险种大类*/
/*7.13增加*/
	char	sAppTyp[C_APP_TYP_LEN];             /*投保分类*/
} plyAppPolyFdCondStru;
/* *** 获取保单(批单)一览信息 *** */
typedef struct _plyGetCplyGridStru
{
	char	sCplyNo[C_PLY_NO_LEN];					/*保 单 号*/
    char	sAppNme[C_APP_NME_LEN];                 /*投保人名称*/
    char	sInsrncCnm[C_INSRNC_CNM_LEN];           /*险种名称*/
    double	fAmt;                 			        /*保险金额*/
    double	fSumPrm;                          		/*保费合计*/
	char	sDptCde[C_DPT_CDE_LEN];                 /*机构部门*/
/*6/14增加*/
	char    sInsrntNme[C_INSRNT_NME_LEN];           /*被保险人名称*/
/*1999.8.5增加*/
	char	sInsrncCls[C_INSRNC_CLS_LEN];		/*险种大类*/
	char	sInsrncCde[C_INSRNC_CDE_LEN];		/*险种代码*/
/*1999.9.24增加lzz*/
	char sPrnTyp[C_PRN_TYP_LEN];              /*单证类型*/
}plyGetCplyGridStru;
/* *** 申请单查询条件数据结构 *** */
typedef struct _plyAppEdrFdCondStru
{
	char	sCplyNo[C_PLY_NO_LEN];				/*保 单 号*/
    char	sEdrAppNo[C_EDR_APP_NO_LEN];        /*申请单号*/
	char	sDptCde[C_DPT_CDE_LEN];				/*机构部门*/
    char	sSignTm1[DATE_LEN];                 /*签单日期1*/
    char	sSignTm2[DATE_LEN];                 /*签单日期2*/
	char	sInsrncCde[C_INSRNC_CDE_LEN];		/*险种代码*/
	char	cLowDpt;							/*下级机构*/
	char	sInsrntNme[C_INSRNT_NME_LEN];       /*被保险人名称*/
    char	sEdrTyp[C_EDR_TYP_LEN];             /*批改类型*/
/*车险新增*/
	char	sLcnNo[C_LCN_NO_LEN];				/*牌照号码*/
	char	sEngNo[C_ENG_NO_LEN];				/*发动机号*/
	char	sUdrMrk[C_UDR_MRK_LEN];             /*核保标志*/
/*6.18增加*/
	char	sInsrncCls[C_INSRNC_CLS_LEN];		/*险种大类*/
} plyAppEdrFdCondStru;
/* *** 查询一条单据信息记录的数据结构 *** */
typedef struct _plyGetDocStru
{
	char  sDocNo[C_DOC_NO_LEN];				        /*单据号*/
  char  sInsrncCde[C_INSRNC_CDE_LEN];             /*险  种*/
  char  sPrnTyp[C_PRN_TYP_LEN];                   /*单证类型*/
	char  sUndrTm[TIME_LEN];                        	/*核保日期*/
} plyGetDocStru ;
/* *** 保单批单应收档 *** */
typedef  struct _finColdueStru 
{
	char sdno[CDNO_LEN];                           /*做帐部门*/
	char stno[CTNO_LEN];                           /*业务代码*/
	char splyno[CPLYNO_LEN];                       /*保单号*/
	char sedrno[CEDRNO_LEN];                       /*批单号*/
	double ftermno;                                /*交费期别*/
	char srctno[CRCTNO_LEN];                       /*收据号)*/
	char spaycde[CPAYCDE_LEN];                     /*缴费人*/
	char spaynme[CPAYNME_LEN];                     /*缴费人名称*/
	char sinscde[CINSCDE_LEN];                     /*险种*/
	char scurno[CCURNO_LEN];                       /*币种*/
	char scolmde[CCOLMDE_LEN];                     /*收款方式*/
	double fprmdue;                                /*应收保费*/
	double fcolamt;                                /*实收保费*/
	char sbnkacct[CBNKACCT_LEN];                   /*银行和帐号*/
	char sempcde[CEMPCDE_LEN];                     /*业务员*/
	char sagtcde[CAGTCDE_LEN];                     /*代理人码*/
	char sbrkcde[CBRKCDE_LEN];                     /*经纪人*/
	char spaystr[DATE_LEN];                        /*交费起期*/
	char spayend [DATE_LEN];                       /*交费止期*/
	char sdptcde[CDPTCDE_LEN];                     /*机构部门*/
	char scoldte[DATE_LEN];                        /*收费日期*/
	char scaldte[DATE_LEN];                        /*结算日期*/
	char saccno[CACCNO_LEN];                       /*记帐编号*/
	char saccdte[DATE_LEN];                        /*记帐日期*/
	char srcptno[CRCPTNO_LEN];                     /*收据印刷号)*/
	char sfcu[CFCU_LEN];                           /*创建人员*/
	char sfcd [DATE_LEN];                          /*创建日期*/
	char slcu[CLCU_LEN];                           /*修改人员*/
	char slcd [DATE_LEN];                          /*修改日期*/
} finColdueStru ;
/* *** 保单批单应付档 *** */ 
typedef  struct _finPaydueStru 
{
	char	sdno[CDNO_LEN];                             /*做帐部门*/
	char	splyno[CPLYNO_LEN];                         /*保单号*/
	char	sedrno[CEDRNO_LEN];                         /*批单号*/
	double	ftermno;                                    /*交费期别*/
	char	srctno[CRCTNO_LEN];                         /*收 据 号*/
	char	spaycde[CPAYCDE_LEN];                       /*缴 费 人*/
	char	spaynme[CPAYNME_LEN];                       /*缴费人名称*/
	char	sinscde[CINSCDE_LEN];                       /*险  种*/
	char	scurno[CCURNO_LEN];                         /*币  种*/
	char	spaymde[CPAYMDE_LEN];                       /*付款方式码*/
	char	sbnkacct[CBNKACCT_LEN];                     /*银行和帐号*/
	double	fnclmamt;									/*应付无赔款退费*/
	double	fdisamt ;									/*应付约定退费*/
	char	sempcde[CEMPCDE_LEN];                       /*业务员*/
	char	sagtcde[CAGTCDE_LEN];                       /*代理人码*/
	double	fcmmdue;									/*应付手续费*/
	double	fcmsdue;									/*应付佣金*/
	char	sbrkcde[CBRKCDE_LEN];                       /*经纪人*/
	double	fbrkamt;									/*应付经纪费*/
	char	sduestr[DATE_LEN];							/*应付起期*/
	char	sdueend[DATE_LEN];							/*应付止期*/
	char	sdptcde[CDPTCDE_LEN];                       /*机构部门*/
	char	scaldte[DATE_LEN];							/*结算日期*/
	char	spaydte[DATE_LEN];							/*付款日期*/
	char	srcptno[CRCPTNO_LEN];                       /*收据印刷号)*/
	char	sfcu[CFCU_LEN];								/*创建人员*/
	char	sfcd[DATE_LEN];								/*创建日期*/
	char	slcu[CLCU_LEN];								/*修改人员*/
	char	slcd[DATE_LEN];								/*修改日期*/
} finPaydueStru ;
typedef struct  _plyEdrItemStru { 
	char sEdrTlbNme[C_EDR_TLB_NME_LEN];                /*批改项对应表名*/
	char sEdrFldNme[C_EDR_FLD_NME_LEN];                 /*批改域字段名*/
	int  nIdcNum;										/*批改项对应的画面ID号*/
} plyEdrItemStru;
typedef struct _BuffChainStru
{
	int	  BuffSize;
	char * NextBuff;
}BuffChainStru;
typedef struct _plyEdrCnt
{
	char	sInsrntNme[C_INSRNT_NME_LEN];		/*被保险人名称*/
	double	fAmt;							    /*保险金额*/
	double 	fRate;								/*费    率*/
	double	fPrm;								/*保    费*/
	double	fSumPrm;							/*保费合计*/
    char    sAmtCur[C_AMT_CUR_LEN];             /*保额币种*/
	char	sPrmCur[C_PRM_CUR_LEN];				/*应收保费币种*/
	double	fAppntProp;							/*约定退费比例*/
	double  fNclmProp;                          /*无赔退费比例*/
	char	sAppPrsnNme[C_APP_PRSN_NME_LEN];    /*申请人名称*/
	char	sEdrAppTm[DATE_LEN];				/*申请日期*/
	double	fAmtVar;                            /*保额变化*/
	double	fPrmVar;							/*保费变化*/
	double	fAppntAmt;                          /*约定退费*/
	double	fNclmAmt;                           /*无赔退费*/
	char	sInsrncBgnTm[DATE_LEN];				/*保险起期*/
	char	sInsrncEndTm[DATE_LEN];				/*保险止期*/
	double	fSaveAmt;							/*保险储金*/
    char    sToday[DATE_LEN];                   /*今天日期*/
	char    sTgtAddr[C_TGT_ADDR_LEN];           /*标的地址*/
}plyEdrCnt;
/*   ZQM 1999.06.11 begin */
typedef struct _plyCmpItemStru  
{
	char sFldName[81];/*字段中文名*/
	char sOldValue[101];
	char sChgValue[101];	/*只有数值型变量才填写*/
	char sNewValue[101];
	char sDataType[2];/* 用于设置显示对齐方式和小数点位数; 'C'字符型;'N':数值型L：长字符型，长字符型在此只填写序号，而长字符型的值填在plyLngFldStru结构数组里。*/
	int nID;	/*长字符型的序号*/
} plyCmpItemStru;
typedef struct _plyLngFldStru
{
	int nID;
	char sOldValue[2001];
    char sNewValue[2001];
} plyLngFldStru;
/*   ZQM 1999.06.11 end */
/*6.29新增 F9获取厂牌车型码结构*/
typedef struct _plyBrndStru
{
	char sBrndCde[C_BRND_CDE_LEN];          /*厂牌车型码*/
	char sBrndCnm[C_BRND_CNM_LEN];			/*中文名称*/
	char sBrndEnm[C_BRND_ENM_LEN];			/*英文名称*/
} plyBrndStru;
/*1999-07-8新增 批改项ID*/
typedef  struct _SetEdrIdStru 
{
	char sCrtCde[C_CRT_CDE_LEN];            /*创建人员*/
	char sCrtTm[DATE_LEN];                  /*创建时间*/
	char sUpdCde[C_UPD_CDE_LEN];            /*修改人员*/
	char sUpdTm[DATE_LEN];                  /*修改时间*/
	char sInsrncCde[C_INSRNC_CDE_LEN];		/*险种码*/
	char sEdrFldNme[C_EDR_FLD_NME_LEN];		/*批改域字段名*/
	char sIdTyp[C_ID_TYP_LEN];				/*画面ID类型*/
	int  nIddNo;							/*画面ID号*/
	int  nIdcNo;							/*控件ID号*/
	int  nGridCol;							/*网格列号*/
} SetEdrIdStru; 
/*	家财长效保费计提批改数据结构 */
typedef struct _plyHomeRichGridStru
{
	char	sCrtCde[C_CRT_CDE_LEN];             /*创建人员*/
	char	sCrtTm[TIME_LEN];    		        /*创建时间*/
	char	sUpdCde[C_UPD_CDE_LEN];             /*修改人员*/
	char	sUpdTm[TIME_LEN];			        /*修改时间*/
	char	cFlag;		/*处理标志 0-未选定，1-选定，2-已处理*/
	char	sDptCde[C_DPT_CDE_LEN];             /*机构部门*/
	int		nYear;	/*计提保费年度*/	
	char	sCplyNo[C_PLY_NO_LEN];				/*保 单 号*/
	char	sEdrNo[C_EDR_NO_LEN];               /*批 单 号*/
	char	sInsrncBgnTm[DATE_LEN];				/*保险起期*/
	char	sInsrncEndTm[DATE_LEN];				/*保险止期*/
	int		nValidDays;							/*本年有效天数*/
	char	cYearFlag;							/*整年标志*/
	char	sInsrntNme[C_INSRNT_NME_LEN];		/*被保险人名称*/
	double 	fSaveAmt;                    		 /*保险储金*/  
	double 	fValidSaveAmt;                    		 /*本年有效储金*/  
	double 	fLastSaveAmt;                    		 /*年初储金*/  
	double	fSumPrm;							/*保费合计*/
	double	fSumPrmVar;							/*本年保费*/
	double	fPrmVar;							/*保费变化*/
	int  	nEdrPrjNo;                            /*序号*/
	double  fCnvrtProp;                			 /*折算比例*/
	char    sEdrTyp[C_EDR_TYP_LEN];       /*批改类型*/
}plyHomeRichGridStru;
/*建议书数据结构*/
typedef  struct _plyProposalStru {
  char sCrtCde[ C_CRT_CDE_LEN ];                           /*创建人员*/
	char sCrtTm [TIME_LEN];                           /*创建日期*/
	char sUpdCde[ C_UPD_CDE_LEN ];                           /*修改人员*/
	char sUpdTm [TIME_LEN];                           /*修改日期*/
	char sDocNo[ C_DOC_NO_LEN ];                           /*单据号*/
	double fRate             ;                           /*费率*/
	char sNclmDesc[ C_NCLM_DESC_LEN ];                           /*免赔描述*/
	char sUndrCndtn[ C_UNDR_CNDTN_LEN ];                           /*承保条件*/
	char sSendTm  [TIME_LEN];                           /*送单时间*/
	char sSendDesc[ C_SEND_DESC_LEN ];                           /*送单时间描述*/
	char sUndrPrsn[ C_UNDR_PRSN_LEN ];                           /*核保人*/
	char sSignTm [TIME_LEN];                           /*签发日期*/
	char sUserId[ C_USER_ID_LEN ];                           /*用户ID*/
	char sUserRemark[ C_USER_REMARK_LEN ];                           /*用户意见*/
	char sRemark[ C_REMARK_LEN ] ;                          /*备注*/
	double fSumPrm;                          		/*保费合计*/
	char sPrmCur[C_PRM_CUR_LEN];                    /*应收保费币种*/
	
/* modi fy by zs 2001/04/16  */
        double fAmt;                                  /*保险金额*/
        double fAmtVar;                               /*保额变化*/
        double fAmtOld;                               /*保额OLD*/
        char sAmtCur[C_AMT_CUR_LEN];                /*保额币种*/
        double fPrm;                                  /*保费*/
        double fPrmVar;                               /*保费变化*/ 
        double fPrmOld;                               /*保费OLD*/ 
        double fRateOld;                      /*费率OLD*/
        char sReadFlag[C_READ_FLAG_LEN];            /*阅读标志*/
        char sPropType[C_PROPOSAL_TYPE_LEN];        /*建议书类型*/
        char sPropFlag[C_PROPOSAL_FLAG_LEN];        /*建议书标志*/
	
} plyProposalStru;


/*投保单--网上送单*/
typedef  struct _plyPlyappNetStru {
  char sCrtCde[ C_CRT_CDE_LEN ];                           /*创建人员*/
	char sCrtTm                       [TIME_LEN];                           /*创建时间*/
	char sUpdCde[ C_UPD_CDE_LEN ];                           /*修改人员*/
	char sUpdTm                       [TIME_LEN];                           /*修改时间*/
	char sPlyAppNo[ C_PLY_APP_NO_LEN ];                           /*投保单号*/
	double fUserSeqNo                  ;                           /*客户登记流水号*/
	char sFeedbackTm                  [DATE_LEN];                           /*反馈日期*/
	char sPrintTm                     [DATE_LEN];                           /*打印日期*/
	char sProvince[ C_PROVINCE_LEN ];                           /*送单省、市*/
	char sCity[ C_CITY_LEN ];                           /*送单县/市/区*/
	char sPlace[ C_PLACE_LEN ];                           /*送单详细位置*/
	char sContactName[ C_CONTACT_NAME_LEN ];                           /*联系人*/
	char sContactPhone[ C_CONTACT_PHONE_LEN ];                           /*联系电话*/
	char sContactFax[ C_CONTACT_FAX_LEN ];                           /*联系传真*/
	char sContactEmail[ C_CONTACT_EMAIL_LEN ];                           /*电邮地址*/
	char sSiteCde[ C_SITE_CDE_LEN ];                           /*网站编码*/
	char sRecNo[C_REC_NO_LEN];				/*暂存记录号*/
	char sSendFlag[C_SEND_FLAG_LEN];                                /*送单方式*/

	char sSendEmpCde[C_SEND_EMP_CDE_LEN];			/*送单人		*/			  
	char sPrtEmpCde[C_PRT_EMP_CDE_LEN];			/*单证打印人*/			  
	char sSendTm[TIME_LEN];							/*送单时间	*/	  
	char sSendedTm[TIME_LEN];						/*送到时间	*/		  
	char sZipCde[C_ZIP_CDE_LEN];				/*邮编	*/	  
	char cPayFlag[C_PAY_FLAG_LEN];	/*付费标志 '0' 上门收费 '1' 网上付费*/	  
	char sSessionId[C_SESSION_ID_LEN];			/*交易流水号 */
	char sBankCde[C_BANK_CDE_LEN];				/*银行代码	*/		  
	char sBankCnm[C_BANK_CNM_LEN];			/*银行名称	*/		  
	char sBankAccnt[C_BANK_ACCNT_LEN];			/*银行帐号	*/			  
	double fGotPrm;								/*实收保费	*/		  
	char sCurTyp[C_CUR_TYP_LEN];				/*币种	*/			  
	char sPayTm[TIME_LEN];						/*缴费日期	*/		  
	char sPayTyp[C_PAY_TYP_LEN];				/*缴费类型	*/			  
	char sPayCde[C_PAY_CDE_LEN];				/*付费代码	*/			  
	
	
	
} plyPlyappNetStru ;
#endif
