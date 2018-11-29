package com.aaa.sb.service;

import java.util.List;
import java.util.Map;

/**
 * className:EmpService
 * discription:
 * author:qcm
 * createTime:2018-11-23 11:32
 */
public interface EmpService {
    /**
     * 根据部门编号查询部门列表（存储过程的调用）
     * @param
     * @return
     */
    List<Map> getListByPro(Map map);
}
