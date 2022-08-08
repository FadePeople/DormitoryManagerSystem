package com.hyb.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hyb.entity.Dormitory;
import com.hyb.form.SearchForm;
import com.hyb.service.DormitoryService;
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
@RequestMapping("/dormitory")
public class DormitoryController {

    @Autowired
    private DormitoryService dormitoryService;

    @GetMapping("/availableList")
    public ResultVO availableList(){
        QueryWrapper<Dormitory> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("available", 0);
        List<Dormitory> dormitoryList = this.dormitoryService.list(queryWrapper);
        return ResultVOUtil.sucess(dormitoryList);
    }

    @PostMapping("/save")
    public ResultVO save(@RequestBody Dormitory dormitory){
        dormitory.setAvailable(dormitory.getType());
        boolean save = this.dormitoryService.save(dormitory);
        if(!save) return ResultVOUtil.fail();
        return ResultVOUtil.sucess(null);
    }

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        return ResultVOUtil.sucess(this.dormitoryService.list(page, size));
    }

    @GetMapping("/search")
    public ResultVO search(SearchForm searchForm){
        return ResultVOUtil.sucess(this.dormitoryService.search(searchForm));
    }

    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") Integer id){
        return ResultVOUtil.sucess(this.dormitoryService.getById(id));
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody Dormitory dormitory){
        boolean update = this.dormitoryService.updateById(dormitory);
        if(!update) return ResultVOUtil.fail();
        return ResultVOUtil.sucess(null);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id") Integer id){
        Boolean delete = this.dormitoryService.deleteById(id);
        if(!delete) return ResultVOUtil.fail();
        return ResultVOUtil.sucess(null);
    }
}

