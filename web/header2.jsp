<%--
  Created by IntelliJ IDEA.
  User: ns
  Date: 2019/12/19
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="head ding">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="indexselect"><img src="img/233.png"/></a></h1>
            <div class="fr clearfix" id="top1"><p class="fl">
                <c:if test="${isLogin !=1 }">
                    <a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>

                </c:if>

                <c:if test="${isLogin ==1 }">
                    <b>你好：</b><a href="login.jsp" id="login">${name.USER_NAME }</a>

                </c:if>

                <c:if test="${isAdminLogin ==1 }">
                    <a href="manage/admin_index.jsp" id="login1">进入后台</a>

                </c:if>
            </p>
                <form action="#" method="get" class="fl">
                    <input type="text" placeholder="热门搜索：宝可梦 剑"/>
                    <input type="button"/></form>
                <div class="btn fl clearfix"><a href="mygxin.jsp"><img src="img/grzx.png"/></a>
                    <a href="#" class="er1"><img src="img/ewm.png"/></a>
                    <c:if test="${isLogin ==1 }">
                        <a href="showcart"><img src="img/gwc.png"/></a>
                    </c:if>

                    <p><a href="#"><img src="img/ewm.jpg"/></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexselect">首页</a></li>

            <c:forEach var="f" items="${flist }">

                <li><a href="selectproductlist?fid=${f.CATE_ID }">${f.CATE_NAME }</a>
                    <div class="sList2">
                        <div class="clearfix">
                            <c:forEach var="c" items="${clist }">
                                <c:if test="${f.CATE_ID == c.CATE_PARENT_ID }">
                                    <a href="selectproductlist?cid=${c.CATE_ID }">${c.CATE_NAME }</a>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>
<div class="address mt" id="add">
    <div class="wrapper clearfix"><a href="indexselect" class="fl">首页</a><span>/</span><a href="mygxin.jsp" class="on">个人中心</a>
    </div>
</div><!------------------------------Bott------------------------------>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="mygxin.jsp"><img src="img/tx.png"/></a>
                <p class="clearfix"><span class="fl">[${name.USER_NAME }]</span><span>[<a href="logout">退出登录</a>]</span></p></h3>
            <div><h4>我的交易</h4>
                <ul>
                    <li><a href="showcart">我的购物车</a></li>
                    <li><a href="myorderq.jsp">我的订单</a></li>
                    <li><a href="myprod.jsp">评价晒单</a></li>
                </ul>
                <h4>个人中心</h4>
                <ul>
                    <li class="on"><a href="mygxin.jsp">我的中心</a></li>
                    <li><a href="address.jsp">地址管理</a></li>
                </ul>
                <h4>账户管理</h4>
                <ul>
                    <li><a href="mygrxx.jsp">个人信息</a></li>
                    <li><a href="remima.jsp">修改密码</a></li>
                </ul>
            </div>
        </div>