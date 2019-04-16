package jingcheng.LoanSupermarket.card.controller;

import io.swagger.annotations.Api;
import jingcheng.LoanSupermarket.card.service.CardService;
import jingcheng.utils.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/card")
@Api(value = "/card", tags = "信用卡模块接口")
public class CardController extends BaseController {

    @Resource
    private CardService cardService;

}
