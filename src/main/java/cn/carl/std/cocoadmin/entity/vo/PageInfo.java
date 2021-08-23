package cn.carl.std.cocoadmin.entity.vo;

import cn.carl.std.cocoadmin.util.EntityTransformUtil;
import lombok.Data;
import org.hibernate.query.internal.NativeQueryImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.support.PageableExecutionUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author zhangtao
 * @Title: PageInfo
 * @Package: cn.carl.std.cocoadmin.entity.vo
 * @Description: 分页对象 （参考JqGrid插件）
 * @date 3/14/21 8:37 PM
 */

@Data
public class PageInfo<M> {
    //当前页码
    private int page;
    //页面大小
    private int pageSize;
    //排序字段
    private String sidx;
    //排序方式
    private String sord;
    //分页结果
    private List<M> rows;
    //总记录数
    private int records;
    //总页数
    private int total;

    /**
     * 获取统一分页结果
     * @param page
     * @param entityModelClass
     * @param <M>
     * @return
     */
    public static <M> PageInfo<M> of(Page page, Class<M> entityModelClass) {
        int records = (int) page.getTotalElements();
        int pageSize = page.getSize();
        int total = records % pageSize == 0 ? records / pageSize : records / pageSize + 1;

        PageInfo<M> pageInfo = new PageInfo<>();
        pageInfo.setPage(page.getNumber() + 1);//页码
        pageInfo.setPageSize(pageSize);//页面大小
        pageInfo.setRows(EntityTransformUtil.copy(page.getContent(), entityModelClass));//分页结果
        pageInfo.setRecords(records);//总记录数
        pageInfo.setTotal(total);//总页数
        return pageInfo;
    }

    /**
     * 获取JPA的分页对象
     * @param query
     * @param pageRequest
     * @param em
     * @return
     * todo ?
     */
    public static Page getJPAPage(Query query, PageRequest pageRequest, EntityManager em) {
        query.setFirstResult((int) pageRequest.getOffset());
        query.setMaxResults(pageRequest.getPageSize());

        //获取分页结果
        return PageableExecutionUtils.getPage(query.getResultList(), pageRequest, () -> {
            //设置countQuerySQL语句
            Query countQuery = em.createNativeQuery("select count(*) from ( " + ((NativeQueryImpl) query).getQueryString() + " ) count_table");
            //设置countQuerySQL参数
            query.getParameters().forEach(parameter -> countQuery.setParameter(parameter.getName(), query.getParameterValue(parameter.getName())));
            //返回一个总数
            return Long.valueOf(countQuery.getResultList().get(0).toString());
        });
    }
}
