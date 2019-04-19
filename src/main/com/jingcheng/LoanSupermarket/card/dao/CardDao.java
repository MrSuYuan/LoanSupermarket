package jingcheng.LoanSupermarket.card.dao;

import jingcheng.LoanSupermarket.card.entity.Bank;
import jingcheng.LoanSupermarket.card.entity.Card;
import jingcheng.LoanSupermarket.card.entity.Carousel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 信用卡模块数据层接口
 */
@Repository("cardDao")
public interface CardDao {

    /**
     * 轮播页
     */
    List<Carousel> carousel();

    /**
     * 热门银行
     */
    List<Bank> popularBank();

    /**
     * 热门信用卡
     */
    List<Card> popularCard(int num);

    /**
     * 全部银行
     */
    List<Bank> allBank(int num);

    /**
     * 全部信用卡
     */
    List<Card> allCard(Map<String,Object> map);

    /**
     * 信用卡详情
     */
    Card cardDetail(Long cardId);

}
