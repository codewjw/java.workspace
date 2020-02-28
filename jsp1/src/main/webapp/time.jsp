<!-- pageEncoding:声明此jsp文件的编码， contentType：声明此jsp文件向浏览器输出的内容格式，
import：导入java代码用到的包-->
<%@page pageEncoding="utf-8" contentType="text/html" import="java.util.Date,java.text.SimpleDateFormat" %>
<% 
  Date date = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
  String  now = sdf.format(date);
%>
 <p><%=now%></p>