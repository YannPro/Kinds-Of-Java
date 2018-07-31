package com.yannyao.demo.yimo.controller;

import com.yannyao.demo.yimo.Exception.BaseErrors;
import com.yannyao.demo.yimo.Exception.BusinessException;
import com.yannyao.demo.yimo.response.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yimo")
public class YimoController {

    @RequestMapping("/a")
    public BaseResponse<String> test() {
        try{
            int i = 1/0;
        }catch (Exception e){

            throw e;
        }
        return null;
    }
}
