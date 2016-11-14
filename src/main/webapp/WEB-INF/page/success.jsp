<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2016/10/22
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Successful</title>
    <style>
        body{background: url(${pageContext.request.contextPath}/user/images/bg_one.png);}
        #center{
            width: 300px;
            height: 100px;
            position: absolute;
            left:0;right: 0;
            bottom: 0;top:0;
            margin:auto;
            background: url(${pageContext.request.contextPath}/user/images/successful.png) no-repeat center;
        }
        p{
            color: #6EECBD;
            font-size: 32px;
            font-weight: 300;
            font-family: "楷体";
            line-height: 40px;
            margin-left: 80px;
        }
    </style>
</head>
<body>
<div id="center">
    <p>${result}</p>
</div>
</body>
</html>
