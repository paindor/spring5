"user strict";
function Session(x,user) {
	sessionStorage.setItem('ctx',x);
	sessionStorage.setItem('js', x+'/resources/js');
	sessionStorage.setItem('css', x+'/resources/css');
	sessionStorage.setItem('img', x+'/resources/img');
	
	
	
	
	return {
		ctx : ()=>{return sessionStorage.getItem('ctx');},
		js : ()=>{return sessionStorage.getItem('js');},
		img : ()=>{return sessionStorage.getItem('img');},
		css : ()=>{return sessionStorage.getItem('css');}
		
		
	}
	
}
function LogUser(x){
	sessionStorage.setItem('cid', x.cid);
	sessionStorage.setItem('cpw', x.cpw);
	sessionStorage.setItem('cname', x.cname);
	sessionStorage.setItem('cnum' , x.cnum);
	
	
	return{
		cid : ()=>{return sessionStorage.getItem('cid');},
		cpw : ()=>{return sessionStorage.getItem('cpw');},
		cname : ()=>{return sessionStorage.getItem('cname');},
		cnum : ()=>{return sessionStorage.getItem('cnum');}
	}
	
	
	
	
}