package cn.carl.std.cocoadmin.entity.vo;

import lombok.Data;

/**
 * @author zhangtao
 * @Title: IpVo
 * @Package: cn.carl.std.cocoadmin.entity.vo
 * @Description: ip信息
 * @date 3/14/21 8:25 PM
 */
@Data
public class IpVo {
    private String ip;//IP地址
    private String pro;//省
    private String proCode;//省编码
    private String city;//城市
    private String cityCode;//城市编码
    private String region;//区
    private String regionCode;//区编码
    private String addr;//详细地址 + 运营商

    //主要用于接参，无实际意义
    private String regionNames;
    private String err;
}
