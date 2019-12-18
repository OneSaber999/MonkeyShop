<%--
  Created by IntelliJ IDEA.
  User: jiandx
  Date: 2019/12/13
  Time: 15:14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/calendar.js"></script>
    <script src="js/function.js"></script>
    <script src="js/jquery-1.12.4.min.js"></script>
    <style>
        .reg p .error{
            display: inline-block;
            border: 1px solid #ff855a;
            color: green;
            height: 25px;
            line-height: 25px;
            padding: 0px 20px;
            margin-left: 20px;
        }
    </style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post" onsubmit="return checkForm(this)">
        <p><h1 style="background-color: red;font-size: 25px;color: white;text-align: center;margin: 0px;">建立MonkeyShop Account</h1></p>
        <p><input type="text" name="userName" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入用户名"><span></span></p>
        <p><input type="text" name="name" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入姓名"><span></span></p>
        <p><input type="text" name="password" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请输入密码"><span></span></p>
        <p><input type="text" name="rePassword" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="请确认密码"><span></span></p>
        <p>
            <input style="width: 15px;height: 15px;" type="radio" name="sex" value="T" checked="checked">男
            <input style="width: 15px;height: 15px;" type="radio" name="sex" value="F" >女
        </p>
        <p><input type="text" name="birthday" value="" onfocus="c.show(this)" placeholder="请输入生日"><span></span></p>
        <p><input type="text" name="email" value="" placeholder="请输入邮箱"><span></span></p>
        <p><input type="text" name="mobile" value="" placeholder="请输入手机号"><span></span></p>
        <p><input type="text" name="address" value="" placeholder="请输入地址"><span></span></p>
        <p><input class="code" name="veryCode" type="text" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="验证码">
           <img height="30px" src="getCode" alt="看不清?换一张" onclick="change(this)"><span></span></p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的
            <a href="#">
            <使用条款和隐私策略 />
            </a>
        </p>
        <p class="txt"><a href="login.jsp"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>
