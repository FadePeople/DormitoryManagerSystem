package com.hyb.service;

import com.hyb.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hyb.form.SearchForm;
import com.hyb.vo.PageVO;
import com.hyb.vo.ResultVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Heyubo
 * @since 2022-07-27
 */
public interface StudentService extends IService<Student> {

    public Boolean saveStudent(Student student);
    public PageVO list(Integer page, Integer size);
    public PageVO search(SearchForm searchForm);
    public Boolean deleteById(Integer id);
}
