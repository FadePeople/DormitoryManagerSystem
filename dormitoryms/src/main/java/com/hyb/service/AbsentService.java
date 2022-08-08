package com.hyb.service;

import com.hyb.entity.Absent;
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
public interface AbsentService extends IService<Absent> {
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
}
