package jingcheng.LoanSupermarket.card.service.impl;

import jingcheng.LoanSupermarket.card.dao.CardDao;
import jingcheng.LoanSupermarket.card.service.CardService;
import jingcheng.utils.response.ReqResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 信用卡模块逻辑层实现
 */
@Service("cardService")
public class CardServiceImpl implements CardService {

    @Resource
    private CardDao cardDao;

    /**
     * 信用卡轮播页
     */
    @Override
    public ReqResponse carousel() {
        return null;
    }

    /**
     * 热门银行
     */
    @Override
    public ReqResponse popularBank() {
        return null;
    }

    /**
     * 热门信用卡
     */
    @Override
    public ReqResponse popularCard() {
        return null;
    }

    /**
     * 全部银行
     */
    @Override
    public ReqResponse allBank(Integer currentPage) {
        return null;
    }

    /**
     * 全部信用卡
     */
    @Override
    public ReqResponse allCard(Integer currentPage, Long bankId, Integer level, Integer annualFeeType, Integer moneyType, Integer cardOrganization, Integer privilege, Integer cardCoverType) {
        return null;
    }

    /**
     * 信用卡详情
     */
    @Override
    public ReqResponse cardDetail(Long cardId) {
        return null;
    }
}
