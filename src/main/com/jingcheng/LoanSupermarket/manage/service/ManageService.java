package jingcheng.LoanSupermarket.manage.service;

import jingcheng.utils.response.ReqResponse;

/**
 * 后台管理模块逻辑层接口
 */
public interface ManageService {

    /**
     * 用户列表
     */
    ReqResponse userList(String userPhone, String createStart , String createEnd , String loginStart , String loginEnd , String currentPage);

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
     * 银行列表
     */
    ReqResponse bankList();

}
