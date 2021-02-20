<%--
  Created by IntelliJ IDEA.
  User: GA
  Date: 2021/1/24
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>修改图书</title>
    <link rel="stylesheet" href="../css/bootstrap.css">
    <script src="../js/bootstrap.js"></script>
    <script src="../js/jquery-3.3.1.js"></script>


</head>
<body>
<div class="container">

    <h2 style="text-align: center">修改图书信息</h2>
    <form action="updateBookServlet" method="post">
        <input type="hidden" name="bid" value="${book.bid}">
        <div class="form-group">
            <label>书名</label>
            <input type="text" class="form-control" name="name" value="${book.name}">

        </div>
        <div>
            作者
            <input type="text" class="form-control" name="author" value="${book.author}">
        </div>
        <div>
            出版日期
            <input type="date" class="form-control" name="pubDate" value="${book.pubDate}">
        </div>
        <div>
            出版社
            <input type="text" class="form-control" name="pubHouse" value="${book.pubHouse}">
        </div>
        <div>
            总页数
            <input type="text" class="form-control" name="page" value="${book.page}">
        </div>
        <div>
            分类
            <!--<input type="text" class="form-control" name="classify" placeholder="请输入分类">-->
            <select name="classify" class="form-control">

                <option>请选择</option>
                <option value="马克思主义、列宁主义、毛泽东思想、邓小平理论">马克思主义、列宁主义、毛泽东思想、邓小平理论</option>
                <option value="哲学、宗教">哲学、宗教</option>
                <option value="政治、法律">政治、法律</option>
                <option value="军事">军事</option>
                <option value="经济">经济</option>
                <option value="文化、科学、教育、体育">文化、科学、教育、体育</option>
                <option value="语言、文字">语言、文字</option>
                <option value="文学">文学</option>
                <option value="${book.classify}" selected>${book.classify}</option>
            </select>
        </div>
        <div>
            中图分类号
            <input type="text" class="form-control" name="clc" value="${book.name}">
        </div>
        <div>
            简介
            <textarea class="form-control" row="3" name="introduction">${book.introduction}</textarea>
        </div>
        <div style="text-align: center">
            <input class="btn btn-primary " type="submit" value="修改并保存">
            <input class="btn btn-danger" type="reset" value="重置">
            <a href="../index.html">
                <button  class="btn btn-default " type="button" value="返回">返回</button>
            </a>
        </div>
    </form>

</div>

</body>
</html>