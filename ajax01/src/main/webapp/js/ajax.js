function getXhr(){
	 var xhr=null;
	 //非ie浏览器
	if(window.XMLHttpRequest){
	xhr = new XMLHttpRequest();
	}else{
	  Xhr = new ActiveXObject('Microsoft.XMLHttp');
	}
	return xhr;
}