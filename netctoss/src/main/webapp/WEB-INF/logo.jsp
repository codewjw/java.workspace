<%@page pageEncoding="utf-8" %>
 <img src="images/logo.png" alt="logo" class="left"/>
 <!--EL表达式默认从四个隐含对象中取值，page-request-session-application 
   但它也有能力从Cookie中取值，语法cookie.name.value-->
<%--  <span>${cookie.user.value}</span> --%>
<!--session中取用户-->
<span>${user}</span>
<a href="#">[退出]</a>   