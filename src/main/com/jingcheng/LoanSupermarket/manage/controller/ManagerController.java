package jingcheng.LoanSupermarket.manage.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jingcheng.LoanSupermarket.manage.service.ManageService;
import jingcheng.utils.base.BaseController;
import jingcheng.utils.base.BasicParameters;
import jingcheng.utils.picture.PictureUrl;
import jingcheng.utils.response.ErrorMessage;
import jingcheng.utils.response.ReqResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

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
            @ApiImplicitParam(name="currentPage" , value="当前页码" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="pageSize" , value="页面容量" ,required = false , paramType = "query" ,dataType = "int")
    })
    @CrossOrigin
    public ReqResponse userList(BasicParameters param){
        String userPhone = request.getParameter("userPhone");
        String createStart = request.getParameter("createStart");
        String createEnd = request.getParameter("createEnd");
        String loginStart = request.getParameter("loginStart");
        String loginEnd = request.getParameter("loginEnd");
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        ReqResponse req = manageService.userList(userPhone,createStart,createEnd,loginStart,loginEnd,currentPage,pageSize);
        return req;
    }


    @RequestMapping(value="/loan/loanList", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "贷款列表", notes = "贷款列表", httpMethod = "POST")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="productName" , value="产品名称" ,required = false , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="amountMin" , value="最低额度" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="amountMax" , value="最高额度" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="tags" , value="标签(多个逗号隔开)" ,required = false , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="startTime" , value="起始时间(格式:2019-01-01)" ,required = false , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="endTime" , value="结束时间(格式:2019-01-01)" ,required = false , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="status" , value="状态(1正常 2禁用)" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="currentPage" , value="当前页码" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="pageSize" , value="页面容量" ,required = false , paramType = "query" ,dataType = "int")
    })
    @CrossOrigin
    public ReqResponse loanList(BasicParameters param){
        String productName = request.getParameter("productName");
        String amountMin = request.getParameter("amountMin");
        String amountMax = request.getParameter("amountMax");
        String tags = request.getParameter("tags");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String status = request.getParameter("status");
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        ReqResponse req = manageService.loanList(productName ,amountMin ,amountMax ,tags ,startTime ,endTime ,status ,currentPage ,pageSize);
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
            @ApiImplicitParam(name="rateType" , value="利率类型(2日 3月 4年)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="amountMin" , value="贷款额度范围(最小)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="amountMax" , value="贷款额度范围(最大)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="deadlineStart" , value="贷款期限(起始)" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="deadlineEnd" , value="贷款期限(结束)" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="loanTime" , value="放款时间" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="loanType" , value="放款时间类型(1小时 2日 3月)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="weights" , value="权重" ,required = true , paramType = "query" ,dataType = "int"),
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
        ReqResponse req = new ReqResponse();
        try{
            req = manageService.insertLoan(productName ,productUrl ,jumpUrl ,rate ,rateType ,
                    amountMin ,amountMax ,deadlineStart ,deadlineEnd ,loanTime ,loanType ,weights ,
                    tags ,apply ,applyTerm ,applyMaterial ,remark);
        }catch(Exception e){
            req.setCode(ErrorMessage.FAIL.getCode());
            req.setMessage("数据类型错误");
        }
        return req;
    }


    @RequestMapping(value="/card/cardList", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "信用卡列表", notes = "信用卡列表", httpMethod = "POST")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="bankId" , value="银行id" ,required = false , paramType = "query" ,dataType = "Long"),
            @ApiImplicitParam(name="cardName" , value="信用卡名称" ,required = false , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="level" , value="等级(1普卡 2金卡 3白金卡)" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="moneyType" , value="币种(1人民币 2美元 3日元)" ,required = false , paramType = "query" ,dataType = "Strinting"),
            @ApiImplicitParam(name="cardOrganization" , value="发卡组织(1银联 2visa 3jcb 4运通)" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="annualFeeType" , value="年费类型(1终身免年费 2交易免年费)" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="privilege" , value="特权(1航空保险 2健康保险 3机场贵宾服务 4健康服务 5汽车救援)" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="cardCoverType" , value="卡面类型(1商务 2卡通 3时尚 4炫酷 5简约 6清新 7传统 8主题)" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="status" , value="状态" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="startTime" , value="起始时间" ,required = false , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="endTime" , value="结束时间" ,required = false , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="currentPage" , value="当前页码" ,required = false , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="pageSize" , value="页面容量" ,required = false , paramType = "query" ,dataType = "int")
    })
    @CrossOrigin
    public ReqResponse cardList(BasicParameters param){
        String bankId = request.getParameter("bankId");
        String cardName = request.getParameter("cardName");
        String level = request.getParameter("level");
        String moneyType = request.getParameter("moneyType");
        String cardOrganization = request.getParameter("cardOrganization");
        String annualFeeType = request.getParameter("annualFeeType");
        String privilege = request.getParameter("privilege");
        String cardCoverType = request.getParameter("cardCoverType");
        String status = request.getParameter("status");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        ReqResponse req = manageService.cardList(bankId ,cardName ,level ,moneyType ,cardOrganization ,annualFeeType ,
                privilege ,cardCoverType ,status ,startTime ,endTime ,currentPage ,pageSize);
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
            @ApiImplicitParam(name="productUrl" , value="产品图(可传多张)" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="summary" , value="摘要" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="level" , value="等级(1普卡 2金卡 3白金卡)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="moneyType" , value="币种(1人民币 2美元 3日元)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="cardOrganization" , value="发卡组织(1银联 2visa 3jcb 4运通)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="interestFreePeriod" , value="免息期限" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="pointTotal" , value="积分累计" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="pointPeriod" , value="积分期限" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="annualFeeType" , value="年费类型(1终身免年费 2交易免年费)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="annualFeeDescription" , value="年费说明" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="CashWithdrawalRatio" , value="取现比例" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="CashWithdrawalFee" , value="取现费用" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="MinimumRepayment" , value="最低还款" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="privilege" , value="特权(1航空保险 2健康保险 3机场贵宾服务 4健康服务 5汽车救援)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="otherPrivilege" , value="其他权益" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="applySkill" , value="申请卡资格及技巧" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="otherDetails" , value="其他详情" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="cardCoverType" , value="卡面类型(1商务 2卡通 3时尚 4炫酷 5简约 6清新 7传统 8主题)" ,required = true , paramType = "query" ,dataType = "int")
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
        ReqResponse req = manageService.insertCard(bankId ,cardName ,jumpUrl ,coverUrl ,productUrl ,summary ,level ,moneyType ,
                cardOrganization ,interestFreePeriod ,pointTotal ,pointPeriod ,annualFeeType ,annualFeeDescription ,CashWithdrawalRatio ,
                CashWithdrawalFee ,MinimumRepayment ,privilege ,otherPrivilege ,applySkill ,otherDetails ,cardCoverType);
        return req;
    }


    @RequestMapping(value="/card/insertBank", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增银行信息", notes = "新增银行信息", httpMethod = "POST")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="bankName" , value="银行名称" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="bankIcon" , value="银行图标" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="bankRemark" , value="银行备注" ,required = true , paramType = "query" ,dataType = "String")
    })
    @CrossOrigin
    public ReqResponse insertBank(BasicParameters param){
        String bankName = request.getParameter("bankName");
        String bankIcon = request.getParameter("bankIcon");
        String bankRemark = request.getParameter("bankRemark");
        ReqResponse req = manageService.insertBank(bankName ,bankIcon, bankRemark);
        return req;
    }


    @RequestMapping(value="upload", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "上传图片", notes = "上传图片", httpMethod = "POST")
    @ApiImplicitParams(value={
        @ApiImplicitParam(name="type" , value="1贷款 2信用卡 3银行 4头像" ,required = true , paramType = "query" ,dataType = "int"),
        @ApiImplicitParam(name="file" , value="文件,可传多张" ,required = true , paramType = "query" ,dataType = "String")
    })
    @CrossOrigin
    public ReqResponse upload(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
        ReqResponse req = new ReqResponse();

        int type = Integer.valueOf(request.getParameter("type"));
        String url = "";
        String picture ;
        String pictureUrl ;

        if(type == 1){
            picture = PictureUrl.picture + "/loan/";
            pictureUrl = PictureUrl.pictureUrl + "/loan/";
        }else if(type == 2){
            picture = PictureUrl.picture + "/card/";
            pictureUrl = PictureUrl.pictureUrl + "/card/";
        }else if(type == 3){
            picture = PictureUrl.picture + "/bank/";
            pictureUrl = PictureUrl.pictureUrl + "/bank/";
        }else if(type == 4){
            picture = PictureUrl.picture + "/user/";
            pictureUrl = PictureUrl.pictureUrl + "/user/";
        }else{
            req.setCode(ErrorMessage.FAIL.getCode());
            req.setMessage("type参数错误");
            return req;
        }

        // 创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver( request.getSession().getServletContext());
        // 判断 request 是否有文件上传,即多部分请求
        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {

                // 取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    // 取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    // 如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if (myFileName.trim() != "") {
                        // 重命名上传后的文件名
                        String fileName = file.getOriginalFilename();
                        //截取文件后缀
                        int i = fileName.indexOf(".");
                        String hou = fileName.substring(i, fileName.length());
                        int random = (int)(Math.random()*1000);
                        // 定义上传路径
                        String newName = random + "." + hou;
                        String path = picture + newName;
                        File localFile = new File(path);
                        file.transferTo(localFile);
                        req.setCode(ErrorMessage.SUCCESS.getCode());
                        req.setMessage("上传完成");
                        String p = pictureUrl + newName;
                        url = url + p + ",";
                        req.setResult(url);
                    }
                }
            }
        }
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("上传成功");
        return req;
    }

}
