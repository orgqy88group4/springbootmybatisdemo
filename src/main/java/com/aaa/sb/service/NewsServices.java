package com.aaa.sb.service;




import java.util.List;
import java.util.Map;

/**
 * className:NewsServices
 * discription:
 * author:qcm
 * createTime:2018-11-22 11:05
 */
public interface NewsServices {
    /**
     * 获取新闻列表
     * @return
     */
    List<Map> getList();

    /**
     * 新闻添加
     * @param map
     * @return
     */
    int add(Map map);


    /**
     * 根据新闻newsID删除新闻
     * @param map
     * @return
     */
    int delete(Map map);

    /**
     * 根据新闻newID来查询信息
     * @param newId
     * @return
     */
    Map byNewsId(int newId);

    /**
     * 修改新闻信息
     * @param map
     * @return
     */
    int updateNews(Map map);


    /**
     * 新闻分页查询
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


    /**
     * 获取所有新闻类型
     * @return
     */
    List<Map> getType();
}
