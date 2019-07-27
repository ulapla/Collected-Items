<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="header.jsp"/>
<div id="page-wrapper" class="p-4">
    <div class="row">
        <div class="col-xl-12">
            <h2 class="page-header">Zaloguj się</h2>
        </div>
        <!-- /.col-xl-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-xl-12">
            <div class="card">

                <!-- /.card-header -->
                <div class="card-body">


                    <form method="post">
                        <div><label> Login : <input type="text" name="username"/> </label></div>
                        <div><label> Hasło: <input type="password" name="password"/> </label></div>
                        <div><input type="submit" value="Zaloguj"/></div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>

<jsp:include page="footer.jsp"/>