"user strict";
var auth = auth || {};

auth =(() =>{
	const WHEN_ERR = 'js파일없음'
	let _,js, auth_vue_js;
	
	let init =()=>{
		_= $.ctx();
		js = $.js();
		auth_vue_js=js+'/vue/auth_vue.js';
		
	};
	let onCreate =()=>{
		
		init();
		$.getScript(auth_vue_js).done(()=>{
			setContentView()
			$('#a_go_join').click(e=>{
				e.preventDefault()
				$('head')
		      .html(auth_vue.join_head())
		   $('body')
		      .html(auth_vue.join_body())
		      $('<button>' , {
				text: 'continue',
				href: '#' ,
				click : e=>{
					alert('시발')
					let data = {cid : $('#cid').val() , cpw : $('#cpw').val(),
				 cnum :$('#cnum').val()}
					e.preventDefault();
					existId()
					join();
					
					
					
					
					
				}
			})
			.addClass('btn btn-primary btn-lg btn-block')
			.appendTo('#button')
			})
		}).fail(()=>{alert(WHEN_ERR)})
		
	}
	let setContentView=()=>{
		login();
		
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
								login()
						},
						error : e => {
							alert('ajax실패' );
							
						}
					
				
		      })
			
			
						
		
	}
	let login =()=>{
		let x = {css:$.css(), img:$.img()}
		$('head')
		.html(auth_vue.login_head(x));
		$('body')
		.html(auth_vue.login_body(x));
		$('<button>', {
			//type :"submit",
			text : "sign in",
	
			click : e =>{
				e.preventDefault();
				let idpw = {cid:$('#cid').val() , cpw:$('#cpw').val()};
				alert('성공');
				$.ajax({
					url : _+'/hcust/:cid/',
					type:'POST',
					dataType:'json',
					data: JSON.stringify(idpw),
					contentType:'application/json',
					success : d =>{
						alert(d.cname+'님 환영합니다')
						
						board()
						
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
		$.ajax({
			url : _+'/hcust/'+$('#cid').val()+'/exist',
			type:'GET',
			contentType:'application/json',
			success : d =>{
				alert(d.msg)
				if(d.msg==='success'){
					return true
					}
				else
					return false
				
				
			},
			error : e =>{
				alert('ajax실패')
				
				
			}
			
		})
	}
		
		return {onCreate ,join, login ,mypage };
	
	
})();
