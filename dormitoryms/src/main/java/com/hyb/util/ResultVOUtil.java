package com.hyb.util;

import com.hyb.vo.ResultVO;

public class ResultVOUtil {
    public static ResultVO sucess(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO fail(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(-1);
        return resultVO;
    }
}
