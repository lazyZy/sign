<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<#include "common/libs.ftl">
</head>

<body>
<div id="vm">
    <div id="wrapper">
    <#include "common/menu.ftl">
        <div id="page-wrapper">
            <div id="page-inner">

                <div class="row">
                    <div class="col-md-12">
                        <h1 class="page-header">
                            个人信息
                            <small>个人信息</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li><a href="#">个人信息</a></li>
                            <li class="active">个人信息</li>
                        </ol>
                    </div>
                </div>


                <!-- Article main content -->
                <div class="row">
                    <header class="page-header">
                        <h1 class="page-title">个人信息</h1>
                    </header>

                    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <form id="vm">
                                    <div class="top-margin">
                                        <label>账号 <span class="text-danger">*</span></label>
                                        <input type="text" class="form-control" v-model="user.userAccount"/>
                                    </div>
                                    <div class="top-margin">
                                        <label>邮箱 <span class="text-danger">*</span></label>
                                        <input type="email" class="form-control" v-model="user.userEmail">
                                    </div>
                                    <div class="top-margin">
                                        <label>工号 <span class="text-danger">(不可修改)</span></label>
                                        <span type="text" class="form-control">{{user.employeeNumber}}</span>
                                    </div>
                                    <div class="top-margin">
                                        <label>密码 <span class="text-danger">*</span></label>
                                        <input type="password" class="form-control" v-model="user.userPwd">
                                    </div>
                                    <div class="top-margin">
                                        <label>姓名 <span class="text-danger">*</span></label>
                                        <input type="text" class="form-control" v-model="user.userName">
                                    </div>
                                    <div class="top-margin">
                                        <label>所在部门 <span class="text-danger">(不可修改)</span></label>
                                        <span type="text" class="form-control">{{departmentName}}</span>
                                    </div>
                                    <div class="top-margin">
                                        <label>性别 <span class="text-danger">*</span></label>
                                        <br/>
                                        <input v-model="user.userGender" type="radio" value="0"/>女
                                        <input v-model="user.userGender" type="radio" value="1"/>男
                                    </div>
                                    <div class="top-margin">
                                        <label>生日 <span class="text-danger">*</span></label>
                                        <input type="date" class="form-control" v-model="user.userBirthday"/>
                                    </div>
                                    <div class="top-margin">
                                        <label>手机号 <span class="text-danger">*</span></label>
                                        <input type="tel" class="form-control" v-model="user.userPhone"/>
                                    </div>
                                    <hr>
                                    <div class="row">
                                        <div class="col-lg-8">
                                        </div>
                                        <div class="col-lg-4 text-right">
                                            <span class="btn btn-action" type="submit" v-on:click="confirm">修改</span>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>

            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
    </div>
    <!-- /. WRAPPER  -->
</div>


</body>
<script src="${request.contextPath}/js/common/info.js"></script>
</html>