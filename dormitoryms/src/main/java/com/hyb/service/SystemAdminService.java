package com.hyb.service;

import com.hyb.entity.SystemAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hyb.form.RuleForm;
import com.hyb.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Heyubo
 * @since 2022-07-27
 */
public interface SystemAdminService extends IService<SystemAdmin> {

    ResultVO login(RuleForm ruleForm);
}
