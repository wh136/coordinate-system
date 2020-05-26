package com.wh136.xyz.task.shell;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ShelMgrImpl implements ShellMgr, ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("begin execute shell");

    }
}
