package jingcheng.LoanSupermarket.card.service;

import jingcheng.utils.response.ReqResponse;

/**
 * 信用卡模块逻辑层接口
 */
public interface CardService {

    /**
     * 信用卡轮播页
     */
    ReqResponse carousel();

    /**
     * 热门银行
     */
    ReqResponse popularBank();

    /**
     * 热门信用卡
     */
    ReqResponse popularCard(int currentPage);

    /**
     * 全部银行
     */
    ReqResponse allBank(Integer currentPage);

    /**
     * 全部信用卡
     */
    ReqResponse allCard(Integer currentPage,String bankId,String level,String annualFeeType,
                        String moneyType,String cardOrganization,String privilege,String cardCoverType);

    /**
     * 信用卡详情
     */
    ReqResponse cardDetail(Long cardId);
}
