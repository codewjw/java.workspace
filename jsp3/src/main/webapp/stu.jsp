<%@page pageEncoding="utf-8" contentType="text/html" %>
<!--引入jstl文件  -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 自定义jstl标签 -->
<%@taglib uri="/lhh-tags" prefix="s" %>
<!Doctype html>
<html>
 <head> 
   <meta charset="utf-8" />
   <title>EL Demo查询学生</title>
 </head>
 <body>
   <!--EL表达式-->
   <!--1.访问Bean的属性  -->
   <p> 
    <!-- 相当于  Student stu =(Student) request.getAttribute("stu"); 
              stu..getName();-->
         姓名：${stu.name}
   </p>
   <p>年龄：${stu['sex']}</p>
   <p>兴趣：${stu.interests[0] }</p>
   <p>课程：${stu.cour.id}</p>
   <!-- EL表达式的取值范围：从四个隐含对象内依次取值，分别是page->
      Request->session->application 也可以明确指定取值范围
              如：requestScope.stu.name  -->
   <p>性别：${requestScope.stu.sex} </p>
   <!-- EL表达式计算-->
   <p>年龄+3：${stu.age+3 }</p>
   <p>介于20到30间 ：${stu.age>20 &&stu.age<30 }</p>
   <p>是否为空：${empty stu.interests }</p>
    <!-- 获取请求参数 -->
   <p>请求参数：${param.username} </p>
   <p>请求参数：${paramValues.city} </p>
   
   <!-- JSTL标签-->
   <p>
    <!--if标签-->    
          性别：
     <!--c:if 表示一个别名为c的命名空间，根据前缀(别名c)去找对应uri，根据uri再找到配置中去  -->
     <!-- c:if 表示命名空间c下的if元素 -->
    <c:if test="${stu.sex=='M'}">男</c:if>
    <c:if test="${stu.sex=='W'} ">女</c:if>
   </p>
   <p>
     <!-- choose标签  -->
          性别：
     <c:choose>
       <c:when test="${stu.sex=='M'}">男</c:when>
       <c:otherwise>女</c:otherwise>
     </c:choose>
   </p>
   <p>
   <!--forEach标签-->
    <c:forEach items="${stu.interests }" var="ints">
      ${ints}
    </c:forEach>
   </p>
   <!--自定义标签  -->
   <p>
           时间
           <s:sysdate format="yyyy-MM-dd" />
   </p>
 </body>
</html>