# ppsweet
---------------------------
## 项目简介
泡泡糖论坛是大学时期的一个传统的MVC模式的论坛项目，最近新学习了springcloud。现使用springcloud对项目进行重构，从传统的MVC项目改造为基于Restful API模块间调用的微服务项目。<br>
## 主要组织结构
> ppsweet
>> ppsweet_article文章模块<br>
>> ppsweet_base基础模块<br>
>> ppsweet_common公共模块，存放utils类，打成jar包<br>
>> ppsweet_config 公共配置模块<br>
>> ppsweet_eureka eureka模块<br>
>> ppsweet_manager 后台网关模块<br>
>> ppsweet_search 页面搜索服务模块<br>
>> ppsweet_sms 短信服务模块<br>
>> ppsweet_user 用户服务模块<br>
>> ppsweet_web 前台网关服务模块<br>
## 技术选型
后端技术<br>

技术 | 说明 | 官网
---------| ---------- | ---------
Spring Boot | 容器+MVC框架 | https://spring.io/projects/spring-boot
Spring Cloud | 系统架构集合 | https://spring.io/projects/spring-cloud
MyBatisGenerator | 数据层代码生成 | http://www.mybatis.org/generator/index.html
Elasticsearch | 搜索引擎 | 	https://github.com/elastic/elasticsearch
RabbitMq | 消息队列 | https://www.rabbitmq.com/
Redis |分布式缓存 | https://redis.io/
Docker |应用容器引擎 |https://www.docker.com/
Redis |分布式缓存|	https://redis.io/
Druid |数据库连接池 |https://github.com/alibaba/druid

## 系统结构图
系统架构图<br>
![ppsweet](https://github.com/hyh180511/ppsweet/document/resource/ppsweey_system_arch1 "架构图")<br>
![ppsweet](https://github.com/hyh180511/ppsweet/document/resource/ppsweey_system_arch2 "架构图")

## 开发环境
技术 | 说明 | 官网
---------| ---------- | ---------
工具 |	版本号	|下载
JDK |	1.8|	https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
Mysql |	5.7 |	https://www.mysql.com/
Redis |	3.2 |	https://redis.io/download
Elasticsearch |	6.2.2 |	https://www.elastic.co/downloads
RabbitMq |	3.4.1 |	http://www.rabbitmq.com/download.html
nginx |	1.10 |	http://nginx.org/en/download.html

## 参考资料
* Spring实战（第4版）
* Spring Boot实战
* Spring Cloud微服务实战
* Spring Cloud与Docker微服务架构实战
* Spring Data实战
* MyBatis从入门到精通
* 深入浅出MySQL
* 循序渐进Linux（第2版）
* Elasticsearch 权威指南
* Elasticsearch 技术解析与实战

## 总结
项目重构总共经历一个半月完成，通过dockerfile打包部署本地虚拟机运行，但是并没有真正经历过大用户量并发访问，无法测试大并发下架构的稳定性，只能模拟大并发下项目的拆分、改造情况。
