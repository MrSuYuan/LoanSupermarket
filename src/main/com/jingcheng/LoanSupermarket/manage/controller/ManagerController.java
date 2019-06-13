package jingcheng.LoanSupermarket.manage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jingcheng.LoanSupermarket.manage.service.ManageService;
import jingcheng.utils.base.BaseController;
import jingcheng.utils.base.BasicParameters;
import jingcheng.utils.response.ReqResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/manage")
@Api(value = "/manage", tags = "后台管理模块")
public class ManagerController extends BaseController {

    @Resource
    private ManageService manageService;

    @RequestMapping(value="/user/userList", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "用户列表", notes = "用户列表", httpMethod = "POST")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="userPhone" , value="手机号" ,required = false , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="createStart" , value="注册起始时间(格式:2019-01-01)" ,required = false , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="createEnd" , value="注册结束时间(格式:2019-01-01)" ,required = false , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="loginStart" , value="登陆起始时间(格式:2019-01-01)" ,required = false , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="loginEnd" , value="登陆结束时间(格式:2019-01-01)" ,required = false , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="currentPage" , value="当前页码" ,required = false , paramType = "query" ,dataType = "Integer")
    })
    @CrossOrigin
    public ReqResponse userList(BasicParameters param){
        String userPhone = request.getParameter("userPhone");
        String createStart = request.getParameter("createStart");
        String createEnd = request.getParameter("createEnd");
        String loginStart = request.getParameter("loginStart");
        String loginEnd = request.getParameter("loginEnd");
        String currentPage = request.getParameter("currentPage");
        ReqResponse req = manageService.userList(userPhone,createStart,createEnd,loginStart,loginEnd,currentPage);
        return req;
    }


    @RequestMapping(value="/loan/loanTags", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "贷款标签", notes = "贷款标签", httpMethod = "POST")
    @CrossOrigin
    public ReqResponse loanTags(BasicParameters param){
        ReqResponse req = manageService.loanTags();
        return req;
    }


    @RequestMapping(value="/loan/insertLoan", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增贷款信息", notes = "新增贷款信息", httpMethod = "POST")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="productName" , value="产品名称" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="productUrl" , value="产品图标(多张逗号拼接)" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="jumpUrl" , value="跳转地址" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="rate" , value="利率" ,required = true , paramType = "query" ,dataType = "double"),
            @ApiImplicitParam(name="rateType" , value="利率类型(2日 3月 4年)" ,required = true , paramType = "query" ,dataType = "Integer"),
            @ApiImplicitParam(name="amountMin" , value="贷款额度范围(最小)" ,required = true , paramType = "query" ,dataType = "Integer"),
            @ApiImplicitParam(name="amountMax" , value="贷款额度范围(最大)" ,required = true , paramType = "query" ,dataType = "Integer"),
            @ApiImplicitParam(name="deadlineStart" , value="贷款期限(起始)" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="deadlineEnd" , value="贷款期限(结束)" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="loanTime" , value="放款时间" ,required = true , paramType = "query" ,dataType = "Integer"),
            @ApiImplicitParam(name="loanType" , value="放款时间类型(1小时 2日 3月)" ,required = true , paramType = "query" ,dataType = "Integer"),
            @ApiImplicitParam(name="weights" , value="权重" ,required = true , paramType = "query" ,dataType = "Integer"),
            @ApiImplicitParam(name="tags" , value="标签(多个逗号拼接)" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="apply" , value="申请流程(集合)" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="applyTerm" , value="申请条件" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="applyMaterial" , value="申请材料" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="remark" , value="备注" ,required = true , paramType = "query" ,dataType = "String")
    })
    @CrossOrigin
    public ReqResponse insertLoan(BasicParameters param){
        String productName = request.getParameter("productName");
        String productUrl = request.getParameter("productUrl");
        String jumpUrl = request.getParameter("jumpUrl");
        String rate = request.getParameter("rate");
        String rateType = request.getParameter("rateType");
        String amountMin = request.getParameter("amountMin");
        String amountMax = request.getParameter("amountMax");
        String deadlineStart = request.getParameter("deadlineStart");
        String deadlineEnd = request.getParameter("deadlineEnd");
        String loanTime = request.getParameter("loanTime");
        String loanType = request.getParameter("loanType");
        String weights = request.getParameter("weights");
        String tags = request.getParameter("tags");
        String apply = request.getParameter("apply");
        String applyTerm = request.getParameter("applyTerm");
        String applyMaterial = request.getParameter("applyMaterial");
        String remark = request.getParameter("remark");
        ReqResponse req = manageService.insertLoan(productName ,productUrl ,jumpUrl ,rate ,rateType ,
                amountMin ,amountMax ,deadlineStart ,deadlineEnd ,loanTime ,loanType ,weights ,
                tags ,apply ,applyTerm ,applyMaterial ,remark);
        return req;
    }


    @RequestMapping(value="/card/bankList", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "银行列表", notes = "银行列表", httpMethod = "POST")
    @CrossOrigin
    public ReqResponse bankList(BasicParameters param){
        ReqResponse req = manageService.bankList();
        return req;
    }


    @RequestMapping(value="/card/insertCard", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增信用卡信息", notes = "新增信用卡信息", httpMethod = "POST")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="bankId" , value="银行id" ,required = true , paramType = "query" ,dataType = "Long"),
            @ApiImplicitParam(name="cardName" , value="卡片名称" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="jumpUrl" , value="跳转地址" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="coverUrl" , value="封面图" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="productUrl" , value="产品图(多张逗号拼接)" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="summary" , value="摘要" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="level" , value="等级(1普卡 2金卡 3白金卡)" ,required = true , paramType = "query" ,dataType = "Integer"),
            @ApiImplicitParam(name="moneyType" , value="币种(1人民币 2美元 3日元)" ,required = true , paramType = "query" ,dataType = "Integer"),
            @ApiImplicitParam(name="cardOrganization" , value="发卡组织(1银联 2visa 3jcb 4运通)" ,required = true , paramType = "query" ,dataType = "Integer"),
            @ApiImplicitParam(name="interestFreePeriod" , value="免息期限" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="pointTotal" , value="积分累计" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="pointPeriod" , value="积分期限" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="annualFeeType" , value="年费类型(1终身免年费 2交易免年费)" ,required = true , paramType = "query" ,dataType = "Integer"),
            @ApiImplicitParam(name="annualFeeDescription" , value="年费说明" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="CashWithdrawalRatio" , value="取现比例" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="CashWithdrawalFee" , value="取现费用" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="MinimumRepayment" , value="最低还款" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="privilege" , value="特权(1航空保险 2健康保险 3机场贵宾服务 4健康服务 5汽车救援)" ,required = true , paramType = "query" ,dataType = "Integer"),
            @ApiImplicitParam(name="otherPrivilege" , value="其他权益" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="applySkill" , value="申请卡资格及技巧" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="otherDetails" , value="其他详情" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="cardCoverType" , value="卡面类型(1商务 2卡通 3时尚 4炫酷 5简约 6清新 7传统 8主题)" ,required = true , paramType = "query" ,dataType = "Integer")
    })
    @CrossOrigin
    public ReqResponse insertCard(BasicParameters param){
        String bankId = request.getParameter("bankId");
        String cardName = request.getParameter("cardName");
        String jumpUrl = request.getParameter("jumpUrl");
        String coverUrl = request.getParameter("coverUrl");
        String productUrl = request.getParameter("productUrl");
        String summary = request.getParameter("summary");
        String level = request.getParameter("level");
        String moneyType = request.getParameter("moneyType");
        String cardOrganization = request.getParameter("cardOrganization");
        String interestFreePeriod = request.getParameter("interestFreePeriod");
        String pointTotal = request.getParameter("pointTotal");
        String pointPeriod = request.getParameter("pointPeriod");
        String annualFeeType = request.getParameter("annualFeeType");
        String annualFeeDescription = request.getParameter("annualFeeDescription");
        String CashWithdrawalRatio = request.getParameter("CashWithdrawalRatio");
        String CashWithdrawalFee = request.getParameter("CashWithdrawalFee");
        String MinimumRepayment = request.getParameter("MinimumRepayment");
        String privilege = request.getParameter("privilege");
        String otherPrivilege = request.getParameter("otherPrivilege");
        String applySkill = request.getParameter("applySkill");
        String otherDetails = request.getParameter("otherDetails");
        String cardCoverType = request.getParameter("cardCoverType");
        ReqResponse req = null;
        return req;
    }
}
