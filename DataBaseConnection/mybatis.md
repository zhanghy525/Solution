- config.xml
```xml
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<settings>
		<seting name="logImpl" value="LOG4J" />
	</settings>
	<typeAliaseses>
		<typeAliases type="com.etoak.po.Student" alias="stu"></typeAliases>
	<typeAliaseses>
	<environments default="mysql">
		<environment id="mysql">
			<transactionManager type="JDBC"></transactionManager>
			<dataSource type="POOLED">
				<property name="driver" value="${et.driver}" />
				<property name="url" value="${et.url}" />
				<property name="username" value="${et.user}" />
				<property name="password" value="${et.pwd}" />
			</dataSource>
		</environment>		
	</environments>
	<mappers>
		<mapper resource="com/etoak/student/po/StuMapper.xml"></mapper>
	</mappers>
</configuration>
```
