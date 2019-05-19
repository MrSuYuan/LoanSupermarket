package jingcheng.LoanSupermarket.manage.dao;

import jingcheng.LoanSupermarket.user.entity.UserVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 后台管理模块数据层接口
 */
@Repository
public interface ManageDao {

    /**
     * 用户列表
     */
    List<UserVo> userList(Map<String,Object> map);
}
