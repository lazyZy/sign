<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>企业新人培训系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content=""/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!-- font files  -->
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Nunito:400,300,700' rel='stylesheet' type='text/css'>
    <!-- /font files  -->
    <!-- css files -->
    <link href="${request.contextPath}/css/style.css" rel='stylesheet' type='text/css' media="all"/>
    <!-- /css files -->
</head>
<body>
<h1>企业新人培训系统</h1>
<div id="vm" class="log">
    <div class="content2">
        <h2>Sign Up Form</h2>
        <form>
            <input type="text" v-model="register.userAccount" placeholder="登录账号">
            <input type="password" v-model="register.userPwd" placeholder="密码">
            <input type="text" v-model="register.userName" placeholder="姓名">
            <input type="text" v-model="register.userBirthday" placeholder="生日">
            <input type="date" v-model="register.userBirthday" placeholder="生日">
            <input type="tel" v-model="register.userPhone" placeholder="手机号">
            <input type="email" v-model="register.userEmail" placeholder="邮箱">
            <br>
            <br>
            <div>
                <input v-model="register.userGender" type="radio" value="0"/>女
                <input v-model="register.userGender" type="radio" value="1"/>男
            </div>
            <br>
            <br>
            <input type="submit" class="sign-in" value="注册" v-on:click="toRegister">
            <input type="button" class="reset" value="返回登录" v-on:click="toLogin">
        </form>
    </div>
    <div class="clear"></div>
</div>
<div class="footer">
</div>

</body>
<script src="${request.contextPath}/libs/vue.min.js"></script>
<script src="${request.contextPath}/libs/axios.js"></script>
<script src="${request.contextPath}/js/common/register.js"></script>
</html>