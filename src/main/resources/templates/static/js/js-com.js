// JavaScript Document
$(function(){
	
	/*导航菜单*/
	jQuery(".nav").slide({ 
		type:"menu", //效果类型
		titCell:".m", // 鼠标触发对象
		targetCell:".sub", // 效果对象，必须被titCell包含
		//effect:"slideDown",//下拉效果
		delayTime:300, // 效果时间
		triggerTime:0, //鼠标延迟触发时间
		defaultPlay:false,
		returnDefault:true
	});
	
	/*banner*/
	jQuery(".fullSlide").hover(function(){ jQuery(this).find(".prev,.next").stop(true,true).fadeTo("show",1) },function(){ jQuery(this).find(".prev,.next").fadeOut() });
	jQuery(".fullSlide").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true,interTime:3500, autoPage:true, trigger:"click" });
	
	
	jQuery(".cen_1_1").slide({ mainCell:".conWrap", targetCell:".more a", effect:"fold"});
	
	jQuery(".focusBox").slide({ titCell:".hd ul", mainCell:".bd ul",effect:"fold", autoPlay:true, autoPage:true, trigger:"click",
		//下面startFun代码用于控制文字上下切换
		startFun:function(i){
			 jQuery(".focusBox .txt li").eq(i).animate({"bottom":0}).siblings().animate({"bottom":-36});
		}
	});
	
	jQuery(".tabsList").slide({ titCell:".tit",targetCell:".tabBody",effect:"fold"});
	
	jQuery(".ind_news").slide({ titCell:"li",targetCell:"p", effect:"fold"});
});