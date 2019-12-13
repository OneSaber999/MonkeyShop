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
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="#" method="post"><h1><a href="index.html"><img src="img/temp/logo.png"></a></h1>
        <p><h1 style="padding:0px">用户注册</h1></p>
        <p><input type="text" name="userName" value="" placeholder="请输入用户名"><span></span></p>
        <p><input type="text" name="name" value="" placeholder="请输入姓名"><span></span></p>
        <p><input type="text" name="password" value="" placeholder="请输入密码"><span></span></p>
        <p><input type="text" name="rePassword" value="" placeholder="请确认密码"><span></span></p>
        <p>
            <input style="width: 15px;height: 15px;" type="radio" name="sex" value="T" checked="checked">男
            <input type="radio" name="sex" value="F" checked="checked">女
        </p>
        <p><input type="text" name="birthday" value="" placeholder="请输入生日"><span></span></p>
        <p><input type="text" name="email" value="" placeholder="请输入邮箱"><span></span></p>
        <p><input type="text" name="mobile" value="" placeholder="请输入手机号"><span></span></p>
        <p><input type="text" name="adress" value="" placeholder="请输入地址"><span></span></p>
        <p><input class="code" type="text" name="" value="" placeholder="验证码">
           <img src="img/temp/code.jpg"><span></span></p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            <使用条款和隐私策略>
        </a></p>
        <p class="txt"><a href="#"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>--></form>
</div>
</body>
</html>
