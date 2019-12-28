<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>基本数据类型</h2>
<form action="param/demo1.do" method="post">
    用户名: <input type="text" name="username"><br/>
    密码: <input type="text" name="password"><br/>
    年龄: <input type="text" name="age"><br/>
    <input type="submit">
</form>
<hr/>
<h2>对象类型_基本数据类型</h2>
<form action="param/demo2.do" method="get">
    用户名: <input type="text" name="username"><br/>
    年龄: <input type="text" name="age"><br/>
    城市 : <input type="text" name="address.city"><br/>
    街道: <input type="text" name="address.street"><br/>
    <input type="submit">
</form>
<hr/>
<h2>对象类型_List类型</h2>
<form action="param/demo3.do" method="get">
    addressList: <input type="text" name="addressList[0].city"><br/>
    addressList: <input type="text" name="addressList[0].street"><br/>
    addressList: <input type="text" name="addressList[1].city"><br/>
    addressList: <input type="text" name="addressList[1].street"><br/>
    <input type="submit">
</form>
<h2>对象类型_Map类型</h2>
<form action="param/demo4.do" method="get">
    <%--只需要关注 key --%>
    stringMap: <input type="text" name="stringMap['第一个']"><br/>
    stringMap: <input type="text" name="stringMap['第二个']"><br/>
    addressMap: <input type="text" name="addressMap['地址1'].city"><br/>
    addressMap: <input type="text" name="addressMap['地址1'].street"><br/>
    addressMap: <input type="text" name="addressMap['地址2'].city"><br/>
    addressMap: <input type="text" name="addressMap['地址2'].street"><br/>
    <input type="submit">
</form>
</body>
</html>
