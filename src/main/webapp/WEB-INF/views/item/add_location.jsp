<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:include page="../header.jsp"/>

<div id="page-wrapper" class="p-4">
    <div class="row">
        <div class="col-xl-12">
            <h1 class="page-header">Dodawanie lokalizacji elementu</h1>
        </div>
        <!-- /.col-xl-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-xl-12">
            <div class="card">

                <!-- /.card-header -->
                <div class="card-body">
                    <form:form method="post" action="/api/item/add/location" modelAttribute="itemLocation">
                    <div><form:errors path="*" class="has-error"/></div>
                    <p>Nazwa: ${item.name}</p>

                    <form:input type="hidden" path="item" name="item.id" value="${item.id}"/>
                    <p><form:select class="form-control" path="location" items="${locations}" itemValue="id"
                                    itemLabel="name" multiple="false"/>
                    <p>Ilość: <form:input class="form-control" id="quantity" path="quantity"/></p>
                    </p>

                    <p>
                        <button type="submit" value="Save">Zapisz</button>
                    </p>
                    </form:form>
<jsp:include page="../footer.jsp"/>