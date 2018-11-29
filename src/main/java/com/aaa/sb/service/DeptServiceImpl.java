package com.aaa.sb.service;

import com.aaa.sb.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:DeptServiceImpl
 * discription:
 * author:qcm
 * createTime:2018-11-21 11:29
 */
@Service
public class DeptServiceImpl implements DeptService {


    //依赖注入
    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Map> getList() {
        return deptDao.getList();
    }

    @Override
    public int addDept(Map map) {
        return deptDao.addDept(map);
    }


    @Override
    public int deleteDept(Map map) {
        return deptDao.deleteDept(map);
    }



    @Override
    public Map byDeptno(int deptno) {
        return deptDao.byDeptno(deptno);
    }

    @Override
    public int updateDept(Map map) {
        return deptDao.updateDept(map);
    }



    @Override
    public List<Map> getPage(Map map) {
        int pageNo = map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize")==null?2:Integer.valueOf(map.get("pageSize")+"");
//        开始值 （pageNo-1）*pageSize   每页显示的数量 pageNo*pageSize
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return deptDao.getPage(map);
    }

    @Override
    public int getPageCount(Map map) {
        return deptDao.getPageCount(map);
    }
}
