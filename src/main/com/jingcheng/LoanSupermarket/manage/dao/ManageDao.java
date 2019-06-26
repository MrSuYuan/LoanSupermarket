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
     * 用户列表数量
     */
    int userListNum(Map<String,Object> map);

    /**
     * 贷款列表
     */
    List<Loan> loanList(Map<String,Object> map);

    /**
     * 贷款列表数量
     */
    int loanListNum(Map<String,Object> map);

    /**
     * 贷款标签
     */
    List<Tag> loanTags();

    /**
     * 添加贷款信息
     */
    void insertLoan(Loan l);

    /**
     * 信用卡列表
     */
    List<Card> cardList(Map<String,Object> map);

    /**
     * 信用卡数量
     */
    int cardNum(Map<String,Object> map);

    /**
     * 银行列表
     */
    List<Bank> bankList();

    /**
     * 添加信用卡信息
     */
    void insertCard(Card card);

    /**
     * 验证银行信息是否存在
     */
    int bank(String bankName);

    /**
     * 添加银行信息
     */
    void insertBank(Bank bank);

    /**
     * 贷款详情
     */
    Loan loan(Long loanId);

    /**
     * 启用/禁用贷款信息
     */
    void loanStatus(Map<String,Object> map);

    /**
     * 删除贷款信息
     */
    void deleteLoan(Long loanId);

    /**
     * 信用卡详情
     */
    Card card(Long cardId);

    /**
     * 启用/禁用信用卡信息
     */
    void cardStatus(Map<String,Object> map);

    /**
     * 删除信用卡信息
     */
    void deleteCard(Long cardId);
}
