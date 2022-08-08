package com.hyb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyb.entity.DormitoryAdmin;
import com.hyb.form.RuleForm;
import com.hyb.form.SearchForm;
import com.hyb.mapper.DormitoryAdminMapper;
import com.hyb.mapper.DormitoryMapper;
import com.hyb.service.DormitoryAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyb.vo.PageVO;
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
public class DormitoryAdminServiceImpl extends ServiceImpl<DormitoryAdminMapper, DormitoryAdmin> implements DormitoryAdminService {

    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;

    @Override
    public ResultVO login(RuleForm ruleForm) {
        QueryWrapper<DormitoryAdmin> dormitoryAdminQueryWrapper = new QueryWrapper<>();
        dormitoryAdminQueryWrapper.eq("username",ruleForm.getUsername());
        DormitoryAdmin dormitoryAdmin = dormitoryAdminMapper.selectOne(dormitoryAdminQueryWrapper);
        ResultVO resultVO = new ResultVO();
        if(dormitoryAdmin==null){
            resultVO.setCode(-1);
            System.out.println("用户不存在");
        }else {
            //判断密码
            if(!ruleForm.getPassword().equals(dormitoryAdmin.getPassword())){
                resultVO.setCode(-2);
                System.out.println("密码错误");
            }else{
                resultVO.setCode(0);
                resultVO.setData(dormitoryAdmin);
                System.out.println("登录成功！");
            }
        }
        return resultVO;
    }

    @Override
    public PageVO list(Integer page, Integer size) {
        Page<DormitoryAdmin> dormitoryAdminPage = new Page<>(page,size);
        Page<DormitoryAdmin> resultPage = dormitoryAdminMapper.selectPage(dormitoryAdminPage, null);
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }

    @Override
    public PageVO search(SearchForm searchForm) {
        //模糊查询+分页
        Page<DormitoryAdmin> dormitoryAdminPage = new Page<>(searchForm.getPage(), searchForm.getSize());
        Page<DormitoryAdmin> resultPage = null;
        if(searchForm.getValue().equals("")){
            resultPage = dormitoryAdminMapper.selectPage(dormitoryAdminPage, null);
        }else{
            QueryWrapper<DormitoryAdmin> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(searchForm.getKey(),searchForm.getValue());
            resultPage = dormitoryAdminMapper.selectPage(dormitoryAdminPage,queryWrapper);
        }
        PageVO pageVO = new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }
}
