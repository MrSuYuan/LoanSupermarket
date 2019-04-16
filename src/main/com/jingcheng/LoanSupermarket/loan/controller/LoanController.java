package jingcheng.LoanSupermarket.loan.controller;

import io.swagger.annotations.Api;
import jingcheng.LoanSupermarket.loan.service.LoanService;
import jingcheng.utils.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/loan")
@Api(value = "/loan", tags = "贷款模块接口")
public class LoanController extends BaseController {

    @Resource
    private LoanService loanService;

}
