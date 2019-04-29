package jingcheng.LoanSupermarket.loan.dao;

import jingcheng.LoanSupermarket.loan.entity.LoanCarousel;
import jingcheng.LoanSupermarket.loan.entity.LoanHeadline;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
