<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/head.jspf" %>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Załóż konto!</h1>
                            </div>
                            <form class="user" method="post" action='<c:url value="/register/"/>'>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="exampleFirstName"
                                            placeholder="Nazwa konta" name="accountName">
                                    </div>
<%--                                    <div class="col-sm-6">--%>
<%--                                        <input type="text" class="form-control form-control-user" id="exampleLastName"--%>
<%--                                            placeholder="Last Name">--%>
<%--                                    </div>--%>
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" id="exampleInputEmail"
                                        placeholder="E-mail" name="email" >
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="exampleInputEmail"
                                           placeholder="Ulica i numer domu" name="address">
                                </div>

                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                               id="exampleInputPassword" placeholder="Miasto" name="city">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user"
                                               id="exampleRepeatPassword" placeholder="Województwo" name="voievodeship" >
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user"
                                            id="exampleInputPassword" placeholder="Hasło" name="password">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="exampleRepeatPassword" placeholder="Powtórz hasło">
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary btn-user btn-block">
                                    Załóż konto
                                </button>
                            </form>
<%--                                <hr>--%>
<%--                                <a href="../index.html" class="btn btn-google btn-user btn-block">--%>
<%--                                    <i class="fab fa-google fa-fw"></i> Register with Google--%>
<%--                                </a>--%>
<%--                                <a href="../index.html" class="btn btn-facebook btn-user btn-block">--%>
<%--                                    <i class="fab fa-facebook-f fa-fw"></i> Register with Facebook--%>
<%--                                </a>--%>
<%--                            </form>--%>
<%--                            <hr>--%>
<%--                            <div class="text-center">--%>
<%--                                <a class="small" href="../forgot-password.html">Forgot Password?</a>--%>
<%--                            </div>--%>
                            <div class="text-center">
                                <a class="small" href="<c:url value="../login/"/>">Masz już konto? Zaloguj się!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <%@include file="../dynamic/board.jspf" %>
    <%@include file="../dynamic/javaScript.jspf" %>

    <!-- Core plugin JavaScript-->
    <script src='<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js"/>'></script>

    <!-- Custom scripts for all pages-->
    <script src='<c:url value="/resources/js/sb-admin-2.min.js"/>'></script>

</body>

</html>