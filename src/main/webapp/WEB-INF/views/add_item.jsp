<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Dodaj element</title>
</head>
<body>
<form:form method="post" action="/api/item/add" modelAttribute="itemDto">
    <p>Nazwa: <form:input id="name" path="name"/></p>
    <p>Rodzaj: <form:input id="type" path="type"/></p>
    <p>Opis: <form:input id="description" path="description"/></p>
    <p>Ilość: <form:input id="quantity" path="quantity" /></p>
    <p><form:select path="locations" items="${locations}"  multiple="false"/></p>

    <p><button type="submit" value="Save">Save</button></p>
</form:form>
<script language="javascript" type="text/javascript" charset="UTF-8"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<%--<script src="/add_item.js"></script>--%>
</body>
</html>
