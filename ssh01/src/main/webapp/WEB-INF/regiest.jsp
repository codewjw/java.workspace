<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 <c:url var="url" value="/user/regiest.action" ></c:url>
 <form action="${url}" method="post">
   <div>
   <div>
     <label>用户名：</label>
     <input type="text" name="user.username" />
   </div>
   <div>
     <label>密码：</label>
     <input type="password" name="user.password" />
   </div>
    <div>
     <label>昵称：</label>
     <input type="text" name="user.nick" />
   </div>
   <input type="submit" value="登录"/>
  </div>
  </form>
</body>
</html>