package com.hyb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hyb.entity.DormitoryAdmin;
import com.hyb.entity.SystemAdmin;
import com.hyb.form.RuleForm;
import com.hyb.mapper.SystemAdminMapper;
import com.hyb.service.SystemAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyb.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Heyubo
 * @since 2022-07-27
 */
@Service
public class SystemAdminServiceImpl extends ServiceImpl<SystemAdminMapper, SystemAdmin> implements SystemAdminService {
    @Autowired
    private SystemAdminMapper systemAdminMapper;
    @Override
    public ResultVO login(RuleForm ruleForm) {
        QueryWrapper<SystemAdmin> systemAdminQueryWrapper = new QueryWrapper<>();
        systemAdminQueryWrapper.eq("username",ruleForm.getUsername());
        SystemAdmin systemAdmin = systemAdminMapper.selectOne(systemAdminQueryWrapper);
        ResultVO resultVO = new ResultVO();
        if(systemAdmin==null){
            resultVO.setCode(-1);
            System.out.println("用户不存在");
        }else {
            //判断密码
            if(!ruleForm.getPassword().equals(systemAdmin.getPassword())){
                resultVO.setCode(-2);
                System.out.println("密码错误");
            }else{
                resultVO.setCode(0);
                resultVO.setData(systemAdmin);
                System.out.println("登录成功！");
            }
        }
        return resultVO;
    }
}
