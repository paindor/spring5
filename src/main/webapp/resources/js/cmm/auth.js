"user strict";
var auth = auth || {};

auth =(() =>{
	const WHEN_ERR = 'js파일없음'
	let _,js, img, css, auth_vue_js , brd_js, auth_info ,cookie_js;
	
	let init =()=>{
		_= $.ctx();
		js = $.js();
		css = $.css()
		img = $.img()
		
		brd_js = js+'/brd/brd.js'
		auth_vue_js=js+'/vue/auth_vue.js';
		auth_info = js+'/cmm/router.js'
		
		cookie_js = js+'/cmm/cookie.js'
		
		
		
		
	};
	let onCreate =()=>{
		
		init();
		$.when(
				$.getScript(auth_vue_js),
				//$.getScript(authjs),
				$.getScript(auth_info ),
				$.getScript(cookie_js),
				$.getScript(brd_js)
					
				
				)
		.done(()=>{
			setContentView()
			$('#a_go_join').click(e=>{
				e.preventDefault()
				$('head')
		      .html(auth_vue.join_head())
		   $('body')
		      .html(auth_vue.join_body())
		   existId()
		      $('<button>' , {
				text: 'continue',
				href: '#' ,
				click : e=>{
					
					e.preventDefault();
					
					join();
					
					
					
					
					
				}
			})
			.addClass('btn btn-primary btn-lg btn-block')
			.appendTo('#button')
			})
		}).fail(()=>{alert(WHEN_ERR)})
		
	}
	let setContentView=()=>{
		$('head').html(auth_vue.login_head({css:$.css(), img:$.img()}))
		$('body').addClass('text-center')
		.html(auth_vue.login_body({css:$.css(), img:$.img()}))
		login()
		access()
		
		
		
	}
	let join=()=>{
		
		
		let data = {cid : $('#cid').val() , cpw : $('#cpw').val(),
				 cnum :$('#cnum').val()}
					
					alert('id?')
					$.ajax({
						url : _+'/hcust/',
						type : 'POST',
						dataType : 'json',
						data : JSON.stringify(data),
						contentType : 'application/json',
						success : d => {
							
							alert('ajax성공' );
							if(d.msg === 'success'){
								$('head').html(auth_vue.join_head({css:$.css(), img:$.img()}))
							$('body').addClass('text-center')
							.html(auth_vue.join_body({css:$.css(), img:$.img()}))
							}
								login()
						},
						error : e => {
							alert('ajax실패' );
							
						}
					
				
		      })
			
			
						
		
	}
	let login =()=>{
		
		$('<button>', {
			//type :"submit",
			text : "sign in",
	
			click : e =>{
				e.preventDefault();
				
				$.ajax({
					url : _+'/hcust/:cid/',
					type:'POST',
					dataType:'json',
					data: JSON.stringify({
						cid: $('#cid').val(),
						cpw: $('#cpw').val()
					}),
					contentType:'application/json',
					success : d =>{
						
						//$.extend (new LogUser(d));
						setCookie("USERID", d.cid)
						
						alert('-->' + getCookie("USERID"))
						brd.onCreate()
							
						
						//$.sessionStorage(d)
						
						
						
						
						
					
						
					},
					error : e =>{
						alert('ajax실패')
						
						
					}
						
				})
				
			}
			
			
		})
		.addClass("btn btn-lg btn-primary btn-block")
		.appendTo('#btn_login')
	}
	let mypage=(data)=>{
		let x = {css:$.css() , img:$.img(), cid:data.cid, cpw: data.cpw  }
		alert(x.cid);
		$('head').html(auth_vue.mypage_head(x))
		$('body').html(auth_vue.mypage_body(x))
	
		
	}
	let board=()=>{
		alert('게시판')
		$('head').html(brd_vue.brd_head())
		$('body').html(brd_vue.brd_body())
		
	}
	let existId=()=>{
		//alert('2222222')
		//alert($('#cid').val())
		$('#cid').keyup(()=>{
			if($('#cid').val().length >2){
				$.ajax({
					url : _+'/hcust/'+$('#cid').val()+'/exist',
					
					contentType:'application/json',
					success : d =>{
						alert(d.msg)
						if(d.msg==='success')
							$('#dupl_check')
							.val('사용가능')
							.css('color' , 'blue')
						else
							$('#dupl_check')
							.val('사용중')
							.css('color' , 'red')
						
						
					},
					error : e =>{
						alert('ajax실패')
						
						
					}
					
				})
		}
		})
	
	}
	
	let access=()=>{
		$('#a_go_admin').click(e=>{
			e.preventDefault()
			let ok = confirm('관리자?')
			if(ok){
				let aid = prompt('사원번호?')
				alert('사번:' + aid)
				alert(_+'/admin/'+aid)
				$.ajax({
					url:_+'/admin/'+aid,
					type:'POST',
					data: 'json',
					dataType:JSON.stringify({aid : aid, apw: prompt('비밀번호')}),
					contentType:'application/json',
					success: d=>{
						if(d.msg==='success'){
							alert('환영합니다')
							admin.onCreate()
						}
						else{
							alert('접근불가')
							app.run(_)
							
						}
						
					},
					error : e =>{
						
					}
				})
			}
		})
		
	}
		
		return {onCreate ,join, login ,mypage };
	
	
})();
