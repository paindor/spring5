"user strict"
var brd = brd || {};

brd = (()=>{
	let _, js,css, img,brd_vue_js , navi_js , brd_js,
		navi_vue_js , page_vue_js
	
	let init =()=>{
		_ = $.ctx()
		js = $.js()
		css = $.css()
		img = $.img()
		brd_js = js+'/brd/brd.js'
		
		brd_vue_js = js+'/vue/brd_vue.js'
		
		
		
		navi_js = js+ '/cmm/navi.js'
		navi_vue_js = js+'/vue/navi_vue.js'
		page_vue_js = js+ '/vue/page_vue.js'
		alert('111' +_)
	}
	let onCreate =()=>{
		
		init()
		$.when(
				$.getScript(brd_vue_js),
				$.getScript(navi_js),
				
				$.getScript(navi_vue_js),
				$.getScript(page_vue_js)
				
		).done(
				setContentView(),
				navi.onCreate()
		).fail()
		
		
		
		
		
		
	}
	let setContentView=()=>{
		
			alert('22' +_)
			$('head').html(brd_vue.brd_head({css:$.css() , img: $.img()}))
			$('body').addClass('text-center')
			.html(brd_vue.brd_body({ctx:'/web', css:$.css(), img:$.img()}))
			$(navi_vue.nav()).appendTo('#navi')
			recent_updates(1)
			
		
		
			
			
		
		
	}
	let recent_updates=x=>{
		alert('호출번호: ' + x)
		$('#recent_updates .media').remove()
		$('#recent_updates .d-block').remove()
		$('#suggestions').remove()
		$.getJSON(_+'/articles/page/' + x, d=>{
			
		
				$.each(d.article, (i,j)=>{
					$('<div class="media text-muted pt-3">'+
			          '<img data-src="holder.js/32x32?theme=thumb&amp;bg=007bff&amp;fg=007bff&amp;size=1" alt="32x32" class="mr-2 rounded" style="width: 32px; height: 32px;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%2232%22%20height%3D%2232%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%2032%2032%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_16dfcdddb72%20text%20%7B%20fill%3A%23007bff%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A2pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_16dfcdddb72%22%3E%3Crect%20width%3D%2232%22%20height%3D%2232%22%20fill%3D%22%23007bff%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%2211.5390625%22%20y%3D%2216.9%22%3E32x32%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">'+
			'          <p id="id_'+i+'"class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">'+
			
						         
			'          </p>'+
			'        </div>').appendTo('#recent_updates')
			
			$('<strong class="d-block text-gray-dark">@<a>'+j.cid+'</a></strong>')
			.appendTo("#id_"+i)
			.click(()=>{
				alert('작성자 클릭')
				
			})
			
			$('<a>'+ j.title + '</a>')
			.appendTo("#id_"+i)
			.click(()=>{
				alert('제목클릭')
				detail(j)
					
				
			})
			
				})
				alert(brd_vue.brd_head())
				alert(page_vue.pagination())
				$(page_vue.pagination())
				.appendTo('#recent_updates')
				$('#pagination').empty()
				let t = ''
				let i = 0
				
				/*for(; i < d.length/5 ; i++){
					t +='<li class="page-item"><a class="page-link" href="#">'+(i+1)+'</a></li>'
				}
				*/
				/*t +='<li class="page-item"><a class="page-link" href="#">2</a></li>'
				t +='<li class="page-item"><a class="page-link" href="#">3</a></li>'*/
					$.each(d.page, (i, j)=>{
					$('<li class="page-item"><a class="page-link" href="#">'+(i+1)+'</a></li>')
					.appendTo('#pagination')
					
				})
				//$( '<li class="page-item"><a class="page-link" href="#">Previous</a></li>')
		})
		
	//	$(page_vue.pagenation()).appendTo('#recent_updates')
		
			
	}
				
	let write=()=>{
		
	//	let x = {cname: $.userInf().cname}
		alert('글작성이동' + log_user)
		
		$('#recent_updates').html(brd_vue.brd_write())
		
		
		$('#form_write input[name=writer]').val(getCookie("USERID"))
		$('#suggestion').remove()
 	
		$('<input>' ,{
			value: "글작성",
			type: "submit",
			style: "float:right;width:100px;margin-right:10px",
		
		})
		.addClass("btn btn-primary")
		.appendTo('#form_write')
		.click(e=>{
			e.preventDefault()
			let json = {
					cid: $('#form_write input[name="writer"]').val(),
					title : $('#form_write input[name="title"]').val(),
					content :$('#form_write textarea[name="content"]').val()
					
			}
			alert('id:' + _)
			$.ajax({
					url: x._+'/articles/',
					type: 'POST',
					data: JSON.stringify(json),
					dataType: 'json',
					contentType:'application/json',
					success : d =>{
						$('#recent_updates div.container-fluid').remove()
						recent_updates(d.count)
						
						
						
					},
					error : e =>{
						alert('안되')
					}
								
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
	

	let detail =x=>{
	$('#recent_updates').html(brd_vue.brd_write())
	$('#recent_updates div.container-fluid h1').html('ARTICLE DETAIL')
		
		$('#form_write input[name=writer]').val(x.cid)
		$('#form_write input[name="title"]').val(x.title)
		$('#form_write textarea[name="content"]').val(x.content)
		$('#suggestion').remove()
 	
		$('<input>' ,{
			value: "삭제",
			style: "float:right;width:100px;margin-right:10px",
		
		})
		.addClass("btn btn-primary")
		.appendTo('#form_write')
		.click(e=>{
			let data = {brdNum:x.brdNum,cid:x.cid , title:x.title, content:x.content}
			alert(_+'/articles/'+x.brdNum)
			$.ajax({
				url: _+'/articles/'+x.brdNum,
				type:'DELETE',
				data: JSON.stringify(x),
				dataType: 'json',
				contentType:'application/json',
				success:d=>{
					$('#recent_updates').empty()
					recent_updates()
					
				},
				error:e=>{
					alert('ajax실패')
					
				}
				
				
			})
			
		})
		$('<input>',{
			value: "수정",
			style : "float:right;width:100px;margin-right:10px",
			
			
		})
		.addClass("btn btn-danger")
		.appendTo('#boardwrite')
		.click(()=>{
			
					x.cid=  $('#form_write input[name=writer]').val()
					x.title = $('#form_write input[name="title"]').val()
					x.content= $('#form_write textarea[name="content"]').val()
					let js = {
						cid : x.cid,
						title: x.title,
						brdNum : x.brdNum,
						content: x.content
						
					}
					//brdNum: x.brdNum
						alert(x.cid+ ' '+x.title +' ' +x.content)
			$.ajax({
				
				url: _+'/articles/'+x.brdNum,
				type: 'PUT',
				data: JSON.stringify(js),
				dataType:'json',
				contentType:'application/json',
				success: d=>{
					alert(d.msg)
					
					$('#recent_updates').empty()
					recent_updates()
					
				},
				error : e =>{
					
				}
			})
			
		})
		
		
	}
	
	let pagination=()=>{
		
	}

	return {onCreate, write}

		
})()