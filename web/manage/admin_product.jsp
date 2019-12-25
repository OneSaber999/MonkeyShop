<%--
  Created by IntelliJ IDEA.
  User: ns
  Date: 2019/12/14
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">商品管理</span></div>
    </div>

    <div id="register" class="result-wrap">
        <form action="/manage/admin_douserdel" id="myform" method="post">
            <div class="result-title">
                <div class="result-list">
                    <a href="/manage/admin_toproductadd"><i class="icon-font"></i>新增商品</a>

                    <!--  a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a -->
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" width="60%">
                    <tr>

                        <th>ID</th>
                        <th>商品名称</th>
                        <th>操作</th>

                    </tr>

                    <c:forEach var="p" items="${plist }">
                        <tr>
                            <td>${p.PRODUCT_ID }</td>
                            <td><img src="../images/product/${p.PRODUCT_FILENAME}" width="80" height="80">
                                    ${p.PRODUCT_NAME }

                            </td>
                            <td>
                                <a href="admin_toproductupdate?id=${p.PRODUCT_ID }">修改</a>
                                <a href="javascript:productdel(${p.PRODUCT_ID })">删除</a>
                            </td>
                        </tr>
                    </c:forEach>

                    <script>
                        function productdel(id) {
                            if(confirm("你确认要删除这件商品吗")) {
                                location.href="admin_doproductdel?id="+id;

                            }
                        }


                    </script>



                </table>
                <div class="list-page">
                    <a href="/manage/admin_productselect?cp=1${SearchParams}">首页</a>
                    <a href="/manage/admin_productselect?cp=${cpage-1<1?1:cpage-1}${SearchParams}">上一页</a>
                    共${tsum}条 ${cpage}/${tpage} 页
                    <a href="/manage/admin_productselect?cp=${cpage+1>tpage?tpage:cpage+1}${SearchParams}">下一页</a>
                    <a href="/manage/admin_productselect?cp=${tpage}${SearchParams}">尾页</a>
                </div>
            </div>
        </form>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>