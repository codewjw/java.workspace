$(function(){
	$("#btn-reg").click(showRegist);
	$("#btn-login").click(showLogin);
	$("#sub-login").click(loginAction);
	$("#sub-regist").click(registAction);
});
//显示注册界面
function showRegist(){
	$("#login").hide();
	$("#regist").show();
}
//显示登录页面
function showLogin(){
	$("#login").show();
	$("#regist").hide();
}

//登录
function loginAction(){
	//获取用户名和密码
	var name = $("#uname").val();
	var password = $("#psw").val();
	var data = {"name":name,"password":password};
	if(!checkUser()){
		return;
	}
	//登录前清空提示语句
	$("#uname").next().html("");
	$("#psw").next().html("");
	$("#msg").children().eq(0).html("");
	$.ajax({
		"url":"user/login.do",
		"type":"post",
		"data":data,
		"dataType":"json",
		"success":function(result){
			if(result.state==0){
				var user = result.data;
				location.href="user/main.do";
				addCookie("userId",user.userId);
			}else if(result.state==2){
			 $("#uname").next().html(result.message);
			 $("#uname").next().addClass("warnColor");
			}else if(result.state==3){
			 $("#psw").next().html(result.message);
			 $("#psw").next().addClass("warnColor");
			}else {
			 $("#msg").children().eq(0).html(result.message);
			 $("#msg").children().eq(0).addClass("warnColor");
			}
		},
		error:function(e){
			alert("登录失败！");
		}
	});
}

//注册
function registAction(){
	//获取用户注册信息
	var name = $("#rname").val();
	var password = $("#password").val();
	var confirmPsw = $("#conformpsw").val();
	var nick = $("#nick").val();
	var email = $("#email").val();
	if(!checkMsg()){
		return;
	}
	console.log(name);
	var data = {"name":name,"password":password,
			"confirmPsw":confirmPsw,"nick":nick,"email":email};
	$.ajax({
		url:"user/regist.do",
		type:"post",
		data:data,
		dataType:"json",
		success:function(result){
			if(result.state==0){
				showLogin();
				$("#uname").val(name);
			}else{
				$("#err-msge").children().eq(0).html(result.message);
				$("#err-msg").children().eq(0).addClass("warnColor");
			}
		},
		error:function(e){
			alert("注册失败！")
		}
	});
	
}

//登录检查
function checkUser(){
	var name = $("#uname").val();
	var password = $("#psw").val();
	if(name==null||name.trim().length==0){
		$("#uname").next().addClass("warnColor");
		$("#uname").next().html("用户名不能为空!");
		return false;
	}
	if(password==null||password.trim().length==0){
		 $("#psw").next().addClass("warnColor");
		 $("#psw").next().html("密码不能为空");
		 return false;
	}
	return true;
}

//注册时候的检查
function checkMsg(){
  var strName = /^[a-zA-Z0-9_-]{6,16}$/;
  var strEmail = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+$/;
  var name = $("#rname").val();
  var password = $("#password").val();
  var confirmPsw = $("#conformpsw").val();
  var nick = $("#nick").val();
  var email = $("#email").val();
  if(!strName.test(name)){
	  $("#rname").next().addClass("warnColor");
	  $("#rname").next().html("6到20位的字母数字或下划线！");
	  return false;
  }
  if(password!=confirmPsw){
	  $("#conformpsw").next().addClass("warnColor");
	  $("#conformpsw").next().html("两次输入密码不一致！");
	  return false;
  }
  if(nick==null||nick.trim().length==0){
	  $("#nick").next().addClass("warnColor");
	  $("#nick").next().html("昵称不能为空");
	  return false;
  }
  if(!strEmail.test(email)){
	  $("#email").next().addClass("warnColor");
	  $("#email").next().html("电子邮件格式错误！");
	  return false;
  }
  return true;
}