<%--
  Created by IntelliJ IDEA.
  User: 12292
  Date: 2022/5/19
  Time: 15:45
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
            <!-- 列表展示-->
            <div class="table-responsive">
                <table class="table table-hover ">
                    <thead>
                    <tr>
                        <th>学生姓名</th>
                        <th>性别</th>
                        <th>学生宿舍</th>
                        <th>学生状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="studentDTO">
                        <tr>
                            <td>${studentDTO.student.name}</td>
                            <td>${studentDTO.student.gender}</td>
                            <td>${studentDTO.dormitory.name}</td>
                            <td>${studentDTO.student.status==0?'待激活':'已激活'}</td>
                            <td>
                                <c:if test="${sessionScope.admin!=null&&studentDTO.student.status==0}">
                                <form method="post" action="/okStudent" >
                                    <input type="text" value="${studentDTO.student.id}" name="studentid" hidden>
                                    <button type="submit" class="btn btn-success ">
                                        激活
                                    </button>
                                </form>
                                </c:if>
                                <form method="post" action="/deleteStudent" >
                                    <input type="text" value="${studentDTO.student.id}" name="studentid" hidden>
                                    <button type="submit" class="btn btn-danger ">
                                        删除
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>


            </div>
        </div>
    </div>
</div>

</body>

</html>