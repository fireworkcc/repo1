<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <h4>查询所有账户</h4>

    <c:forEach items="${list}" var="account">
        ${account.name}
        ${account.money}
    </c:forEach>

</body>
</html>
