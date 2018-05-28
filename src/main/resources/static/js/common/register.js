var vm = new Vue({
    el: '#vm',
    data: {
        register: {
            userAccount: "",
            userPwd: "",
            userName: "",
            userGender: "0",
            userBirthday: "",
            userPhone:"",
            userEmail:""
        }
    },
    methods: {

        toLogin: function () {
            console.log("跳转到登录页面！");
            location.href="/login";
        },

        toRegister: function () {
            if(vm.register.userAccount.length < 6){
                alert("账户长度不小于6位");
            }else if(vm.register.userPwd.length < 8){
                alert("密码长度不小于8位");
            }else if(vm.register.userName.length < 2){
                alert("姓名长度不小于两位");
            }else if(vm.register.userPhone.length != 11){
                alert("手机号码非法");
            }else if(vm.register.userEmail.length == 0){
                alert("邮箱不能为空");
            }else{
                axios.post('../../user/register', {
                    userAccount: vm.register.userAccount,
                    userPwd: vm.register.userPwd,
                    userName: vm.register.userName,
                    userGender: vm.register.userGender,
                    userBirthday: vm.register.userBirthday,
                    userPhone: vm.register.userPhone,
                    userEmail: vm.register.userEmail,
                    userStatus: "0",
                    employeeNumber: "0"
                })
                    .then(function (response){
                        console.log(response);
                        // if (response.data.code === 200) {
                        //     alert("注册成功");
                        //     location.href = "/login";
                        // }
                        // if (response.data.code != 200) {
                        //     alert("该账号已被注册");
                        // }

                    });
            }

        }


    }
});

