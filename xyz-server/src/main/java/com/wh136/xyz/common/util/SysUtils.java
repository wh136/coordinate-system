package com.wh136.xyz.common.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SysUtils {

    /**
     * 模拟耗时操作
    * @param ms 单位毫秒 long
    * */
    public static void workTime(long ms) {
        long currentTimeBegin = System.currentTimeMillis();
        log.info("[workTime] Work begin");
        final long l = System.currentTimeMillis();
        while (System.currentTimeMillis() <= l + ms) {
        }
        long currentTimeEnd = System.currentTimeMillis();
        log.info("[workTime] Work end. cost time {} second",(currentTimeEnd-currentTimeBegin)/1000);
    }

}
