<%--
  Created by IntelliJ IDEA.
  User: jiandx
  Date: 2019/12/3
  Time: 15:10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎使用『MonkeyShop』后台管理系统。</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                    <a href="admin_touseradd"><i class="icon-font">&#xe041;</i>新增用户</a>
                    <a href="admin_tocateadd"><i class="icon-font">&#xe048;</i>新增分类</a>
                    <a href="admin_toproductadd"><i class="icon-font">&#xe001;</i>新增商品</a>

                </div>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>系统基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">操作系统</label><span class="res-info">WIN10</span>
                    </li>
                    <li>
                        <label class="res-lab">运行环境</label><span class="res-info">TomCat 7.0.96</span>
                    </li>
                    <li>
                        <label class="res-lab">Modules</label><span class="res-info">JDK1.8</span>
                    </li>
                    <li>
                        <label class="res-lab">上传附件限制</label><span class="res-info">未知</span>
                    </li>
                    <li>
                        <label class="res-lab">北京时间</label><span class="res-info" id="now"></span>
                    </li>
                    <li>
                        <label class="res-lab">服务器地址</label><span class="res-info">http://localhost:8080/</span>
                    </li>
                    <li>
                        <label class="res-lab">框架</label><span class="res-info">没用</span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>使用帮助</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">如果不会：</label><span class="res-info"><a href="http://www.baidu.com/" target="_blank">百度一下</a></span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
<script>
    function showTime(){
        var nowDate = new Date();
        //获取年份
        var y = nowDate.getFullYear();
        //获取月份
        var mon = nowDate.getMonth()+1;
        //获取日期
        var d = nowDate.getDate();
        //获取小时
        var h = nowDate.getHours();
        //获取分钟
        var min = nowDate.getMinutes();
        //获取秒数
        var s = nowDate.getSeconds();
        var showT = document.getElementById("now");
        showT.innerHTML = y+"年"+mon+"月"+d+"日"+h+"时"+min+"分"+s+"秒";
        var w = window.location.hostname;
    }

    showTime();
</script>
</html>
