###数据库链接配置文件
- 通过java代码配置
- 通过xml配置

```java

```
- 通过properties配置
```java
Properties pro = new Properties();
InputStream is = Factory.class.getResourceAsStream("../../../../../db.properties");
pro.load(is);
is.close();
```


###得到数据库链接
```java
//通过Connection
Connection con = DriverManager.getConnection(url,name,pwd);
PreparedStatement pst = con.preparedStatement(sql);
ResultSet rs = pst.executeQuery();
con.close();
//通过DataSource
DataSource ds = new BasicDataSource();
ds.setDirverClassName(String name);ds.setUrl(String s);ds.setPassword(String s);ds.setUsername(String s);
//Connection con = ds.getConnection();//也可以给出Connection
QueryRunner qr = new QueryRunner(DataSource ds);
qr.query(sql,new BeanHandler(Bean.class),params..);//BeanListHandler,MapHandler
//通过struts
Reader reader = Resources.getResourceAsReader("config.xml");
SqlSession session = SqlSessionFactoryBuilder().build(reader);
```
####通过Hibernate获得链接
- 获得链接,开启事务,进行简单的查询
	1. `session.get()`
	2. `session.update()`

	3. `session.save()`
- 书写执行语句
- 复杂查询:选取执行器
	1. `Query query = session.createQuery(String hql)`
	2. `SQLQuery query = session.createSQLQuery(String sql)`
	3. `Criteria cri = session.createCriteria(Class)`
- 提交/回滚事务
- 关闭链接

####通过Mybaties
- 获得链接
`session = SF.getSession();`
- 书写Mapper.xml
	1. 表中字段和
> 如何获得数据库的主键?
默认primary key 无法返回,需要添加支持;
字符串类型?


2. db.properties
```
et.driver=com.mysql.jdbc.Driver
et.url=jdbc:mysql:///etoak
et.user=root
et.pwd=etoak
```

- 调用xml
`session.select(String statement,Object obj);``
- 提交
`session.commit()`
- 关闭
`session.close()`

#遇到过的问题
- xml头文件出现空格
- 生成的json属性名和实体类不相符
- Caused by: java.sql.SQLException: Invalid value for getInt()
**数据库的类型,xml的类型,java实体类,Dao层参数的类型不相符**
- like '%#{name}%'
