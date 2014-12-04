

/* 在线客服插件*/
(function($) {
$.fn.lrkf = function (options) {
    var opts={
        skin:'lrkf_green1',
        direction:'right',
        position:'fixed',
        btnText:'客服在线',
        foot:'',
        tel:'',
        qrCode:'',
        more:null,
        kfTop:'120',
        z:'99999',
        defShow:true,
        diyCon:"",
        Event:'',
        root:'./',
        callback:function(){}
    },$body = $("body"),$url = "";
    $.extend(opts,options);

    //插入html结构和基??css
    if(!$("#lrkfwarp").length){
        $body.append("<div id='lrkfwarp' class='lrkf lrkf-"+opts.direction+" lrkfshow' style="+opts.position+"><a href='#' class='lrkf_btn lrkf_btn_hide'>"+opts.btnText+"</a><div class='lrkf_box'><div class='lrkf_header'><a href='#' title='关闭' class='lrkf_x'></a></div><div class='lrkf_con'><ul class='kflist'></ul></div><div class='lrkf_foot'>"+opts.foot+"</div></div></div>");

    }

    $(window).load(function(){
        init()
    });

    function init(){
        var $lrKfWarp = $("#lrkfwarp"),
            $lrKf_con = $lrKfWarp.find(".lrkf_con"),
            $kfList = $lrKf_con.children("ul"),
            $lrKf_x = $lrKfWarp.find(".lrkf_x"),
            $lrKf_btn = $lrKfWarp.find(".lrkf_btn"),
            $lrKfWarp_w = $lrKfWarp.outerWidth()*1;

        $lrKfWarp.css({top:opts.kfTop+"px",'z-index':opts.z});

        if (!opts.defShow){
            $lrKfWarp.removeClass("lrkfshow").css({right:-$lrKfWarp_w});
        }

        //自定义内??
        if(opts.diyCon == ""){
            $.each(opts.qqs,function (i,o) {
                $kfList.append("<li class=qq><a target=_blank href=http://wpa.qq.com/msgrd?v=3&uin="+o.qq+"&site=qq&menu=yes><img src=http://wpa.qq.com/pa?p=2:"+o.qq+":45>"+o.name+"</a></li>");
            });
            if(opts.tel){
                $kfList.append("<li class=hr></li>");
                $.each(opts.tel,function (i,o) {
                    $kfList.append("<li class=tel>"+o.name+":<b>"+o.tel+"</b></li>");
                });
            }
            if(opts.qrCode){
                $kfList.append("<li class=hr></li><li class=qrcode><img src='"+opts.qrCode+"'/></li>");
            }
            if(opts.more){
                $kfList.append("<li class=hr></li><li class=more><a href='"+opts.more+"' target=_blank>>>更夎方式</a></li>");
            }
        }else{
            $lrKf_con.html(opts.diyCon);
        }

        //IE6随屏幕滚??
        if ($().isIe6() || opts.position=='absolute'){
            var $lrKfWarpTop = $lrKfWarp.offset().top;
            $(window).scroll(function() {
                var offsetTop = $lrKfWarpTop + $(window).scrollTop() +"px";
                $lrKfWarp.animate({top:offsetTop},{duration:600,queue:false });
            });
        }

        $lrKf_x.click(function(){
            $lrKfWarp.hide();
            return false;
        });

        if(opts.Event==''||opts.Event=='hover'){
        	var pageWidth = window.innerWidth;
        	if(typeof pageWidth != "number"){ 
        	if(document.compatMode == "number"){ 
        	pageWidth = document.documentElement.clientWidth; 
        	}else{ 
        	pageWidth = document.body.clientWidth; 
        	} 
        	} 

        	if(pageWidth>1160){
      		  if(opts.direction == "right"){
      			  $lrKfWarp.stop().animate({right:0});
              }else{
            	  $lrKfWarp.stop().animate({left:0});
              }
      	}
      	if(pageWidth<1160){
      		if(opts.direction == "right"){
      			$lrKfWarp.stop().animate({right:-$lrKfWarp_w});
            }else{
            	$lrKfWarp.stop().animate({left:-$lrKfWarp_w});
            }
      	}
        	 window.onresize=function(){  
        		  pageWidth = window.innerWidth;
             	if(typeof pageWidth != "number"){ 
             	if(document.compatMode == "number"){ 
             	pageWidth = document.documentElement.clientWidth; 
             	}else{ 
             	pageWidth = document.body.clientWidth; 
             	} 
             	} 
        		 if(pageWidth>1160){
        			  if(opts.direction == "right"){
        				  $lrKfWarp.stop().animate({right:0});
        	        }else{
        	      	  $lrKfWarp.stop().animate({left:0});
        	        }
        		}
        		if(pageWidth<1160){
        			if(opts.direction == "right"){
        				$lrKfWarp.stop().animate({right:-$lrKfWarp_w});
        	      }else{
        	      	$lrKfWarp.stop().animate({left:-$lrKfWarp_w});
        	      }
        		} 
            } ;
            $lrKfWarp.mouseenter(function(){
                if(opts.direction == "right"){
                    $(this).stop().animate({right:0});
                }else{
                    $(this).stop().animate({left:0});
                }
            }).mouseleave(function(){
                    if(opts.direction == "right"){
                        $(this).stop().animate({right:-$lrKfWarp_w});
                    }else{
                        $(this).stop().animate({left:-$lrKfWarp_w});
                    }
                });
        }else{
            $lrKf_btn.on("click", function(){
                if( $lrKfWarp.hasClass("lrkfshow") ){
                    $lrKfWarp.animate({right:-$lrKfWarp_w},function(){$lrKfWarp.removeClass("lrkfshow")});
                }else{
                    $lrKfWarp.addClass("lrkfshow").animate({right:0});
                }
                return false;
            });
        }//判断是单击显示还是滑过显示???
        opts.callback();
    }

};

//IE6判断
$.fn.isIe6 = function(){
    return !("maxHeight" in document.createElement("div").style);
};

function LoadJsCss(filename, filetype){
    if (filetype=="js")
    {
        var fileRef=document.createElement('script');//创建标签
        fileRef.setAttribute("type","text/javascript");//定义属????ype的???为text/javascript
        fileRef.setAttribute("src", filename);//文件的地??
    }
    else if (filetype=="css")
    {
        var fileRef=document.createElement("link");
        fileRef.setAttribute("rel", "stylesheet");
        fileRef.setAttribute("type", "text/css");
        fileRef.setAttribute("href", filename);
    }
    if (typeof fileRef!="undefined")
    {
        document.getElementsByTagName("head")[0].appendChild(fileRef)
    }
}

})(jQuery);




$(document).ready(function(){
	$("#lrkfwarp").lrkf({
	    //root:'http://img.lrjz100.com/lrkf/0.01/',	//客服代码文件夹的路径，例如: '/qqkefu/'
	    skin:'lrkf_green1',
	    kfTop:'140',
	    defShow:false,
	    qqs:[
	        {'name':'售前咨询','qq':'2851330366'},		//注意逗号是英文的逗号
	        {'name':'技术咨询','qq':'2851330367'}			//注意最后一个{}不要英文逗号
	    ],
	    tel:[
	        {'name':'客服电话','tel':'0755-61919966'}		//注意逗号是英文的逗号
	    ],
	    qrCode:'../image/icon/qrcode.png'	//二维码的路径，自行修改
//	    more:"http://www.51xuediannao.com/",				//>>更多方式
//	    foot:"8:30-18:00"                                  //底部在线时间，有些风格里面没有给这个预留位置

	}); 
	$("#link>ul>li").hover(function(){
			$(this).find(">a").css({
				"color":"#0a7ac4",
				"background-color":"#eee"
			});
			$(this).find("ul").slideDown("fast");
		},function(){
			$(this).find(">a").css({
				"color":"#505050",
				"background-color":"#fafafa"
			});
			$(this).find("ul").slideUp("fast");
		});
	
	 $("#link>ul>li").each(function(){
		 var $this=$(this);
		 var href=$this.find(">.menu>li:eq(0)").find("a").attr("href");
		 $this.find(">a").attr("href",href);
		 
	 });
	 
	
});


