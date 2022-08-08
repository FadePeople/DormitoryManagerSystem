package com.hyb.service;

import com.hyb.entity.Dormitory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hyb.form.SearchForm;
import com.hyb.vo.PageVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Heyubo
 * @since 2022-07-27
 */
public interface DormitoryService extends IService<Dormitory> {
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
    public Boolean deleteById(Integer id);

}
