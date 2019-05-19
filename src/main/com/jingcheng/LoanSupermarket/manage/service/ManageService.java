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


}
