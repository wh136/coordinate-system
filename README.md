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


# java国际化
https://blog.csdn.net/zhoudaxia/article/details/37536195
<资源名>_<语言代码>_<国家/地区代码>.properties
resource_zh_CN.properties包含中文字符并且以UTF-8进行编码，假设将该资源文件放到d:\目录下，通过下面的命令就可以将其转换为Unicode代码的形式：
D:\>native2ascii -encoding utf-8 d:\resource_zh_CN.properties
D:\resource_zh_CN_1.properties

另一种方法
1. settings-->Encoding 都设置为utf-8
并勾选 Properties Files encoding 为utf-8
右键在所需要产生国际化文件的目录下new->Resource bundle 选择zh_CN和local(已经设置utf-8)输入LocalStrings

# 代码模板
https://www.programcreek.com/


# java并发 java.util.concurrent

1. 任务类 实现Runnable接口

2. 线程类 构造Thread类 （将任务对象提交给Thread构造器，生成线程对象。并调用线程对象的start方法为该线程执行初始化操作，然后自动调用run方法在线程中启动该任务。）

3. 执行器 Executor,用于管理Thread对象，简化并发编程。
   用于代替显式的创建线程对象--> new Thread(new LiftOff())
   
   newCachedThreadPool 缓存式线程池

# redis
建议在windows10安装docker然后部署redis
docker pull redis
docker run -itd -p 6379:6379 --name=redis redis:latest
docker exec -it redis-test /bin/bash

# 热部署
https://www.cnblogs.com/chenkeyu/p/10296588.html
Idea设置
settings-->Build Execution Deployment --> Compiler
勾选 Build project automatically
下载livereload插件，将其安装到chrome扩展程序中，并选中允许访问文件网址。

7.测试
(1)修改类 应用会重启
(2)修改配置文件 应用会重启
(3)修改静态文件（html、css等），应用不会重启，但是会调用livereload，浏览器会自动刷新，显示最新的修改内容。

# 与前端调试，使用本机电脑服务，可以让前端同事用fiddler设置代理，在局域网内开发。


