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

}
