###数据库链接配置文件
- 通过java代码配置
- 通过xml配置
- 通过properties配置


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
```
####通过Hibernate获得链接
- 获得链接,开启事务
- 书写执行语句
- 选取执行器
	1. `Query query = session.createQuery(String hql)`
	2. `SQLQuery query = session.createSQLQuery(String sql)`
	3. `Criteria cri = session.createCriteria(Class);`
- 提交/回滚事务
- 关闭链接