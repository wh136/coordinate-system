# coordinate-system
Spring Boot implement of coordinate-system.
This project is for coordinate-system. My dreams about help student learning coordinate system.
### SpringBoot项目目录结构（工程结构）
根目录：com.bajins
1.启动类CsdnApplication.java推荐放在根目录com.bajins包下
2.实体类domain
    jpa项目: com.bajins.domain
    mybatis项目: com.bajins.pojo
3.数据接口访问层(Dao)
    jpa项目: com.bajins.repository
    mybatis项目: com.bajins.mapper
4.数据服务接口层Service推荐：com.bajins.service
5.数据服务实现层Service Implements推荐：com.bajins.service.impl
    使用idea的同学推荐使用com.bajins.serviceImpl目录
6.前端控制器层Controller推荐：com.bajins.controller
7.工具类库utils推荐：com.bajins.utils
8.配置类config推荐：com.bajins.config
9.数据传输对象dto推荐：com.bajins.dto
    数据传输对象Data Transfer Object用于封装多个实体类domain之间的关系，不破坏原有的实体类结构
10.视图包装对象vo推荐：com.bajins.vo
    视图包装对象View Object用于封装客户端请求的数据，防止部分数据泄露如：管理员ID，保证数据安全，不破坏 原有的实体类结构
11.常量接口类constant推荐：com.bajins.constant

二、资源目录结构
根目录：resources
1.项目配置文件：resources/application.yml
2.静态资源目录：resources/static/
    用于存放html、css、js、图片等资源
3.视图模板目录：resources/templates/
    用于存放jsp、thymeleaf等模板文件
4.mybatis项目mybatis映射文件：resources/mapper/
5.mybatis项目mybatis配置文件：resources/mapper/config/
https://blog.csdn.net/qq_39615545/article/details/90172038
### 由数据库自动生成实体类POJOS
### 由实体类映射到数据库
### user role
https://blog.csdn.net/Xincainy/article/details/83789682
### Many to Many 注解
https://blog.csdn.net/flowingflying/article/details/81327886
### Spring boot Jpa 插入数据
https://blog.csdn.net/CREATE_17/article/details/89076131
### 打包
mvn clean package -Dmaven.test.skip=true  



