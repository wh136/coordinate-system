package com.wh136.xyz.common.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadPoolExecutor;


@Slf4j
public class XyzDiscardPolicy extends ThreadPoolExecutor.DiscardPolicy {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        super.rejectedExecution(r, e);
        log.info("[XyzDiscardPolicy] thread pool:{} -- thread:{} was discard silently.",e.toString(),r.toString());
    }
}
