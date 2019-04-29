package jingcheng.LoanSupermarket.loan.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jingcheng.LoanSupermarket.loan.service.LoanService;
import jingcheng.utils.base.BaseController;
import jingcheng.utils.base.BasicParameters;
import jingcheng.utils.response.ReqResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/loan")
@Api(value = "/loan", tags = "贷款模块接口")
public class LoanController extends BaseController {

    @Resource
    private LoanService loanService;


    @RequestMapping(value="carousel", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "贷款轮播页", notes = "贷款轮播页", httpMethod = "POST")
    public ReqResponse carousel(BasicParameters param){
        ReqResponse req = loanService.carousel();
        return req;
    }


    @RequestMapping(value="headline", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "贷款头条", notes = "贷款头条", httpMethod = "POST")
    public ReqResponse headline(BasicParameters param){
        ReqResponse req = loanService.headline();
        return req;
    }


    @RequestMapping(value="hotLoan", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="type" , value="分类(1推荐 2易通过 3放款快 4利息低)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="currentPage" , value="当前页" ,required = false , paramType = "query" ,dataType = "int")
    })
    @ApiOperation(value = "热门贷款", notes = "热门贷款", httpMethod = "POST")
    public ReqResponse hotLoan(BasicParameters param, int type, int currentPage){
        ReqResponse req = loanService.hotLoan(type, currentPage);
        return req;
    }


    @RequestMapping(value="newProducts", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="type" , value="分类(1推荐 2易通过 3放款快 4利息低)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="currentPage" , value="当前页" ,required = false , paramType = "query" ,dataType = "int")
    })
    @ApiOperation(value = "新品推荐", notes = "新品推荐", httpMethod = "POST")
    public ReqResponse newProducts(BasicParameters param, int type, int currentPage){
        ReqResponse req = loanService.newProducts(type, currentPage);
        return req;
    }


    @RequestMapping(value="brandLoan", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="type" , value="分类(1推荐 2易通过 3放款快 4利息低)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="currentPage" , value="当前页" ,required = false , paramType = "query" ,dataType = "int")
    })
    @ApiOperation(value = "品牌贷款", notes = "品牌贷款", httpMethod = "POST")
    public ReqResponse brandLoan(BasicParameters param, int type, int currentPage){
        ReqResponse req = loanService.brandLoan(type, currentPage);
        return req;
    }


    @RequestMapping(value="largeStaging", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="type" , value="分类(1推荐 2易通过 3放款快 4利息低)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="currentPage" , value="当前页" ,required = false , paramType = "query" ,dataType = "int")
    })
    @ApiOperation(value = "大额分期", notes = "大额分期", httpMethod = "POST")
    public ReqResponse largeStaging(BasicParameters param, int type, int currentPage){
        ReqResponse req = loanService.largeStaging(type, currentPage);
        return req;
    }


    @RequestMapping(value="smallLoan", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="type" , value="分类(1推荐 2易通过 3放款快 4利息低)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="currentPage" , value="当前页" ,required = false , paramType = "query" ,dataType = "int")
    })
    @ApiOperation(value = "小额速贷", notes = "小额速贷", httpMethod = "POST")
    public ReqResponse smallLoan(BasicParameters param, int type, int currentPage){
        ReqResponse req = loanService.smallLoan(type, currentPage);
        return req;
    }


    @RequestMapping(value="loan", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="loanId" , value="贷款id" ,required = true , paramType = "query" ,dataType = "Long")
    })
    @ApiOperation(value = "贷款详情", notes = "贷款详情", httpMethod = "POST")
    public ReqResponse loan(BasicParameters param, Long loanId){
        ReqResponse req = loanService.loan(loanId);
        return req;
    }

}
