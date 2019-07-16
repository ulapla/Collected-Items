<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Dodaj element</title>
</head>
<body>
<%--<c:forEach items="${locations}" var="location">--%>
<%--    <p>${location.place}</p>--%>
<%--</c:forEach>--%>


<form:form method="post" action="/api/item/add" modelAttribute="item">
    <div><form:errors path="*" class="has-error" /></div>
    <p>Nazwa: <form:input id="name" path="name"/></p>

    <p>Opis: <form:input id="description" path="description"/></p>
    <p>Ilość: <form:input id="quantity" path="quantity" /></p>
    <p><form:select path="category" items="${categories}"  itemValue="id" itemLabel="name" multiple="false"/>

    </p>

    <p><button type="submit" value="Save">Save</button></p>
</form:form>
<%--<script language="javascript" type="text/javascript" charset="UTF-8"></script>--%>

<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
<%--<script src="/add_item.js"></script>--%>
</body>
</html>
