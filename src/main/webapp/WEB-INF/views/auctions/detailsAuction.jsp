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
                    <h1 class="h3 mb-0 text-gray-800">${singleAuction.name}</h1>
                </div>

                <div class="row">

                    <!-- Earnings (Monthly) Card Example -->


                    <div class="col-lg-6">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">${singleAuction.name}</h6>
                            </div>
                            <div class="h5 mb-0 font-weight-bold text-gray-800">${singleAuction.description}</div>
                            <div class="card-body">
                                    ${singleAuction.categoryModel.description}
                            </div>
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