<%--
  Created by IntelliJ IDEA.
  User: Jgybz
  Date: 2019/12/30
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/error.do"><h2>异常展示</h2></a>
<hr>
<h2>文件上传</h2>
<a href="fileUpload.jsp">文件上传</a>
<hr>
<h2>数组数据接收</h2>
<a href="ajax.jsp">Ajax请求</a>
<hr>
<h2>数组数据接收</h2>
<form action="array.do" method="get">
    爱好: <input type="checkbox" name="hobby" value="1">抽烟
    <input type="checkbox" name="hobby" value="2">喝酒
    <input type="checkbox" name="hobby" value="3">烫头
    <input type="checkbox" name="hobby" value="4">按摩
    <input type="submit">
</form>
<hr>
<h2>日期转换器</h2>
<form action="/date.do">
    姓名<input type="text" name="username"><br>
    密码<input type="password" name="password"><br>
    性别<input type="text" name="gender"><br>
    生日<input type="text" name="birthday"><br>
    <input type="submit">
</form>
<hr>
<a href="demo3.do">返回值String，逻辑视图，</a>
<hr>
<a href="demo4.do">返回值String，物理视图，请求转发</a>
<hr>
<a href="demo5.do">返回值String，物理视图，重定向</a>
<hr>
<a href="demo6.do">返回值void，物理视图，请求转发</a>
<hr>
<a href="demo7.do">返回值void，物理视图，重定向</a>
<hr>
<a href="demo8.do">返回值ModelAndView 物理视图，请求转发</a>
<hr>
<a href="demo9.do">返回值ModelAndView 物理视图，重定向</a>

</body>
</html>
