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

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class=" m-0 font-weight-bold text-primary">${singleAuction.name}</h1>
                    <h5 class=" m-0  text-primary">${singleAuction.categoryModel.name}
                        - ${singleAuction.categoryModel.description}</h5>
                </div>

                <div class="row">

                    <!-- Earnings (Monthly) Card Example -->


                    <div class="col-lg-12">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <div class="h3 mb-0 text-gray-800 ">Opis:</div>
                                <br>
                                <div class="h5 mb-0 text-gray-800">${singleAuction.description}</div>
                            </div>

                            <div class="card-body">
                                Cena: ${singleAuction.minValue}
                                <form method="post" action='<c:url value="/bidding/placeBid/${singleAuction.id}"/>'>
                                    <label class="col-2 col-form-label">Licytuj: </label>
                                    <input class="col-4 form-control" type="number" name="proposedValue">
                                    <button class="btn btn-danger" type="submit">
                                        <i> Licytuj! </i>
                                    </button>
                                </form>

                            </div>

                            <div class="card-body">

                                Cena: ${singleAuction.buyNowValue}
                                <form method="post"
                                      action='<c:url value="/auctions/auctionDetails/${singleAuction.id}"/>'>
                                    <button class="btn btn-danger" type="submit">
                                        <i> Kup Teraz! </i>
                                    </button>
                                </form>

                            </div>

                            <c:forEach items="${bidding}" var="example">
                                <div class="h5 mb-0 text-gray-800">
                                    Użytkownik: ${example.userModel.accountName} Kwota: ${example.value}  Data: ${example.bidTime}
                                </div>
                            </c:forEach>

                        </div>
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