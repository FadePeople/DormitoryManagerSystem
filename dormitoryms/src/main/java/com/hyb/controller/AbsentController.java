package com.hyb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hyb.entity.Absent;
import com.hyb.entity.Dormitory;
import com.hyb.entity.Student;
import com.hyb.form.SearchForm;
import com.hyb.service.AbsentService;
import com.hyb.service.BuildingService;
import com.hyb.service.DormitoryService;
import com.hyb.service.StudentService;
import com.hyb.util.ResultVOUtil;
import com.hyb.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Heyubo
 * @since 2022-07-27
 */
@RestController
@RequestMapping("/absent")
public class AbsentController {

    @Autowired
    private AbsentService absentService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        return ResultVOUtil.sucess(this.absentService.list(page, size));
    }

    @GetMapping("/search")
    public ResultVO search(SearchForm searchForm){
        return ResultVOUtil.sucess(this.absentService.search(searchForm));
    }

    @GetMapping("/buildingList")
    public ResultVO buildingList(){
        return ResultVOUtil.sucess(this.buildingService.list());
    }

    @GetMapping("/findDormitoryByBuildingId/{id}")
    public ResultVO findDormitoryByBuildingId(@PathVariable("id") Integer id){
        QueryWrapper<Dormitory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("building_id", id);
        List<Dormitory> dormitoryList = this.dormitoryService.list(queryWrapper);
        return ResultVOUtil.sucess(dormitoryList);
    }

    @GetMapping("/findStudentByDormitoryId/{id}")
    public ResultVO findStudentByDormitoryId(@PathVariable("id") Integer id){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dormitory_id", id);
        List<Student> studentList = this.studentService.list(queryWrapper);
        return ResultVOUtil.sucess(studentList);
    }

    @PostMapping("/save")
    public ResultVO save(@RequestBody Absent absent){
        String createDate = absent.getCreateDate();
        createDate = createDate.substring(0, 10);
        absent.setCreateDate(createDate);
        boolean save = this.absentService.save(absent);
        if(!save) return ResultVOUtil.fail();
        return ResultVOUtil.sucess(null);
    }


}

