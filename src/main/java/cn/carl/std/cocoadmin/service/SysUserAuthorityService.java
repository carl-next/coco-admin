package cn.carl.std.cocoadmin.service;

import cn.carl.std.cocoadmin.entity.pojo.UserAuthority;
import cn.carl.std.cocoadmin.entity.vo.Result;
import cn.carl.std.cocoadmin.entity.vo.SysUserAuthorityVo;

import java.util.List;

public interface SysUserAuthorityService extends CommonService<SysUserAuthorityVo, UserAuthority,String> {
    Result<List<SysUserAuthorityVo>> findByUserId(String userId);
    Result<Boolean> saveAllByUserId(String userId, String authorityIdList);
}
