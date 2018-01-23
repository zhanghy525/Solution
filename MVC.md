
- 基础方法
  - Connection
  - DataSource+QueryRunner

- mybatis + Hibernate + jquery + BootStarp


- mybatis+struts+jquery+BootStarp
jsp/ajax -> struts.xml`<action name="m_.action" class="A" method="m">` -> A.class.m() -> struts.xml`<result name="m_" type=""></result>` -> jsp/action/ajax.success
```
A.class.m()
|__service.m()
    |__session.mapper(StuentMapper.class[提供抽象方法])
        |__mapper.xml[提供对应抽象方法的执行器]
        |__<mapper namespace="com.etoak.dao.StuentMapper">
```
**mapper的namespace和接口要对应.接口的抽象方法和Mapper.xml的执行器的name要对应.**另外sql和po实体类的属性要对应.
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
