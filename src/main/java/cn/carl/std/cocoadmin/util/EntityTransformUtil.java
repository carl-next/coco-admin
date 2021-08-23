package cn.carl.std.cocoadmin.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanMap;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangtao
 * @Title: EntityTransformUtil
 * @Package: cn.carl.std.cocoadmin.util
 * @Description: 实体转换工具【如：vo->pojo】
 * @date 3/15/21 11:49 PM
 */
@Slf4j
public class EntityTransformUtil {

    /**
     * 类型转换：实体Vo <->实体  例如：UserVo <-> User
     *
     * @param src        数据源
     * @param targetType 目标类型
     * @param count      层数
     * @param <T>
     * @return
     */
    public static <T> T copy(Object src, Class<T> targetType, Integer count) {
        count--;
        T target = null;
        try {
            //创建一个空目标对象，并获取一个BeanWrapper代理器，用于属性填充，
            //BeanWrapperImpl在内部使用Spring的BeanUtils工具类对Bean进行反射操作，设置属性。
            target = targetType.newInstance();
            BeanWrapper targetBean = new BeanWrapperImpl(target);

            //获取源对象的BeanMap，属性和属性值直接转换为Map的key-value 形式
            BeanMap srcBeanMap = new BeanMap(src);

            for (Object key : srcBeanMap.keySet()) {
                //源对象 属性 name
                String srcPropertyName = (String) key;
                //源对象属性 值
                Object srcPropertyValue = srcBeanMap.get(srcPropertyName);
                //源对象属性类型
                Class srcPropertyType = srcBeanMap.getType(srcPropertyName);

                //目标对象属性类型
                Class targetPropertyType = targetBean.getPropertyType(srcPropertyName);

                //源对象属性值非空判断、目标对象属性类型非空判断，如果为空跳出，继续操作下一个属性
                if ("class".equals(srcPropertyName) || targetPropertyType == null) {
                    continue;
                }
                //类型相等，可直接设置值，比如：String与String 或者 User与User
                if (srcPropertyType == targetPropertyType) {
                    targetBean.setPropertyValue(srcPropertyName, srcPropertyValue);
                } else {//类型不相等
                    //满足条件，跳出递归
                    if(count <= -1){
                        return target;
                    }
                    //如果源复杂对象为null，直接跳过，不需要复制
                    if(srcPropertyValue == null){
                        continue;
                    }
                    //复杂对象 递归
                    targetBean.setPropertyValue(srcPropertyName,EntityTransformUtil.copy(srcPropertyValue,targetPropertyType,count));
                }
            }

        } catch (Exception e) {
            log.error(ErrorUtil.errorInfoToString(e));
        }
        return target;
    }

    /**
     * 默认一层
     * @param src
     * @param tagetType
     * @param <T>
     * @return
     */
    public static <T> T copy(Object src,Class<T> tagetType){
        return EntityTransformUtil.copy(src,tagetType,1);
    }

    /**
     * 类型转换：实体Vo <->实体  例如：List<UserVo> <-> List<User>
     * 支持实体对象属性仅简单属性【一层】
     * @param srcList
     * @param targetType
     * @param <T>
     * @return
     */
    public static <T> List<T> copy(List srcList,Class<T> targetType){
        List<T> targetList=new ArrayList<>();
        for(Object src: srcList){
            targetList.add(EntityTransformUtil.copy(src,targetType));
        }
        return targetList;
    }

    /**
     * 类型转换：Object[]转Vo
     * 当使用自定义SQL查询，查询字段跟实体对应不上时，可以使用Object[]接值
     * em.createNativeQuery(sql.toString())，第二个参数不传时，默认就是用Object[]来接值
     * 因为是Object[]转Vo，是按顺序来取值、设置，所有要求两边的字段、属性顺序要一一对应
     * @param src
     * @param targetType
     * @param <T>
     * @return
     */
    public static <T> T copyByObject(Object[] src, Class<T> targetType){
        T targetVo = null;
        try {
            //遍历Object[]转换为Field[]
            targetVo  = targetType.newInstance();
            Field[] fields = targetType.getDeclaredFields();
            int length = src.length < fields.length ? src.length : fields.length;
            for (int i = 0; i < length; i++) {
                Field field = fields[i];
                Object fieldVal = src[i];
                if (fieldVal instanceof Character || fieldVal instanceof BigDecimal) {
                    fieldVal = String.valueOf(fieldVal);
                }

                field.setAccessible(true);//获取授权
                field.set(targetVo, fieldVal);//赋值
            }
        } catch (InstantiationException | IllegalAccessException e) {
            ErrorUtil.errorInfoToString(e);
        }
        return targetVo;
    }

    /**
     * 类型转换：List<Object[]>转List<Vo>
     * @param srcList
     * @param targetType
     * @param <T>
     * @return
     */
    public static <T> List<T> copyListByObject(List<Object[]> srcList, Class<T> targetType) {
        List<T> newList = new ArrayList<>();
        if (srcList != null) {
            for (Object[] src : srcList) {
                newList.add(EntityTransformUtil.copyByObject(src,targetType));
            }
        }
        return newList;
    }
}
