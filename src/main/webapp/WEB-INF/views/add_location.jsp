<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>add location</title>
</head>
<body>
<form:form method="post" action="/api/item/${item.id}/add/location" modelAttribute="itemLocation">
    <div><form:errors path="*" class="has-error" /></div>
    <p>Nazwa: ${item.name}</p>

    <input type="hidden" name="item.id" value="${item.id}"/>
    <p><form:select path="location" items="${locations}"  itemValue="id" itemLabel="name" multiple="false"/>
    <p>Ilość: <form:input id="quantity" path="quantity" /></p>
    </p>

    <p><button type="submit" value="Save">Save</button></p>
</form:form>
</body>
</html>
