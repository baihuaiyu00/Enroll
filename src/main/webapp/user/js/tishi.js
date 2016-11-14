window.onload=function(){
	var  ainput=document.getElementById("put");
	var adiv2=document.getElementById('div2');
	ainput.onmouseover=function(){
		adiv2.style.display="block";
	}
	ainput.onmouseout=function(){
		adiv2.style.display="none";
	}
}

function isTel(str){
       var reg=/^([0-9]|[\-])+$/g ;
       if(str.length<7 || str.length>18){
        return false;
       }
       else{
         return reg.exec(str);
       }
}
 
function validate_email(field,alerttxt)
{

with (field)
{
apos=value.indexOf("@")
dotpos=value.lastIndexOf(".")
if (apos<1||dotpos-apos<2) 
  {alert(alerttxt);return false}
else {return true}
}
}
function validate_form(thisform)
{
with (thisform)
{
if (validate_email(email,"Not a valid e-mail address!")==false)
  {email.focus();return false}
}
}