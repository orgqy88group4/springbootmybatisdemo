package com.aaa.sb.dao;

import java.util.List;
import java.util.Map;

/**
 * className:EmpDao
 * discription:
 * author:qcm
 * createTime:2018-11-23 11:15
 */
public interface EmpDao {
    /**
     * 根据部门编号查询部门列表（存储过程的调用）
     * @param
     * @return
     */
    List<Map> getListByPro(Map map);
}
