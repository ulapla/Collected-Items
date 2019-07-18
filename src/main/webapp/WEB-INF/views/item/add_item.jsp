<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:include page="../header.jsp"/>

<div id="page-wrapper" class="p-4">
    <div class="row">
        <div class="col-xl-12">
            <h1 class="page-header">Dodawanie elementu</h1>
        </div>
        <!-- /.col-xl-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-xl-12">
            <div class="card">

                <!-- /.card-header -->
                <div class="card-body">
<form:form method="post" action="/api/item/add" modelAttribute="item">
    <div><form:errors path="*" class="has-error" /></div>
    <p>Nazwa: <form:input class="form-control" id="name" path="name"/></p>

    <p>Opis: <form:input class="form-control" id="description" path="description"/></p>

    <p><form:select class="form-control" path="category" items="${categories}"  itemValue="id" itemLabel="name" multiple="false"/>

    </p>

    <p><button type="submit" value="Save">Zapisz</button></p>
</form:form>
<jsp:include page="../footer.jsp"/>
