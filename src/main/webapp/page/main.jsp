<%--
  Created by IntelliJ IDEA.
  User: GA
  Date: 2021/1/19
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.css">
    <script src="../js/jquery-3.3.1.js"></script>
    <script src="../js/bootstrap.js"></script>
</head>


<style>
    .user {
        width: 50px;
        line-height: 26px;
        float: right;
        color: #ac2925;

    }

    .ta {
        border-collapse: collapse !important;
        border: 1px solid #ddd;
    }
</style>


<script>

    /*$(function () {

        $.get("findUserServlet", {}, function (data) {
            var msg = "欢迎您," + data.name;
            $("#welcome").html(msg);
        });



    });
*/
    $(function () {
        var flag = false;
        $("#select_all").click(function () {
//            var name = document.getElementsByName("bid");
            var name = $("input[name='bid']");
            for (var i = 0; i < name.length; i++) {
                name[i].checked = !flag;
            }
            flag = !flag;
        });

        $("#delSelected").click(function () {
            if (confirm("您确定删除所选项目")) {
                var flag1 = false;
                var bid = document.getElementsByName("bid");
//                var bid = $("input[name='bid']");
                for (var i = 0; i <= bid.length; i++) {
                    if (bid[i].checked) {
                        flag1 = true;
                        break;
                    }
                }
                if (flag1) {
                   $("#form").submit();
                }
            }


        });

    });

    function deleteBookById(bid) {

        if (confirm("你确定要删除")) {
            location.href = "${pageContext.request.contextPath}/deleteBookServlet?bid=" + bid;
        }
    }


</script>

<body>
<div class="container">
    <div class="nav">
        <span class="user " id="welcome">欢迎您</span>
    </div>
</div>
<hr>


<div class="container">
    <div>
        <h3 style="text-align: center">图书信息</h3>
        <div style="float: left;margin:5px;">
            <form class="form-inline" action="findBookServlet" method="post">
                <div class="form-group">
                    <label for="exampleInputName2">书名</label>
                    <input type="text" name="name" class="form-control" id="exampleInputName2">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail2">作者</label>
                    <input type="text" name="author" class="form-control" id="exampleInputEmail2">
                </div>

                <button type="submit" class="btn btn-primary">查询</button>
            </form>
        </div>

        <div style="float: right;margin:5px;">
            <a href="../add_book.html">
                <button type="button" class="btn btn-primary">添加图书信息</button>
            </a>
            <a>
                <button type="button" class="btn btn-danger" href="javascript:void(0);" id="delSelected">删除选中</button>
            </a>
        </div>


        <div>
            <ul id="book" style="text-align: center">
                <!--  <li>序号:1<br>
                  书名:《论十大关系》导读<br>
                  作者:艾四林总主编<br>
                  出版日期:2018-06-01<br>
                  出版社:北京：中国民主法制出版社<br>
                  总页数:179<br>
                  分类:马克思主义、列宁主义、毛泽东思想、邓小平理论<br>
                  中图分类号:A841.26<br>
                  简介:《论十大关系》初步总结了我国社会主义建设的经验，提出了探索适合中国国情的社会主义建设道路的任务，是毛泽东关于社会主义建设问题的代表作，反映了第一代中央领导集体对于适合中国国情的社会主义道路的认识和探索，标志着以毛泽东为代表的中共领导人对中国社会主义道路的探索开始形成了一个初步的但是较为系统的思路。
                  </li>-->
            </ul>
        </div>
        <br>
        <br>

        <!--<div id="book"></div>-->
        <form id="form" action="${pageContext.request.contextPath}/deleteBookServlet" method="post">
            <table class="table table-bordered">
                <tr>
                    <td><input type="checkbox" id="select_all"></td>
                    <th>书名</th>
                    <th>作者</th>
                    <th>出版日期</th>
                    <th>出版社</th>
                    <th>分类</th>
                    <th>操作</th>
                </tr>

                <%--var 临时变量--varStatus循环状态对象--%>
                <c:forEach items="${book}" var="book" varStatus="s">
                    <tr>
                        <td><input name="bid" type="checkbox" value="${book.bid}">
                                <%--${s.count}--%>
                            <span>${s.count}</span>
                        </td>
                        <td><a href="../book_detail.html?bid=${book.bid}">${book.name}</a></td>

                        <td>${book.author}</td>
                        <td>${book.pubDate}</td>
                        <td>${book.pubHouse}</td>
                        <td>${book.classify}</td>
                        <td><a class="btn btn-info btn-sm" href="${pageContext.request.contextPath}/findBookByIdServlet?bid=${book.bid}">修改</a>
                            <a class="btn btn-danger btn-sm" href="javascript:deleteBookById(${book.bid});">删除</a>
                        </td>

                    </tr>
                </c:forEach>

            </table>
        </form>


        <div>
            <nav aria-label="Page navigation">
                <ul class="pagination  pagination-lg">
                    <li>
                        <a href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>

                    </li>

                    <c:forEach begin="1" end="${page.totalPage}" var="i">
                        <li>
                            <a href="${pageContext.request.contextPath}/findBookServlet?currentPage=${i}&rows=10&name=${map.name[0]}&author=${map.author[0]}">${i}
                            </a>
                        </li>

                    </c:forEach>

                    <li>
                        <a href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>

                    <span style="font-size: 25px;margin-left: 5px;">
                    共${page.totalCount}条记录，共${page.totalPage}页
                </span>
                </ul>

            </nav>
        </div>
    </div>
</div>


</body>


</html>
