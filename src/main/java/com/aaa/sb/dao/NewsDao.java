package com.aaa.sb.dao;

import org.apache.ibatis.annotations.*;
import org.mybatis.caches.redis.RedisCache;

import java.util.List;
import java.util.Map;

/**
 * className:NewsDao
 * discription:
 * author:qcm
 * createTime:2018-11-22 10:51
 */
@CacheNamespace(implementation = RedisCache.class)
public interface NewsDao {
    /**
     * 获取新闻列表
     * @return
     */
    @Select(value = "select * from tb_news")
    List<Map> getList();

    /**
     * 新闻添加
     * @param map
     * @return
     */
    @Insert(value = "insert into tb_news values(seq_news_id.nextval,#{title},#{content},#{type},0,#{picPath},#{fileName})")
    int add(Map map);

    /**
     * 根据新闻newsID删除新闻
     * @param map
     * @return
     */
    @Delete(value = "delete from tb_news where newsId = #{newsId}")
    int delete(Map map);

    /**
     * 根据新闻newID来查询信息
     * @param newId
     * @return
     */
    @Select(value = "select * from tb_news where newsId = #{newsId}")
    Map byNewsId(int newId);

    /**
     * 修改新闻信息
     * @param map
     * @return
     */
    @Update(value = "update tb_news set title=#{title},content=#{content},typeid=#{typeid},picpath=#{picPath} where newsId = #{newsId}")
    int updateNews(Map map);




    /**
     * 新闻分页查询
     * @param map
     * @return
     */
    @Select(value = "select * from (select rownum rn,t.* from tb_news t where rownum < #{end}) a where a.rn > #{start}")
    List<Map> getPage(Map map);

    /**
     * 查询分页总数量
     * @param map
     * @return
     */
    @Select(value = "select count(1) as cnt from tb_news")
    int getPageCount(Map map);


    /**
     * 获取所有新闻类型
     * @return
     */
    @Select(value = "select * from tb_newstype")
    List<Map> getType();
}
