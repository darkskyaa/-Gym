eApp.controller('navController', function ($scope, $http, $controller, sysInfoService, $q) {
    
    $controller('baseController', {
        $scope: $scope
    });
    $scope.controllerName = 'navController';
    
    var log = console.log;
    var table = console.table;
    
    $scope.init = function () {
    };
    
    
    $scope.init();
});
