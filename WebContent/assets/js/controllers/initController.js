eApp.controller('initController', function ($scope, $http, $controller, sysInfoService, $q) {

    $controller('baseController', {
        $scope: $scope
    });
    $scope.controllerName = 'initController';
    
    var log = console.log;
    var table = console.table;
    
    $scope.$watch(function () {
        return $scope.connector('get','container');
    }, function () {
        $scope.container = $scope.connector('get','container');
    }, true);
    
    
    $scope.init = function () {
        $scope.connector('set','container', 'assets/txn/register/register.html');
    }
    $scope.init();
});
