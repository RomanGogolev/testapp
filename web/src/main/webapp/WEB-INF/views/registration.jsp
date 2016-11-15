<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../resources/favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="../../resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../resources/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../resources/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../resources/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">
    <h2>${error1}</h2>
    <h2>${error2}</h2>
    <h2>${error3}</h2>
    <h2>${error4}</h2>
    <form class="form-signin" action="${contextPath}/sign-up" method="post" name="registrationform">
        <h2 class="form-signin-heading">Please sign up</h2>
        <input type="text" name="username" id="username" class="form-control" placeholder="Username" required autofocus>
        <input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
        <input type="password" name="confirmPassword" id="confirmPassword" class="form-control" placeholder="Confirm Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
    </form>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../resources/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
