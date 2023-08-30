<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/head.jspf" %>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <%@include file="../dynamic/sidebar.jspf" %>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <%@include file="../dynamic/topBar.jspf" %>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="d-sm-flex align-items-center justify-content-between mb-4">
                <h1 class="h3 mb-0 text-gray-800">   Dodaj aukcje</h1>
            </div>


            <div class="container-fluid">
                <form method="post" action='<c:url value="/auctions/addAuction"/>'>
                <div class="row">
                    <div class="col-12">


                        <div class="card shadow mb-4">
                            <div class="card-header py-3">


                                <div class="form-group row">
                                    <label class="col-2 col-form-label">Nazwa przedmiotu</label>
                                    <input class="col-10 form-control" type="text" name="name" placeholder="wpisz nazwę">
                                </div>


                                <div class="form-group row">
                                    <label class="col-2 col-form-label">Opis przedmiotu</label>
                                    <textarea class="col-10 form-control" name="description" type="text" rows="4"
                                              placeholder="uzupełnij opis"></textarea>
                                </div>
                                <div class="form-group row">
                                    <label class="col-2 col-form-label">Wybierz kategorie</label>
                                    <select class="form-control" id="sel1" name="categoryModel.id" >

                                        <c:forEach items="${categoryList}" var="example">
                                            <option value="${example.id}">${example.name}</option>
                                        </c:forEach>

                                    </select>
                                </div>

                                <div class="form-group row">
                                    <label class="col-2 col-form-label">Minimalna cena</label>
                                    <input class="col-4 form-control" type="number" name="minValue">

                                    <label class="col-2 col-form-label">Cena Kup Teraz</label>
                                    <input class="col-4 form-control" type="number" name="buyNowValue">
                                </div>

                                <div class="form-group row">
                                    <label class="col-2 col-form-label">Data zakonczneia aukcji</label>
                                    <input class="col-2 form-control" type="datetime-local" name="endDate">



                                    <label class="col-2 col-form-label">Promuj aukcje</label>
                                    <input class="col-1 form-control" type="checkbox" name="isPromoted" value=true>


                                </div>





<%--                                <div class="form-group row">--%>
<%--                                    <label class="col-2 col-form-label">Od czego się zaczęło</label>--%>
<%--                                    <textarea class="col-10 form-control" type="text" rows="5"--%>
<%--                                              placeholder="uzupełnij od czego się zaczęło"></textarea>--%>
<%--                                </div>--%>



                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-success">Wyślij</button>
            </form>
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <%@include file="../dynamic/footer.jspf" %>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<%@include file="../dynamic/logoutModal.jspf" %>

<!-- Bootstrap core JavaScript-->
<%@include file="../dynamic/board.jspf" %>
<%@include file="../dynamic/javaScript.jspf" %>

</body>

</html>