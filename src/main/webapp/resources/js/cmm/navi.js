"user strict"
var navi = navi || {}
navi = (()=>{
	let _,js, auth_vue_js , img, css, brd_js, auth_js, js_navi_vue
	let init=x=>{
		
		
		brd_js = js+'/brd/brd.js'
		auth_vue_js=js+'/vue/auth_vue.js'
		auth_js= js+'/cmm/auth.js'
		
		
		js_navi_vue = js+'/vue/navi_vue.js'
	
		
	}
	let onCreate=()=>{
		init()
		$.when(
				$.getScript(brd_js),
				$.getScript(auth_js)
				
				
		).done(()=>{
			setContentView()
				$.getScript(js_navi_vue)
		navi_vue.nav()
		}).fail(()=>{
			
		})
		
	
		
		
		
		
	}
	let setContentView=()=>{
		
		$('<a>' , {
			href:'#',
			
			text: '글작성'
				
		} )
		.addClass('nav-link')//) class="nav-link" href="#">글 작성</a>'')
		.appendTo('#go_write')
		.click (e=>{
				e.preventDefault()
				$.getScript(brd_js, ()=>{
					brd.write({_:_ ,img:img , css:css , js:js})
				})
				
				
			})
		$('<a>' , {
			href:'#',
			text: '로그아웃'
				
		} )
		.addClass('nav-link')//) class="nav-link" href="#">글 작성</a>'')
		.appendTo('#go_logout')
		.click(  e=>{
			e.preventDefault()
			deleteCookie()
			app.run(_)
			
			
			
			
		})
	}
	return {onCreate}
	
})()