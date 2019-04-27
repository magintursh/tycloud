# tycloud

### 介绍

    tycloud是一个基于springboot的服务端脚手架。后续集成springcloud各个子项目，转向微服务

###  目标

    1.简化基础业务开发过程，这部分开发任务占一般项目的比较大的任务量，尤其各种单表分页，列表查询的重复sql，
      如果能够做到一定程度的简化，可以大大减少开发人员的工作量，使其专心于核心业务。
      针对简化事宜，目前主要在ORM层下功夫，截止目前，已经略有成效。
      主要表现在：
        a.针对单表查询，不用写sql。列表，分页，都不用写。
        b.dao层的mapper只是一个空的接口，大部分业务不需要在mapper中写任何代码，因为使用了mybatis-plus，所以也不需要mapper的xml文                
          件。
        c.baseService中有大量的泛型方法以供使用，单表单对象增删改查在service层也不需要写代码，
          列表和分页查询也只需要一行代码。
        注：提倡单表查询。只将关系数据库作为数据存储即可，不提倡使用复杂sql解决业务问题，
            可以将复杂查询转化为多个单表查询，然后在代码中组合结果，各个单表查询合理使用
            缓存就可以解决性能问题。完全单表操作，对数据库设计有比较高的要求，慎重设计。
            目前已经有多个项目只使用单表操作，表现良好。除非以后有复杂报表可能需要些一些sql。
            其实报表的场景也可以简化为单表查询，后续文档继续探讨。
    2.降低学习成本。新人快速上手，基础知识过关的新人，可以快速进入业务开发状态。
    3.常用组件集成。集成业内常用的各种组件，redis，mq，事件，mongodb等等
    4.通用业务模型的实现。开箱即用的业务模型，可以大大的缩减项目开发周期。计划实现的通用业务模型有
      订单系统，虚拟账户系统，支付网关，动态表单，报表系统，通用预约系统，优惠策略定制，
      基础数据(验证码，字典，内部消息，地理位置信息，通用文件信息存储，操作记录与计数，)
    5.集成常用第三方系统。短信（阿里大鱼），存储（七牛，阿里OSS），支付（微信公众平台，支付宝）
    6.基于springboot，springcloud支持微服务，优化调用过程，将本身就开箱即用的springcloud子项目
      集成进来，根据情况选择使用。协助业务拆分和扩展。
    7.使用vue-element-admin实现通用后台管理，动态表单web界面，以及别的通用业务模型的web端。
    8.大家都在造轮子，我也来应景。希望能造出稍微圆一点的轮子，能为大家所喜欢。
    
   ###  技术栈
     
     1. SpringBoot 2.0.7.RELEASE
     2. MyBatis-Plus 2.0.5
     3. mybatis-spring-boot-starter 1.2.0
     4. SpringCloud Finchley.SR2
     5. Kaptcha 2.3.2
     6. jackson-databind 2.9.7
     7. springfox-swagger2 2.2.2
     8. HikariCP 2.7.9
     
   ###  项目结构
   
  ~~~
tycloud
   
   	tycloud-core-------------------------核心包，一般情况下实例项目都会引用到
        tycloud-core-auth-------------------------用户认证，session共享
        tycloud-core-rdbms------------------------集成mybatis，mybatisplus，简化orm和封装servic通用操作
        tycloud-core-restful----------------------对restful风格的接口封装，集成接口文档，统一异常处理，请求拦截处理，返回数据封装，上下文封装
        tycloud-core-foundation-------------------常用工具类库，线程内上下文封装；Bean、File,列表转树结构，加密解密等等。。。。。
   		
   	tycloud-component--------------------组件
   	    tycloud-component-amqp--------------------对spring的amqp简单集成
   	    tycloud-component-cache-------------------缓存，对redis的进一步实现和封装，地理位置，管道，zset实现分页查询，分布式锁
   	    tycloud-component-event-------------------利用spring的事件机制实现基于rest接口的事件处理机制
   	    tycloud-component-opendata----------------集成常用第三方开放接口，七牛，阿里大鱼，腾讯im，极光推送
   	    tycloud-component-notification------------消息通知，目前就只有短信的实现，（后期计划重构或者取消此模块）
   	    
   	tycloud-module-----------------------通用业务模型，针对特定业务场景进行封装实现（待进一步封装后开源出来）
       	    tycloud-module-account------------虚拟账户系统（待进一步封装后开源出来）
       	    tycloud-module-order--------------通用订单系统（待进一步封装后开源出来）
       	    tycloud-module-trade--------------简单支付渠道实现，支付宝，微信。。。。（待进一步封装后开源出来）
       	    
   	tycloud-api-------------------------基础业务接口实现
   	    tycloud-api-privilege---------------------用户登录认证，权限管理 
   	    tycloud-api-systemctl---------------------基础数据的API接口
   		
   	tycloud-server----------------------平台级服务（还未完成，待进一步开发。）
   	    tycloud-server-notification---------------通知中心，主要用于处理mq消息
   	    tycloud-server-gateway--------------------服务网关，实现的springcloud-gateway
   	    tycloud-server-config---------------------配置中心，集成springcloud-config
   ~~~

   目录约定：
   
   	示例：
   	tycloud-api-privilege----------------以下目录为项目约定目录结构
      	    org.tycloud.api.privilege.
      	                            controller-------接口目录 
      	                            face.------------业务层
      	                                model--------vo
      	                                orm.---------数据操作
      	                                    dao------mapper接口目录
      	                                    entity---po目录
      	                                service------业务实现类
   ###  约定
   
   **orm**
   
    1.entity需要继承BaseEntity
        对应的数据表不能缺少通用字段
       
         SEQUENCE_NBR    bigint	20    物理主键
         REC_USER_ID    varchar	32    最后更新者的id
         REC_STATUS    varchar	16     数据状态（这字段计划用于逻辑删除。。但从未这么干过。）
         REC_DATE    datetime        最后更新时间
         
    2.使用了mybatisplus，所以实例项目中不需要引入mapper.xml，baseMapper的方法足够使用。
      除非要进行复杂查询，可自行引入xml文件 
    3.通常情况下dao层的mapper子接口只是一个空接口，除非要自己写sql，或引入了xml，才会在其中写代码。
   
   **service**
    
    1.继承baseService
  ```JAVA
    public class LocationInfoService extends BaseService<LocationInfoModel,LocationInfo,LocationInfoMapper> implements IService<LocationInfo> 
    {}
  ````
    2.在service中不提倡引入mapper，因为mapper只有接口，没有实现类，在IDE中会有报错提示，与逼格不符。
      使用baseService提供的泛型方法足够业务开发。
    3.service中的方法不要重载,因为会只根据方法名通过反射获取方法实例。
    4.service层只有实现类，抛弃了以前接口，觉得麻烦。
    5.单表单对象的操作可以不需要在service中写方法，泛型方法足够用，
      分页查询和列表查询也只需要一行代码，示例如下：
-
      分页：
```java
        public Page<DictionarieModel> queryDictPage(Page page, String agencyCode ,
                                                       String buType,
                                                       String dictAlias,
                                                       @Condition(Operator.like) String dictName,
                                                       String dictCode) throws Exception
            {
                return this.queryForPage(page,null,false,agencyCode,buType,dictAlias,dictName,dictCode);
            }
```
          作为查询条件的参数名称需要和对应model中的属性名称一致。
          传入baseService.queryForPage中的params参数列表需要和前置方法(queryDictPage)的参数顺序一致，
          底层会自动解析前置方法参数名称并对值判空，然后转换为数据库字段名，用于构建条件组装器。
          注解@Condition用于定义条件操作符，已实现的条件操作符详见Operator，所有查询条件的逻辑关系都是与关系
          目前还没打算实现或关系。         
-
      列表：（参数约定与分页方法相同）
```java
      public List<DictionarieModel> queryDictList(String agencyCode ,
                                                     String buType,
                                                     String dictAlias,
                                                      @Condition(Operator.like)String dictName,
                                                     String dictCode) throws Exception
          {
              return this.queryForList(null,false,agencyCode,buType,dictAlias,dictName,dictCode);
          }
```


   **controller**
   
    1.统一返回值，所有接口统一使用ResponseModel封装返回值。
    2.自定义注解@TycloudOperation用来定义接口的访问级别ApiLevel，鉴权控制needAuth
    3.
    
    
   **关于缓存**
    
    1.对象缓存
        。。。
    2.列表缓存
    3.缓存刷新和删除
    4.特定业务场景的缓存方案
   
   **代码生成器的使用**
   
    1.使用mybatisplus提供的代码生成器，详见示例项目。
   
   
   ###  最佳实践
   
    1.将tycloud-core和tycloud-component中的组件包打包发布到maven私服nexus中统一管理，
      然后各个实例项目引用后进行业务项目的开发。
   
   ###  后续计划
   
    1.完善基础模块
    2.集成spingcloud配置中心，接口网关，注册中心
    3.完善通用业务模型
    4.集成web端
    
   ###  后记
   
    多年开发生涯，使用过很多优秀的开源软件，所谓站在巨人的肩膀上，也就是这样了，深受其益。
    然后有了开源自己代码的想法，觉得能拿得出手的也就是这个框架了，代码算不上规范，设计算不上优秀。
    但其中也是包含了鄙人的些许想法和业务积累，应该可以为需要的人提供一个参考，或者能提高生产效率就更好了。
    心态最重要。还希望过路大神不吝赐教，有什么想法和建议可以发出来，一起讨论。
    
   ###  鸣谢
   
    1.
   
   
   ### 关于单表和多表查询的讨论
   
    目前几个项目全部单表查询，数据库设计好，做好缓存，为了以后业务拆分和转向微服务做准备。
    到现在还没出现啥问题。这里所说的是提倡单表，而并不排斥多表查询。
    这里在引用网上的一段讨论：
    [关于单表和多表查询的讨论](https://cloud.tencent.com/info/3d45e7d699c5800e5a7b083a6eb65724.html')
    1. 从逻辑架构分层原则来看
     关联关系代表了业务规则/逻辑，毫无约束大量使用关联查询，就是把大量的业务规则和逻辑放在数据库来执行了，数据库消耗cpu、内存、io等资源进行关联操作，实际上是在做应用该做的事情。
    
    
    2. 从资源利用率方面看
     大部分场景下，并不是所有关联查询的结果都被有效使用了。例如后台管理的列表界面，通常都会分页显示，关联查询的结果集，只有当前页的数据被使用，其他都是无用的，但数据库需要消耗额外资源得到全部结果集，再从中得到当前页数据。
    
    
    3. 从架构的伸缩性方面看
     大量的关联查询会导致集中式的数据库架构很难向分布式架构转换，伸缩性方面的优化难度高。
   
    优缺点：
    
    关联查询方便快速，开发效率比较好，如果系统、数据库经过一些垂直优化手段完全能够满足性能要求是可以使用的，例如中小企业的内部管理系统等。
    
    不使用关联查询在架构层面有很多优点，但对系统分析和设计、开发能力要求高。一般在互联网行业等用户数较多的情况下最好重视这方面。
    
    理论上不存在什么复杂场景，如果不使用数据库的关联查询就无法满足需求的。巨无霸的ERP系统SAP，基本整个系统功能都是用单表查询实现的