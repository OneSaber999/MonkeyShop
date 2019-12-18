<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>MonkeyShop</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body>
<!------------------------------head------------------------------>
<%@ include file="header2.jsp" %>

        <div class="you fl">
            <div class="my clearfix"><h2 class="fl">我的订单</h2><a href="#" class="fl">请谨防钓鱼链接或诈骗电话，了解更多&gt;</a></div>
            <div class="dlist clearfix">
                <ul class="fl clearfix" id="wa">
                    <li class="on"><a href="#2">全部有效订单</a></li>
                    <li><a href="#2">待支付</a></li>
                    <li><a href="#2l">待收货</a></li>
                    <li><a href="#2">已关闭</a></li>
                </ul>
                <form action="#" method="get" class="fr clearfix">
                    <input type="text" name="" id="" value="" placeholder="请输入商品名称、订单号"/>
                    <input type="button" name="" id="" value=""/>
                </form>
            </div>
            <div class="dkuang"><p class="one">已收货</p>
                <div class="word clearfix">
                    <ul class="fl clearfix">
                        <li>2019年12月17日 18:53</li>
                        <li>杨小黄</li>
                        <li>订单号:5160513358520018</li>
                        <li>在线支付</li>
                    </ul>
                    <p class="fr">订单金额：<span>349.00</span>元</p></div>
                <div class="shohou clearfix"><a href="#" class="fl"><img src="img/temp/hyzx.png"/></a>
                    <p class="fl"><a href="#">塞尔达传说:荒野之息</a><a href="#">¥349.00×1</a></p>
                    <p class="fr"><a href="myprod.jsp">待评价</a><a href="orderxq.jsp">订单详情</a></p></div>
            </div>
            <div class="dkuang clearfix deng"><p class="one fl">待收货</p>
                <div class="clearfix">
                    <div class="fl vewwl"><a href="wuliu.jsp" class="ckwl">查看物流</a>
                        <div class="wuliu"><h4>圆通速递：858888888888888</h4>
                            <ul>
                                <li><p>妥投投递并签收，已签收。签收人：本人签收</p>
                                    <p>2019-12-13 17:30:00</p></li>
                                <li><p>深圳市南油速递营销部安排投递（投递员姓名：六六六。联系电话：14243452522;</p>
                                    <p>2019-12-14 08:50:00</p></li>
                                <li><p>到达广东省邮政速递物流有限公司深圳航空邮件处理中心处理中心（经转）</p>
                                    <p>2019-12-15 02:20:00</p></li>
                                <li>以上为最新跟踪信息<a href="wuliu.html">查看全部</a></li>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>

            <div class="fenye clearfix"><a href="#"><img src="img/zuo.jpg"/></a><a href="#">1</a><a href="#"><img
                    src="img/you.jpg"/></a></div>
        </div>
    </div>
</div><!--返回顶部-->
<div class="gotop"><a href="showcart">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.jsp">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div><!--footer-->
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
<script src="js/user.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>