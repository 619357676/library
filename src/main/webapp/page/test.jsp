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










<body>



<div class="container">
    <div>



        <!--<div id="book"></div>-->
        <form>
            <table  class="table table-bordered">


                <%--var 临时变量--varStatus循环状态对象--%>
                <c:forEach  begin="1" end="10" var="book" step="1" varStatus="s">
                    <tr>
                        <td>${s.count}</td>
                            <%--<td>${book.book}</td>--%>
                            <%-- <td>作者</td>
                             <td>出版日期</td>
                             <td>出版社</td>
                             <td>分类</td>--%>

                            <%-- <td><input type="checkbox" value="${book.bid}"></td>
                             &lt;%&ndash;<td>${s.count}</td>&ndash;%&gt;
                             <td>${book.name}</td>
                             <td>${book.author}</td>
                             <td>${book.pubDate}</td>
                             <td>${book.pubHouse}</td>
                             <td>${book.classify}</td>
                             <td>dsfds</td>--%>
                    </tr>
                </c:forEach>

            </table>
        </form>

    </div>
</div>

</body>


</html>
