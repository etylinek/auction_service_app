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
                    <h1 class=" m-0 font-weight-bold text-primary">${user.accountName}</h1>
                    <h5 class=" m-0  text-primary">email: ${user.email} - utworzono: ${user.accountCreationDate}</h5>
                </div>

                <div class="row">

                    <!-- Earnings (Monthly) Card Example -->


                    <div class="col-lg-12">
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <div class="h3 mb-0 text-gray-800 ">Adres:</div>
                                <div class="h5 mb-0 text-gray-800"> <br>${user.address}<br>
                                    </div>
                            </div>

                            <div class="card-body">

                                Województwo: ${user.voievodeship}<br>
                                Miasto: ${user.city}

                            </div>
                        </div>
                    </div>

                    <div class="container-fluid">
                        <form method="post" action='<c:url value="/users/editUser/${user.id}"/>'>
                            <div class="row">
                                <div class="col-12">


                                    <div class="card shadow mb-4">
                                        <div class="card-header py-3">


                                            <div class="form-group row">
                                                <label class="col-2 col-form-label">Nazwa konta</label>
                                                <input class="col-10 form-control" type="text" name="accountName" value="${user.accountName}">
                                            </div>


                                            <div class="form-group row">
                                                <label class="col-2 col-form-label">Hasło</label>
                                                <input class="col-10 form-control" name="password" type="text" placeholder="wpisz hasło">
                                            </div>

                                            <div class="form-group row">
                                                <label class="col-2 col-form-label">E-mail</label>
                                                <input class="col-10 form-control" name="email" type="text" value="${user.email}">
                                            </div>

                                            <div class="form-group row">
                                                <label class="col-2 col-form-label">Województwo</label>
                                                <input class="col-10 form-control" type="text" name="voievodeship" value="${user.voievodeship}">
                                            </div>

                                            <div class="form-group row">
                                                <label class="col-2 col-form-label">Miasto</label>
                                                <input class="col-10 form-control" type="text" name="city" value="${user.city}">
                                            </div>

                                            <div class="form-group row">
                                                <label class="col-2 col-form-label">Ulica i numer domu</label>
                                                <input class="col-10 form-control" type="text" name="address" value="${user.address}">
                                            </div>



                                            <%--                                <div class="form-group row">--%>
                                            <%--                                    <label class="col-2 col-form-label">Od czego się zaczęło</label>--%>
                                            <%--                                    <textarea class="col-10 form-control" type="text" rows="5"--%>
                                            <%--                                              placeholder="uzupełnij od czego się zaczęło"></textarea>--%>
                                            <%--                                </div>--%>


                                        </div>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-success">Edytuj</button>
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