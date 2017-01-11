$(function(){
	
	$('.setNowDate').datepicker({ 
		endDate:'+1',//结束时间，在这时间之后都不可选
	 	autoclose: true, 
	 	todayBtn: 'linked', 	
	 });
	

	$(".close_sidebox").click(function(){
	  $(".sidebox").hide(300);
	});

	$(".setNowDate").val(getNowDate());
	
	setFullYear();

  //设置模态框 登陆和注册的弹窗
  $("#go_regist").click(function(){
    $("#loginModal").modal("hide");
    $("#regModal").modal("show");
    return false;
  });

  $("#register").modal({
    show:false,  //关闭自动显示
    keyboard:false, //关闭键盘esc
  });

  $("#go_login").click(function(){
    $("#regModal").modal("hide");
    $("#loginModal").modal("show");
    return false;
  });

  $("#login").modal({
    show:false,  //关闭自动显示
    keyboard:false, //关闭键盘esc
  });


  //修复input组件 边框高亮效果
  $('.input-group').on('focus', '.form-control', function () {
    $(this).closest('.input-group, .form-group').addClass('focus');
  }).on('blur', '.form-control', function () {
    $(this).closest('.input-group, .form-group').removeClass('focus');
  });

  if($(window).width()<768){
    $('.navbar-nav .active').css("border-top", "none");
    $("#myNav").addClass("navbar-fixed-top");
  }else{
    openHoverMenu()
    //$('.navbar-nav .active').css("border-top", "2px solid  #1ABC9C");
  }
//小屏幕时执行此效果
  $(window).resize(function(){
      if($(window).width()>=768){
        //$('.navbar-nav .active').css("border-top", "2px solid  #1ABC9C");
        openHoverMenu(); //开启悬停菜单显示
        $("#myNav").removeClass("navbar-fixed-top");
      }else{
        //视为手机端
          $('.navbar-nav .active').css("border-top", "none");
          $("#myNav").addClass("navbar-fixed-top");
      }
  });
  
  
});


/**
 *  针对手机浏览器进行导航优化
 */
function openHoverMenu(){
  $(document).off('click.bs.dropdown.data-api');  //关闭点击效果
  $('ul.nav li.dropdown').hover(function() {
    $(this).find('.dropdown-toggle span').removeClass().addClass("fui-triangle-up-small");
    $(this).find('.dropdown-menu').stop(true, true).delay(150).fadeIn(400);
  }, function() {
    $(this).find('.dropdown-toggle span').removeClass().addClass("fui-triangle-down-small");
    $(this).find('.dropdown-menu').stop(true, true).delay(150).fadeOut(400);
  });
  
  $('#userDropDown').hover(function() {
	    $(this).find('.dropdown-toggle span').removeClass().addClass("fui-triangle-up-small");
	    $(this).find('.dropdown-menu').stop(true, true).delay(150).fadeIn(400);
	  }, function() {
	    $(this).find('.dropdown-toggle span').removeClass().addClass("fui-triangle-down-small");
	    $(this).find('.dropdown-menu').stop(true, true).delay(150).fadeOut(400);
	  });
}



/**
 * 美化的alert提示框
 *
 */
function alertInfo(msg){
	$(".alertContent").html(msg);
	$("#alertInfo").modal("show");
}

/**
 * 不带关闭按钮的提示窗
 * @param msg 提示信息
 * @param url 提示后跳转的地址
 */
function LocationModal(msg,url){
	$(".msgModal").html(msg);
	$("#infoModal").modal("show");
	setTimeout(function(){
		location.href=url;
	}, 900)
}

/**
 *  弹出一个不带关闭按钮的提示窗
 * @param msg 提示信息
 */
function infoModal(msg){
	$(".msgModal").html(msg);
	$("#infoModal").modal("show");
	setTimeout(function(){
		$("#infoModal").modal("hide");
	}, 900)
}

/**
 * 弹出一个不带关闭按钮的提示窗
 * @param msg 提示信息
 * @param time 延时关闭时间
 */
function infoModal2(msg , time){
	$(".msgModal").html(msg);
	$("#infoModal").modal("show");
	setTimeout(function(){
		$("#infoModal").modal("hide");
	}, time)
}


function infoModal3(msg){
	$(".msgModal").html(msg);
	$("#infoModal").modal("show");
}


/**
 * 导航添加active效果
 */

function addNavActive(nav){
	 //获取导航
	switch(nav){
		case '首页':
			$("#navTop > li[title='首页']").addClass("active");
			break;
		case '健康报告':
			$("#navTop > li[title='健康报告']").addClass("active");
			break;
		case '健康日志':
			$("#navTop > li[title='健康日志']").addClass("active");
			break;
		case '健康行动':
			$("#navTop > li[title='健康行动']").addClass("active");
			break;
		case '健康监测':
			$("#navTop > li[title='健康监测']").addClass("active");
			break;
		default:
	}
	
}

//获取当前时间
function getNowDate(){
	var date = new Date();
	var month = date.getMonth()+1;
	var d = date.getDate();
	if(month<10) month="0"+month;
	if(d<10) d = "0"+d;
	var txt = date.getFullYear()+"-"+month+"-"+d;
	return txt;
}

/*-----分页处理函数------*/
function pageHandler(url){
	//重新注册分页点击事件
	$(".pageul > li > a").each(function(){
		
		var page = parseInt($("#pageNo").val());//当前页
		
		if(url.substring(url.length-1,url.length)=='/'){
			//多一个 / 去掉这个/
			url = url.substring(0,url.length-1);
		}
		
		$(this).click(function(){
			if($(this).text() == '上一页'){
				showPersonList(page - 1 , url);
				return;
			}else if($(this).text() == '下一页'){
				showPersonList(page + 1 , url);
				return;
			}else{
				showPersonList($(this).text() , url);
			}
		});
	});
}


function showPersonList(pageNo , url){
	var totalPage= $("#totalPage").val();//总页数
	if(pageNo < 1) return ;//当前页位第一页，上一页不可用
	if(pageNo > totalPage ) return;//当前页位最后一页，下一页不可用
		window.location.href=url+"/"+pageNo;
		//window.location.href=url+pageNo;
	}


//获取当前年份
function setFullYear(){
	var date = new Date();
	$(".setFullYear").html(date.getFullYear());
}


//新功能建设提示
function comingSoon(){
	alertInfo("新版功能建设中,敬请期待！");
}