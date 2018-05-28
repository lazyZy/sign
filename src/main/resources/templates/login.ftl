<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- font files  -->
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Nunito:400,300,700' rel='stylesheet' type='text/css'>
    <!-- /font files  -->
    <!-- css files -->
    <link href="${request.contextPath}/css/style.css" rel='stylesheet' type='text/css' media="all" />
    <!-- /css files -->
</head>
<body>
<h1>Unique Login Form</h1>
<div class="log">
    <div class="content1" >
        <h2>Sign In Form</h2>
        <form>
            <input type="text" name="userid" value="USERNAME" >
            <input type="password" name="psw" value="PASSWORD" >
            <div class="button-row">
                <input type="submit" class="sign-in" value="Sign In">
                <input type="reset" class="reset" value="Reset">
                <div class="clear"></div>
            </div>
        </form>
    </div>
    <div class="clear"></div>
</div>
<div class="footer">
</div>

</body>
</html>