angular.module("root", ["ngResource"]).controller("users", ["$scope", "$resource", function ($scope, $resource) {
        var url = window.location.href.split("/users").join("") + "/user_list";
        var users = $resource(url);
        console.log(url);

        $scope.getUsers = function () {
            console.log(users);
            $scope.users = users.query();
        };

        $scope.postUser = function () {
            var response = $scope.user.$save(function () {
                alert("User saved!");
            });
        };
    }]);


