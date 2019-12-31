<%--
  Created by IntelliJ IDEA.
  User: Jgybz
  Date: 2019/12/30
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script>
        function sendAjax1() {
            $.ajax({
                url:"/Ajax/demo1.do",
                data:'{}',
                success:function (resultdata) {
                    console.log(resultdata)
                },
                datatype:"json",
                type:"post"
            })
        }
        function sendAjax2() {
            $.ajax({
                url:"/Ajax/demo2.do",
                data:'{"username":"jgybzx","password":"123","gender":"男"}',
                datatype:"json",
                type:"post",
                success:function (resultdata) {
                    console.log(resultdata)
                },
                contentType:"application/json"
            })
        }
    </script>
</head>
<body>
<input type="button" onclick="sendAjax1()" value="ajax请求，普通数据返回"><br>
<input type="button" onclick="sendAjax2()" value="ajax请求，json数据返回"><br>

</body>
</html>
