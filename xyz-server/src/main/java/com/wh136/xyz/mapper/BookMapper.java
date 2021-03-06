package com.wh136.xyz.mapper;

import com.wh136.xyz.mapper.po.BookPo;
import com.wh136.xyz.mapper.po.CleanUserAclPolicyPO;
import com.wh136.xyz.mapper.po.SecurityGroupDelReqDto;
import com.wh136.xyz.mapper.po.VpnClientClean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {

    List<BookPo> insertBook(BookPo bookPo);


    /**
     * 删除安全组
     *
     * @param reqDtos
     */
    void batchDelSGByIds(@Param("reqDtos") List<SecurityGroupDelReqDto> reqDtos);


    List<CleanUserAclPolicyPO> queryByUserId(String userId);

    List<VpnClientClean> queryVpnByUserId(String userId);

    void deleteByUserIdAndPolicyIds(@Param("userId") String userId, @Param("aclPolicyIds") List<String> aclPolicyIds);

    void deleteByUserIdAndInstanceIds(@Param("userId") String userId, @Param("instanceIds") List<String> instanceIds);

}


