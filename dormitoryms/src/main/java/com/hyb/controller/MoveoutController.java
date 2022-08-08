package com.hyb.controller;


import com.hyb.form.SearchForm;
import com.hyb.service.MoveoutService;
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
@RequestMapping("/moveout")
public class MoveoutController {

    @Autowired
    private MoveoutService moveoutService;

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        return ResultVOUtil.sucess(this.moveoutService.list(page, size));
    }

    @GetMapping("/search")
    public ResultVO search(SearchForm searchForm){
        return ResultVOUtil.sucess(this.moveoutService.search(searchForm));
    }

    @PutMapping("/moveout/{id}/{reason}")
    public ResultVO moveout(@PathVariable("id") Integer id,@PathVariable("reason") String reason){
        Boolean moveout = this.moveoutService.moveout(id, reason);
        if(!moveout) return ResultVOUtil.fail();
        return ResultVOUtil.sucess(null);
    }

    @GetMapping("/moveoutList/{page}/{size}")
    public ResultVO moveoutList(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        return ResultVOUtil.sucess(this.moveoutService.moveoutList(page, size));
    }

    @GetMapping("/moveoutSearch")
    public ResultVO moveoutSearch(SearchForm searchForm){
        return ResultVOUtil.sucess(this.moveoutService.moveoutSearch(searchForm));
    }

}

