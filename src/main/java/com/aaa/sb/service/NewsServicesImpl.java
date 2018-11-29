package com.aaa.sb.service;

import com.aaa.sb.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:NewsServicesImpl
 * discription:
 * author:qcm
 * createTime:2018-11-22 11:06
 */
@Service
public class NewsServicesImpl implements NewsServices {

    @Autowired
    private NewsDao newsDao;


    @Override
    public List<Map> getList() {
        //System.out.println(1/0);
        return newsDao.getList();
    }

    @Override
    public int add(Map map) {
        return newsDao.add(map);
    }


    @Override
    public int delete(Map map) {
        return newsDao.delete(map);
    }


    @Override
    public Map byNewsId(int newId) {
        return newsDao.byNewsId(newId);
    }


    @Override
    public int updateNews(Map map) {
        return newsDao.updateNews(map);
    }

    @Override
    public List<Map> getType() {
        return newsDao.getType();
    }

    @Override
    public List<Map> getPage(Map map) {
        int pageNo = map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize")==null?5:Integer.valueOf(map.get("pageSize")+"");
//        开始值 （pageNo-1）*pageSize   每页显示的数量 pageNo*pageSize
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return newsDao.getPage(map);
    }

    @Override
    public int getPageCount(Map map) {
        return newsDao.getPageCount(map);
    }
}
