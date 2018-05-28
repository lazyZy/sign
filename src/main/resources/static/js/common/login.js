var vm = new Vue({
    el: '#vm',
    data: {
        login: {
            userName: "",
            pwd: ""
        }
    },
    methods: {
        confirm: function () {
            console.log("触发登录按钮");
            if(vm.login.userName.length < 6 ){
                alert("工号或账号过短!");
            }else{
                axios.post("/user/login", {
                    userName: vm.login.userName,
                    pwd: vm.login.pwd
                })
                    .then(function (response) {
                        if (200 === response.data.code ) {
                            localStorage.setItem("token", response.data.data);
                            location.href = "/index";
                        } else {
                            alert("用户名或密码错误！");
                        }
                    })
            }
        },
        toRegister:function () {
                location.href = "/register";
            }
        }

})