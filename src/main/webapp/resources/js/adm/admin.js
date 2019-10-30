var admin = admin || {}

admin =(()=>{
	let _, js, img, css
	
	let init=()=>{
		_= $.ctx()
		js=$.js()
		css = $.css()
		img = $.img()
		
	}
	let onCreate=()=>{
		init()
		setContentView()
		
	}
	let setContentView=()=>{
		
		
	}
	return {onCreate}
	
})()