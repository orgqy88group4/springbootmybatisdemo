package com.aaa.sb.service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptService
 * discription:
 * author:qcm
 * createTime:2018-11-21 11:28
 */
public interface DeptService {
    /**
     * 部门列表查询
     * @return
     */
    List<Map> getList();

    /**
     * 添加部门信息
     * @param map
     * @return
     */
    int addDept(Map map);

    /**
     * 添加部门信息
     * @param map
     * @return
     */
    int deleteDept(Map map);

    /**
     * 根据deptno查询部门信息
     * @param deptno
     * @return
     */
    Map byDeptno(int deptno);

    /**
     * 修改部门信息
     * @param map
     * @return
     */
    int updateDept(Map map);



    /**
     * 员工分页查询
     * @param map
     * @return
     */
    List<Map> getPage(Map map);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    int getPageCount(Map map);
}
