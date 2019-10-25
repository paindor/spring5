"user strict"
var brd = brd || {};

brd = (()=>{
	let _, js,brd_vue_js , log_user
	
	let init = ()=>{
		_= $.ctx()
		js=$.js()
		
		brd_vue_js = js+'/vue/brd_vue.js'
		
		log_user = $.cname()
		
		
	}
	let onCreate =()=>{
		init()
		$.getScript(brd_vue_js, ()=>{
		setContentView()
			$('<a>' , {
				href:'#',
				click : e=>{
					e.preventDefault()
					write()
					
				},
				text: '글작성'
					
			} )
			.addClass('nav-link')//) class="nav-link" href="#">글 작성</a>'')
			.appendTo('#go_write')
		
		})
		
	}
	let setContentView=()=>{
		
			$('head').html(brd_vue.brd_head({css:$.css() , img: $.img()}))
			$('body').addClass('text-center')
			.html(brd_vue.brd_body({ctx:'/web', css:$.css(), img:$.img()}))
			$('#recent_updates .media').remove()
			$('#recent_updates .d-block').remove()
			$('#recent_updates').append('<h1> 등록된글없음</h1>')
		
			
			
		
		
	}
	let write=()=>{
	//	let x = {cname: $.userInf().cname}
		alert('글작성이동' + log_user)
		
		$('#recent_updates').html(brd_vue.brd_write())
		
		$('#suggestion').remove()
		$('#writer_name').val(log_user)
		
	}
	
	return {onCreate}
	
	
})()