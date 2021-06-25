package com.wh136.xyz.service.demo;


import com.wh136.xyz.dao.BookRepository;
import com.wh136.xyz.entity.Book;
import com.wh136.xyz.mapper.BookMapper;
import com.wh136.xyz.mapper.po.BookPo;
import com.wh136.xyz.mapper.po.CleanUserAclPolicyPO;
import com.wh136.xyz.mapper.po.SecurityGroupDelReqDto;
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
    @org.springframework.transaction.annotation.Transactional(rollbackFor = Exception.class)
    public void deleteSlbSecurityPolicy() {
        String userId = "";
        List<CleanUserAclPolicyPO> cleanUserAclPolicyPOS = bookMapper.queryByUserId(userId);
        List<String> aclPolicyIds = new ArrayList<>();
        cleanUserAclPolicyPOS.forEach(cleanUserAclPolicyPO -> {
            String aclId = cleanUserAclPolicyPO.getAclPolicyId();
            aclPolicyIds.add(aclId);
        });
        bookMapper.deleteByUserIdAndPolicyIds(userId, aclPolicyIds);
        log.info("[deleteSlbSecurityPolicy] delte acl policy ids:{}", aclPolicyIds);
    }


}
