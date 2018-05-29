
<nav class="navbar navbar-default top-navbar" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/info"><i class="fa fa-comments"></i> <strong>{{user.userName}}</strong></a>
    </div>
    <ul class="nav navbar-top-links navbar-right">
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
            <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">
            <li><a href="/info"><i class="fa fa-user fa-fw"></i> 用户信息</a>
            </li>
            <li class="divider"></li>
            <li><a href="/login"><i class="fa fa-sign-out fa-fw"></i> 登出</a>
            </li>
        </ul>
        <!-- /.dropdown-user -->
    </li>
    <!-- /.dropdown -->
    </ul>
</nav>
<!--/. NAV TOP  -->
<nav class="navbar-default navbar-side" role="navigation">
    <div id="sideNav" href=""><i class="fa fa-caret-right"></i></div>
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">

            <li>
                <a href="/index"><i class="fa fa-dashboard"></i>主面板</a>
            </li>
            <li>
                <a href="/task"><i class="fa fa-desktop"></i>任务查看</a>
            </li>
            <li>
                <a href="/meeting"><i class="fa fa-bar-chart-o"></i>会议通知</a>
            </li>
            <li v-if="user.userStatus > 8 ">
                <a href="/checkMember"><i class="fa fa-qrcode"></i>人员审核</a>
            </li>
            <li v-if="user.userStatus > 8 ">
                <a href="/adminRegister"><i class="fa fa-qrcode"></i>管理员注册</a>
            </li>

            <li>
                <a href="/member"><i class="fa fa-table"></i>人员管理</a>
            </li>
            <li>
                <a href="form.ftl"><i class="fa fa-edit"></i> Forms </a>
            </li>


            <li>
                <a href="#"><i class="fa fa-sitemap"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="#">Second Level Link</a>
                    </li>
                    <li>
                        <a href="#">Second Level Link</a>
                    </li>
                    <li>
                        <a href="#">Second Level Link<span class="fa arrow"></span></a>
                        <ul class="nav nav-third-level">
                            <li>
                                <a href="#">Third Level Link</a>
                            </li>
                            <li>
                                <a href="#">Third Level Link</a>
                            </li>
                            <li>
                                <a href="#">Third Level Link</a>
                            </li>

                        </ul>

                    </li>
                </ul>
            </li>
        </ul>

    </div>

</nav>
<!-- /. NAV SIDE  -->