<%@page pageEncoding="utf-8" import="entity.*,java.util.*" %>

<!Doctype html>
<html>
<head>
   <meta charset="utf-8" />
   <title>查询员工</title>
   <link rel="stylesheet" href="emp.css" />
 </head>
 <body>
   <table>
     <thead>
       <tr>
         <td>编号</td>
         <td>姓名</td>
         <td>性别</td>
         <td>年龄</td>
         <td>薪水</td>
         <td>部门</td>
       </tr>
     </thead>
     <tbody>
     <%
       List<Emp> emps =(List<Emp>) request.getAttribute("emps");
       for(Emp emp:emps){
      %>
      <tr>
         <td><%=emp.getEmpno() %></td>
         <td><%=emp.getName() %></td>
         <td><%=emp.getGender() %></td>
         <td><%=emp.getAge() %></td>
         <td><%=emp.getSalary() %></td>
         <td><%=emp.getDeptno() %></td>
      </tr>
      <% }
     %>
     </tbody>
     <tfoot></tfoot>
   </table>
   </body>
</html>