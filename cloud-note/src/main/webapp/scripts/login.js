/* login.js编码为utf-8*/
$(function(){
	$("#login").click(LoginAction);
	$("#count").blur(checkUserName);
	$("#password").blur(checkPasswd);
	$("#regist_button").click(regist);
	$("#regist_username").blur(checkRegistName);
	$("#regist_password").blur(checkRegistPasswd);
	$("#final_password").blur(checkRegistConfirmpwd);
});

function LoginAction(){
	//获取用户名密码
	var username = $("#count").val();
	var passwd =$("#password").val();
	var n = checkUserName()+checkPasswd();
	if(n!=2){
		return;
	}
	var data = {"userName":username,"passwd":passwd};
	$.ajax({
		"url":"user/login.do",
		"type":"post",
		"data":data,
		"dataType":"json",
		"success":function(result){
			if(result.state==0){
				var user = result.data;
			    location.href="edit.html";
			    addCookie("userId",user.userId);
			}else if(result.state==2){
				$("#count").next().html(result.message);
			}else if(result.state==3){
				$("#password").next().html(result.message);
			}else{
				alert(result.message);
			}
		},
		"error":function(e){
			alert("通信失败！")
		}
	});
}

function regist(){
	var n = checkRegistName()+checkRegistPasswd()+checkRegistConfirmpwd();
	if(n!=3){
		return;
	}
	var name = $("#regist_username").val().trim();
	var passwd = $("#regist_password").val().trim();
	var confirm = $("#final_password").val().trim();
	var nick = $("#nickname").val().trim();
	var data = {"name":name,"passwd":passwd,"confirm":confirm,"nick":nick};
	var url = "user/regist.do";
	//$.post封装了$.ajax({})的post请求
	$.post(url,data,function(result){
		if(result.state==0){
		    //history.back();
			$("#back").click();
			$("#count").val(result.data.userName);
			$("password").focus();
			//清空表单
			$("#regist_username").val('');
			$("#regist_password").val('');
			$("#final_password").val('');
			$("#nickname").val('');
			//$("#password").val(result.data.userPasswd);
		}else if(result.state==4){
			$("#regist_username").next().show().find("span").html(result.message);
		}else if(result.state==3){
			$("#regist_password").next().show().find("span").html(result.message);
		}
	});
	/*$.ajax({
		"url":"user/regist.do",
		"type":"post",
		"data":data,
		"dataType":"json",
		"success":function(result){
			if(result.state==0){
				//var user = result.data;
			    location.href="edit.html";
			}else if(result.state==4){
				$("#regist_username").next().show().find("span").html(result.message);
			}else if(result.state==3){
				$("#regist_password").next().show().find("span").html(result.message);
			}
		},
	    "error":function(e){
	    	alert("通信失败");
	    }
	});*/
}

function checkUserName(){
	var rule = /^\w{4,20}$/;
	var name = $("#count").val().trim();
	if(!rule.test(name)){
		$("#count").next().html("4到20位字符");
		return false;
	}
	$("#count").next().html("");
	return true;
}
function checkPasswd(){
	var rule = /^\w{4,20}$/;
	var passwd =$("#password").val();
	if(!rule.test(passwd)){
		$("#password").next().html("4到20位字符");
		return false;
	}
	$("#password").next().html("");
	return true;
}
function checkRegistName(){
	var rule = /^\w{4,20}$/;
	var name = $("#regist_username").val().trim();
	if(rule.test(name)){
		$("#regist_username").next().hide();
		return true;
	}
	$("#regist_username").next().show().find("span").html("4到20位字符");
	return false;
}
function checkRegistPasswd(){
	var rule = /^\w{4,20}$/;
	var passwd = $("#regist_password").val().trim();
	if(rule.test(passwd)){
		$("#regist_password").next().hide();
		return true;
	}
	$("#regist_password").next().show().find("span").html("4到20位字符");
	return false;
}
function checkRegistConfirmpwd(){
	var confirm = $("#final_password").val();
	var passwd =  $("#regist_password").val();
	if(passwd&&confirm==passwd){
		$("#final_password").next().hide();
		return true;
	}
	$("#final_password").next().show().find("span").html("确认密码不一致");
	return false;
}