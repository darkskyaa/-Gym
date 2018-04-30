eApp.controller('initController', function ($scope, $http, $controller, sysInfoService, $q, $http) {
    
    $controller('baseController', {
        $scope: $scope
    });
    $scope.controllerName = 'initController';
    
    var log = console.log;
    var table = console.table;
    
    $scope.init = function () {
    	$scope.container = 'asset/txn/register/register.html';
    }
    $scope.init();
});
