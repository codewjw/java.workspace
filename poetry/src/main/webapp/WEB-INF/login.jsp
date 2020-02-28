<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
 <link rel="stylesheet" href="styles/login.css"/>
  <script type="text/javascript" src="scripts/jquery.min.js"></script>
  <script type="text/javascript" src="scripts/cookie_util.js"></script>
  <script type="text/javascript" src="scripts/login.js"></script>
</head>
<body>
 <div id="login" class="l_center">
      <div class="l_center2">
          <p id="msg"><span></span></p>
	      <p><label>用户名：</label><input type="text" value="" name="name" id="uname" /><span></span></p>
		  <p><label>密&nbsp;&nbsp;&nbsp;码：</label><input type="password" value="" name="password" id="psw" /><span></span></p>
		  <p class="btn-position"><input type="button" id="sub-login" value="登录" class="btn-size" /><a id="btn-reg" href="javascript:void(0)" >注册</a></p>
	  </div>
  </div>
  <div id="regist" class="l_center">
     <div class="l_center2">
          <p id="err-msg"><span></span></p>
		  <p><label>用户名&nbsp;&nbsp;&nbsp;：</label><input type="text" value="" name="name" id="rname"/><span></span></p>
		  <p><label>密&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;&nbsp;：</label><input type="password" value="" name="password" id="password" /><span></span></p>
		  <p><label>确认密码：</label><input type="password" value="" name="confirmPsw" id="conformpsw"/><span></span></p>
		  <p><label>昵&nbsp;&nbsp;&nbsp;称&nbsp;&nbsp;&nbsp;：</label><input type="text" value="" name="nick" id="nick" /><span></span></p>
		  <p><label>邮&nbsp;&nbsp;&nbsp;箱&nbsp;&nbsp;&nbsp;：</label><input type="text" value="" name="email" id="email" /><span></span></p>
		  <p class="btn-position"><input type="button" value="注册" id="sub-regist" class="btn-size" /><a id="btn-login" href="javascript:void(0)">登录</a></p>
     </div>
  </div>
</body>
</html>