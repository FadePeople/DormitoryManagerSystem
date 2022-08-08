package com.hyb.controller;


import com.hyb.entity.Building;
import com.hyb.form.SearchForm;
import com.hyb.service.BuildingService;
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
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @PostMapping("/save")
    public ResultVO save(@RequestBody Building building){
        boolean save = buildingService.save(building);
        if(save) return ResultVOUtil.sucess(null);
        return ResultVOUtil.fail();
    }

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        return ResultVOUtil.sucess(this.buildingService.list(page, size));
    }

    @GetMapping("/list")
    public ResultVO list(){
        return ResultVOUtil.sucess(this.buildingService.list());
    }

    @GetMapping("/search")
    public ResultVO search(SearchForm searchForm){
        return ResultVOUtil.sucess(this.buildingService.search(searchForm));
    }

    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") Integer id){
        return ResultVOUtil.sucess(buildingService.getById(id));
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody Building building){
        boolean update = this.buildingService.updateById(building);
        if(!update) return ResultVOUtil.fail();
        return ResultVOUtil.sucess(null);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id") Integer id){
        Boolean delete = buildingService.deleteById(id);
        if(delete) return ResultVOUtil.sucess(null);
        return ResultVOUtil.fail();
    }
}

