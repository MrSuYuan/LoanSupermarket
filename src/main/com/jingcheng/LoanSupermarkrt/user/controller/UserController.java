package jingcheng.LoanSupermarkrt.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jingcheng.LoanSupermarkrt.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Api(value = "/user", tags = "用户模块接口")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value="user", method= RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "测试方法", notes = "测试方法详细说明", httpMethod = "GET")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="phone" , value="手机号" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="code" , value="验证码" ,required = true , paramType = "query" ,dataType = "String"),
            @ApiImplicitParam(name="password" , value="新密码" ,required = true , paramType = "query" ,dataType = "String")
    })
    @CrossOrigin
    public Map<String,Object> user(String phone, String code, String password){
        Map<String,Object> map=new HashMap<>();
        int i=userService.userNum();
        map.put("num", i);
        map.put("phone", phone);
        map.put("code", code);
        map.put("password", password);
        map.put("msg", "数据加载成功");
        map.put("flag", true);
        return map;
    }

    //添加注释

}
