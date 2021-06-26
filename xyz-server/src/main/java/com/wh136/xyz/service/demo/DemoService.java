package com.wh136.xyz.service.demo;


import com.wh136.xyz.mapper.po.BookPo;
import com.wh136.xyz.mapper.po.CleanUserAclPolicyPO;
import com.wh136.xyz.mapper.po.VpnClientClean;

import java.util.List;

public interface DemoService {
    void nonPublicCallTransaction();

    void addBook(BookPo bookPo);

    void cleanslb();

    void deleteSlbSecurityPolicy();

    List<CleanUserAclPolicyPO> querytbl_lbaas_user_acl_policy();

    List<VpnClientClean> deleteVpnClient();
}
