package com.hyb.controller;


import com.hyb.entity.DormitoryAdmin;
import com.hyb.form.RuleForm;
import com.hyb.form.SearchForm;
import com.hyb.service.DormitoryAdminService;
import com.hyb.util.ResultVOUtil;
import com.hyb.vo.PageVO;
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
@RequestMapping("/dormitoryAdmin")
public class DormitoryAdminController {
    @Autowired
    private DormitoryAdminService dormitoryAdminService;
    @GetMapping("/login")
    public ResultVO login(RuleForm ruleForm) {
        ResultVO resultVO = dormitoryAdminService.login(ruleForm);
        return resultVO;
    }

    @PostMapping("/save")
    public ResultVO save(@RequestBody DormitoryAdmin dormitoryAdmin){
        boolean save = dormitoryAdminService.save(dormitoryAdmin);
        ResultVO resultVO = new ResultVO();
        if(save) return ResultVOUtil.sucess(null);
        return ResultVOUtil.fail();
    }

    @GetMapping("/list/{page}/{size}")
    public ResultVO list(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        PageVO list = dormitoryAdminService.list(page, size);
        return ResultVOUtil.sucess(list);
    }

    @GetMapping("/search")
    public ResultVO search(SearchForm searchForm){
        PageVO pageVO = dormitoryAdminService.search(searchForm);
        return ResultVOUtil.sucess(pageVO);
    }

    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id") Integer id){
        DormitoryAdmin dormitoryAdmin = dormitoryAdminService.getById(id);
        return ResultVOUtil.sucess(dormitoryAdmin);
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody DormitoryAdmin dormitoryAdmin){
        boolean updateById = dormitoryAdminService.updateById(dormitoryAdmin);
        if(!updateById) return ResultVOUtil.fail();
        return ResultVOUtil.sucess(null);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id") Integer id){
        boolean removeById = dormitoryAdminService.removeById(id);
        if(!removeById) return ResultVOUtil.fail();
        return ResultVOUtil.sucess(null);
    }

    @GetMapping("/list")
    public ResultVO list(){
        List<DormitoryAdmin> list = dormitoryAdminService.list();
        return ResultVOUtil.sucess(list);
    }

}

