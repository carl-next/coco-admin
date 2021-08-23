package cn.carl.std.cocoadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 通用Repository
 *
 * @param <E> 实体类
 * @param <T> id主键类型
 */
/**
所有对象类接口都会继承此接口 为了告诉JPA不要创建对应接口的bean对象
就在类上加注解@NoRepositoryBean
这样spring容器中就不会有BaseReposytory接口的bean对象 告诉JPA不要创建对应接口的bean对象*/
@NoRepositoryBean //因为没有具体表映射 作为parent只用作继承
public interface CommonRepository<E,T> extends JpaRepository<E,T>, JpaSpecificationExecutor<E> {
}
