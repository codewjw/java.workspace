<%@page pageEncoding="utf-8" import="dao.*,java.util.*,entity.*"%>
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
       EmpDao ed = new EmpDao(); 
       List<Emp> emps =ed.findAll(); 
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