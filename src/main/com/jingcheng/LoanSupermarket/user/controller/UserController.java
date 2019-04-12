package jingcheng.LoanSupermarket.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jingcheng.LoanSupermarket.user.service.UserService;
import jingcheng.utils.base.BasicParameters;
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

    @RequestMapping(value="startupPage", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "APP启动页图片", notes = "APP启动页图片", httpMethod = "POST")
    public Map<String,Object> startupPage(BasicParameters param){
        Map<String,Object> map=new HashMap<>();
        map.put("msg", "数据加载成功");
        map.put("flag", true);
        return map;
    }

    @RequestMapping(value="checkVersion", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "查看APP版本信息", notes = "查看APP版本信息", httpMethod = "POST")
    public Map<String,Object> checkVersion(){
        Map<String,Object> map=new HashMap<>();
        map.put("msg", "数据加载成功");
        map.put("flag", true);
        return map;
    }

    @RequestMapping(value="sendMessage", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "发送短信", notes = "发送短信", httpMethod = "POST")
    @ApiImplicitParams(value={
            @ApiImplicitParam(name="userPhone" , value="手机号" ,required = true , paramType = "query" ,dataType = "String")
    })
    @CrossOrigin
    public Map<String,Object> sendMessage(String userPhone){
        Map<String,Object> map=new HashMap<>();
        map.put("userPhone", userPhone);
        map.put("msg", "数据加载成功");
        map.put("flag", true);
        return map;
    }

    @RequestMapping(value="user", method= RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "测试方法", notes = "测试方法详细说明", httpMethod = "POST")
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
