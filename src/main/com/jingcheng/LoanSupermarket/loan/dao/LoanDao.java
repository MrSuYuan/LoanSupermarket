package jingcheng.LoanSupermarket.loan.dao;

import jingcheng.LoanSupermarket.loan.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 贷款模块数据层接口
 */
@Repository("loanDao")
public interface LoanDao {

    /**
     * 轮播页数据,展示最近3条
     */
    List<LoanCarousel> loanCarousel();

    /**
     * 贷款头条,展示最近10条
     */
    List<LoanHeadline> headline();

    /**
     * 贷款标签列表
     */
    List<Tag> tagList();

    /**
     * 首页贷款列表
     */
    List<LoanVo> loanList(Map<String,Object> map);

    /**
     * 新品推荐
     */
    List<LoanVo> newProducts(Map<String,Object> map);

    /**
     * 热门产品
     */
    List<LoanVo> hotProduct(Map<String,Object> map);

    /**
     * 大额分期
     */
    List<LoanVo> largeStaging(Map<String,Object> map);

    /**
     * 小额速贷
     */
    List<LoanVo> smallLoan(Map<String,Object> map);

    /**
     * 贷款详情
     */
    Loan loanMessage(Long loanId);
}
