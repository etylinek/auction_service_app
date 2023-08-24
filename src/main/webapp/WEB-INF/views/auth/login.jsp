<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@include file="../dynamic/head.jspf" %>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Witaj ponownie!</h1>
                                    </div>
                                    <form class="user" action='<c:url value="/login"/>' method="post">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                 aria-describedby="emailHelp"
                                                placeholder="Nazwa konta" name="username" required>
                                        </div>

                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="exampleInputPassword" placeholder="Hasło" name="password" required>
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Remember
                                                    Me</label>
                                            </div>
                                        </div>
                                        <input type="submit" class="btn btn-primary btn-user btn-block" value="Zaloguj">
                                    </form>
<%--                                        <hr>--%>
<%--                                        <a href="../index.html" class="btn btn-google btn-user btn-block">--%>
<%--                                            <i class="fab fa-google fa-fw"></i> Login with Google--%>
<%--                                        </a>--%>
<%--                                        <a href="../index.html" class="btn btn-facebook btn-user btn-block">--%>
<%--                                            <i class="fab fa-facebook-f fa-fw"></i> Login with Facebook--%>
<%--                                        </a>--%>
<%--                                    </form>--%>

                                    <hr>
<%--                                    <div class="text-center">--%>
<%--                                        <a class="small" href="../forgot-password.html">Forgot Password?</a>--%>
<%--                                    </div>--%>
                                    <div class="text-center">
                                        <a class="small" href="<c:url value="/register/"/>">Założ konto!</a>
                                    </div>
                                </div>
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