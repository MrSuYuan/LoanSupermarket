package jingcheng.LoanSupermarket.manage.dao;

import jingcheng.LoanSupermarket.card.entity.Bank;
import jingcheng.LoanSupermarket.card.entity.Card;
import jingcheng.LoanSupermarket.loan.entity.Loan;
import jingcheng.LoanSupermarket.loan.entity.Tag;
import jingcheng.LoanSupermarket.user.entity.UserVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 后台管理模块数据层接口
 */
@Repository
public interface ManageDao {

    /**
     * 用户列表
     */
    List<UserVo> userList(Map<String,Object> map);

    /**
     * 贷款标签
     */
    List<Tag> loanTags();

    /**
     * 添加贷款信息
     */
    void insertLoan(Loan l);

    /**
     * 银行列表
     */
    List<Bank> bankList();

    /**
     * 添加信用卡信息
     */
    void insertCard(Card card);
}
