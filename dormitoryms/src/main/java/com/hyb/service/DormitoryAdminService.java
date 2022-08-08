package com.hyb.service;

import com.hyb.entity.DormitoryAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hyb.form.RuleForm;
import com.hyb.form.SearchForm;
import com.hyb.vo.PageVO;
import com.hyb.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Heyubo
 * @since 2022-07-27
 */
public interface DormitoryAdminService extends IService<DormitoryAdmin> {
    public ResultVO login(RuleForm ruleForm);
    public PageVO list(Integer page,Integer size);
    public PageVO search(SearchForm searchForm);
}
