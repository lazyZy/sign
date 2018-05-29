var vm = new Vue({
    el: '#vm',
    data: {
        user:"",
        tasks:[]
    },
    mounted: function () {
        console.log(localStorage.getItem("token"));
        axios.post('/user/getInfoByToken?token='+localStorage.getItem("token"), {})
            .then(function (response) {
                if (response.data.code === 200) {
                    vm.user = response.data.data;
                    axios.post('/user/getInfoByToken?token='+localStorage.getItem("token"), {})
                        .then(function (response) {
                            if (response.data.code === 200) {
                                vm.user = response.data.data;
                            }
                            console.log(response);

                        });
                }else{
                    alert("请登录");
                    location.href="/login";
                }
                console.log(response);

            });


    },
    methods: {

    }
});

