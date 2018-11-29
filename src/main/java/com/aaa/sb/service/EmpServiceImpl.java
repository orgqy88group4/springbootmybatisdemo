package com.aaa.sb.service;

import com.aaa.sb.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:EmpServiceImpl
 * discription:
 * author:qcm
 * createTime:2018-11-23 11:32
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Map> getListByPro(Map map) {
        //调用dao执行call调用存储过程，出参需要执行完后，放入map
        empDao.getListByPro(map);
//        map.get("empList")是object类型，需强制转位List<Map>
        return (List<Map>)map.get("empList");
    }
}
