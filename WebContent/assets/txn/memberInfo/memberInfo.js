eApp.controller('memberInfoController', function ($scope, $controller, sysInfoService) {
    
    $controller('baseController', {
        $scope: $scope
    });
    $scope.controllerName = 'memberInfoController';
    
    var log = console.log;
    var table = console.table;
    
    $scope.init = function () {
        $scope.name = sysInfoService.getUserName();
        $scope.phone = sysInfoService.getUserPhone();
        $scope.account = sysInfoService.getUserAccount();
    };
    
    
    $scope.init();
});
