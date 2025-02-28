<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans 
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- Quét các component trong package -->
    <context:component-scan base-package="com.springmvc" />

    <!-- Cấu hình ViewResolver để tìm JSP -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/views/" />
        <property name="suffix" value=".jsp" />
    </bean>

    <!-- Cấu hình DataSource kết nối MySQL -->
    <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
        <property name="url" value="jdbc:mysql://localhost:3306/CoffeeLuck" />
        <property name="username" value="root" />
        <property name="password" value="yourpassword" />
    </bean>
</beans>
