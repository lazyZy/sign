<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>企业新人培训系统</title>
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
<h1>企业新人培训系统</h1>
<div id="vm" class="log">
    <div class="content1" >
        <h2>登录</h2>
        <form>
            <input type="text" v-model="login.userName" placeholder="用户名">
            <input type="password" v-model="login.pwd" placeholder="密码">
            <div class="button-row">
                <input type="submit" class="sign-in" value="登录" v-on:click="confirm">
                <input type="button" class="reset" value="注册" v-on:click="toRegister">
                <div class="clear"></div>
            </div>
        </form>
    </div>
    <div class="clear"></div>
</div>
<div class="footer">
</div>

</body>
<script src="${request.contextPath}/libs/vue.min.js"></script>
<script src="${request.contextPath}/libs/axios.js"></script>
<script src="${request.contextPath}/js/common/login.js"></script>
</html>