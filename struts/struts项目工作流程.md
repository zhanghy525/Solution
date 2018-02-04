>服务器启动:构造strutsPreparedAndExecuteFilter的对象，并且初始化，
在初始化时读取struts的配置文件。没问题，等待客户端请求
请求到达:根据请求的名字到struts.xml中寻找指定的action的name,根据名字找到对应的
class类，创建该类的对象，然后使用指定的方法处理【默认是execute方法处理】，处理完毕之后，根据方法
返回值到《result》中寻找对应的跳转地址，跳转到指定地址。


jsp/ajax -> struts.xml`<action name="m_.action" class="A" method="m">` -> A.class.m() -> struts.xml`<result name="m_" type=""></result>` -> jsp/action/ajax.success
```
A.class.m()
|__service.m()
    |__session.mapper(StuentMapper.class[提供抽象方法])
        |__mapper.xml[提供对应抽象方法的执行器]
        |__<mapper namespace="com.etoak.dao.StuentMapper">
```
**mapper的namespace和接口要对应.接口的抽象方法和Mapper.xml的执行器的name要对应.** 另外sql和po实体类的属性要对应.
如果字段不相符,那么
```
  <resultMap type="stu" id="rMap_stu">
		<id column="id" property="sid" />
		<result column="name" property="sname"></result>
		<result column="email" property="semail"></result>
	</resultMap>
```
如果作为需要返回时,设置为resultMap
```
<select id="getSome" parameterType="map" resultMap="rMap_stu">
...
</select>
```


> 参数传递是每次把新技术加到老项目的关键

~~两种模型驱动 实际就是个get和setter的操作~~
