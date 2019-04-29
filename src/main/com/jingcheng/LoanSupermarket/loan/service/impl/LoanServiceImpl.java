package jingcheng.LoanSupermarket.loan.service.impl;

import jingcheng.LoanSupermarket.loan.dao.LoanDao;
import jingcheng.LoanSupermarket.loan.entity.LoanCarousel;
import jingcheng.LoanSupermarket.loan.entity.LoanHeadline;
import jingcheng.LoanSupermarket.loan.service.LoanService;
import jingcheng.LoanSupermarket.user.dao.UserDao;
import jingcheng.utils.response.ErrorMessage;
import jingcheng.utils.response.ReqResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 贷款模块逻辑层实现
 */
@Service("loanService")
public class LoanServiceImpl implements LoanService {

    @Resource
    private LoanDao loanDao;

    /**
     * 贷款轮播页
     */
    @Override
    public ReqResponse carousel() {
        ReqResponse req = new ReqResponse();
        List<LoanCarousel> list = loanDao.loanCarousel();
        req.setResult(list);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }

    /**
     * 贷款头条
     */
    @Override
    public ReqResponse headline() {
        ReqResponse req = new ReqResponse();
        List<LoanHeadline> list = loanDao.headline();
        req.setResult(list);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }

    /**
     * 热门贷款
     */
    @Override
    public ReqResponse hotLoan(int type, int currentPage) {
        return null;
    }

    /**
     * 新品推荐
     */
    @Override
    public ReqResponse newProducts(int type, int currentPage) {
        return null;
    }

    /**
     * 品牌贷款
     */
    @Override
    public ReqResponse brandLoan(int type, int currentPage) {
        return null;
    }

    /**
     * 大额分期
     */
    @Override
    public ReqResponse largeStaging(int type, int currentPage) {
        return null;
    }

    /**
     * 小额速贷
     */
    @Override
    public ReqResponse smallLoan(int type, int currentPage) {
        return null;
    }

    /**
     * 贷款详情
     */
    @Override
    public ReqResponse loan(Long loanId) {
        return null;
    }
}
