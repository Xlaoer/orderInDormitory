<%--
  Created by IntelliJ IDEA.
  User: 12292
  Date: 2022/5/19
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- 引入 Bootstrap -->
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入 font-awesome -->
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>宿舍订货系统</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-10">
            <!-- 顶部搜索部分 -->
            <div class="panel panel-default">
                <div class="panel-heading">模糊搜索</div>
                <div class="panel-body">
                    <form role="form" class="form-inline" action="/search" method="post">
                        <div class="form-group">
                            <label for="name">字段：</label>
                            <select name="key" class="form-control">
                                <option value="username">姓名</option>
                                <option value="domitory">宿舍</option>
                                <option value="date">日期</option>
                                <option value="0">未完成</option>
                                <option value="1">已完成</option>
                            </select>
                        </div>
                        <div class="form-group" style="margin-left: 20px">
                            <label for="value">值：</label>
                            <input type="text" class="form-control" name="value" placeholder="字段值" maxlength="12" style="width: 130px">
                        </div>
                        <div class="form-group " style="margin-left: 20px">
                            <button type="submit" class="btn btn-info ">
										<span style="margin-right: 5px"
                                              class="glyphicon glyphicon-search" aria-hidden="true">
										</span>开始搜索
                            </button>
                        </div>
                        <c:if test="${sessionScope.student!=null}">
                        <div class="form-group " style="margin-left: 48px">
                            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#addOrder">
										<span style="margin-right: 5px" class="" aria-hidden="true">
											<i class="fa fa-user-plus">新增订单</i>
											</span>
                            </button>
                        </div>
                        </c:if>
                    </form>
                </div>
            </div>
            <!-- 列表展示-->
            <div class="table-responsive">
                <table class="table table-hover ">
                    <thead>
                    <tr>
                        <th>订单ID</th>
                        <th>学生姓名</th>
                        <th>宿舍</th>
                        <th>货物详情</th>
                        <th>下单日期</th>
                        <th>订单状态</th>
                        <c:if test="${sessionScope.admin!=null}">
                            <th>操作</th>
                        </c:if>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="orderDTO">
                        <tr>
                            <td>${orderDTO.order.id}</td>
                            <td>${orderDTO.student.name}</td>
                            <td>${orderDTO.dormitory.name}</td>
                            <td>${orderDTO.order.item}</td>
                            <td>${orderDTO.order.createTime}</td>
                            <td>${orderDTO.order.status==0?'待完成':'已完成'}</td>
                            <c:if test="${sessionScope.admin!=null&&orderDTO.order.status==0}">
                                <td>
                                    <form method="post" action="/okOrder" >
                                        <input type="text" value="${orderDTO.order.id}" name="orderid" hidden>
                                        <button type="submit" class="btn btn-success ">
                                            完成订单
                                        </button>
                                    </form>
                                </td>
                            </c:if>
                            <td>
                                <c:if test="${orderDTO.student.id==sessionScope.student.id||sessionScope.admin!=null}">
                                    <form method="post" action="/deleteOrder" >
                                        <input type="text" value="${orderDTO.order.id}" name="orderid" hidden>
                                        <button type="submit" class="btn btn-danger ">
                                            删除
                                        </button>
                                    </form>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>


                <!-- add框 -->
                <form method="post" action="/addOrder" class="form-horizontal" style="margin-top: 0px" role="form"
                      id="form_data" style="margin: 20px;">
                    <div class="modal fade" id="addOrder" tabindex="-1"
                         role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"
                                            aria-hidden="true">x</button>
                                    <h4 class="modal-title" id="myModalLabel">新增订单</h4>
                                </div>
                                <div class="modal-body">
                                    <form class="form-horizontal" role="form">
                                        <input type="text" value="${sessionScope.student.id}" hidden name="studentId">
                                        <input type="text" value="${sessionScope.student.dormitoryId}" hidden name="dormitoryId">
                                        <div class="form-group">
                                            <label  class="col-sm-3 control-label">货物详情</label>
                                            <div class="col-sm-9">
                                                <input type="text" required class="form-control" id="name"
                                                       name="item" value="" placeholder="请输入您要购买的货物">
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                    <button type="submit" class="btn btn-primary">提交</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>


            </div>
        </div>
    </div>
</div>

</body>

</html>