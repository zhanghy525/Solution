###mapper标签属性说明
- mapper  namespace:和package的功能用法相同,可以包名加类名区分?
  - id :执行器的key值
  - parameterType:参数类型
  - resultType:结果类型
  - resultMap:结果映射
```java
session = SqlSessionFactoryBuilder().build(Resources.getResourceAsReader()).openSession();
session.insert("namespace.addstu",stu);
```
### 表中字段和class字段不一致时,如何处理?
1. 语句用表字段,参数用class字段
```xml
<insert id="addStu" parameterType="stu">
  insert into stu(sname,sage,sbirth)
  values
  (#{name},#{age},#{birth})
</insert>
```
2. **通过Map映射**
~~type是目标类,property是类中属性,column是表中字段,id是此map的代号~~
```xml
<resultMap type="stu" id="rMap_stu">
  <id column="sid" property="id" />
  <result column="sname" property="name" ></result>
  <result column="sage" property="age"></result>
  <result column="sbirth" property="birth"></result>
</resultMap>
<select id="queryStuById" parameterType="int"
resultMap="rMap_stu">
  ...
</select>
```
###主键的处理方案
mapper.xml内置数据了数据类型:string
```xml
<insert id="addS" parameterType="s">
  <!-- order:表示先执行查询id的语句然后添加 -->
  <selectKey keyProperty="id" resultType="string/int"
  order="BEFORE">
     下表中的语句
  </selectKey>
  ...
</insert>
```
先产生id,然后放入数据库,不然id为空无法放入
|       |     int |   String   |
| :-------- | :--------:| :------: |
| mysql    |   select @@last_insert_id as id |  select replace(uuid(),'-','') as id  |
| oracle    |  select etoak_seq.nextval from dual  |  select sys_guid() as id from dual  |
| oracle    |  通过查询最大然后+1  |    |

###参数的传递
通过map传递多个参数:
```java
Map<String,Object> map=new HashMap<>();
map.put("param",param1);
...
```
参数的接收:
```xml
<insert parameterType="map">...${param}...</insert>
```
参数传递中字符串的处理:
### /#和$的区别,以字符a为例
${param} = a;
/#{param} = "a";
> **$更适用字符拼接的方式**
