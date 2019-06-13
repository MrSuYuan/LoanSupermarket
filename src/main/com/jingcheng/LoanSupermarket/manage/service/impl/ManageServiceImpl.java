package jingcheng.LoanSupermarket.manage.service.impl;

import jingcheng.LoanSupermarket.card.entity.Bank;
import jingcheng.LoanSupermarket.loan.entity.Loan;
import jingcheng.LoanSupermarket.loan.entity.Tag;
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

    /**
     * 贷款标签
     */
    @Override
    public ReqResponse loanTags() {
        ReqResponse req = new ReqResponse();
        List<Tag> tagList = manageDao.loanTags();
        req.setResult(tagList);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }

    /**
     * 添加贷款信息
     */
    @Override
    public ReqResponse insertLoan(String productName, String productUrl, String jumpUrl, String rate,
            String rateType, String amountMin, String amountMax, String deadlineStart, String deadlineEnd,
            String loanTime, String loanType, String weights, String tags, String apply,
            String applyTerm, String applyMaterial, String remark) {
        ReqResponse req = new ReqResponse();
        Loan l = new Loan();
        l.setProductName(productName);
        l.setProductUrl(productUrl);
        l.setJumpUrl(jumpUrl);
        l.setRate(Double.parseDouble(rate));
        l.setRateType(Integer.valueOf(rateType));
        l.setAmountMin(Integer.valueOf(amountMin));
        l.setAmountMax(Integer.valueOf(amountMax));
        l.setDeadlineStart(deadlineStart);
        l.setDeadlineEnd(deadlineEnd);
        l.setLoanTime(Integer.valueOf(loanTime));
        l.setLoanType(Integer.valueOf(loanType));
        l.setWeights(Integer.valueOf(weights));
        l.setTags(tags);
        l.setApplyTerm(applyTerm);
        l.setRemark(remark);
        l.setApplyMaterial(applyMaterial);

        //String apply集合,申请流程

        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }

    /**
     * 银行列表
     */
    @Override
    public ReqResponse bankList() {
        ReqResponse req = new ReqResponse();
        List<Bank> bank = manageDao.bankList();
        req.setResult(bank);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }
}
