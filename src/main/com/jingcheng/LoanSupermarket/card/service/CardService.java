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
    ReqResponse allCard(Integer currentPage,Long bankId,Integer level,Integer annualFeeType,
                        Integer moneyType,Integer cardOrganization,Integer privilege,Integer cardCoverType);

    /**
     * 信用卡详情
     */
    ReqResponse cardDetail(Long cardId);
}
