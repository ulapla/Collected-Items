<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form >
    <p>Nazwa: <input id="name" path="name"/></p>
    <p>Rodzaj: <input id="type" path="type"/></p>
    <p>Opis: <input id="description" path="description"/></p>
    <p>Ilość: <input id="quantity" path="quantity" /></p>
    <p ><select id="locations"></select></p>
    <p><button type="submit" value="Save">Save</button></p>
</form>
<script language="javascript" type="text/javascript" charset="UTF-8"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/add_item.js"></script>
</body>
</html>
