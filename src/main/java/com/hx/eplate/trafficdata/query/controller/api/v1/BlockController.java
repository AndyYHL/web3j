package com.hx.eplate.trafficdata.query.controller.api.v1;

/**
 * Created by wuhaochao on 2017/7/26.
 */
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 区块
 */
@RequestMapping("/block")
@RestController
public class BlockController {
    /**
     * 获取最新区块数量
     *
     * @return
     * @throws Throwable
     */
    @RequestMapping("/getBlockNumber")
    public Object getBlockNumber() throws Throwable {
        return null;
    }

    /**
     * 获取区块详情
     *
     * @return
     */
    @RequestMapping("/getBlockInfo/{blockNumber}")
    public Object getBlockInfo(@PathVariable("blockNumber") Integer blockNumber) throws Throwable {
        return null;
    }

    /**
     * 分页获取区块信息
     *
     * @param pagesize
     * @return
     */
    @RequestMapping("/getBlockInfoByPage/{pagesize}")
    public Object getBlockInfoByPage(@PathVariable("pagesize") Integer pagesize) {
        return null;
    }

}
