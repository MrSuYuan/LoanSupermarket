package jingcheng.LoanSupermarket.card.service.impl;

import jingcheng.LoanSupermarket.card.dao.CardDao;
import jingcheng.LoanSupermarket.card.entity.Bank;
import jingcheng.LoanSupermarket.card.entity.Card;
import jingcheng.LoanSupermarket.card.entity.Carousel;
import jingcheng.LoanSupermarket.card.service.CardService;
import jingcheng.utils.response.ErrorMessage;
import jingcheng.utils.response.ReqResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        ReqResponse req = new ReqResponse();
        List<Carousel> list = cardDao.carousel();
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        req.setResult(list);
        return req;
    }

    /**
     * 热门银行
     */
    @Override
    public ReqResponse popularBank() {
        ReqResponse req = new ReqResponse();
        List<Bank> list = cardDao.popularBank();
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        req.setResult(list);
        return req;
    }

    /**
     * 热门信用卡
     */
    @Override
    public ReqResponse popularCard(int currentPage) {
        ReqResponse req = new ReqResponse();
        int num = (currentPage - 1)*10;
        List<Card> list = cardDao.popularCard(num);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        req.setResult(list);
        return req;
    }

    /**
     * 全部银行
     */
    @Override
    public ReqResponse allBank(Integer currentPage) {
        ReqResponse req = new ReqResponse();
        int num = (currentPage - 1)*10;
        List<Bank> list = cardDao.allBank(num);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        req.setResult(list);
        return req;
    }

    /**
     * 全部信用卡
     */
    @Override
    public ReqResponse allCard(Integer currentPage, String bankId, String level, String annualFeeType,
                               String moneyType, String cardOrganization, String privilege, String cardCoverType) {
        ReqResponse req = new ReqResponse();
        int num = (currentPage - 1)*10;
        Map<String,Object> map = new HashMap<>();
        map.put("num",num);
        map.put("bankId",bankId);
        map.put("level",level);
        map.put("annualFeeType",annualFeeType);
        map.put("moneyType",moneyType);
        map.put("cardOrganization",cardOrganization);
        map.put("privilege",privilege);
        map.put("cardCoverType",cardCoverType);
        List<Card> list = cardDao.allCard(map);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        req.setResult(list);
        return req;
    }

    /**
     * 信用卡详情
     */
    @Override
    public ReqResponse cardDetail(Long cardId) {
        ReqResponse req = new ReqResponse();
        Card card = cardDao.cardDetail(cardId);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        req.setResult(card);
        return req;
    }
}
