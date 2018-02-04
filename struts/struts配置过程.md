- 搭建流程
1. 添加JAR包
2. web.xml添加过滤器
3. 添加核心配置文件struts.xml

- web.xml改动
```xml
	<filter>
        <filter-name>struts2</filter-name>
        <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
    </filter>

    <filter-mapping>
        <filter-name>struts2</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```

- 基本的struts.xml
```xml
<struts>
	<package name="etoak" extends="struts-default">
		<action name="hello" class="com.etoak.action.HelloAction">
			<!-- type: dispatcher chain redirect redirectAction stream json -->
			<result>success.jsp</result>
		</action>
	</package>
	<include file="struts-download.xml"></include>
</struts>
```
<package>:表示包，一般struts使用包来组织代码，一个功能模块一般在一个包里。
	name:包名字 不重复
	extends:表示继承，必须继承struts-default默认包，很多struts的功能都被封装在
	默认包中，必须继承。
<action>:表示请求。
	name:请求名字【不带后缀】
	class：请求的处理类
<result>:表示结果
		name:返回的字符串 默认是success,一般与Action类中处理方法的返回值一致
		type:
			dispatcher:默认的 以请求转发的方式跳转到其他页面。
			redirect:以重定向的方式跳转到其他页面。
			chain:表示以请求转发的方式跳转到其他action
			redirectAction:表示以重定向的方式跳转到其他Action
资源文件:
struts-default.xml
	该文件定义了Struts默认的包，struts-default包，定义了常用的result
	还定义了一堆的拦截器 和拦截器栈
default.properties:
	struts的默认行为：默认拦截后缀 默认的文件上传的大小。。
	该文件中的属性都可以通过在struts.xml中添加<constant>来修改


- 优雅的struts.xml结构
```
struts.xml
|
|--include -> struts-model1.xml
|
|--include -> struts-model2.xml
```
- 优雅的struts-model.xml
> 以method_emp描述action,以method_success区分不同的result,让拦截器寻找合适的result
```xml
<action name="*_emp" class="com.etoak.action.EmpAction">
	...
	<result name="addemp_success"></result>
	<result name="query_success"></result>
	...
</action>
...
<action name="queryMgrAndDeptAndJob_emp" class="com.etoak.action.EmpAction"
    	method="queryMgrAndDeptAndJob">
    <result name="query_success">addemp.jsp</result>
</action>
<action name="addemp_emp" class="com.etoak.action.EmpAction"
    	method="addemp">
    <result name="addemp_success" type="redirectAction">queryMgrAndDeptAndJob_emp</result>
</action>
...
```
