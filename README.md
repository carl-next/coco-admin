# coco-admin
a commom backstage management system for study

---
# 更新记录
## day 210307
- the project create
- pom.xml update
- application.yml create
- IndexController create
- static/view import

## day 210309
- do nothing

## day 210314
- common service
- some utils
- some constant
- SysSettingAssist

## day 210315
- EntityTransformUtil
- CommomService
---
# 知识点记录
## 注解
- @SpringBootApplication  : 是Sprnig Boot项目的核心注解，目的是开启自动配置
- @RestController和@RequestMapping注解是来自SpringMVC的注解，它们不是SpringBoot的特定部分。
- @RestController：提供实现了REST API，可以服务JSON,XML或者其他。这里是以String的形式渲染出结果。
- @RequestMapping：提供路由信息，”/“路径的HTTP Request都会被映射到xxx方法进行处理。
- @RestController 是返回json数据。
- @Controller是返回页面
- @Configuration+@Bean
  作用：：功能类似于在applicationContext.xml文件手动注册Bean。此时在各级Bean中需要添加setter方法，
- @Slf4j 

    如果不想每次都写
```
private  final Logger logger = LoggerFactory.getLogger(当前类名.class);
```
  可以用注解@Slf4j 来打印日志。\
  使用方式：\
1.你的IDEA上需要安装Lombok插件 \
2.在你的  springboot项目中引入lombok的jar
```
　　　　<dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
 
 ```
3.在任意类上添加注解@Slf4j，并可以在本类中任意方法内打印日志了
- @NoRepositoryBean

    所有对象类接口都会继承此接口 为了告诉JPA不要创建对应接口的bean对象 就在类上加注解@NoRepositoryBean
这样spring容器中就不会有BaseReposytory接口的bean对象
告诉JPA不要创建对应接口的bean对象

- @Data\
    注在类上，提供类的get、set、equals、hashCode、canEqual、toString方法
- @AllArgsConstructor\
 注在类上，提供类的全参构造
- @NoArgsConstructor\
注在类上，提供类的无参构造
- @Setter\
注在属性上，提供 set 方法
- @Getter\
注在属性上，提供 get 方法
- @EqualsAndHashCode\
注在类上，提供对应的 equals 和 hashCode 方法
- JPA之@Entity、@Table、@Column、@Id\
Java Persistence API定义了一种定义，可以将常规的普通Java对象（有时被称作POJO）映射到数据库。
1. @Entity 表明该类 (UserEntity) 为一个实体类，它默认对应数据库中的表名是user_entity。这里也可以写成：
   ```
   　　@Entity(name = "xwj_user")
   ```
   　　或者
   ```
   　　@Entity
   　　@Table(name = "xwj_user", schema = "test")
   ```
   　　查看@Entity注解，发现其只有一个属性name，表示其所对应的数据库中的表名

2. @Table 当实体类与其映射的数据库表名不同名时需要使用 @Table注解说明，该标注与 @Entity 注解并列使用，置于实体类声明语句之前，可写于单独语句行，也可与声明语句同行。\
@Table注解的常用选项是 name，用于指明数据库的表名。\
@Table注解还有两个选项 catalog 和 schema 用于设置表所属的数据库目录或模式，通常为数据库名。
3. @Id注释指定表的主键，它可以有多种生成方式：\
   　　1）TABLE：容器指定用底层的数据表确保唯一；\
   　　2）SEQUENCE：使用数据库德SEQUENCE列莱保证唯一（Oracle数据库通过序列来生成唯一ID）；\
   　　3）IDENTITY：使用数据库的IDENTITY列莱保证唯一；\
   　　4）AUTO：由容器挑选一个合适的方式来保证唯一；\
   　　5）NONE：容器不负责主键的生成，由程序来完成。
- @PersistenceContex\
    这个是JPA中的注解，PersistenceContext，称为持久化上下文，它一般包含有当前事务范围内的，被管理的实体对象(Entity)的数据。每个EntityManager，都会跟一个PersistenceContext相关联。PersistenceContext中存储的是实体对象的数据，而关系数据库中存储的是记录。

## Other

- SpringBoot的ApplicationRunner

    在开发中可能会有这样的情景。需要在容器启动的时候执行一些内容。比如读取配置文件，数据库连接之类的。SpringBoot给我们提供了两个接口来帮助我们实现这种需求。这两个接口分别为CommandLineRunner和ApplicationRunner。他们的执行时机为容器启动完成的时候。
SpringBoot启动加载类ApplicationRunner:有时希望项目在启动的时候加载一些系统参数，就要用到ApplicationRunner,
ApplicationRunner是一个接口，我们需要实现它，并重写run()方法，当项目启动时，run()方法便会自动执行.
 
- Spring Data JPA介绍

  可以理解为JPA规范的再次封装抽象，底层还是使用了Hibernate的JPA技术实现，引用JPQL（Java Persistence Query Language）查询语言，属于Spring整个生态体系的一部分。随着Spring Boot和Spring Cloud在市场上的流行，Spring Data JPA也逐渐进入大家的视野，它们组成有机的整体，使用起来比较方便，加快了开发的效率，使开发者不需要关心和配置更多的东西，完全可以沉浸在Spring的完整生态标准实现下。JPA上手简单，开发效率高，对对象的支持比较好，又有很大的灵活性，市场的认可度越来越高。\
    JPA是Java Persistence API的简称，中文名为Java持久层API，是JDK 5.0注解或XML描述对象－关系表的映射关系，并将运行期的实体对象持久化到数据库中。\
  通俗来讲springdata jpa是对jpa规范的一层封装，hibernate实现了jpa规范。\
  java代码----->springdata jpa ------>jpa规范------>hibernate------>jdbc ----->mysql数据库\
  (我们使用java代码调用springdata jpa的api，springdata jpa封装了jpa规范，并且内部使用的是hibernate实现，hibernate封装了jdbc进行数据库操作。)

- springdata jpa使用Example快速实现动态查询\
    Query by Example (QBE) is a user-friendly querying technique with a simple interface. It allows dynamic query creation and does not require to write queries containing field names. In fact, Query by Example does not require to write queries using store-specific query languages at all.[按例查询（QBE）是一种用户界面友好的查询技术。 它允许动态创建查询，并且不需要编写包含字段名称的查询。 实际上，按示例查询不需要使用特定的数据库的查询语言来编写查询语句。]\
    **Example api的组成**
    1. Probe: 含有对应字段的实例对象。
    2. ExampleMatcher：ExampleMatcher携带有关如何匹配特定字段的详细信息，相当于匹配条件。
    3. Example：由Probe和ExampleMatcher组成，用于查询。\
    4. 通过在使用springdata jpa时可以通过Example来快速的实现动态查询，同时配合Pageable可以实现快速的分页查询功能。
    5. 对于非字符串属性的只能精确匹配，比如想查询在某个时间段内注册的用户信息，就不能通过Example来查询\
    具体见[springdata jpa使用Example快速实现动态查询](https://blog.csdn.net/long476964/article/details/79677526)
- JPA EntityManager\
EntityManager是JPA中用于增删改查的接口，它的作用相当于一座桥梁，连接内存中的java对象和数据库的数据存储。\
[JPA EntityManager详解](https://www.jianshu.com/p/091360c47e6b) 
- spring-boot-starter-security 工作原理\
[spring-boot-starter-security 工作原理](https://blog.csdn.net/weixin_44865916/article/details/113358359) 