package com.aaa.sb.controller;

import com.aaa.sb.service.DeptService;
import com.aaa.sb.util.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:DeptController
 * discription:
 * author:qcm
 * createTime:2018-11-21 11:32
 */

@RestController   //全部返回json字符串
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;
    //窄化映射请求
//    @ResponseBody//返回json字符串
//    @RequestMapping("/list")
//    public Object list(){
//        System.out.println(deptService.getList());
//        return deptService.getList();
//    }




//    @RequestMapping("/list")
//    //model把数据带到页面   pageNo显示第几页
//    public Object list(Integer pageNo, HttpServletRequest request){
//        //定义每页显示的数量
//        int pageSize=2;
//        Map map = new HashMap();
//        //判断有没有传参，没传参数选择第一页
//        int tPageNo = pageNo==null?1:pageNo;
//        map.put("pageNo",tPageNo);
//        map.put("pageSize",pageSize);
//        String pageString = new PageUtil(tPageNo, pageSize, deptService.getPageCount(map), request).getPageString();
//        return pageString;
//    }



    @RequestMapping("/list2")
    public Object list2(Integer pageNo, Model model,HttpServletRequest request){
        Map map = new HashMap();
        //定义每页显示的数量
        int pageSize=2;
        //判断有没有传参，没传参数选择第一页
        int tPageNo = pageNo==null?1:pageNo;
        map.put("pageNo",tPageNo);
        map.put("pageSize",pageSize);
        List<Map> deptList = deptService.getPage(map);
        String pageString = new PageUtil(tPageNo, pageSize, deptService.getPageCount(map), request).getPageString();
        map.put("pageString",pageString.replace("/dept/list2","/jsp/dept/list.html"));
        deptList.add(map);
        //把数据显示到页面
        return deptList;
    }











    @RequestMapping("/addSaveDept")
//    @RequestParam Map mapParam把页面的值传过来
    public Object addEmp( @RequestParam Map mapParam){
        int i = deptService.addDept(mapParam);
        Map map = new HashMap();
        if (i > 0){
            map.put("msg","添加成功");
        }else {
            map.put("msg","添加失败");
        }
        return map;
    }


    @RequestMapping("/deleteDept")
    public Object deleteEmp(@RequestParam Map mapParam){
        int i = deptService.deleteDept(mapParam);
        if (i > 0){
            mapParam.put("msg","删除成功");
        }else{
            mapParam.put("msg","删除失败");
        }
        return mapParam;
    }



    /**
     * 跳转到更新用户页面
     */
//    @ResponseBody//返回json字符串
    @RequestMapping("/toUpdateDept")
    public Object update(Integer deptno) {
        Map byDeptno = deptService.byDeptno(deptno);
        return byDeptno;
    }

    //    修改部门信息
    @RequestMapping("/updateDept")
    public Object updateEmp(@RequestParam Map mapParam){
//        @RequestParam Map mapParam可以接收页面传来的参数，页面中参数的字段必须要和SQL中的字段名一样
        int i = deptService.updateDept(mapParam);
        if (i > 0){
            mapParam.put("msg","修改成功");
        }else {
            mapParam.put("msg","修改失败");
        }
        return mapParam;
    }
}
