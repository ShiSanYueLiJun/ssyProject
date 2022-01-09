分布式架构
注意：org.springframework.cloud、com.alibaba.cloud同一系列的版本一定要统一版本，不然出现版本不兼容问题
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.6.2</version>
    </parent>
遇见问题应用启动卡主,是因为包的冲突导致,推荐方案一
    解决方案一 SpringBoot系列的版本更换
        <parent>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
            <version>2.2.5.RELEASE</version>
        </parent>
    解决方案一 保持2.6.2的版本不变添加依赖
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.3.14</version>
        </dependency>
 
 
 
 feign.RetryableException: Read timed out executing POST http://points-service/points/AddPoints
 原因：Feign客户端调用服务端的时候连接超时   
 由于Feign底层使用Ribbon调用请求，ribbon的默认超时时间为1s，所以超过1s就报错
 因为开启了hystrix明显可以看到是http请求报错超时，feign的调用分两层，
 ribbon的调用和hystrix的调用，高版本的hystrix默认是关闭的，
 所以在application.yml配置文件中设置ribbon即可     
feign:
  hystrix:
    enabled: true
  client:
    config:
      default:
        connect-timeout: 60000 #请求连接的超时时间，默认时间为1秒
        read-timeout: 30000 #请求处理的超时时间
         