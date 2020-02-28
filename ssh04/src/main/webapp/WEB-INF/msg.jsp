<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <!--引入struts提供的标签库，声明OPNL标签来源 -->
 <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
  <h1>ValueStack</h1>
  <!-- OGNL表达式 -->
  <s:property value="message"/></br>
  <s:property value="[1].message"/><br/>
  <s:property value="#session.name"/></br>
  <!--EL表达式获取数据的形式-->
  ${message} <br/>
  ${session.name}
  <!-- 输出ValueStack存储的数据  -->
  <s:debug></s:debug>
</body>
</html>