eApp.controller('initController', function ($scope, $http, $controller, sysInfoService, $q, $http) {
    
    $controller('baseController', {
        $scope: $scope
    });
    $scope.controllerName = 'initController';
    
    var log = console.log;
    var table = console.table;
    
    $scope.test = function() {
    	$http({
    		method: 'GET',
    		url: 'member/angular'
    	}).then(function successCallback(response) {
    		table(response.data);
    		angular.forEach(response.data, function(obj,index) {
    			alert(obj.id + ' : ' + obj.name);
    		})
    		
    	}, function errorCallback(response) {
    		
    	});
    }
    
    $scope.init = function () {
//        table(sysInfoService);
//        sysInfoService.setUserName('Johnson'); 帥的
        
        $scope.main = {
            data: [],
            param: []
        };
    }
    $scope.init();
});
