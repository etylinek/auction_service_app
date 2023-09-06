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
                    <h1 class="h3 mb-0 text-gray-800">Aukcje</h1>
                </div>

                <div class="row">

                    <!-- Earnings (Monthly) Card Example -->

                    <c:forEach items="${auctions}" var="example">
                        <%--                        <div class="col-xl-6 col-md-6 mb-4">--%>
                        <%--                            <div class="card border-left-primary shadow h-100 py-2">--%>
                        <%--                                <div class="card-body">--%>
                        <%--                                    <div class="row no-gutters align-items-center">--%>
                        <%--                                        <div class="col mr-2">--%>
                        <%--                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">--%>
                        <%--                                                    ${example.name}</div>--%>
                        <%--                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${example.minValue}</div>--%>
                        <%--                                        </div>--%>
                        <%--                                        <div class="card-body">--%>
                        <%--                                                ${example.description}--%>
                        <%--                                        </div>--%>
                        <%--                                        <div class="col-auto">--%>
                        <%--                                            <i class="fas fa-calendar fa-2x text-gray-300"></i>--%>
                        <%--                                        </div>--%>
                        <%--                                    </div>--%>
                        <%--                                </div>--%>
                        <%--                            </div>--%>
                        <%--                        </div>--%>

                        <div class="col-lg-6">
                            <div class="card shadow mb-4">
                                <a href='<c:url value="/auctions/auctionDetails/${example.id}"/>'>
                                    <div class="card-header py-3">

                                        <h5 class="m-0 font-weight-bold text-primary">${example.name}
                                            <c:choose>
                                                <c:when test="${example.promoted==true}">
                                                    <h6 align="right">Promowane!</h6>
                                                </c:when>
                                            </c:choose>
                                        </h5>
                                        <br>
                                        <div class="h6 mb-0 text-gray-800">
                                            Data rozpoczecia: ${example.startDate} <div class="float-right"> Data zakonczenia: ${example.endDate}</div></div>
                                        <br>

                                        <div class="h6 mb-0 text-gray-800">
                                            Miasto: ${example.userModel.city} <div class="float-right"> Województwo: ${example.userModel.voievodeship}</div></div>
                                        <br><br>


                                        <div class="h5 mb-0 font-weight-bold text-gray-800">
                                            Licytacja: ${example.minValue} <br> Kup Teraz!: ${example.buyNowValue}</div>
                                    </div>

                                    <div class="card-body">
                                            ${example.description}
                                    </div>
                                </a>
                            </div>
                        </div>
                        </a>

                    </c:forEach>


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