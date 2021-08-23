package cn.carl.std.cocoadmin.service.impl;

import cn.carl.std.cocoadmin.assist.SysSettingAssist;
import cn.carl.std.cocoadmin.entity.pojo.SysSetting;
import cn.carl.std.cocoadmin.entity.vo.Result;
import cn.carl.std.cocoadmin.entity.vo.SysSettingVo;
import cn.carl.std.cocoadmin.repository.SysSettingRepository;
import cn.carl.std.cocoadmin.service.SysSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author zhangtao
 * @Title: SysSettingServiceImpl
 * @Package: cn.carl.std.cocoadmin.service.impl
 * @Description: 系统设置 service
 * @date 3/14/21 10:04 PM
 */
@Service
@Transactional
public class SysSettingServiceImpl extends CommonServiceImpl<SysSettingVo, SysSetting,String> implements SysSettingService {

//    @PersistenceContext
//    private EntityManager em;
//    @Autowired
//    private SysSettingRepository sysSettingRepository;

    /**
     * 保存SysSettingVo
     * @param entityVo
     * @return
     */
    @Override
    public Result<SysSettingVo> save(SysSettingVo entityVo) {
        //调用父类
        Result<SysSettingVo> result = super.save(entityVo);

        //更新系统设置时同步更新公用静态集合sysSettingMap
        SysSettingAssist.setSysSettingMap(result.getData());

        return result;
    }
}
