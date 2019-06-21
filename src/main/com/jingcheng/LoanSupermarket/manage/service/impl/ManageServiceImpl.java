package jingcheng.LoanSupermarket.manage.service.impl;

import jingcheng.LoanSupermarket.card.entity.Bank;
import jingcheng.LoanSupermarket.card.entity.Card;
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
    public ReqResponse userList(String userPhone, String createStart, String createEnd, String loginStart, String loginEnd, String currentPage, String pageSize) {
        ReqResponse req = new ReqResponse();
        Map<String,Object> map = new HashMap<>();
        map.put("userPhone",userPhone);
        map.put("createStart",createStart);
        map.put("createEnd",createEnd);
        map.put("loginStart",loginStart);
        map.put("loginEnd",loginEnd);
        if(null == pageSize || "".equals(pageSize)){
            pageSize = "10";
        }
        map.put("pageSize",Integer.valueOf(pageSize));
        if(null != currentPage && !"".equals(currentPage) && Integer.valueOf(currentPage)>0){
            map.put("num",(Integer.valueOf(currentPage)-1) * Integer.valueOf(pageSize));
        }else{
            map.put("num",0);
        }
        List<UserVo> list = manageDao.userList(map);
        int userNum = manageDao.userListNum(map);
        Map<String,Object> result = new HashMap<>();
        result.put("userList",list);
        result.put("userNum",userNum);
        req.setResult(result);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }

    /**
     * 贷款列表
     */
    @Override
    public ReqResponse loanList(String productName, String amountMin, String amountMax, String tags,
            String startTime, String endTime, String status, String currentPage, String pageSize) {
        ReqResponse req = new ReqResponse();
        Map<String,Object> map = new HashMap<>();
        map.put("productName",productName);
        map.put("amountMin",amountMin);
        map.put("amountMax",amountMax);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        map.put("status",status);
        if(null == pageSize || "".equals(pageSize)){
            pageSize = "10";
        }
        map.put("pageSize",Integer.valueOf(pageSize));
        if(null != currentPage && !"".equals(currentPage) && Integer.valueOf(currentPage)>0){
            map.put("num",(Integer.valueOf(currentPage)-1) * Integer.valueOf(pageSize));
        }else{
            map.put("num",0);
        }
        if(null != tags){
            String [] tag = tags.split(",");
            map.put("tag",tag);
        }
        List<Loan> list = manageDao.loanList(map);
        int loanNum = manageDao.loanListNum(map);
        Map<String,Object> result = new HashMap<>();
        result.put("loanList",list);
        result.put("loanNum",loanNum);
        req.setResult(result);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }

    /**
     * 查看贷款详情
     */
    @Override
    public ReqResponse loan(Long loanId) {
        return null;
    }

    /**
     * 禁用/启用贷款信息
     * 1正常 2禁用
     */
    @Override
    public ReqResponse loanStatus(Long loanId, int status) {
        return null;
    }

    /**
     * 删除贷款信息
     */
    @Override
    public ReqResponse loanDelete(Long loanId) {
        return null;
    }

    /**
     * 编辑贷款信息
     */
    @Override
    public ReqResponse loanEdit(Long loanId) {
        return null;
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
        String [] url = productUrl.split(",");
        l.setProductCoverUrl(url[0]);
        manageDao.insertLoan(l);
        //String apply集合,申请流程

        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据添加完成");
        return req;
    }

    /**
     * 信用卡列表
     */
    @Override
    public ReqResponse cardList(String bankId, String cardName, String level, String moneyType, String cardOrganization, String annualFeeType,
           String privilege, String cardCoverType, String status, String startTime, String endTime, String currentPage, String pageSize) {
        ReqResponse req = new ReqResponse();
        Map<String,Object> map = new HashMap<>();
        map.put("bankId",bankId);
        map.put("cardName",cardName);
        map.put("level",level);
        map.put("moneyType",moneyType);
        map.put("cardOrganization",cardOrganization);
        map.put("annualFeeType",annualFeeType);
        map.put("privilege",privilege);
        map.put("cardCoverType",cardCoverType);
        map.put("status",status);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        if(null == pageSize || "".equals(pageSize)){
            pageSize = "10";
        }
        map.put("pageSize",Integer.valueOf(pageSize));
        if(null != currentPage && !"".equals(currentPage) && Integer.valueOf(currentPage)>0){
            map.put("num",(Integer.valueOf(currentPage)-1) * Integer.valueOf(pageSize));
        }else{
            map.put("num",0);
        }
        List<Card> list = manageDao.cardList(map);
        int cardNum = manageDao.cardNum(map);
        Map<String,Object> result = new HashMap<>();
        result.put("cardList",list);
        result.put("cardNum",cardNum);
        req.setResult(result);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }

    /**
     * 查看信用卡详情
     */
    @Override
    public ReqResponse card(Long cardId) {
        return null;
    }

    /**
     * 禁用/启用信用卡信息
     */
    @Override
    public ReqResponse cardStatus(Long cardId, int status) {
        return null;
    }

    /**
     * 删除信用卡信息
     */
    @Override
    public ReqResponse cardDelete(Long cardId) {
        return null;
    }

    /**
     * 编辑信用卡信息
     */
    @Override
    public ReqResponse cardEdit(Long cardId) {
        return null;
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

    /**
     * 添加信用卡信息
     */
    @Override
    public ReqResponse insertCard(String bankId, String cardName, String jumpUrl, String coverUrl, String productUrl, String summary, String level, String moneyType, String cardOrganization, String interestFreePeriod, String pointTotal, String pointPeriod, String annualFeeType, String annualFeeDescription, String CashWithdrawalRatio, String CashWithdrawalFee, String MinimumRepayment, String privilege, String otherPrivilege, String applySkill, String otherDetails, String cardCoverType) {
        ReqResponse req = new ReqResponse();
        Card card = new Card();
        card.setBankId(Long.parseLong(bankId));
        card.setCardName(cardName);
        card.setJumpUrl(jumpUrl);
        card.setCoverUrl(coverUrl);
        card.setProductUrl(productUrl);
        card.setSummary(summary);
        card.setLevel(Integer.valueOf(level));
        card.setMoneyType(Integer.valueOf(moneyType));
        card.setCardOrganization(Integer.valueOf(cardOrganization));
        card.setInterestFreePeriod(interestFreePeriod);
        card.setPointPeriod(pointPeriod);
        card.setPointTotal(pointTotal);
        card.setAnnualFeeDescription(annualFeeDescription);
        card.setAnnualFeeType(Integer.valueOf(annualFeeType));
        card.setCashWithdrawalRatio(CashWithdrawalRatio);
        card.setCashWithdrawalFee(CashWithdrawalFee);
        card.setMinimumRepayment(MinimumRepayment);
        card.setPrivilege(Integer.valueOf(privilege));
        card.setOtherPrivilege(otherPrivilege);
        card.setApplySkill(applySkill);
        card.setOtherDetails(otherDetails);
        card.setCardCoverType(Integer.valueOf(cardCoverType));
        manageDao.insertCard(card);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据添加完成");
        return req;
    }

    /**
     * 添加银行信息
     */
    @Override
    public ReqResponse insertBank(String bankName, String bankIcon, String bankRemark) {
        ReqResponse req = new ReqResponse();
        //先验证银行信息是否存在
        int num = manageDao.bank(bankName);
        if(num > 0){
            req.setCode(ErrorMessage.FAIL.getCode());
            req.setMessage("此银行信息已经存在");
            return req;
        }else{
            Bank bank = new Bank();
            bank.setBankName(bankName);
            bank.setBankIcon(bankIcon);
            bank.setBankRemark(bankRemark);
            manageDao.insertBank(bank);
            req.setCode(ErrorMessage.SUCCESS.getCode());
            req.setMessage("数据添加完成");
            return req;
        }

    }
}
