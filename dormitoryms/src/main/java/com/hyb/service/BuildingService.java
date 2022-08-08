package com.hyb.service;

import com.hyb.entity.Building;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hyb.form.SearchForm;
import com.hyb.vo.PageVO;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Heyubo
 * @since 2022-07-27
 */
public interface BuildingService extends IService<Building> {

    public PageVO list(Integer page,Integer size);
    public PageVO search(SearchForm searchForm);
    public Boolean deleteById(Integer id);
}
