<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><html>
<%@ page isELIgnored="false" %>

<head>
    <title>News</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section>
    <h2>News List</h2>
    <hr>
<%--    <a href="patients?action=create">Add News</a>--%>
    <hr>
    <table border="1" cellpadding="8" cellspacing="0">
        <c:forEach items="${news}" var="nevv">
            <jsp:useBean id="nevv" scope="page" type="com.epam.news.model.New"/>
            <tr class="normal">
                <td><c:out value="${nevv.title}"/></td>
<%--                <td>${nevv.date}</td>--%>
            </tr>
            <tr class="normal">
                <td>${nevv.brief}</td>
            </tr>
        </c:forEach>
    </table>
</section>

</body>
</html>
