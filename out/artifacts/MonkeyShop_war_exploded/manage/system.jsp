<%--
  Created by IntelliJ IDEA.
  User: ns
  Date: 2019/12/18
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
<!--/sidebar-->
<div class="main-wrap">
    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">系统设置</span></div>
    </div>
    <div class="result-wrap">
        <form action="#" method="post" id="myform" name="myform">
            <div class="config-items">
                <div class="config-title">
                    <h1><i class="icon-font">&#xe00a;</i>网站信息设置</h1>
                </div>
                <div class="result-content">
                    <table width="100%" class="insert-tab">
                        <tbody><tr>
                            <th width="15%"><i class="require-red">*</i>域名：</th>
                            <td><input type="text" id="" value="#" size="85" name="keywords" class="common-text"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>站点标题：</th>
                            <td><input type="text" id="" value="『MonkeyShop』-有趣、方便、超值" size="85" name="title" class="common-text"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>关键字：</th>
                            <td><input type="text" id="" value="任天堂,NS,Nintendo,Nintendo Switch,Nintendo Switch Online" size="85" name="keywords" class="common-text"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>描述：</th>
                            <td><input type="text" id="" value="『MonkeyShop』，让您的任天堂游戏体验更加有趣、方便、超值。持有Nintendo Account的玩家皆可免费使用。" size="85" name="description" class="common-text"></td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <input type="submit" value="提交" class="btn btn-primary btn6 mr10">
                                <input type="button" value="返回" onClick="history.go(-1)" class="btn btn6">
                            </td>
                        </tr>
                        </tbody></table>
                </div>
            </div>
            <div class="config-items">
                <div class="config-title">
                    <h1><i class="icon-font">&#xe014;</i>站长信息设置</h1>
                </div>
                <div class="result-content">
                    <table width="100%" class="insert-tab">
                        <tr>
                            <th width="15%"><i class="require-red">*</i>网站联系邮箱：</th>
                            <td><input type="text" id="" value="xxxx@yyy.com" size="85" name="email" class="common-text"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>联系人：</th>
                            <td><input type="text" id="" value="王智贤" size="85" name="contact" class="common-text"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>联系电话：</th>
                            <td><input type="text" id="" value="123456" size="85" name="phone" class="common-text"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>备案ICP：</th>
                            <td><input type="text" id="" value="爷在郑州" size="85" name="icp" class="common-text"></td>
                        </tr>
                        <tr>
                            <th><i class="require-red">*</i>地址：</th>
                            <td><input type="text" id="" value="中国 • 郑州" size="85" name="address" class="common-text"></td>
                        </tr>
                        <tr>
                            <th></th>
                            <td>
                                <input type="hidden" value="siteConf.inc.php" name="file">
                                <input type="submit" value="提交" class="btn btn-primary btn6 mr10">
                                <input type="button" value="返回" onClick="history.go(-1)" class="btn btn6">
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </form>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>