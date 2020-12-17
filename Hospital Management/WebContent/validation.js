/**
 * 
 */

function validateData(){
	var sid=document.getElementById("ssnid");
	var custname=document.getElementById("patientname");
	var age=document.getElementById("age");
	var addr=document.getElementById("addr");
	var exp=/^[A-Za-z0-9\s]+$/;
	var a=/^[A-Za-z\s]+$/;
	if(sid.value.length !=9){
		//alert("SSN Id must be 9 digit number");
		document.getElementById("s_id").textContent="SSN Id must be 9 digit number";
		document.getElementById("s_id").style.color="red";
		return false;
	}
	if(!custname.value.match(a)){
		//alert("Name must contain only alphabets");
		document.getElementById("s_name").textContent="Name must contain only alphabets";
		document.getElementById("s_name").style.color="red";
		return false;
	}
	
	if(!addr.value.match(exp)){
		
		//alert("Name must contain only alphabets");
		document.getElementById("s_addr").textContent="Please enter Aplhanumeric values only";
		document.getElementById("s_addr").style.color="red";
		return false;
	}
	return true;
}