package com.wh136.xyz.common.ssh;


import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

/**
 * SSH工具类
 * */

@Slf4j
@Component
public class SSHTools {

    private static final int DEFAULT_BUFFER_SIZE = 1024;

    private static final int DEFAULT_READ_INTERVAL = 200;

    public static String execute(SSHHost sshHost, String cmd) throws Exception{
        if (StringUtils.isEmpty(sshHost.getPassword())) {
//            return null;
        }
        return null;
    }

    public static String executeWithoutPassword(SSHHost sshHost,String cmd) throws Exception{
        Session session = null;
        try {
            session = createSessionWithoutPassword(sshHost);
//            return null;
        } catch (Exception e) {
            log.info("e");
        }
        return null;
    }


    /**
     * 获取一个和远程服务器的ssh会话连接（免密）
     * @param sshHost 远程服务器信息
     * @return null 如果连接不正确
     * @throws JSchException 无法连接
     */
    public static Session createSessionWithoutPassword(SSHHost sshHost) throws JSchException{
        if (!((sshHost != null) && !(StringUtils.isEmpty(sshHost.getIp()))
                && !(StringUtils.isEmpty(sshHost.getUser())) && (sshHost.getPort() > 0))) {
            return null;
        }
        String hostIp = sshHost.getIp();
        String user = sshHost.getUser();
        int port = sshHost.getPort();

        JSch jSch = new JSch();
        jSch.addIdentity("/root/.ssh/id_rsa");
        Session session = jSch.getSession(user, hostIp, port);
        session.setConfig("StrictHostKeyCheking", "no");
        session.connect();
        return session;
    }

}
