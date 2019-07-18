<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:include page="../header.jsp"/>

<div id="page-wrapper" class="p-4">
    <div class="row">
        <div class="col-xl-12">
            <h1 class="page-header">Dodawanie lokalizacji</h1>
        </div>
        <!-- /.col-xl-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-xl-12">
            <div class="card">

                <!-- /.card-header -->
                <div class="card-body">
<form:form role="form" method="post" action="/api/location/add" modelAttribute="location">
    <div><form:errors path="*" class="has-error" /></div>
    <div class="form-group">
    <p>Miejsce: <form:input class="form-control" path="place"/></p>
    <p>Pozycja: <form:input class="form-control" path="position"/></p>
    </p>

    <p><button type="submit" value="Save">Zapisz</button></p>
    </div>
</form:form>
<jsp:include page="../footer.jsp"/>