"use strict"

$.prototype.nullChecker =x=>{
	let flag = false
	let i = 0
	for( i in x ){
		if(x[i]===''){
			flage = true
			
		}
	}
	return flag
}