# XMU'17 OOAD Module Standard Group

This repo contains Public Releases and Offical Resources from XMU'17 OOAD Module Standard Group

## Roadmap

* 12/7 First Meeting - Short communication and understanding
* 12/8 Second Meeting - Write Service, Dao, Mapper standard interface
* 12/9 Third Meeting - Service,Dao,Mapper draft
* 12/10 Forth Meeting(Online) - Integration and modification
* 12/11 Publish All layers Standard
* 12/12 Redo and discuss
* 12/12 Publish Module Standard 1.0

## Resources

* [Javadoc](doc)
* [工作量分配](工作量划分.txt)

## Other Resources

* [阿里规约](resources/阿里规约.pdf)

## According to Alibaba specification
1. 【强制】类名使用 UpperCamelCase 风格，必须遵从驼峰形式，但以下情形例外：DO / BO /
DTO / VO / AO
正例：MarcoPolo / UserDO / XmlService / TcpUdpDeal / TaPromotion
反例：macroPolo / UserDo / XMLService / TCPUDPDeal / TAPromotion
2. 【强制】对于 Service 和 DAO 类，基于 SOA 的理念，暴露出来的服务一定是接口，内部
的实现类用 Impl 的后缀与接口区别。
正例：CacheServiceImpl 实现 CacheService 接口。
3. 【参考】各层命名规约：  
A) Service/DAO 层方法命名规约  
1） 获取单个对象的方法用 get 做前缀。  
2） 获取多个对象的方法用 list 做前缀。  
3） 获取统计值的方法用 count 做前缀。  
4） 插入的方法用 save/insert 做前缀。  
5） 删除的方法用 remove/delete 做前缀。  
6） 修改的方法用 update 做前缀。  
B) 领域模型命名规约  
1） 数据对象：xxxDO，xxx 即为数据表名。  
2） 数据传输对象：xxxDTO，xxx 为业务领域相关的名称。  
3） 展示对象：xxxVO，xxx 一般为网页名称。    
4） POJO 是 DO/DTO/BO/VO 的统称，禁止命名成 xxxPOJO。  
4. 【参考】分层领域模型规约：  
 DO（Data Object）：与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。  
 DTO（Data Transfer Object）：数据传输对象，Service 或 Manager 向外传输的对象。  
 BO（Business Object）：业务对象。由 Service 层输出的封装业务逻辑的对象。  
 AO（Application Object）：应用对象。在 Web 层与 Service 层之间抽象的复用对象模型，
极为贴近展示层，复用度不高。  
 VO（View Object）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象。  
 Query：数据查询对象，各层接收上层的查询请求。注意超过 2 个参数的查询封装，禁止
使用 Map 类来传输。
