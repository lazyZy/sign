var vm = new Vue({
    el: '#vm',
    data: {
        user:{
            userDepartmentId:""
        },
        departmentName:""
    },
    mounted: function () {
        console.log(localStorage.getItem("token"));
        axios.post('/user/getInfoByToken?token='+localStorage.getItem("token"), {})
            .then(function (response) {
                if (response.data.code === 200) {
                    vm.user = response.data.data;
                    vm.user.userBirthday = vm.user.userBirthday.substring(0,10);
                    axios.post('/user/getDepartmentInfoById?departmentId='+vm.user.userDepartmentId, {})
                        .then(function (response) {
                            if (response.data.code === 200) {
                                vm.departmentName = response.data.data.departmentName;
                            }
                            console.log(response);

                        });
                }else{
                    location.href="/login";
                }
                console.log(response);

            });


    },
    methods: {
        confirm:function(){
            axios.post("/user/register", vm.user)
                .then(function (response) {
                    if (200 === response.data.code ) {
                        localStorage.setItem("token", response.data.data);
                        location.href = "/index";
                    } else {
                        alert("修改失败");
                    }
                })

        }
    }
});

