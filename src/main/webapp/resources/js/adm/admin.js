var admin = admin || {}

admin =(()=>{
	let _, js, img, css, navi_js, navi_vue_js
	
	let init=()=>{

		_= $.ctx()
		js=$.js()
		css = $.css()
		img = $.img()
		navi_js = js+'/cmm/navi.js'
		navi_vue_js= js+'/vue/navi_vue.js'
		
	}
	let onCreate=()=>{
		init()
		$.when(
			$.getScript(navi_js),
			$.getScript(navi_vue_js)
		).done(()=>{
			setContentView()
			
		}).fail( ()=>{
			alert('실패')
		})
		
		
		
		
	}
	let setContentView=()=>{
		
		
		$('body').empty()
		$(navi_vue.nav()).appendTo('body')
		navi.onCreate()
		$('<table id="tab"><tr></tr></table>')
		.css({border: '1px solid black', width: '80%',height: '90%', 'margin': '0 auto'})
		.appendTo('body')
		$.each(
			[{id : 'left', width : '20%'},
			{id : 'right', width : '80%'}],
			(i,j)=>{
			$('<td id="'+j.id+'"></td>')
			.css({border: '2px solid black', width: j.width, 'vertical-align': 'top'})
			.appendTo('#tab tr')
		})
		$.each([
			{txt: '웹크롤링', name: 'web_crawl'},
			{txt: '고객관리', name: 'cust_mgmt'},
			{txt: '상품등록', name: 'item_reg'},
			{txt: '상품조회', name: 'item_srch'},
			{txt: '상품수정', name: 'item_mod'},
			{txt: '상품삭제', name: 'item_del'}],
			(i,j)=>{
				$('<div name="'+j.name+'">'+j.txt+'</div>')
				.css({border: '2px solid black', margin: 'auto 0', 'line-height': '50px'})
				.appendTo('#left')
				.click(function(){
				$(this).addClass('active')
				$(this).siblings().removeClass('active')
				let that = $(this).attr('name')
				
				switch(that){
				case 'web_crawl':
					webCrawl();
					break;
				case 'cust_mgmt' : 
					//custMgr();
					break;
				case 'item_reg' : break;
				case 'item_srch' : break;
				case 'item_mod' : break;
				case 'item_del' : break;
				}
			})
		})
		
		
		
	}
	let webCrawl=()=>{
		
		$('#right').empty()
		$('<h2>web crawling</h2>').appendTo('#right')
		$('<form id="cr_form"><select></select></form>')
		.appendTo('#right')
		$.each([{value:'naver' ,txt: 'naver.com'},
			{value:'daum' ,txt : 'daum.net'}],
			(i, j) =>{
				$('<option value="' +j.value +'">' +j.txt +'</option>')
				.appendTo('#cr_form select')
			 
		}) 
		$('<br></br><input type="text"></input> ')
		.appendTo('#cr_form')
		$('<input type="submit"></input>')
		.appendTo('#cr_form')
		.click(()=>{
			alert('고객관리')
		})
			
			
		
		
		
		
		
	}
	return{onCreate}
})()