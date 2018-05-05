eApp.controller('initController', function ($scope, $controller, sysInfoService) {

    $controller('baseController', {
        $scope: $scope
    });
    $scope.controllerName = 'initController';
    
    var log = console.log;
    var table = console.table;
    
    $scope.init = function () {
        $scope.changeContainer('register');
    }
    
    $scope.init();
});
