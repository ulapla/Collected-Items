<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:include page="../header.jsp"/>
<div id="page-wrapper" class="p-4">
    <div class="row">
        <div class="col-xl-12">
            <h1 class="page-header">Edycja ilości elementów w lokalizacji</h1>
        </div>
        <!-- /.col-xl-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-xl-12">
            <div class="card">

                <!-- /.card-header -->
                <div class="card-body">
<form:form method="post" action="/api/item/location/edit/${itemLocation.id}" modelAttribute="itemLocation">
    <div><form:errors path="*" class="has-error" /></div>
    <table width="100%" class="table table-striped table-bordered table-hover"
           id="dataTables-example">
        <tr>
            <th>Element</th>
            <th>Miejsce</th>
            <th>Pozycja</th>
        </tr>
        <tr>
            <td>${itemLocation.item.name}</td>
            <td>${itemLocation.location.place}</td>
            <td>${itemLocation.location.position}</td>
        </tr>

    </table>
    <p>Ilość: <form:input class="form-control" path="quantity" value="${quantity}"/></p>
    <form:hidden path="location"/>
    <form:hidden path="item"/>
    <p><button type="submit" value="Save">Zapisz</button></p>
</form:form>
<jsp:include page="../footer.jsp"/>