<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2016/8/31
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>计算机应用技术协会纳新报名</title>
    <link href="${pageContext.request.contextPath}/user/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/user/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="js/ie-emulation-modes-warning.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<script  type="text/javascript" src="js/code.js"></script>
<body >

<div class="container" >

    <form class="form-signin" method="post">
        <h2 class="form-signin-heading">ACAT纳新报名</h2>
        <input type="text" id="schoolnum" name="schoolnum" class="form-control" placeholder="学号" required autofocus>
        <input type="password" id="password" name="password" class="form-control" placeholder="密码(教务系统密码)" required>
        <input type="text" id="validate" name="validate" class="form-control" placeholder="验证码" required id="inputCode">
        <p ><span class="code" ><img src="" style="width:100px;height: 30px"></span>
            <%--<span id="noclear">看不清</span></p>--%>
            <span id="noclear"><a onclick="getImage();return false;" href="">看不清</a></span></p>
        <button class="btn btn-lg btn-primary btn-block" id="loginbtn" >登录</button>
    </form>

</div> <!-- /container -->
<script src="${pageContext.request.contextPath}/user/js/jquery-1.8.3.min.js" type="text/javascript"></script>
<script type="application/javascript" language="JavaScript">
    window.onload=function () {
//                    alert("fresh");
        $.get("./setCode",
                function(data) {
                    $("img").attr("src", "data:image/jpeg;base64," + data);
                });
    }

    //                init();
    //                function init() {
    //                    $.get("./setCode",
    //                            function(data) {
    //                                //其实在第一次运行的时候是可以直接将图片的二进制作为Image的src进行显示的，但是因为后台统一返回的是
    //                                //经过base64编码过后的内容，所以这里初始显示的时候也是利用base64的方法
    //                                $("img").attr("src", "data:image/jpeg;base64," + data);
    //                            });
    //                }
    function getImage(){
//                    alert("123");
        var schoolnum=document.getElementById("schoolnum").value;
        var url = "./stu/getImage?schoolnum="+ schoolnum;
        window.location.href = url;
    }

    $("#loginbtn").click( function (){
        var json_data = [{"schoolnum":$("#schoolnum").val()},{"password":$("#password").val()},{"validate":$("#validate").val()}];
        $.ajax({
            type:'post',
            url:'${pageContext.request.contextPath}/stu/validate',
            dataType:'json',
            data:"json_data="+JSON.stringify(json_data),
            success:function (data) {
                alert("123");
            },
            error:function (data) {

            }
        });
    })

</script>


</body>
</html>


<%-------------------------------------------------界面2.0--------------------------------------------------------------%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">--%>
<%--<meta name="apple-mobile-web-app-capable" content="yes">--%>
<%--<meta name="apple-mobile-web-app-status-bar-style" content="black">--%>
<%--<meta name="format-detection" content="telephone=no">--%>
<%--<meta charset="UTF-8">--%>
<%--<title>Document</title>--%>
<%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/css/08.2.css">--%>
<%--</head>--%>
<%--<body>--%>
<%--<div>--%>
    <%--<div class="login-form">--%>
        <%--<div class="table-sty">--%>
            <%--<form action="${pageContext.request.contextPath}/stu/validate" method="post">--%>
            <%--<div id="box">--%>
            <%--<ul>--%>
            <%--<li><input type="text" name="schoolnum" class="form-control" placeholder="学号"/></li>--%>
            <%--<li><input type="password" name="password" class="form-control" placeholder="密码"/></li>--%>
            <%--<li><input type="text" name="validate" class="form-control"  placeholder="验证码" style="width:100px;">--%>
            <%--<img src="" style="width:80px;"><a onclick="getImage();return false;" href="">看不清</a>--%>
            <%--</li>--%>

            <%--<li class="one"><input class="one" type="submit" value="login in" onclick="validate()"/></li>--%>
            <%--</ul>--%>
            <%--</div>--%>
            <%--</form>--%>
            <%--<script src="${pageContext.request.contextPath}/user/js/jquery-1.8.3.min.js" type="text/javascript"></script>--%>
            <%--<script type="application/javascript" language="JavaScript">--%>
                <%--window.onload=function () {--%>
<%--//                    alert("fresh");--%>
                    <%--$.get("./setCode",--%>
                            <%--function(data) {--%>
                                <%--$("img").attr("src", "data:image/jpeg;base64," + data);--%>
                            <%--});--%>
                <%--}--%>

<%--//                init();--%>
<%--//                function init() {--%>
<%--//                    $.get("./setCode",--%>
<%--//                            function(data) {--%>
<%--//                                //其实在第一次运行的时候是可以直接将图片的二进制作为Image的src进行显示的，但是因为后台统一返回的是--%>
<%--//                                //经过base64编码过后的内容，所以这里初始显示的时候也是利用base64的方法--%>
<%--//                                $("img").attr("src", "data:image/jpeg;base64," + data);--%>
<%--//                            });--%>
<%--//                }--%>
                <%--function getImage(){--%>
<%--//                    alert("123");--%>
                    <%--var schoolnum=document.getElementById("schoolnum").value;--%>
                    <%--var url = "./stu/getImage?schoolnum="+ schoolnum;--%>
                    <%--window.location.href = url;--%>
                <%--}--%>
            <%--</script>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>


<%--</body>--%>
<%--<script src="${pageContext.request.contextPath}/user/js/jquery.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/user/js/bootstrap.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/user/js/registered.js"></script>--%>
<%--</html>--%>
<%-------------------------------------------------界面2.0--------------------------------------------------------------%>

<%-------------------------------------------------界面1.0-------------------------------------------%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
    <%--<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">--%>
    <%--<meta name="apple-mobile-web-app-capable" content="yes">--%>
    <%--<meta name="apple-mobile-web-app-status-bar-style" content="black">--%>
    <%--<meta name="format-detection" content="telephone=no">--%>
    <%--<meta charset="UTF-8">--%>
    <%--<title>Document</title>--%>
    <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/user/css/08.2.css">--%>
<%--</head>--%>
<%--<body>--%>
<%--<div>--%>
    <%--<div class="login-form">--%>
        <%--<div class="table-sty">--%>
            <%--<form action="${pageContext.request.contextPath}/stu" method="post">--%>
                <%--<div id="box">--%>
                    <%--<ul>--%>
                        <%--<li><input type="text" name="schoolnum" class="form-control" value="studentnumber"/></li>--%>
                        <%--<li><input type="text" name="password" class="form-control" value="password"/></li>--%>
                        <%--<li><input type="text" name="validate" class="form-control"  value="验证码">--%>
                            <%--<img src="">--%>
                        <%--</li>--%>
                        <%--<a onclick="getImage();return false;" href="">看不清</a>--%>
                        <%--<li class="one"><input class="one" type="submit" value="login in" onclick="validate()"/></li>--%>
                    <%--</ul>--%>
                <%--</div>--%>
            <%--</form>--%>
            <%--<script src="${pageContext.request.contextPath}/user/js/jquery-1.8.3.min.js" type="text/javascript"></script>--%>
            <%--<script type="application/javascript" language="JavaScript">--%>
                <%--window.onload=function () {--%>
<%--//                    alert("fresh");--%>
                    <%--$.get("./setCode",--%>
                            <%--function(data) {--%>
                                <%--$("img").attr("src", "data:image/jpeg;base64," + data);--%>
                            <%--});--%>
                <%--}--%>

                <%--function getImage(){--%>
                    <%--var schoolnum=document.getElementById("schoolnum").value;--%>
                    <%--var url = "./stu/getImage?schoolnum="+ schoolnum;--%>
                    <%--window.location.href = url;--%>
                <%--}--%>
            <%--</script>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<%--</body>--%>
<%--<script type="text/javascript" src="${pageContext.request.contextPath}/user/js/login.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/user/js/jquery.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/user/js/bootstrap.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/user/js/registered.js"></script>--%>
<%--</html>--%>
<%-------------------------------------------------界面1.0-------------------------------------------%>