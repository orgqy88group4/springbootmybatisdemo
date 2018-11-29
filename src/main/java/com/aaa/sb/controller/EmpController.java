package com.aaa.sb.controller;

import com.aaa.sb.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Map;

/**
 * className:EmpController
 * discription:
 * author:qcm
 * createTime:2018-11-23 11:38
 */
@Controller
@RequestMapping("/emp001")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 调用存储过程
     * @param deptNo
     * @return
     */
    @ResponseBody
    @RequestMapping("/proList")
    public Object proList(Map map,Integer deptNo){
        map.put("deptNo",deptNo);
        return empService.getListByPro(map);
    }
}
