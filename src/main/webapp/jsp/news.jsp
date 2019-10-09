<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<%@ page isELIgnored="false" %>

<head>
    <title>News Management</title>
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<section>
    <h2>News Management</h2>
    <%--    <a href="patients?action=create">Add News</a>--%>
</section>

<div class="box-table">
    <div class="box-table width20 box-col ">
        <div class="box-row ">
            <div class="box_menu width100">News List</div>
        </div>
        <div class="box-row ">
            <div class="box_menu width100">Add News</div>
        </div>
    </div>
    <div class="box-table width80 box-col">
        <c:forEach items="${news}" var="news">
            <jsp:useBean id="news" scope="page" type="com.epam.news.model.News"/>

            <div class="box-row">
                <div class="box width80">${news.title}</div>
                <div class="box width20">${news.date}</div>
            </div>
            <div class="box-row">
                <div class="box width100">${news.brief}</div>
            </div>
            <div class="box-row">
                <div class="box width80"></div>
                <div class="box width20">view edit check</div>
            </div>
            <div class="box-row">
                <div class="box width100"></div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
