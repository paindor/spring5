"user strict"
var brd = brd || {};

brd = (()=>{
	let _, js,brd_vue_js , log_user ,$form
	
	let init = ()=>{
		_= $.ctx()
		js=$.js()
		
		brd_vue_js = js+'/vue/brd_vue.js'
		
		log_user = $.cname()
		$form = 'form'
		
		
	}
	let onCreate =()=>{
		init()
		$.getScript(brd_vue_js, ()=>{
		setContentView()
		navigation()
		
		
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
		
		
		$('#form_write input[name=writer]').val(log_user)
		$('#suggestion').remove()
		
		
		/*<input type="reset" class="btn btn-danger" style="float:right;width:100px;margin-right:10px" value="CANCEL"/>'
		+'<input name="write" type="submit" class="btn btn-primary" style="float:right;width:100px;margin-right:10px" value="SUBMIT"/>
	*/	
		
		$('<input>' ,{
			value: "글작성",
			type: "submit",
			style: "float:right;width:100px;margin-right:10px",
		
		})
		.addClass("btn btn-primary")
		.appendTo('#boardwrite')
		.click(()=>{
			let json = {
					cid: $('#form_write input["name=writer"]').val(),
					title : $('#form_write input[name=title]').val(),
					content :$('#form_write textarea').val()
					
			}
			alert('id:' + json.title)
			$.ajax({
					url:_+'/articles/',
					type: 'POST',
					data: JSON.stringify(data),
					dataType: 'json',
					contentType:'application/json',
					success : d =>{
						//$('#recent_updates').
						
						
					},
					error : e =>{
						alert('안되')
					}
					
					/*url: '' ,
					type: '',
					data: {},
					dataType: '',
					cnotentType:'' ,
					success : d=>{
						
					},
					error :e=>{
						
					}*/
					
			})
		})
	}
	
		
	
		
		$('<input>',{
			type : "reset",
			value: "취소",
			style : "float:right;width:100px;margin-right:10px",
			click: e =>{
				e.preventDefault()
				alert('취소클릭')
			}
			
		})
		.addClass("btn btn-danger")
		.appendTo('#boardwrite')
	
		
	let navigation =()=>{
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
	}
	
	return {onCreate}
		
		
})()