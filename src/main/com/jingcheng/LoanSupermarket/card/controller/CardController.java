package jingcheng.LoanSupermarket.card.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jingcheng.LoanSupermarket.card.service.CardService;
import jingcheng.utils.base.BaseController;
import jingcheng.utils.base.BasicParameters;
import jingcheng.utils.response.ReqResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/card")
@Api(value = "/card", tags = "信用卡模块接口")
public class CardController extends BaseController {

    @Resource
    private CardService cardService;

    @RequestMapping(value="carousel", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "信用卡轮播页", notes = "信用卡轮播页", httpMethod = "POST")
    public ReqResponse carousel(BasicParameters param){
        ReqResponse req = new ReqResponse();
        return req;
    }

    @RequestMapping(value="popularBank", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "热门银行", notes = "热门银行", httpMethod = "POST")
    public ReqResponse popularBank(BasicParameters param){
        ReqResponse req = new ReqResponse();
        return req;
    }

    @RequestMapping(value="popularCard", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "热门信用卡", notes = "热门信用卡", httpMethod = "POST")
    public ReqResponse popularCard(BasicParameters param){
        ReqResponse req = new ReqResponse();
        return req;
    }

    @RequestMapping(value="allBank", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="currentPage" , value="页码" ,required = true , paramType = "query" ,dataType = "int")
    })
    @ApiOperation(value = "全部银行", notes = "全部银行", httpMethod = "POST")
    public ReqResponse allBank(BasicParameters param,int currentPage){
        ReqResponse req = new ReqResponse();
        return req;
    }

    @RequestMapping(value="allCard", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="currentPage" , value="页码" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="bankId" , value="银行" ,required = false , paramType = "query" ,dataType = "Long"),
            @ApiImplicitParam(name="level" , value="等级(1普卡 2金卡 3白金卡)" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="annualFeeType" , value="年费类型(1终身免年费 2交易免年费)" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="moneyType" , value="币种(1人民币 2美元 3日元)" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="cardOrganization" , value="发卡组织(1银联 2visa 3jcb 4运通)" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="privilege" , value="特权(1航空保险 2健康保险 3机场贵宾服务 4健康服务 5汽车救援)" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="cardCoverType" , value="卡面类型(1商务 2卡通 3时尚 4炫酷 5简约 6清新 7传统 8主题)" ,required = false , paramType = "query" ,dataType = "int")
    })
    @ApiOperation(value = "全部信用卡", notes = "全部信用卡", httpMethod = "POST")
    public ReqResponse allCard(BasicParameters param,int currentPage,Long bankId,int level,int annualFeeType,
                               int moneyType,int cardOrganization,int privilege,int cardCoverType){
        ReqResponse req = new ReqResponse();
        return req;
    }

    @RequestMapping(value="cardDetail", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="cardId" , value="信用卡id" ,required = true , paramType = "query" ,dataType = "Long")
    })
    @ApiOperation(value = "信用卡详情", notes = "信用卡详情", httpMethod = "POST")
    public ReqResponse cardDetail(BasicParameters param){
        ReqResponse req = new ReqResponse();
        return req;
    }


}
