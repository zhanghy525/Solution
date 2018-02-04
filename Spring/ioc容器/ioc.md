> xml规范的两种标准
- dtd      类型  string
- schema   类型  string int datetime

# ioc
@(iJava)[spring framework]


为了实现`Object object = new Object();`的效果
w3c制订了ioc容器配置文件的schema标准
> ~~就是创建一个工厂对象,其中的属性都是官方制定的~~
其中:
xmlns:xsd="http://www.w3.org/2001/XMLSchema"
class  class 类名
targetNamespace="http://www.springframework.org/schema/beans"
类名        
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
new
xsi:schemaLocation="http://www.springframework.org/schema/beans
http://www.springframework.org/schema/beans/spring-beans-4.0.xsd"
对象  Object()
xmlns="http://www.springframework.org/schema/beans"
Object object =

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans-4.0.xsd">

</beans>
```
###注入方式:
- bean元素
  - class属性 表示实例对象 ~~相当于标识符,引用~~
  - id属性 别名,随便起名 **但是要唯一**

1. setter注入★★★★★
- setter注入方式使用元素property
name属性表示定义是类中字段属性，在底层代码中实现反射setId setName setAge
value属性注入值（赋值）
```xml
  <bean id="stu" class="com.etoak.bean.Student">
    <property name="id" value="1"></property>
    <property name="name" value="易途"></property>
    <property name="age" value="10"></property>
  </bean>
```
2. 构造方法注入★★
``public Student(String id, String name, Integer age)``
- **需要有全参构造方法** ~~使用的是构造方法的变量名~~ ==在形参和属性名不同的时侯是有区别的==
```xml
  <bean id="stuC" class="com.etoak.bean.Student">
    <constructor-arg name="id" value="et1710"></constructor-arg>
    <constructor-arg name="name" value="etoak"></constructor-arg>
    <constructor-arg name="age" value="10"></constructor-arg>
  </bean>
```
- 构造方法注入 下标索引  下标从0开始
```xml
  <bean id="stuI" class="com.etoak.bean.Student">
    <constructor-arg index="0" value="et"></constructor-arg>
    <constructor-arg index="1" value="易途"></constructor-arg>
    <constructor-arg index="2" value="10"></constructor-arg>
  </bean>
```
3. 普通方法注入/工厂方法注入
- 使用lookup-method元素
  - name属性表示调用的方法名称
  - bean属性表示引入配置文件当中某个bean元素属性id值
```xml
  <bean id="methodStu" class="com.etoak.bean.ClassRoom">
    <lookup-method name="getStu" bean="stu" />
  </bean>
```
需要一个提供方法的类,需要有一个返回class属性的getStu的方法
```java
public class ClassRoom {
	public Student getStu(){
		return null;
	}
}
```
###调用ioc容器,生成实体类
```java
ClassPathXmlApplicationContext ac =
		new ClassPathXmlApplicationContext("applicationContext.xml");
//启动容器
ac.start();
//获取容器对象Student别名为stu
Student stu = (Student)ac.getBean("stu");
```

##类的五种作用域
```xml
<bean id="stuPrototype"
	    class="com.etoak.bean.Student"
	    scope="prototype"/>
<bean id="stuPrototype"
      class="com.etoak.bean.Student"
      scope="prototype">
</bean>
```
1. singleton ★★★
**单例**,也是默认值
始终保持一个对象,就new一次
**容器启动时创建对象**
2. prototype ★★★
非单例,每次都会创建一个新对象
==**容器启动时不会创建对象 调用对象时创建对象**==       

//基于http的
3. request  非单例
每次都会创建一个新对象
4. session  单例  **浏览器关闭session消亡**
始终保持一个对象,就new一次    -> ~~相当于4范围的Session~~
5. global session 单例  服务器
始终保持一个对象,就new一次 -> ~~相当于4范围的application,服务器开机只存在一份~~
