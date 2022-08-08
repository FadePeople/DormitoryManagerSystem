package com.hyb.controller;


import com.hyb.form.RuleForm;
import com.hyb.service.DormitoryAdminService;
import com.hyb.service.SystemAdminService;
import com.hyb.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Heyubo
 * @since 2022-07-27
 */
@RestController
@RequestMapping("/systemAdmin")
public class SystemAdminController {
    @Autowired
    private SystemAdminService systemAdminService;

    @GetMapping("/login")
    public ResultVO login(RuleForm ruleForm){
        ResultVO resultVO = systemAdminService.login(ruleForm);
        return resultVO;
    }
}

