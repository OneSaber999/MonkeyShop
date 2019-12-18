<%--
  Created by IntelliJ IDEA.
  User: ns
  Date: 2019/12/19
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>ok</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css"/>
</head>
<body><!----------------------------------------order------------------>
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
<div class="order mt cart">
    <div class="site"><p class="wrapper clearfix"><span class="fl">支付成功</span><img class="top"
                                                                                   src="img/temp/cartTop03.png"></p>
    </div>
    <p class="ok">支付成功！剩余<span>5</span>秒<a href="myorderq.jsp">返回订单页</a></p></div>
<div class="like"><h4>最近访问</h4>
    <div class="bottom">
        <div class="hd"><span class="prev"><img src="img/temp/prev.png"></span><span class="next"><img
                src="img/temp/next.png"></span></div>
        <div class="imgCon bd">
            <div class="likeList clearfix">
                <div>

                    <c:forEach var="lp" items="${lastlylist }">
                        <a href="selectproductview?id=${lp.PRODUCT_ID }">
                            <dl>
                                <dt><img src="images/product/${lp.PRODUCT_FILENAME }" width="200px" height="311px"></dt>
                                <dd>【NS】${lp.PRODUCT_NAME }</dd>
                                <dd>￥${lp.PRODUCT_PRICE }.00</dd>
                            </dl>
                        </a>
                    </c:forEach>

                </div>
            </div>
        </div>
    </div>
</div><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">MonkeyShop&copy;1000-2019公司版权所有 京ICP备010101-01备0101010101号<br/>
        违法和不良信息举报电话：123-456-789，本网站所列图片，除特殊说明，所有图片均为网上搬运,blabala
    </p>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.SuperSlide.2.1.1.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">jQuery(".bottom").slide({
    titCell: ".hd ul",
    mainCell: ".bd .likeList",
    autoPage: true,
    autoPlay: false,
    effect: "leftLoop",
    autoPlay: true,
    vis: 1
});</script>
</body>
</html>