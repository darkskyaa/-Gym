/**===============================================================================
								  BaseController
==================================================================================
    @Author: Johnson
    @description: BaseLine Controller
    @LastUpdate: 2018/04/14
================================================================================*/
/** ------------------------------------------------------------------------------
 * 
 * 	[function] 
 * 
 * -----------------------------------------------------------------------------*/
eApp.controller('baseController', function($rootScope, $scope, $http, $filter, $window, $timeout) {
    $scope.controllerName = ""; 
    $rootScope.language = $window.navigator.language || $window.navigator.userLanguage;
    /* current controller name */
    if($scope.$parent.controllerName){
    	$scope.localCtrl = $scope.$parent.controllerName;
    	$rootScope.localCtrl = $scope.localCtrl;
    }
    /**
     * 平台或交易間傳遞參數用
     * @type {[type]}
     */    
    $scope.args = $rootScope.args;
    
    
    /**========================================================================
	Platform Communication function and server
	平台程式即時通訊資料傳遞函式與擬伺服器
    @description: controller to controller, scope to scope.
    @LastUpdate: 2018/04/14
    @parameter: 
    	type = 'set' || 'get'
    	name = 'FPPDM100'
    	args = {CUST_ID:'A123456789',PROD_ID:'10010',...} || any kind of data
    @example: 
    ※'set':
    	var data = row;
    	$scope.connector('set','FPPDM100', data);
    ※'get':
    	var data = $scope.connector('get','FPPDM100');
    ※print:
    	$scope.connector();
    ==========================================================================*/
    $scope.connector = function (type, name, args) {
    	if(!type && !name && !args){
    		return;
    	};
    	//check parameter
    	if(!type || !name){
    		return;
		};
		//set id
		var id = angular.copy(name.toString().toUpperCase().trim());
		//select type
    	switch(type.toString().toUpperCase().trim()){
	    	case 'SET':
		    	var data = angular.copy(args);
		    	if($rootScope.server.id.indexOf(id)===-1){
		    		$rootScope.server.id.push(id);
		    		$rootScope.server.data.push(data);
		    	}else{
		    		$rootScope.server.data[$rootScope.server.id.indexOf(id)] = data;
		    	}
	    		break;
	    	case 'GET':
	    		if($rootScope.server.id.indexOf(id)===-1){
	    			return;
	    		}else{
	    			return (angular.copy($rootScope.server.data[$rootScope.server.id.indexOf(id)]));
	    		}
	    		break;
    		default:
    			return;
    	};
    };
    $rootScope.connector = $scope.connector;
    
	///======================
	/// 訊息通知
	///======================
    //Modify: 2016/03/22 ArthurKO
    //Modify: 2016/03/31 William: 新增參數，允許訊息帶參數
    //Success
	$rootScope.showSuccessMsg = function(sMsg, params) {
		$rootScope.showMsgProcess(sMsg, 'SUCCESS', params);
	}
	//Normal Message
	$rootScope.showMsg = function(sMsg, params) {
		$rootScope.showMsgProcess(sMsg, 'NORMAL', params);
	}
    //Warning Message
	$rootScope.showWarningMsg = function(sMsg, params) {
		$rootScope.showMsgProcess(sMsg, 'WARNING', params);
	}
	//Error Message
	$rootScope.showErrorMsg = function(sMsg, params) {	
		$rootScope.showMsgProcess(sMsg, 'DANGER', params);
	}
	//Error Message(dialog)
	$rootScope.showErrorMsgInDialog = function(sMsg, params){
		$rootScope.showMsgProcess(sMsg, 'DANGER', params);
//		$scope.errorMessage = 'ERROR:[' + msg + ']';
	}
    
	//Process Message
	$rootScope.showMsgProcess = function(sMsg, status, params) {
		
		if (typeof sMsg !== "undefined" && sMsg !== "") {
			var oDate = new Date();
			sMsg = padLeft(oDate.getHours().toString(), 2) + ":" +
					padLeft(oDate.getMinutes().toString(), 2) + ":" +
        			padLeft(oDate.getSeconds().toString(), 2) + "-" +
        			sMsgHandler(sMsg, params);
        			//$filter('i18n')(sMsg).replace('{0}', params);
        			//$filter('i18n')(sMsg);
		}

		sMsg = sMsg || $scope.msg;
		$scope.msg = sMsg;
		/**marking for production**/
//		console.log(sMsg);
//		var clazz = 'msg';
//		switch(status){
//		case 'warning':
//			clazz = 'warningMsg';
//			break;
//		case 'danger':
//			clazz = 'dangerMsg';
//		break;
//		default:
//			
//		}
//		$('#msgContent').removeClass().addClass(clazz);
		// if ($scope.$parent.tabInfo && $scope.$parent.tabInfo.selected) {
//		alert('baseCtrl status: ['+status+']');
		$rootScope.showStatusMsg(sMsg, status);
		// }
	};
	
    ///======================
	/// DATEPICKER
	///======================
	$rootScope.toJsDate = function(str){
    	if(!str)return null;
    	var a=str.split(" ");
    	var d=a[0].split("-");
    	var t=a[1].split(":");
        return new Date(d[0],(d[1]-1),d[2],t[0],t[1],t[2]);
    };
    $rootScope.nowDate = new Date();
    $rootScope.minDate = new Date(new Date().getFullYear()-1,0,1);
    $rootScope.maxDate = new Date(new Date().getFullYear()+1,11,31);
    
});
