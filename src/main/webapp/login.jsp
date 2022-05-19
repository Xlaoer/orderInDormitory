<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>登录界面</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <div class="form row" style="height: 300px;">
    <form class="form-horizontal col-md-offset-3" action="<%= request.getContextPath()%>/login" method="post">
      <h3 class="form-title">登录</h3>
      <div class="col-md-9">
        <div class="form-group">
          <i class="fa fa-user fa-lg"></i>

          <input class="form-control required" required placeholder="请输入用户名" type="text" name="name"/>
        </div>
        <div class="form-group">
          <i class="fa fa-lock fa-lg"></i>
          <input class="form-control required" required placeholder="请输入密码" type="password" name="password"/>
        </div>
        <span style="color: red;font-size: 13px;margin-left: -17px;">${error}</span>
        <div class="form-group">
          <label class="radio-inline">
            <input type="radio" name="type" checked  value="student" class="radio-inline" > 学生
          </label>
          <label class="radio-inline">
            <input type="radio" name="type" value="admin" class="radio-inline"> 宿管
          </label>
        </div>
        <div class="form-group col-md-offset-9">
          <button type="submit" class="btn btn-success pull-left" name="submit">登录</button>
          <button type="reset" class="btn btn-success pull-right" name="submit">重置</button>
        </div>
        <div class="form-group col-md-offset-9">
          <button class="btn btn-success"><a href="register.jsp">去注册</a></button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>
