package com.wh136.xyz.service.demo;


import com.wh136.xyz.dao.BookRepository;
import com.wh136.xyz.entity.Book;
import com.wh136.xyz.mapper.BookMapper;
import com.wh136.xyz.mapper.po.BookPo;
import com.wh136.xyz.mapper.po.CleanUserAclPolicyPO;
import com.wh136.xyz.mapper.po.SecurityGroupDelReqDto;
import com.wh136.xyz.mapper.po.VpnClientClean;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    private BookMapper bookMapper;

    @Override
    public void nonPublicCallTransaction() {
        protectTransaction();
    }

    @Override
    public void addBook(BookPo bookPo) {
        bookMapper.insertBook(bookPo);
    }

    @Transactional(rollbackOn = Exception.class)
    void protectTransaction() {
        bookRepository.setbookname("book1");
        int error = 1 / 0;
    }

    @Transactional(rollbackOn = Exception.class)
    public void cleanslb(){
        SecurityGroupDelReqDto s = new SecurityGroupDelReqDto();
        s.setInstanceId("sg-defaultadmin");
        s.setTenantId("defaultadmin");
        SecurityGroupDelReqDto s1 = new SecurityGroupDelReqDto();
        s1.setInstanceId("sg-compute01");
        s1.setTenantId("compute");
        List<SecurityGroupDelReqDto> list = new ArrayList<>();
        list.add(s);list.add(s1);
        bookMapper.batchDelSGByIds(list);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteSlbSecurityPolicy() {
        String userId = "66c63797-961c-4783-8808-34464b64df96";
        List<CleanUserAclPolicyPO> cleanUserAclPolicyPOS = bookMapper.queryByUserId(userId);
        List<String> aclPolicyIds = new ArrayList<>();
        cleanUserAclPolicyPOS.forEach(cleanUserAclPolicyPO -> {
            String aclId = cleanUserAclPolicyPO.getAclPolicyId();
            aclPolicyIds.add(aclId);
        });
        bookMapper.deleteByUserIdAndPolicyIds(userId, aclPolicyIds);
        log.info("[deleteSlbSecurityPolicy] delte acl policy ids:{}", aclPolicyIds);
    }

    @Override
    public List<CleanUserAclPolicyPO> querytbl_lbaas_user_acl_policy() {
        String userId = "66c63797-961c-4783-8808-34464b64df96";
        deleteSlbSecurityPolicy();
        return bookMapper.queryByUserId(userId);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
    public List<VpnClientClean> deleteVpnClient() {
        log.info("[deleteVpnClient]");
        String userId = "66c63797-961c-4783-8808-34464b64df96";
        List<VpnClientClean> vpnClientCleans = bookMapper.queryVpnByUserId(userId);
        List<String> instanceIds = new ArrayList<>();
        vpnClientCleans.forEach(vpnClientClean -> {
            String instanceId = vpnClientClean.getInstanceId();
            instanceIds.add(instanceId);
        });
        bookMapper.deleteByUserIdAndInstanceIds(userId, instanceIds);
        log.info("[deleteVpnClient] delete instanceIds:{}", instanceIds);
        return vpnClientCleans;
    }


}
