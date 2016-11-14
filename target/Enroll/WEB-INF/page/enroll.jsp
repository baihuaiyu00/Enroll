<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2016/8/31
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <style type="text/css">
        p{
            height:25px;
            line-height:25px;
            /*background: red;*/
            position: relative;
            top:10px;
        }
        div#sex{
            height:25px;
            line-height: 25px;
            text-align:left;
        }
        body{
            padding-top: 0px;
            padding-bottom: 0px;
        }
    </style>
</head>

<body >
<div class="container" >

    <form action="create" method="post" class="form-signin" onsubmit="return wait();">
        <h2 class="form-signin-heading">ACAT纳新报名</h2>
        <input type="text" name="stu_name"  class="form-control" placeholder="姓名" required autofocus>
        <input type="text" name="stu_num" class="form-control" value="" placeholder="学号">
        <input type="text" name="tel" class="form-control" placeholder="电话" required >
        <div id="sex">
            <label class="radio-inline">
                性别:
            </label>
            <label class="radio-inline">
                <input type="radio" name="sex" id="inlineRadio1" value="1" checked> 男
            </label>
            <label class="radio-inline">
                <input type="radio" name="sex" id="inlineRadio2" value="2"> 女
            </label>

            <%--性别:--%>
            <%--男<input type="radio" name="sex" class="form-control"  value="1"  id="two"checked  />--%>
            <%--女<input type="radio" name="sex" class="form-control"  value="2" id="two" />--%>

        </div>
        <input type="text" name="major" class="form-control" placeholder="专业班级" required >
        <input type="email" name="email" class="form-control" placeholder="电子邮箱" required >
        <p>方向选择</p>
        <select name="choice" class="form-control">
            <option>java组</option>
            <option>web前端</option>
            <option>php组</option>
        </select>
        <p>自我介绍</p>
        <textarea class="form-control" name="self_introd" rows="3"></textarea>
        <button class="btn btn-lg btn-primary btn-block" type="submit" >提交</button>
    </form>

</div> <!-- /container -->


</body>
<script type="text/javascript">
    function wait(){
        document.getElementById("submitBtn").style.display="none";
    }
</script>
</html>


