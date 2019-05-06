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
}
