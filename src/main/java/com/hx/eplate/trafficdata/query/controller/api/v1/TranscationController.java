package com.hx.eplate.trafficdata.query.controller.api.v1;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wuhaochao on 2017/7/21.
 */

/**
 * 交易
 */
@RequestMapping("/transcation")
@RestController
public class TranscationController {

    /**
     * 获取全部交易信息
     *
     * @return
     * @throws Throwable
     */
    @RequestMapping("/getTransInfo")
    public Object getTranscationInfo() throws Throwable {
        return null;
    }

    /**
     * 分页获取交易信息
     *
     * @param pagesize
     * @return
     * @throws Throwable
     */
    @RequestMapping("/getTransInfo/{pagesize}")
    public Object getTranscationInfoByPage(@PathVariable("pagesize") Integer pagesize) throws Throwable {
        return null;
    }

    /**
     * 通过交易hash获取交易信息
     *
     * @param hash
     * @return
     */
    @RequestMapping("/getTransInfoByHash/{hash}")
    public Object getTranscationInfoByHash(@PathVariable("hash") String hash) {
        return null;
    }
}
