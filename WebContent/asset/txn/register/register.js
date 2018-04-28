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
    		angular.forEach(response.data, function(obj,index) {
    			alert(obj.id + ' : ' + obj.name);
    		})
    		
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
    		table(response.data);
    		angular.forEach(response.data, function(obj,index) {
    			alert(obj.id + ' : ' + obj.name);
    		})
    		
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
