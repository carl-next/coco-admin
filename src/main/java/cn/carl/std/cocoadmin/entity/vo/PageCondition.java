package cn.carl.std.cocoadmin.entity.vo;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.thymeleaf.util.StringUtils;

/**
 * @author zhangtao
 * @Title: PageCondition
 * @Package: cn.carl.std.cocoadmin.entity.vo
 * @Description: 分页条件
 * @date 3/14/21 7:28 PM
 */
@Data
public class PageCondition {
    //当前页码
    private int page = 1;
    //每页个数
    private int rows = 10;
    //排序字段
    private String sidx;
    //排序方式
    private String sord;

    /**
     * 获取JPA的分页查询对象
     *
     * @return
     */
    public Pageable getPageable() {
        //处理非法页码 页面数量
        if (page < 1) {
            page = 1;
        }
        if (rows < 1) {
            rows = 10;
        }
        //排序处理
        if (!StringUtils.isEmpty(sidx) && !StringUtils.isEmpty(sord)) {
            Sort.Direction direction = "desc".equals(sord.toLowerCase()) ? Sort.Direction.DESC : Sort.Direction.ASC;
            return PageRequest.of(page - 1, rows, Sort.by(direction, sord));
        }
        return PageRequest.of(page - 1, rows);
    }

}
