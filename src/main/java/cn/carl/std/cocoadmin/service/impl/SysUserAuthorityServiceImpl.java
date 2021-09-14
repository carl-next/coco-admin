package cn.carl.std.cocoadmin.service.impl;

import cn.carl.std.cocoadmin.entity.pojo.UserAuthority;
import cn.carl.std.cocoadmin.entity.vo.PageInfo;
import cn.carl.std.cocoadmin.entity.vo.Result;
import cn.carl.std.cocoadmin.entity.vo.SysUserAuthorityVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangtao
 * @Title:
 * @Package: cn.carl.std.cocoadmin.service.impl
 * @Description:
 * @date 9/14/21 10:00 PM
 */
@Service
public class SysUserAuthorityServiceImpl extends CommonServiceImpl<SysUserAuthorityVo, UserAuthority,String> implements cn.carl.std.cocoadmin.service.SysUserAuthorityService {
    /**
     * 获取分页对象
     *
     * @param vo
     * @return
     */
    @Override
    public Result<PageInfo<SysUserAuthorityVo>> page(SysUserAuthorityVo vo) {
        return null;
    }

    /**
     * 获取多对象
     *
     * @param vo
     * @return
     */
    @Override
    public Result<List<SysUserAuthorityVo>> list(SysUserAuthorityVo vo) {
        return null;
    }

    /**
     * 获取
     *
     * @param id
     * @return
     */
    @Override
    public Result<SysUserAuthorityVo> get(String id) {
        return null;
    }

    /**
     * 保存
     *
     * @param vo
     * @return
     */
    @Override
    public Result<SysUserAuthorityVo> save(SysUserAuthorityVo vo) {
        return null;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public Result<String> delete(String id) {
        return null;
    }

    @Override
    public Result<List<SysUserAuthorityVo>> findByUserId(String userId) {
        return null;
    }

    @Override
    public Result<Boolean> saveAllByUserId(String userId, String authorityIdList) {
        return null;
    }

}
