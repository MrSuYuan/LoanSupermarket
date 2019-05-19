package jingcheng.LoanSupermarket.manage.service.impl;

import jingcheng.LoanSupermarket.manage.dao.ManageDao;
import jingcheng.LoanSupermarket.manage.service.ManageService;
import jingcheng.LoanSupermarket.user.entity.UserVo;
import jingcheng.utils.response.ErrorMessage;
import jingcheng.utils.response.ReqResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台管理模块逻辑层实现
 */
@Service("manageService")
public class ManageServiceImpl implements ManageService {

    @Resource
    private ManageDao manageDao;

    /**
     * 用户列表
     */
    @Override
    public ReqResponse userList(String userPhone, String createStart, String createEnd, String loginStart, String loginEnd, String currentPage) {
        ReqResponse req = new ReqResponse();
        Map<String,Object> map = new HashMap<>();
        map.put("userPhone",userPhone);
        map.put("createStart",createStart);
        map.put("createEnd",createEnd);
        map.put("loginStart",loginStart);
        map.put("loginEnd",loginEnd);
        if(null != currentPage && !"".equals(currentPage) && Integer.valueOf(currentPage)>0){
            map.put("num",(Integer.valueOf(currentPage)-1)*10);
        }else{
            map.put("num",0);
        }
        List<UserVo> list = manageDao.userList(map);
        Map<String,Object> result = new HashMap<>();
        result.put("userList",list);
        req.setResult(result);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }
}
