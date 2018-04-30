/**===============================================================================================
 						custom directive using jQuery-UI, AngularJS 												  
==================================================================================================
 @LastUpdate: 2018/04/30
=================================================================================================*/
eSoafApp.directive('msgBar', function() {
    return {
        restrict: 'E',
        transclude: true,
        replace: true,
        scope:{
        },
        template: function(element, attrs) {
            var htmlText =  '<div>'+
	            				'<div id="mwt_fb_tab"><a class="left_no"><span><i class="glyphicon glyphicon-chevron-right mwt_btn_color"></i></span><span class="mwt_btn_color">訊</span><span class="mwt_btn_color">息</span></a></div>'+
		            			'<div id="mwt_mwt_slider_scroll">'+
			            			'<div id="mwt_slider_content">'+
				            			'<div class="bootstrap-admin-panel-content in">'+
					            			'<div class="row">'+
					            				'<div class="col-lg-1 col-md-1 col-sm-1"></div>'+
					            				'<div id="mwt_msg_panl" class="col-lg-11 col-md-11 col-sm-11">'+
					            					'<div ng-init="insert(row)" id="mwt_msg_box" style="border-radius:5px!important;line-height:25px;text-align:left;animation: ngdialog-fadein 0.5s;" ng-repeat="row in msglist" ng-class="{\'alert alert-success\': row.type == \'S\',\'alert alert-info\': row.type == \'N\', \'alert alert-warning\': row.type==\'W\', \'alert alert-danger\': row.type==\'E\'}"><a class="close" style="color:#000;" ng-click="remove(row)">&times;</a><span ng-class="{\'label label-info\': row.type == \'N\', \'label label-success\': row.type == \'S\', \'label label-warning\': row.type == \'W\', \'label label-danger\': row.type == \'E\'}">{{row.label}}</span>&nbsp;{{row.message}}</div>'+
					            				'</div>'+
				            				'</div>'+
					            		'</div>'+
					            	'</div>'+
					            '</div>'+
            				'</div>'
            				;
            return htmlText;
        },
        controller: ['$rootScope','$scope', function($rootScope,$scope) {
        	/** Function **/
        	/* Initialize */   	
        	$scope.msglist = [];
        	/* Remove MsgBox */
        	$scope.remove = function(row){
    			for(var i=0; i<$scope.msglist.length; i+=1){
    				if($scope.msglist[i] == row)$scope.msglist.splice(i, 1);
    			};
    			//Close MsgBox
    			if($scope.msglist.length>0)return;
    			var w = $("#mwt_slider_content").width();
	        	$("#mwt_mwt_slider_scroll").animate( { left:'-'+w+'px' }, 500 ,'swing');
	    		$("#mwt_fb_tab i").removeClass("glyphicon-chevron-left");
	    		$("#mwt_fb_tab i").addClass("glyphicon-chevron-right");
	    		$("#mwt_fb_tab a").removeClass("left_go");
	    		$("#mwt_fb_tab a").addClass("left_no");
    		};
    		/** Get Message **/
    	    /* 秀訊息, 由 BaseController 負責呼叫 */
    		$rootScope.showStatusMsg = function(sMsg, status) {
    	    	if(sMsg){
    	    		//Check Type
    	    		var msgType = status.toString().toUpperCase().trim();
    	    		var msgBody = sMsg.toString().trim();
    	    		var tmpTP = '';
    	    		var tmpTXT = '';
    	    		//Switch Type
    	    		switch(msgType){
    		    		case 'SUCCESS':
    		    			tmpTP = 'S';
    	    				tmpTXT = '成功訊息';
    	    				break;
    		    		case 'NORMAL':
    		    			tmpTP = 'N';
    	    				tmpTXT = '一般訊息';
    	    				break;
    		    		case 'WARNING':
    		    			tmpTP = 'W';
    	    				tmpTXT = '警告訊息';
    	    				break;
    		    		case 'DANGER':
    	    				tmpTP = 'E';
    		    			tmpTXT = '錯誤訊息';
    		    			break;
    	    			default:
    	    				tmpTP = 'N';
	    					tmpTXT = '一般訊息';
	    					break;
    	    		};
//    	    		alert(' tmpTP: '+tmpTP+' tmpTXT: '+tmpTXT);
    	    		$scope.msglist.unshift({'type': tmpTP, 'message': msgBody, 'label': tmpTXT});
    	    	}
    		};
    		/** append row in list **/
    		$scope.insert = function(row){
    			var w = $("#mwt_slider_content").width(),
    				e = $("#mwt_msg_panl").children(":nth-child("+($scope.msglist.indexOf(row)+1)+")"),
    				_color, _color_chg;
    			switch(row.type){
	    			case 'N':
	    				_color = "rgba(42,176,237,1)";
	    				_color_chg = "hsla(350,99%,55%,0.9)";
	    				break;
	    			case 'S':
	    				_color = "rgba(0,36,0,1)";
	    				_color_chg = "hsla(350,99%,55%,0.9)";
	    				break;
	    			case 'W':
	    				_color = "rgba(237,144,23,1)";
	    				_color_chg = "hsla(350,99%,55%,0.9)";
	    				break;
	    			case 'E':
	    				_color = "rgba(231,56,39,1)";
	    				_color_chg = "rgb(51,51,51)";
	    				break;
    				default:
    					_color = "rgba(42,176,237,1)";
    					_color_chg = "hsla(350,99%,55%,0.9)";
    					break;
    			};
    			//level 1
    			$("#mwt_fb_tab>a>span>i, #mwt_fb_tab>a>span").animate({color:'hsla(350,99%,55%,0.9)'},300).animate({color:'#FFF'},300);
				//level 2
    			$(e).animate({color:_color_chg},300).animate({color:_color},300).animate({color:_color_chg},300).animate({color:_color},300);
    			if ($("#mwt_mwt_slider_scroll").css('left') == '-'+w+'px')
				{
					$("#mwt_mwt_slider_scroll").animate({ left:'0px' }, 500 ,'swing');
					$("#mwt_fb_tab i").removeClass("glyphicon-chevron-right");
					$("#mwt_fb_tab i").addClass("glyphicon-chevron-left");
					$("#mwt_fb_tab a").removeClass("left_no");
					$("#mwt_fb_tab a").addClass("left_go");        					
				}
        	};
        	
        }],
        link: function (scope, element, attrs, ctlModel, transclude) {
        	
        	var w = $("#mwt_slider_content").width(),
                isLocal = document.location.hostname == "127.0.0.1" || document.location.hostname == "192.168.0.8"  || document.location.hostname == "localhost";
        	
        	$("#mwt_fb_tab").attr("title","滑鼠點擊展開或隱藏訊息視窗").on("mouseenter",function(){
        		$("#mwt_fb_tab").addClass("mwt_fb_tab-hover","fast");
        		$(".mwt_btn_color").animate({color:'hsla(350,99%,55%,0.9)!important'},600);
        	}).on("mouseleave",function(){
        		$("#mwt_fb_tab").removeClass("mwt_fb_tab-hover","fast");
        		$(".mwt_btn_color").animate({color:'#FFF!important'},600);
        	});
        	
//        	$("#mwt_fb_tab").attr("title","滑鼠點擊展開或隱藏訊息視窗").on("mouseenter",function(){
//        		$("#mwt_fb_tab").animate({
//        			background: "rgb(248,80,50) !important",
//        			background: "-moz-linear-gradient(-45deg,  rgba(248,80,50,1) 0%, rgba(241,111,92,1) 0%, rgba(241,111,92,1) 15%, rgba(241,111,92,1) 15%, rgba(241,111,92,1) 46%, rgba(246,41,12,1) 76%, rgba(240,47,23,1) 95%, rgba(231,56,39,1) 100%) !important",
//        			background: "-webkit-linear-gradient(-45deg,  rgba(248,80,50,1) 0%,rgba(241,111,92,1) 0%,rgba(241,111,92,1) 15%,rgba(241,111,92,1) 15%,rgba(241,111,92,1) 46%,rgba(246,41,12,1) 76%,rgba(240,47,23,1) 95%,rgba(231,56,39,1) 100%) !important",
//        			background: "linear-gradient(135deg,  rgba(248,80,50,1) 0%,rgba(241,111,92,1) 0%,rgba(241,111,92,1) 15%,rgba(241,111,92,1) 15%,rgba(241,111,92,1) 46%,rgba(246,41,12,1) 76%,rgba(240,47,23,1) 95%,rgba(231,56,39,1) 100%) !important",
//        			filter: "progid:DXImageTransform.Microsoft.gradient( startColorstr='#f85032', endColorstr='#e73827',GradientType=1 ) !important"
//        		}, 1000);
//        	}).on("mouseleave",function(){
//        		$("#mwt_fb_tab").animate({
//        			background:"rgb(254,187,187)!important",
//        			background:"-moz-linear-gradient(-45deg,  rgba(254,187,187,1) 0%, rgba(255,92,92,1) 100%)!important",
//        			background:"-webkit-linear-gradient(-45deg,  rgba(254,187,187,1) 0%,rgba(255,92,92,1) 100%)!important",
//        			background:"linear-gradient(135deg,  rgba(254,187,187,1) 0%,rgba(255,92,92,1) 100%)!important",
//        			background:"progid:DXImageTransform.Microsoft.gradient( startColorstr='#febbbb', endColorstr='#ff5c5c',GradientType=1 )!important"
//        		}, 1000);
//        	});
        	
        	/** Open/Close by Click **/
        	$("#mwt_fb_tab").click(function(){
        		if ($("#mwt_mwt_slider_scroll").css('left') == '-'+w+'px')
        		{
        			//Open
        			$("#mwt_mwt_slider_scroll").animate({ left:'0px' }, 500 ,'swing');
        			$("#mwt_fb_tab i").removeClass("glyphicon-chevron-right");
        			$("#mwt_fb_tab i").addClass("glyphicon-chevron-left");
        			$("#mwt_fb_tab a").removeClass("left_no");
        			$("#mwt_fb_tab a").addClass("left_go");
        		}
        		else
        		{
        			//Close
        			$("#mwt_mwt_slider_scroll").animate( { left:'-'+w+'px' }, 500 ,'swing');
        			$("#mwt_fb_tab i").removeClass("glyphicon-chevron-left");
        			$("#mwt_fb_tab i").addClass("glyphicon-chevron-right");
        			$("#mwt_fb_tab a").removeClass("left_go");
        			$("#mwt_fb_tab a").addClass("left_no");
        		}
        	});       	
        	
        	/** Get MSG **/
        	/* Add: 2016/03/22 ArthurKO */
//        	scope.$watch('msglist', function (newValue, oldValue) {
//        		if(newValue == oldValue){
//        			return;
//        		};
//        	};
        	
        	/* Add: 2016/02/22 ArthurKO */
//        	$("#mwt_msg_panl").bind('DOMNodeInserted',function(event){
//        		//Inserted
//        		if (event.type == 'DOMNodeInserted') {
//        			
////        			$("#mwt_fb_tab").hide().show("bounce",{},500);
//        			
//        			var _color = $(event.target).css("color");
//        			//level 1
////        			$("#mwt_fb_tab>a>span>i, #mwt_fb_tab>a>span").animate({color:'hsla(350,99%,55%,0.9)'},300).animate({color:'#FFF'},300);
//    				//level 2
////        			$(event.target).animate({color:'hsla(350,99%,55%,0.9)'},300).animate({color:_color},300).animate({color:'hsla(350,99%,55%,0.9)'},300).animate({color:_color},300);
//        			
//        			if ($("#mwt_mwt_slider_scroll").css('left') == '-'+w+'px')
//    				{
//    					$("#mwt_mwt_slider_scroll").animate({ left:'0px' }, 500 ,'swing');
//    					$("#mwt_fb_tab i").removeClass("glyphicon-chevron-right");
//    					$("#mwt_fb_tab i").addClass("glyphicon-chevron-left");
//    					$("#mwt_fb_tab a").removeClass("left_no");
//    					$("#mwt_fb_tab a").addClass("left_go");        					
//    				}
//        	    }
//        	});
        	
        	/** Close by blur **/
        	/* Add: 2016/03/02 ArthurKO */
//        	$("#mwt_slider_content").blur(function(){
//        		if ($("#mwt_mwt_slider_scroll").css('left') == w+'px'){
//        			$("#mwt_mwt_slider_scroll").animate( { left:'-'+w+'px' }, 600 ,'swing');
//        			$("#mwt_fb_tab i").removeClass("glyphicon-chevron-left");
//        			$("#mwt_fb_tab i").addClass("glyphicon-chevron-right");
//        			$("#mwt_fb_tab a").removeClass("left_go");
//        			$("#mwt_fb_tab a").addClass("left_no");
//        		}
//        	});    
        	
            /** 滑鼠移開移入 **/	
        	// Modify: 2016/03/02 ArthurKO
        	// Add: 2016/07/26 ArthurKO isLocal
        	if(isLocal){
        		$("#mwt_slider_content").mouseleave(function() {
            		$("#mwt_mwt_slider_scroll").animate( { left:'-'+w+'px' }, 500 ,'swing');
            		$("#mwt_fb_tab i").removeClass("glyphicon-chevron-left");
            		$("#mwt_fb_tab i").addClass("glyphicon-chevron-right");
            		$("#mwt_fb_tab a").removeClass("left_go");
            		$("#mwt_fb_tab a").addClass("left_no");
            	});
        	}
        	
        	/** 無訊息自動關閉 **/
        	// Add: 2016/07/27 ArthurKO
//        	scope.$watch('msglist', function (newValue, oldValue) {
//        		alert("in");
//        		if(scope.msglist.length>0)return;
//        		alert("go");
//	        	$("#mwt_mwt_slider_scroll").animate( { left:'-'+w+'px' }, 500 ,'swing');
//	    		$("#mwt_fb_tab i").removeClass("glyphicon-chevron-left");
//	    		$("#mwt_fb_tab i").addClass("glyphicon-chevron-right");
//	    		$("#mwt_fb_tab a").removeClass("left_go");
//	    		$("#mwt_fb_tab a").addClass("left_no");
//        	});
        	
            /** 滑鼠移開點擊 **/
//        	$('body').click(function(e) {
//        	    var target = $(e.target);
//        	    if(!target.is('#mwt_fb_tab') &&
//            	   !target.is('#mwt_slider_content') &&
//            	   !target.is('#mwt_mwt_slider_scroll') &&
//            	   !target.is('#mwt_fb_tab') &&
//            	   !target.is('#mwt_msg_panl')
//        	    )
//        	    {
//        			$("#mwt_mwt_slider_scroll").animate( { left:'-'+w+'px' }, 500 ,'swing');
//        			$("#mwt_fb_tab i").removeClass("glyphicon-chevron-left");
//        			$("#mwt_fb_tab i").addClass("glyphicon-chevron-right");
//        			$("#mwt_fb_tab a").removeClass("left_go");
//        			$("#mwt_fb_tab a").addClass("left_no");
//        	    };
//        	});	
        	
        	/** CSS/CLASS **/
        	/* Version: 2016/02/21 */
        	/* msg button */
        	$("#mwt_fb_tab").css("z-index","103") //51->102
        					.css("position","absolute")
        					.css("left","0")
        					.css("margin-bottom","25px")
							.css("background","rgb(254,187,187)")
							.css("background","-moz-linear-gradient(-45deg,  rgba(254,187,187,1) 0%, rgba(255,92,92,1) 100%)")
							.css("background","-webkit-linear-gradient(-45deg,  rgba(254,187,187,1) 0%,rgba(255,92,92,1) 100%)")
							.css("background","linear-gradient(135deg,  rgba(254,187,187,1) 0%,rgba(255,92,92,1) 100%)")
							.css("filter","progid:DXImageTransform.Microsoft.gradient( startColorstr='#febbbb', endColorstr='#ff5c5c',GradientType=1 )")
//        					.css("background","hsla(0, 100%, 50%, 0.5)")
        					.css("border","0px")
//        					.css("text-shadow","0 0 10px rgba(255,255,255,1)")
							.css("-webkit-box-shadow","rgb(206,220,231) 0px 2px 6px")
	   						.css("-moz-box-shadow","rgb(206,220,231) 0px 2px 6px")
	   						.css("box-shadow","rgb(206,220,231) 0px 2px 6px");
        	/* msg button text */
        	$(".mwt_btn_color").css("color","#FFFFFF");
        	$("#mwt_mwt_slider_scroll").css("z-index","102") //50-101
        							   .css("margin-bottom","15px");
        	$("#mwt_slider_content").css("overflow-x","hidden")
			   						.css("overflow-y","auto")
			   						.css("height","198px")
			   						.css("top","20px")
			   						.css("text-align","center")			   						
			   						.css("-webkit-border-radius","0px 15px 15px 0px")
			   						.css("-moz-border-radius","0px 15px 15px 0px")
			   						.css("border-radius","0px 15px 15px 0px")			   						
			   						.css("-webkit-box-shadow","rgb(206,220,231) 0px 2px 6px")
			   						.css("-moz-box-shadow","rgb(206,220,231) 0px 2px 6px")
			   						.css("box-shadow","rgb(206,220,231) 0px 2px 6px")
			   						.css("background","hsla(0, 90%, 40%, 0.1)");
//        							.css("background","hsla(0,0%,100%,.1)");
			   					

        	
        	
        }
    };
    
});