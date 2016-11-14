window.onload=function(){
 var ainput=document.getElementsByTagName('input');

for (var i = 0; i < ainput.length-1; i++) {
	ainput[i].onfocus=function(){
		this.value="";
	}
ainput[1].onclick=function(){
		
ainput[1].type="password";
}

}
}