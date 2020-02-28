//scripes/note.js
var SUCCESS = 0;
var ERROR= 1;

$(function(){
	$(document).data('page',0);
	//网页加载以后立即读取笔记本列表
	//loadNoteBooks();
	loadPagedNotebook();
	//冒泡机制绑定点击事件,笔记本点击事件
	//在div上绑定事件，区分事件源
	//click绑定事件无法区分事件源
	//$("#notebook-list").on('click','li',loadNotes);
	$("#notebook-list").on('click','.notebook',loadNotes);
	$("#notebook-list").on('click','.more',loadPagedNotebook);
	$("#note-list").on('click','li',showNoteContent);
	$("#note-list").on('click','#add_note',showAddNoteDialog);
	$("#can").on("click",".create-note",addNote);
	$("#can").on("click",".cancel,.close",cancelNote);
	$("#save_note").click(saveNote);
	$("#note-list").on("click",".btn-note-menu",showNoteMenu)
	//监听document事件
	$(document).click(hideNoteMenu);
	//移动笔记
	$("#note-list").on('click','.btn_move',showMoveToNoteBookDialog)
	$("#can").on("click",".ensure",saveMoveNote)
	//删除笔记
	$("#note-list").on('click','.btn_delete',deletenNote);
	//回收站按钮绑定事件
	$("#trash_button").click(showTrashBin);
	//回收站li绑定事件
	$("#trash-bin").on("click","li",showNoteContent)
	
	$("#trash-bin").on("click",".btn_replay",updateStatus);
	$("#trash-bin").on("click",".btn_delete",deletenNote2);
	//startHartbet();
});

//定时器发请求，测试用户是否一直都登录着
/*function startHartbet(){
	var url = "user/hart.do";
	//setTimeout(function(){},5000);
	setInterval(function(){
		$.getJSON(url,function(result){
			console.log(result.message);
		});
	},5000);
}*/

/*分页*/
function loadPagedNotebook(){
	var page = $(document).data('page');
	var userId = getCookie('userId');
	var url = "notebook/page.do";
	var data = {userId:userId,page:page};
	//从服务器拉取数据
	$.getJSON(url,data,function(result){
		if(result.state==0){
			var notebooks = result.data;
			showPagedNotebooks(notebooks,page);
			$(document).data('page',page+1);
		}else{
			alert(result.message);
		}
	});
}

function showPagedNotebooks(notebooks,page){
	var ul = $("#notebook-list ul");
	if(page==0){//第一页的时候清空
		ul.empty();
	}else{//从第二页开始追加
		ul.find(".more").remove();
	}
	for(var i=0;i<notebooks.length;i++){
		var notebook = notebooks[i];
		var li = '<li class="online notebook"><a>'+
		  '<i class="fa fa-book" title="online" rel="tooltip-bottom">'+
	      '</i> [name]</a></li>';
		li = $(li.replace('[name]',notebook.cn_notebook_name));
		li.data('notebookId',notebook.cn_notebook_id);
		ul.append(li);
	}
	if(notebooks.length!=0){
		ul.append(moreTem);
	}
}
var moreTem = "<li class='online more'><a><i class='fa fa-plus' title='online' +" +
		"rel='tooltip-bottom'></i>加载更多...</a></li>";

function loadNoteBooks(){
	var url= "notebook/list.do";
	var data = {userId:getCookie('userId')};
	//利用ajax从服务器获取数据
	/*$.post(url,data,function(data){	
	});*/
	//$.ajax({});
	$.getJSON(url,data,function(result){
		if(result.state == SUCCESS){
			var notebooks = result.data;
			showNoteBooks(notebooks);
		}else{
			alert(result.message);
		}
	});
}
function showNoteBooks(data){
	var ul = $("#notebook-list ul");
	//先清空ul
	ul.empty();
	//i标签是定义的字体图标
	var Template= '<li class="online notebook"><a>'+
		  '<i class="fa fa-book" title="online" rel="tooltip-bottom">'+
	      '</i> [name]</a></li>';
	
	for(var i=0;i<data.length;i++){
		var li = $(Template.replace('[name]',data[i].cn_notebook_name));
		//绑定数据，将notebookId绑定到li上
		li.data('notebookId',data[i].cn_notebook_id);
		ul.append(li);
	}
}

function loadNotes(e){
	//var obj = e.target;
	//影藏回收站，显示笔记列表
	$("#trash-bin").hide();
	$("#note-list").show();
	
	var li = $(this);//当前被点击的对象
	//清除之前的选定样式
	li.parent().find('a').removeClass('checked');
	//在被点击的对象上增加选定效果
	li.find('a').addClass('checked');
	var url = 'note/findnotes.do';
	var data = {notebookId:li.data('notebookId')}
	//绑定被点击的notebookId到document中，以备后面用
	$(document).data('notebookId',li.data('notebookId'))
	$.getJSON(url,data,function(result){
		if(result.state==0){
			showNotes(result.data);
		}else{
			alert(result.message);
		}
	});
}

function showNotes(notes){
	var template = '<li class="online"><a>'+
	'<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+
	'[title]<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down btn-note-menu">'+
	'<i class="fa fa-chevron-down"></i></button></a>'+
	'<div class="note_menu" tabindex="-1">'+
	'<dl>'+
		'<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至...">'+
		'<i class="fa fa-random"></i></button></dt>'+
		'<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享">'
		+'<i class="fa fa-sitemap"></i></button></dt>'
		+'<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除">'+
		'<i class="fa fa-times"></i></button></dt>'
	+'</dl>'
    +'</div>'
    +'</li>';
    var ul = $("#note-list ul");
    ul.empty();
	for(var i=0;i<notes.length;i++){
		  var li = $(template.replace('[title]',notes[i].title));
		  li.data('noteId',notes[i].cn_note_id);
		  ul.append(li);
	}
}

function showNoteContent(){
	var li = $(this);
	//清除之前的选定样式
	li.parent().find('a').removeClass('checked');
	//在被点击的对象上增加选定效果
	li.find('a').addClass('checked');
	var url = "note/findnote.do";
	var data = {"noteId":li.data('noteId')};
	$.post(url,data,function(result){
		if(result.state==0){
			$("#input_note_title").val(result.data.noteTitle);
			um.setContent(result.data.noteBody);
			$(document).data("noteTitle",result.data.noteTitle);
			$(document).data("noteBody",result.data.noteBody);
			$(document).data("noteId",li.data('noteId'));
		}else{
			alert(result.message);
		}
	});
}

function showAddNoteDialog(){
	if( $("#notebook-list ul .checked").parent().data('notebookId')){
		$("#can").load('alert/alert_note.html',function(){
			$("#input_note").focus();
		});
		$(".opacity_bg").show();
	}else {
		alert("请先选择笔记本");
	}
	
}

//创建笔记
function addNote(){
	if(!checkNoteContent()){
		return;
	}
	var url="note/addnote.do";
	var li = $("#notebook-list ul .checked").parent();
	if(li.data('notebookId')){
		data = {"notebookId":li.data('notebookId'),
				"userId":getCookie('userId'),
				"title":$("#input_note").val()};
		$.post(url,data,function(result){
			if(result.state==0){
				appendNote(result.data);
				cancelNote();
			}else{
				alert(result.message);
			}
		});
	}else{
		alert("您选择的笔记本为已取消");
	}
	
}
//取消创建笔记，关闭窗口
function cancelNote(){
	$(".opacity_bg").hide();
	$("#can").empty();
}

function checkNoteContent(){
	if($("#input_note").val()){
		return true;
	}
	alert("请先输入笔记名称！");
	return false;
}

//追加笔记
function appendNote(noteId){
	var template = '<li class="online"><a>'+
	'<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>'+
	'[title]<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down">'+
	'<i class="fa fa-chevron-down"></i></button></a>'+
	'<div class="note_menu" tabindex="-1">'+
	'<dl>'+
		'<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至...">'+
		'<i class="fa fa-random"></i></button></dt>'+
		'<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享">'
		+'<i class="fa fa-sitemap"></i></button></dt>'
		+'<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除">'+
		'<i class="fa fa-times"></i></button></dt>'
	+'</dl>'
    +'</div>'
    +'</li>';
    var ul = $("#note-list ul");
    var li = $(template.replace('[title]',$("#input_note").val()));
	li.data('noteId',noteId);
	ul.append(li);
}

//保存笔记
function saveNote(){
   var data = getData();
   if(data){
	   var url = "note/updatenote.do";
	   $.post(url,data,function(result){
		   if(result.state==0){
			   console.log(result);
			   alert(result.data.noteTitle+"修改成功")
		   }else{
			   alert(result.message);
		   }  
	   });
   }
}

function getData(){
	 var title = $("#input_note_title").val();
	 var currentBody = um.getContent();
	 var old_title = $(document).data("noteTitle");
	 var old_body = $(document).data("noteBody");
	 var data = null;
	 var noteId = $(document).data("noteId");
	 if(title&&currentBody&&title!=old_title&&currentBody!=old_body){
		 data = {"noteId":noteId,"noteTitle":title,"noteBody":currentBody};
	 }
	 if(title&&title!=old_title&&currentBody==old_body){
		 data = {"noteId":noteId,"noteTitle":title};
	 }
	 if(currentBody&&currentBody!=old_body&&title==old_title){
		 data = {"noteId":noteId,"noteBody":currentBody};
	 }
	 return data;
}

//显示笔记菜单
function showNoteMenu(){
	var btn=$(this);
	//只弹出被选定的笔记项的菜单
    btn.parent('.checked').next().toggle();
    return false; //阻止事件继续传播，阻止其传播给document
}
//document点击事件，影藏笔记菜单
function hideNoteMenu(){
	//弹出菜单前，先影藏已经弹出的菜单
	//hide也是个异步方法,菜单收起来以后再弹出新的菜单
	 $(".note_menu").hide();
}

//显示移动笔记的对话框
function showMoveToNoteBookDialog(){
	var li =  $(this).parent().parent().parent().parent();
	//保存当前选中的noteId
	$(document).data("noteId",li.data("noteId"));
	var url = "notebook/list.do";
	var data = {"userId":getCookie("userId")};
	if($("#can").html()){
		$("#can").empty();
	}
	$("#can").load('alert/alert_move.html',function(){
		$.post(url,data,function(result){
			//往select控件上绑定数据
			for(var i=0;i<result.data.length;i++){
				var option = ' <option value="'+result.data[i].cn_notebook_id+'">'+
				result.data[i].cn_notebook_name+'</option>';
				$("#moveSelect").append($(option));
			}
			
		});
	});
}
function saveMoveNote(){
	if(!checkSelect){
		return;
	}
	var noteId = $(document).data("noteId");
	var notebookId = $("#moveSelect").val();
	var url = "note/movenote.do";
	var data = {"noteId":noteId,"notebookId":notebookId}
	$.post(url,data,function(result){
		if(result.state==0){
			alert("笔记"+result.data.noteTitle+"移动成功");
			$("#can").empty();
		}else{
			alert(result.message);
		}
	});
}
function checkSelect(){
	if($("#moveSelect").val()=="none"){
		alert("请选择变更的笔记本");
		return false;
	}
	var notebookId = $(document).data('notebookId');
	if($("#moveSelect").val()==notebookId){
		alert("您选择是原笔记本，请重新选择");
		return false;
	}
	return true;
}

//删除笔记
function deletenNote(){
	var btn = $(this);
	if(confirm("确认要删除该笔记吗？")){
		var li = btn.parent().parent().parent().parent();
		var noteId = li.data("noteId");
		var url = "note/deletenote.do";
		var data = {"noteId":noteId};
		$.post(url,data,function(result){
			if(result.state==0){
				alert(result.data.noteTitle+"被成功删除")
			}else{
				alert(result.message);
			}
		});
	}
}

//删除笔记
function deletenNote2(){
	var btn = $(this);
	if(confirm("确认要删除该笔记吗？")){
		var li = btn.parent().parent();
		var noteId = li.data("noteId");
		var url = "note/deletenote.do";
		var data = {"noteId":noteId};
		$.post(url,data,function(result){
			if(result.state==0){
				alert(result.data.noteTitle+"被成功删除")
			}else{
				alert(result.message);
			}
		});
	}
}


function showTrashBin(){
	//显示回收站，影藏笔记列表
	$("#note-list").hide();
	$("#trash-bin").show();
	var ul = $("#trash-bin ul");
	var url = "note/findnotesbystate.do";
	var data = {"notebookId":$(document).data("notebookId")};
	var template ='<li class="disable">'+
		'<a ><i class="fa fa-file-text-o" title="online" rel="tooltip-bottom">'+
		'</i> [title]<button type="button" '+
		'class="btn btn-default btn-xs btn_position btn_delete">'+
		'<i class="fa fa-times"></i></button><button type="button"'+
		' class="btn btn-default btn-xs btn_position_2 btn_replay">'+
		'<i class="fa fa-reply"></i></button></a></li>';
	$.post(url,data,function(result){
		if(result.state==0){
			console.log(result);
			for(var i=0;i<result.data.length;i++){
				var li = $(template.replace("[title]",result.data[i].title));
				li.data("noteId",result.data[i].cn_note_id);
				ul.append(li);
			}
		}else{
			alert(result.message);
		}
	});
}

function updateStatus(){
	var btn = $(this);
	var li = btn.parent().parent();
	var data = {"noteId":li.data("noteId"),"noteStatusId":"1"};
	var url = "note/updatestatus.do";
	$.post(url,data,function(result){
		if(result.state==0){
			alert(result.data.noteTitle+"状态更新成功！");
		}else{
			alert(result.message);
		}
	});
}
