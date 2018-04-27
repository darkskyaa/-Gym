eApp.controller('registerController', function ($scope, $http, $controller, sysInfoService, $q, $http) {
    
    $controller('baseController', {
        $scope: $scope
    });
    $scope.controllerName = 'registerController';
    
    var log = console.log;
    var table = console.table;
    
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
