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
                <h1 class="h3 mb-0 text-gray-800">Wyszukaj aukcje</h1>
            </div>


            <div class="container-fluid">
                <form method="post" action='<c:url value="/auctions/detailSearch"/>'>
                    <div class="row">
                        <div class="col-12">


                            <div class="card shadow mb-4">
                                <div class="card-header py-3">


                                    <div class="form-group row">
                                        <label class="col-2 col-form-label">Miasto</label>
                                        <input class="col-10 form-control" type="text" name="city"
                                               placeholder="wpisz miasto">

                                        <label class="col-2 col-form-label">Województwo</label>
                                        <input class="col-10 form-control" name="voievodeship" type="text"
                                                  placeholder="wpisz wojewodzwo"></input>
                                    </div>
                                    <div class="form-group row">


                                        <label class="col-2 col-form-label">Sortowanie wg czasu dodania aukcji lub końca</label>
                                        <input class="col-4 form-control" type="number" name="sortDateType">


                                        <label class="col-2 col-form-label">Sortowanie wg ceny</label>
                                        <input class="col-4 form-control" type="number" name="sortByValue">
                                        <%--                                    <select id="cars">--%>
                                        <%--                                        <option value="1"  type="number" name="sortDateType">start</option>--%>
                                        <%--                                        <option value="2" type="number" name="sortDateType">end</option>--%>
                                        <%--                                    </select>--%>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-2 col-form-label">minimalna cena</label>
                                        <input class="col-4 form-control" type="number" name="buyNow">
                                    </div>

                                </div>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-success">Szukaj</button>
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