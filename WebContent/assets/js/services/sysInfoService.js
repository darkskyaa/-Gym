///======================
/// singleton service
/// 存取登入者資料、系統變數、
///======================
eApp.factory('sysInfoService', ['$rootScope', '$q',
	function ($rootScope, $q) {

        /**============================================================================
         * 
         * 				Platform storage device 平台儲存裝置 ($rootScope)
         * 
         * ============================================================================*/
        /*-----------------------------------------------------------------------------
         * @Description: 前端資料管理伺服器
         *               font-end manager server
         *-----------------------------------------------------------------------------*/
        $rootScope.navigator = (navigator.userAgent.match("Safari") !== null && navigator.userAgent.match("Safari")) ? true : false;
        $rootScope.server = {
            id: [],
            data: []
        };
        $rootScope.system = {
            platform: {
                type: [],
                code: [],
                info: []
            },
            component: {
                type: [],
                code: [],
                info: []
            }
        };
        $rootScope.mode = {
            // pressure test mode
            pressure: {
                $record: false, // record
                $test: false // test
            }
        };
        //checker
        var $chk = {
            $obj: function (owner, match) {
                var flag = false,
                    deferred = $q.defer();
                for (var i = 0; i < owner.length; i += 1) {
                    if (owner[i] === match) {
                        flag = true;
                        deferred.resolve(i);
                        break;
                    }
                }
                if (!flag) deferred.reject();
                return deferred.promise;
            }
        };

        /*-----------------------------------------------------------------------------
         * @Description: 登出機制-判斷物件
         *               Logout Checker
         *  @Parameters: 
         *-----------------------------------------------------------------------------*/
        $chk.$obj($rootScope.system.platform.type, 'logout').then(
            function (i) {},
            function () {
                $rootScope.system.platform.type.push('logout');
                $rootScope.system.platform.code.push(0);
                $rootScope.system.platform.info.push({
                    status: false,
                    classic: false,
                    URL: {
                        $test: 'Login.html',
                        $official: 'http://portal.kgibank.com',
                        $official_test: 'http://portal-test.kgibank.com'
                    }
                });
            });

        /**============================================================================
         * 
         * 			Platform storage device and method 平台儲存裝置與方法 (singleton)
         * 
         * ============================================================================*/
        if (arguments.callee._singletonInstance) {
            return arguments.callee._singletonInstance;
        }

        var obj = {};

        obj.UserInfo = {};
        obj.RoleName = "";

        obj.MenuInfo = {}; //選單
        obj.SysParam = {}; //系統變數

        /** get set **/

        obj.getUser = function () {
            return $.parseJSON(sessionStorage.User);
        };
        obj.setUser = function (user) {
            sessionStorage.User = JSON.stringify(user);
        };

        obj.getUserID = function () {
            return sessionStorage.UserID;
        };
        obj.setUserID = function (UserID) {
            sessionStorage.UserID = UserID;
        };

        obj.getUserName = function () {
            return sessionStorage.UserName;
        };
        obj.setUserName = function (UserName) {
            sessionStorage.UserName = UserName;
        };

        obj.getRoleID = function () {
            return sessionStorage.RoleID;
        };
        obj.setRoleID = function (RoleID) {
            sessionStorage.RoleID = RoleID;
        };

        obj.getRoleName = function () {
            return sessionStorage.RoleName;
        };
        obj.setRoleName = function (RoleName) {
            sessionStorage.RoleName = RoleName;
        };

        obj.parseUserInfo = function (oJSON) {
            parseUserInfo(oJSON);
        }
        
        arguments.callee._singletonInstance = obj;
        return obj;

}]);
