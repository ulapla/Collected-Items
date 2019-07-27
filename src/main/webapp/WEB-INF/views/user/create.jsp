<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Create user</title>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:include page="../header.jsp"/>

<div id="page-wrapper" class="p-4">
    <div class="row">
        <div class="col-xl-12">
            <h1 class="page-header">Nowy użytkownik</h1>
        </div>
        <!-- /.col-xl-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-xl-12">
            <div class="card">

                <!-- /.card-header -->
                <div class="card-body">
                    <form:form method="post" action="/create/user" modelAttribute="user">
                    <div><form:errors path="*" class="has-error" /></div>
                    <p>Login: <form:input class="form-control" id="name" path="username"/></p>

                    <p>Hasło: <form:input class="form-control" id="description" path="password"/></p>

                    </p>

                    <p><button type="submit" value="Save">Zapisz</button></p>
                    </form:form>
                    <jsp:include page="../footer.jsp"/>

</body>
</html>
