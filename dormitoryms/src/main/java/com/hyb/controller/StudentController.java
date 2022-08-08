package com.hyb.controller;


import com.hyb.entity.Student;
import com.hyb.form.SearchForm;
import com.hyb.service.StudentService;
import com.hyb.util.ResultVOUtil;
import com.hyb.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Heyubo
 * @since 2022-07-27
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody Student student){
        Boolean saveStudent = studentService.saveStudent(student);
        if(saveStudent) return ResultVOUtil.sucess(null);
        return ResultVOUtil.fail();
    }

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable Integer page, @PathVariable Integer size){
        return ResultVOUtil.sucess(studentService.list(page,size));
    }

    @GetMapping("/search")
    public ResultVO search(SearchForm searchForm){
        return ResultVOUtil.sucess(studentService.search(searchForm));
    }

    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") Integer id){
        Student student = studentService.getById(id);
        return ResultVOUtil.sucess(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id") Integer id){
        Boolean deleteById = studentService.deleteById(id);
        if(deleteById) return ResultVOUtil.sucess(null);
        return ResultVOUtil.fail();
    }
}

