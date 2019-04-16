package jingcheng.LoanSupermarket.loan.service.impl;

import jingcheng.LoanSupermarket.loan.dao.LoanDao;
import jingcheng.LoanSupermarket.loan.service.LoanService;
import jingcheng.LoanSupermarket.user.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 贷款模块逻辑层实现
 */
@Service("loanService")
public class LoanServiceImpl implements LoanService {

    @Resource
    private LoanDao loanDao;

}
