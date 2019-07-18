<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:include page="../header.jsp"/>
<div id="page-wrapper" class="p-4">
    <div class="row">
        <div class="col-xl-12">
            <h1 class="page-header">Edycja elementu</h1>
        </div>
        <!-- /.col-xl-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-xl-12">
            <div class="card">

                <!-- /.card-header -->
                <div class="card-body">
<form:form method="post" action="/api/item/edit/${item.id}" modelAttribute="item">
    <div><form:errors path="*" class="has-error" /></div>
    <p>Nazwa: <form:input class="form-control" id="name" path="name" value="${item.name}"/></p>
    <p>Opis: <form:input class="form-control" id="description" path="description" value="${item.description}"/></p>
    <p><form:select class="form-control" path="category" items="${categories}"  itemValue="id" itemLabel="name" value="category" multiple="false"/></p>

<%--    <p><form:input type="hidden" path="itemLocations" value="${item.itemLocations}"/></p>--%>

<%--    <p><form:select path="locations" items="${locations}"  itemValue="id" itemLabel="name" multiple="true"/></p>--%>

    <p><button type="submit" value="Save">Zapisz</button></p>
</form:form>
<jsp:include page="../footer.jsp"/>