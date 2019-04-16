package jingcheng.LoanSupermarket.card.service.impl;

import jingcheng.LoanSupermarket.card.dao.CardDao;
import jingcheng.LoanSupermarket.card.service.CardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * 信用卡模块逻辑层实现
 */
@Service("cardService")
public class CardServiceImpl implements CardService {

    @Resource
    private CardDao cardDao;
}
