<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
 编号:${user.id}<br>
 姓名:${user.name}<br>
 年龄:${user.age}<br>
 性别:${user.sex==0?"女":"男"}<br>
 地址:${user.add}<br>
</body>
</html>