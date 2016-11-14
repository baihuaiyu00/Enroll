<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2016/9/2
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>报名情况</title>
    <script src="${pageContext.request.contextPath}/user/js/jquery-1.8.3.min.js" type="text/javascript"></script>
    <style type="text/css">
        .t1
        {
            clear: both;
            border: 1px solid #c9dae4;
        }
        .t1 tr th
        {
            color: #0d487b;
            background: #f2f4f8 url("") repeat-x left bottom;
            line-height: 28px;
            border-bottom: 1px solid #9cb6cf;
            border-top: 1px solid #e9edf3;
            font-weight: normal;
            text-shadow: #e6ecf3 1px 1px 0px;
            padding-left: 5px;
            padding-right: 5px;
        }
        .t1 tr td
        {
            border-bottom: 1px solid #e9e9e9;
            padding-bottom: 5px;
            padding-top: 5px;
            color: #444;
            border-top: 1px solid #FFFFFF;
            padding-left: 5px;
            padding-right: 5px;
            word-break: break-all;
        }
        /* white-space:nowrap; text-overflow:ellipsis; */
        tr.alt td
        {
            background: #ecf6fc; /*这行将给所有的tr加上背景色*/
        }
        tr.over td
        {
            background: #bcd4ec; /*这个将是鼠标高亮行的背景色*/
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function () { //这个就是传说的ready
            $(".t1 tr").mouseover(function () {
                //如果鼠标移到class为stripe的表格的tr上时，执行函数
                $(this).addClass("over");
            }).mouseout(function () {
                //给这行添加class值为over，并且当鼠标一出该行时执行函数
                $(this).removeClass("over");
            }) //移除该行的class
            $(".t1 tr:even").addClass("alt");
            //给class为stripe的表格的偶数行添加class值为alt
        });
    </script>
</head>
<body>
    <p>总共报名人数:${stus_num}</p>
    <table width="100%" id="ListArea" border="0" class="t1" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td>姓名</td>
            <td>学号</td>
            <td>性别</td>
            <td>专业班级</td>
            <td>电话</td>
            <td>email</td>
            <td>方向</td>
            <td>个人简介</td>
        </tr>
        <c:forEach items="${stu_list}" var="stu">
            <tr>
                <td>${stu.stu_name}</td>
                <td>${stu.stu_num}</td>
                <td>${stu.sex}</td>
                <td>${stu.major}</td>
                <td>${stu.tel}</td>
                <td>${stu.email}</td>
                <td>${stu.choice}</td>
                <td>${stu.self_introd}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
