package com.hx.eplate.trafficdata.query.dao;

import java.util.Map;

/**
 * Created by Administrator on 2017-03-23.
 */
public interface BaseWriteDao {
    /**
     * 保存全部字段
     * @param m
     * @return
     */
    int save(Map m);
    /**
     * 插入
     * @param m
     */
    Integer saveNotNull(Map m);

    /**
     * 根据ID号修改单个实体
     * @param m
     */
    Integer upt(Map m);

    /**
     * 根据ID号删除单个实体
     * @param m
     */
    Integer del(Map m);

}
