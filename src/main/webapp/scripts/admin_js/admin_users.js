var admin_users = angular.module("admin.users", ["ngResource"]);

admin_users.constant("baseUrl", "../users");
admin_users.controller("users", ["$scope", "$resource", "baseUrl", function ($scope, $resource, baseUrl) {

        // результатом работы $resource является объект (access object) с помощью которого можно выполнять обращения к серверу. 
        $scope.usersResource = $resource(baseUrl, {id: "@id", username: "@username", enabled: "@enabled"}, {"update" : {method : "PUT"}});

        // получение всех данных из модели
        // get all users from model
        $scope.refresh = function () {
            $scope.users = $scope.usersResource.query();
            $scope.user = undefined;
        };
        
        //update user
        $scope.update = function () {
            if (angular.isDefined($scope.user)) {
                $scope.user.$update();
                $scope.edit = false;
                $scope.refresh();
            }
        };

        $scope.edit = false;

        $scope.user_edit = function (user) {
            if (angular.isDefined(user)) {
                $scope.user = user;
                $scope.edit = true;
            }
        };
        
        $scope.back = function () {
            $scope.edit = false;
            $scope.user = undefined;
        };
         
        $scope.refresh();
    }]);

