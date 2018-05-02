package com.hx.eplate.trafficdata.query.dao.read;

import com.hx.eplate.trafficdata.query.dao.BaseReadDao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017-10-20.
 */
@Mapper
public interface UserInfoReadDao extends BaseReadDao<Map> {
    //继承BaseDao
}
