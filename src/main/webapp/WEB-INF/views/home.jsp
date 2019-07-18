<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<jsp:include page="header.jsp"/>
<div id="page-wrapper" class="p-4">
    <div class="row">
        <div class="col-xl-12">
            <h1 class="page-header">Strona główna</h1>
        </div>
        <!-- /.col-xl-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-xl-12">
            <div class="card">

                <!-- /.card-header -->
                <div class="card-body">


<h2 class="page-header">Ilość wszystkich elementów: ${quantityAll}</h2>
    <form action="/api/item/search/" method="post">
        Nazwa: <input type="text" class="form-control" name="name"/>
        <input type="hidden" name="description"/>
        <button type="submit">Szukaj</button>
    </form>

<jsp:include page="footer.jsp"/>
