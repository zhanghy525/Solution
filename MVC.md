
###MVC框架
> 将数据存取、显示、业务逻辑分离的软件架构,各模块各司其职,**便于维护和扩展**

```
|-Model--------->模型层,**存和数据**-->Dao层
|-View---------->视图层,**显示**-->jsp,html
|-Controller---->控制层,**业务逻辑**-->servlet
```
controller->service->dao是目前常规的调用逻辑
> **框架真正的目的:便于维护扩展,业务逻辑清晰**

#Struts
Struts是一款免费的、开源的 容易搭建的MVC架构的具体是实现框架。支持**约定优于配置**【很多配置项都不需要写，有默认值】，**支持扩展插件**，**支持AJAX和json**

###Action工作模式:
> 研究一项新的技术,首先应该实现的是参数直接的传递,然后比较看看它能代替之前哪方面的功能(它像什么,它能更好的干啥)
1. 参数传递


2. 组织结构
package:包,一般struts用包组织代码,一个功能模块一般在一个包~~也是为了方便我们查找吧~~
```md
-packeage:name,extends(必须继承struts-default)
|-constrant:
|-action:name,class
  |-result:type,
  |-filter:
...
```
***

### Action与Servlet对比★★★
> ~~Action和Servlet都是为了处理客户端请求,返回服务器响应的方式,Action有点类似接管容器的感觉(从web.xml加载时,同时加载到服务器,无缝衔接容器的请求,打包成struts模式的数据,然后它把它自己当成一个容器,从它自己的struts.xml(web.xml)中读取自己的Action处理产生响应,还给容器,容器返回响应)~~
1.Action类每次请求都会构造对象，Servlet 是单实例的。
2.Action类是一个普通类，Servlet则必须实现Servlet标准（javax.servlet.Servlet,javax.servlet.http.HttpServlet）
3.Action不与容器耦合，便于测试，Servlet与容器耦合。
Action底层与Servlet没有关系~！！~~~
== Action建议创建成员变量,Servlet不能创建成员变量 ==

- 优点：业务代码解耦，提高开发效率; 缺点：执行效率偏低，需要使用反射、解析XML等技术手段，结构复杂
- Action每次构造对象,而Servlet是单实例的
- Action不需要实现接口
- Action不与容器耦合,便于测试

Action底层与Servlet没有关系~！！~~~
== Action建议创建成员变量,Servlet不能创建成员变量 ==

***

- Exec and 思考
> 如果功能实现了,但是有的页面跳转有问题,可能是action和jsp等跳转逻辑发生了问题,例如

==错误的== add.action->add.jsp(填写数据提交)->save.action->add.jsp
==正确的== add.action->add.jsp(填写数据提交)->save.action->**add.action**->add.jsp


8种组合实现MVC框架
- 基础方法
  - Connection + Servlet
  - DBCP + Servlet
  - Connection + struts
  - DBCP + struts

- Servlet + Hibernate
- Servlet + mybatis
- struts + Hibernate
- mybatis+struts
