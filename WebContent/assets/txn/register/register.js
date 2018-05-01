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
    		switch(response.data.code) {
    			case -1:
    				$scope.showErrorMsg('帳號重複! 請重新註冊。');
    				break;
    			case 0:
    				$scope.showErrorMsg('註冊失敗! 請聯絡管理者。');
    				break;
    			case 1:
    				$scope.showSuccessMsg('註冊成功!');
    				break;
    		}
    		
    	}, function errorCallback(response) {
    		$scope.showErrorMsg('註冊失敗! 請聯絡管理者。');
    	});
    };
    
    $scope.login = function() {
    	$http({
    		method: 'POST',
    		url: 'member/login',
    		data: $scope.loginForm
    	}).then(function successCallback(response) {
            sysInfoService.setUser(response.data);
            $scope.connector('set','container','');
    	}, function errorCallback(response) {
    		
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
