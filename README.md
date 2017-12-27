### Servlet基础
#### 1. 什么是Servlet?
> 问题:先有jsp还是先有Servlet?

答:先有Servlet,因为jsp的前身就是Servlet
Servlet是在服务器端运行的小程序,一个servelet就是一个java类,并且可以通过"请求-响应"编程模式来访问这个驻留在内存里的Servlet程序

#### 2.Tomcat容器等级
Tomcat容器分为四个等级,Servlet的容器管理Context容器,一个Context对应一个web工程

![Tomcat容器](./images/container.png)
#### 3.手工编写第一个servlet
1. 继承HttpServlet

![servlet](./images/servlet.png)

2. 重写doGet()或者doPost()方法
3. 在web.xml中注册Servlet
#### 4.使用IDEA编写servlet
#### 5.servlet的生命周期
#### 6.servlet获取九大内置对象
#### 7.servlet与表单
#### 8.servlet路径跳转
#### 9.project