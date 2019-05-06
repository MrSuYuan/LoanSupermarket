package jingcheng.LoanSupermarket.loan.service.impl;

import jingcheng.LoanSupermarket.loan.dao.LoanDao;
import jingcheng.LoanSupermarket.loan.entity.*;
import jingcheng.LoanSupermarket.loan.service.LoanService;
import jingcheng.utils.response.ErrorMessage;
import jingcheng.utils.response.ReqResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 贷款模块逻辑层实现
 */
@Service("loanService")
public class LoanServiceImpl implements LoanService {

    @Resource
    private LoanDao loanDao;

    /**
     * 贷款轮播页
     */
    @Override
    public ReqResponse carousel() {
        ReqResponse req = new ReqResponse();
        List<LoanCarousel> list = loanDao.loanCarousel();
        req.setResult(list);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }

    /**
     * 贷款头条
     */
    @Override
    public ReqResponse headline() {
        ReqResponse req = new ReqResponse();
        List<LoanHeadline> list = loanDao.headline();
        req.setResult(list);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }

    /**
     * 热门贷款
     * 分类(1推荐 2易通过 3放款快 4利息低)
     */
    @Override
    public ReqResponse hotLoan(int type, int num) {
        ReqResponse req = new ReqResponse();
        Map<String,Object> map = new HashMap<>();
        map.put("type", type);
        map.put("num", num);
        List<LoanVo> loanList = loanDao.loanList(map);
        List<Tag> tagList = loanDao.tagList();
        loanList = formatTag(loanList, tagList);
        req.setResult(loanList);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }

    /**
     * 新品推荐
     */
    @Override
    public ReqResponse newProducts(int type, int num) {
        ReqResponse req = new ReqResponse();
        Map<String,Object> map = new HashMap<>();
        map.put("type", type);
        map.put("num", num);
        List<LoanVo> loanList = loanDao.newProducts(map);
        List<Tag> tagList = loanDao.tagList();
        loanList = formatTag(loanList, tagList);
        req.setResult(loanList);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }

    /**
     * 热门产品
     */
    @Override
    public ReqResponse hotProduct(int type, int num) {
        ReqResponse req = new ReqResponse();
        Map<String,Object> map = new HashMap<>();
        map.put("type", type);
        map.put("num", num);
        List<LoanVo> loanList = loanDao.hotProduct(map);
        List<Tag> tagList = loanDao.tagList();
        loanList = formatTag(loanList, tagList);
        req.setResult(loanList);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }

    /**
     * 大额分期
     */
    @Override
    public ReqResponse largeStaging(int type, int num) {
        ReqResponse req = new ReqResponse();
        Map<String,Object> map = new HashMap<>();
        map.put("type", type);
        map.put("num", num);
        List<LoanVo> loanList = loanDao.largeStaging(map);
        List<Tag> tagList = loanDao.tagList();
        loanList = formatTag(loanList, tagList);
        req.setResult(loanList);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }

    /**
     * 小额速贷
     */
    @Override
    public ReqResponse smallLoan(int type, int num) {
        ReqResponse req = new ReqResponse();
        Map<String,Object> map = new HashMap<>();
        map.put("type", type);
        map.put("num", num);
        List<LoanVo> loanList = loanDao.smallLoan(map);
        List<Tag> tagList = loanDao.tagList();
        loanList = formatTag(loanList, tagList);
        req.setResult(loanList);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }

    /**
     * 贷款详情
     */
    @Override
    public ReqResponse loan(Long loanId) {
        ReqResponse req = new ReqResponse();
        Loan loan = loanDao.loanMessage(loanId);
        System.out.println(loan.getTags());
        List<Tag> tagList = loanDao.tagList();
        String []tadIds = loan.getTags().split(",");
        List<Tag> tag = new ArrayList<>();
        for(int j = 0; j < tadIds.length; j++){
            Tag t = new Tag();
            for(int k = 0; k < tagList.size(); k++){
                if(Long.valueOf(tadIds[j]) == tagList.get(k).getId()){
                    t.setId(tagList.get(k).getId());
                    t.setTagName(tagList.get(k).getTagName());
                    tag.add(t);
                }
            }
        }
        loan.setTagList(tag);
        req.setResult(loan);
        req.setCode(ErrorMessage.SUCCESS.getCode());
        req.setMessage("数据加载完成");
        return req;
    }

    /**
     * 格式化贷款标签
     */
    public static List<LoanVo> formatTag(List<LoanVo> loanList,List<Tag> tagList){
        for(int i = 0; i < loanList.size(); i++){
            List<Tag> tag = new ArrayList<>();
            String []tadIds = loanList.get(i).getTags().split(",");
            for(int j = 0; j < tadIds.length; j++){
                Tag t = new Tag();
                for(int k = 0; k < tagList.size(); k++){
                    if(Long.valueOf(tadIds[j]) == tagList.get(k).getId()){
                        t.setId(tagList.get(k).getId());
                        t.setTagName(tagList.get(k).getTagName());
                        tag.add(t);
                    }
                }
            }
            loanList.get(i).setTagList(tag);
        }
        return loanList;
    }
}
