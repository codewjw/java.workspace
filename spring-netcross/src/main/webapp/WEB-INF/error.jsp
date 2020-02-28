<%@page pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            var timer;
            //启动跳转的定时器
            function startTimes() {
                timer = window.setInterval(showSecondes,1000);
            }

            var i = 5;
            function showSecondes() {
                if (i > 0) {
                    i--;
                    document.getElementById("secondes").innerHTML = i;
                }
                else {
                    window.clearInterval(timer);
                    /* 浏览器地址以地址栏为准，浏览器本身访问一个正确页面出错，被转发给error.jsp，
                                                 但浏览器地址不会变，5秒后再转发时，会根据浏览器地址来计算相对路径，但这里是之前的路径，
                                                 不是error的路径，所以这里用相对路径就不一定会正确，此处应该用绝对路径*/
                    location.href = "/spring-netctoss/toLogin.do";
                }
            }

            //取消跳转
            function resetTimer() {
                if (timer != null && timer != undefined) {
                    window.clearInterval(timer);
                    location.href = "/spring-netctoss/toLogin.do";
                }
            }
        </script> 
    </head>
    <body class="error_page" onload="startTimes();">
        <h1 id="error">
	        遇到错误，&nbsp;<span id="secondes">5</span>&nbsp;秒后将自动跳转，立即跳转请点击&nbsp;
            <a  href="javascript:resetTimer();">返回</a>
        </h1>
    </body>
</html>
