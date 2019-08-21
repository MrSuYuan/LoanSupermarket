package jingcheng.LoanSupermarket.manage.service;

import jingcheng.utils.response.ReqResponse;

/**
 * 后台管理模块逻辑层接口
 */
public interface ManageService {

    /**
     * 用户列表
     */
    ReqResponse userList(String userPhone, String createStart, String createEnd, String loginStart, String loginEnd, String currentPage, String pageSize);

    /**
     * 贷款列表
     */
    ReqResponse loanList(String productName ,String amountMin ,String amountMax ,String tags ,String startTime ,String endTime ,String status ,String currentPage ,String pageSize);

    /**
     * 查看贷款详情
     */
    ReqResponse loan(Long loanId);

    /**
     * 禁用/启用贷款信息
     */
    ReqResponse loanStatus(Long loanId,int status);

    /**
     * 删除贷款信息
     */
    ReqResponse loanDelete(Long loanId);

    /**
     * 编辑贷款信息
     */
    ReqResponse loanEdit(Long loanId ,String productName ,String productUrl ,String jumpUrl ,String rate ,String rateType ,
                           String amountMin ,String amountMax ,String deadlineStart ,String deadlineEnd ,String loanTime ,
                           String loanType ,String weights ,String tags ,String apply ,String applyTerm ,String applyMaterial ,
                           String remark);

    /**
     * 贷款标签
     */
    ReqResponse loanTags();

    /**
     * 添加贷款信息
     */
    ReqResponse insertLoan(String productName ,String productUrl ,String jumpUrl ,String rate ,String rateType ,
        String amountMin ,String amountMax ,String deadlineStart ,String deadlineEnd ,String loanTime ,
        String loanType ,String weights ,String tags ,String apply ,String applyTerm ,String applyMaterial ,
        String remark);

    /**
     * 信用卡列表
     */
    ReqResponse cardList(String bankId ,String cardName ,String level ,String moneyType ,String cardOrganization ,String annualFeeType ,
        String privilege ,String cardCoverType ,String status ,String startTime ,String endTime ,String currentPage ,String pageSize);

    /**
     * 查看信用卡详情
     */
    ReqResponse card(Long cardId);

    /**
     * 禁用/启用信用卡信息
     */
    ReqResponse cardStatus(Long cardId,int status);

    /**
     * 删除信用卡信息
     */
    ReqResponse cardDelete(Long cardId);

    /**
     * 编辑信用卡信息
     */
    ReqResponse cardEdit(Long cardId ,String bankId ,String cardName ,String jumpUrl ,String coverUrl ,String productUrl ,
                           String summary ,String level ,String moneyType ,String cardOrganization ,String interestFreePeriod ,
                           String pointTotal ,String pointPeriod ,String annualFeeType ,String annualFeeDescription ,String CashWithdrawalRatio ,
                           String CashWithdrawalFee ,String MinimumRepayment ,String privilege ,String otherPrivilege ,
                           String applySkill ,String otherDetails ,String cardCoverType);

    /**
     * 银行列表
     */
    ReqResponse bankList();

    /**
     * 添加信用卡信息
     */
    ReqResponse insertCard(String bankId ,String cardName ,String jumpUrl ,String coverUrl ,String productUrl ,
        String summary ,String level ,String moneyType ,String cardOrganization ,String interestFreePeriod ,
        String pointTotal ,String pointPeriod ,String annualFeeType ,String annualFeeDescription ,String CashWithdrawalRatio ,
        String CashWithdrawalFee ,String MinimumRepayment ,String privilege ,String otherPrivilege ,
        String applySkill ,String otherDetails ,String cardCoverType);

    /**
     * 添加银行信息
     */
    ReqResponse insertBank(String bankName, String bankIcon, String bankRemark);

}
