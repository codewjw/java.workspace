<%@page pageEncoding="utf-8" contentType="text/html" %>
<!Document html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>第一个jsp</title>
  </head>
  <body>
    <!-- jsp声明 -->
     <%! 
     public double multiple(double d){
    	 return d*100;
     } %>
    <ul>
       <%
          for(int i=0;i<10;i++){
        %>
        <!-- 2.jsp表达式 -->
        	<li><%=multiple(Math.random()) %></li>
       <% }
       %>
    </ul>
    <%@include file="time.jsp" %>
  </body>
</html>