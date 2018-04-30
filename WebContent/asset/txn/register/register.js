eApp.controller('registerController', function ($scope, $http, $controller, sysInfoService, $q) {
    
    $controller('baseController', {
        $scope: $scope
    });
    $scope.controllerName = 'registerController';
    
    var log = console.log;
    var table = console.table;
    
    $scope.register = function() {
    	debugger
    	$http({
    		method: 'POST',
    		url: 'member/register',
    		data: $scope.registerForm
    	}).then(function successCallback(response) {
    		debugger
    		table(response.data);
    		switch(response.data.code) {
    			case -1:
    				alert('帳號重複! 請重新註冊。');
    				break;
    			case 0:
    				alert('註冊失敗! 請聯絡管理者。');
    				break;
    			case 1:
    				// yes
    				break;
    		}
    		
    	}, function errorCallback(response) {
            debugger
    	});
    };
    
    $scope.login = function() {
        debugger
    	$http({
    		method: 'POST',
    		url: 'member/login',
    		data: $scope.loginForm
    	}).then(function successCallback(response) {
            debugger
            sysInfoService.setUser(response.data);
            $scope.container = '';
    	}, function errorCallback(response) {
    		debugger
    	});
    };
    
    $scope.init = function () {
    	$scope.registerForm = {
    		account: '',
            password: '',
            name: '',
            sex: '',
            birthday: '',
            phone: '',
            addr: ''
    	};
    	$scope.loginForm = {
            account: '',
            password: ''
    	};
    };
    
    
    $scope.init();
});
