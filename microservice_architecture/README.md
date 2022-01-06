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