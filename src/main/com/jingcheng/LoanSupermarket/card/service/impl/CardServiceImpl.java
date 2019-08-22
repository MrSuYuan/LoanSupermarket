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

        if(null != bankId && !"".equals(bankId)){
            map.put("bankId",bankId);
        }else{
            map.put("bankId",null);
        }

        if(null != level && !"".equals(level)){
            String [] levels = level.split(",");
            map.put("level",levels);
        }else{
            map.put("level",null);
        }

        if(null != annualFeeType && !"".equals(annualFeeType)){
            String [] annualFeeTypes = annualFeeType.split(",");
            map.put("annualFeeType",annualFeeTypes);
        }else{
            map.put("annualFeeType",null);
        }

        if(null != moneyType && !"".equals(moneyType)){
            String [] moneyTypes = moneyType.split(",");
            map.put("moneyType",moneyTypes);
        }else{
            map.put("moneyType",null);
        }

        if(null != cardOrganization && !"".equals(cardOrganization)){
            String [] cardOrganizations = cardOrganization.split(",");
            map.put("cardOrganization",cardOrganizations);
        }else{
            map.put("cardOrganization",null);
        }

        if(null != privilege && !"".equals(privilege)){
            String [] privileges = privilege.split(",");
            map.put("privilege",privileges);
        }else{
            map.put("privilege",null);
        }

        if(null != cardCoverType && !"".equals(cardCoverType)){
            String [] cardCoverTypes = cardCoverType.split(",");
            map.put("cardCoverType",cardCoverTypes);
        }else{
            map.put("cardCoverType",null);
        }

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
