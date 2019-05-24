package jingcheng.LoanSupermarket.loan.controller;

import io.swagger.annotations.*;
import jingcheng.LoanSupermarket.loan.service.LoanService;
import jingcheng.utils.base.BaseController;
import jingcheng.utils.base.BasicParameters;
import jingcheng.utils.response.ErrorMessage;
import jingcheng.utils.response.ReqResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/loan")
@Api(value = "/loan", tags = "贷款模块接口")
public class LoanController extends BaseController {

    @Resource
    private LoanService loanService;

    @RequestMapping(value="carousel", method= RequestMethod.POST)
    @ApiImplicitParams(value={
        @ApiImplicitParam(name="device_type" , value="设备类型（1：Android，2：IOS, 3WEB）" ,required = true, paramType = "query" ,dataType = "String")
    })
    @ResponseBody
    @ApiOperation(value = "贷款轮播页", notes = "贷款轮播页", httpMethod = "POST")
    public ReqResponse carousel(){
        ReqResponse req = loanService.carousel();
        return req;
    }


    @RequestMapping(value="headline", method= RequestMethod.POST)
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="device_type" , value="设备类型（1：Android，2：IOS, 3WEB）" ,required = true, paramType = "query" ,dataType = "String")
    })
    @ResponseBody
    @ApiOperation(value = "贷款头条", notes = "贷款头条", httpMethod = "POST")
    public ReqResponse headline(){
        ReqResponse req = loanService.headline();
        return req;
    }


    @RequestMapping(value="hotLoan", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
        @ApiImplicitParam(name="device_type" , value="设备类型（1：Android，2：IOS, 3WEB）" ,required = true, paramType = "query" ,dataType = "String"),
        @ApiImplicitParam(name="type" , value="分类(1推荐 2易通过 3放款快 4利息低)" ,required = true , paramType = "query" ,dataType = "int"),
        @ApiImplicitParam(name="currentPage" , value="当前页" ,required = false , paramType = "query" ,dataType = "int")
    })
    @ApiOperation(value = "热门贷款", notes = "热门贷款", httpMethod = "POST")
    public ReqResponse hotLoan(){
        String type = request.getParameter("type");
        String currentPage = request.getParameter("currentPage");
        ReqResponse req = new ReqResponse();
        if(type != null && !"".equals(type)){
            req = loanService.hotLoan(Integer.valueOf(type), formatCurrentPage(currentPage));
        }else{
            req.setCode(ErrorMessage.FAIL.getCode());
            req.setMessage("参数错误");
        }
        return req;
    }


    @RequestMapping(value="newProducts", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="device_type" , value="设备类型（1：Android，2：IOS, 3WEB）" ,required = true, paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="type" , value="分类(1推荐 2易通过 3放款快 4利息低)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="currentPage" , value="当前页" ,required = false , paramType = "query" ,dataType = "int")
    })
    @ApiOperation(value = "新品推荐", notes = "新品推荐", httpMethod = "POST")
    public ReqResponse newProducts(){
        String type = request.getParameter("type");
        String currentPage = request.getParameter("currentPage");
        ReqResponse req = new ReqResponse();
        if(type != null && !"".equals(type)){
            req = loanService.newProducts(Integer.valueOf(type), formatCurrentPage(currentPage));
        }else{
            req.setCode(ErrorMessage.FAIL.getCode());
            req.setMessage("参数错误");
        }
        return req;
    }


    @RequestMapping(value="hotProduct", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="device_type" , value="设备类型（1：Android，2：IOS, 3WEB）" ,required = true, paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="type" , value="分类(1推荐 2易通过 3放款快 4利息低)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="currentPage" , value="当前页" ,required = false , paramType = "query" ,dataType = "int")
    })
    @ApiOperation(value = "热门产品", notes = "热门产品", httpMethod = "POST")
    public ReqResponse hotProduct(){
        String type = request.getParameter("type");
        String currentPage = request.getParameter("currentPage");
        ReqResponse req = new ReqResponse();
        if(type != null && !"".equals(type)){
            req = loanService.hotProduct(Integer.valueOf(type), formatCurrentPage(currentPage));
        }else{
            req.setCode(ErrorMessage.FAIL.getCode());
            req.setMessage("参数错误");
        }
        return req;
    }


    @RequestMapping(value="largeStaging", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="device_type" , value="设备类型（1：Android，2：IOS, 3WEB）" ,required = true, paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="type" , value="分类(1推荐 2易通过 3放款快 4利息低)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="currentPage" , value="当前页" ,required = false , paramType = "query" ,dataType = "int")
    })
    @ApiOperation(value = "大额分期", notes = "大额分期", httpMethod = "POST")
    public ReqResponse largeStaging(){
        String type = request.getParameter("type");
        String currentPage = request.getParameter("currentPage");
        ReqResponse req = new ReqResponse();
        if(type != null && !"".equals(type)){
            req = loanService.largeStaging(Integer.valueOf(type), formatCurrentPage(currentPage));
        }else{
            req.setCode(ErrorMessage.FAIL.getCode());
            req.setMessage("参数错误");
        }
        return req;
    }


    @RequestMapping(value="smallLoan", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="device_type" , value="设备类型（1：Android，2：IOS, 3WEB）" ,required = true, paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="type" , value="分类(1推荐 2易通过 3放款快 4利息低)" ,required = true , paramType = "query" ,dataType = "int"),
            @ApiImplicitParam(name="currentPage" , value="当前页" ,required = false , paramType = "query" ,dataType = "int")
    })
    @ApiOperation(value = "小额速贷", notes = "小额速贷", httpMethod = "POST")
    public ReqResponse smallLoan(){
        String type = request.getParameter("type");
        String currentPage = request.getParameter("currentPage");
        ReqResponse req = new ReqResponse();
        if(type != null && !"".equals(type)){
            req = loanService.smallLoan(Integer.valueOf(type), formatCurrentPage(currentPage));
        }else{
            req.setCode(ErrorMessage.FAIL.getCode());
            req.setMessage("参数错误");
        }
        return req;
    }


    @RequestMapping(value="loan", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="device_type" , value="设备类型（1：Android，2：IOS, 3WEB）" ,required = true, paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="loanId" , value="贷款id" ,required = true , paramType = "query" ,dataType = "Long"),
            @ApiImplicitParam(name="userId" , value="用户id" ,required = false , paramType = "query" ,dataType = "Long")
    })
    @ApiOperation(value = "贷款详情", notes = "贷款详情", httpMethod = "POST")
    public ReqResponse loan(){
        String loanId = request.getParameter("loanId");
        String userId = request.getParameter("userId");
        ReqResponse req = loanService.loan(userId, Long.valueOf(loanId));
        return req;
    }


    @RequestMapping(value="loanCollect", method= RequestMethod.POST)
    @ResponseBody
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="device_type" , value="设备类型（1：Android，2：IOS, 3WEB）" ,required = true, paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="collectStatus" , value="0取消收藏 1收藏" ,required = true, paramType = "query" ,dataType = "Integer"),
            @ApiImplicitParam(name="loanId" , value="贷款id" ,required = true , paramType = "query" ,dataType = "Long"),
            @ApiImplicitParam(name="userId" , value="用户id" ,required = true , paramType = "query" ,dataType = "Long")
    })
    @ApiOperation(value = "贷款收藏", notes = "贷款收藏", httpMethod = "POST")
    public ReqResponse loanCollect(){
        String loanId = request.getParameter("loanId");
        String userId = request.getParameter("userId");
        String collectStatus = request.getParameter("collectStatus");
        ReqResponse req = loanService.loanCollect(collectStatus, userId, Long.valueOf(loanId));
        return req;
    }

    /**
     * 格式化页码
     * @param currentPage 前段传来的页面
     * @return 数据库查询起始条数
     */
    public static int formatCurrentPage(String currentPage){
        if(null == currentPage || "".equals(currentPage)){
            return 0;
        }else{
            return (Integer.valueOf(currentPage)-1)*10;
        }
    }

}
