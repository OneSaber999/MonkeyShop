<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: jiandx
  Date: 2019/12/3
  Time: 15:11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>

    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">用户管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/manage/admin_douserselect" method="post">
                    <table class="search-tab">
                        <tr>
                            <th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="s" >
                                    <option value="">全部</option>
                                    <option value="19">精品界面</option><option value="20">推荐界面</option>
                                </select>
                            </td>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value="${param.keywords}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_useradd.jsp"><i class="icon-font"></i>新增用户</a>
                        <a id="batchDel" href="javascript:void(0)"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name="" type="checkbox"></th>
                            <th>ID</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>EMAIL</th>
                            <th>手机号码</th>
                            <th>添加时间</th>
                            <th>操作</th>
                        </tr>

                    <c:forEach var="u" items="${userlist}">
                        <tr>
                            <td class="tc"><input name="id[]" value="${u.USER_ID}" type="checkbox"></td>
                            <td>${u.USER_ID}</td>
                            <td>${u.USER_NAME}</td>
                            <td>${u.USER_SEX=='T'?'男':'女'}</td>
                            <td>${u.USER_EMAIL}</td>
                            <td>${u.USER_MOBILE}</td>
                            <td>${u.USER_UPDATETIME}</td>

                            <td>
                                <a class="link-update" href="admin_touserupdate?id=${u.USER_ID}&cpage=${cpage}">修改</a>
                                <a class="link-del" href="admin_">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                    <div class="list-page">  共${tsum}条 ${cpage}/${tpage} 页
                        <a href="/manage/admin_douserselect?cp=1${SearchParams}">首页</a>
                        <a href="/manage/admin_douserselect?cp=${cpage-1<1?1:cpage-1}${SearchParams}">上一页</a>
                        <a href="/manage/admin_douserselect?cp=${cpage+1>tpage?tpage:cpage+1}${SearchParams}">下一页</a>
                        <a href="/manage/admin_douserselect?cp=${tpage}${SearchParams}">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
