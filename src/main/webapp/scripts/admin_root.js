angular.module("root", ["ngResource"])
	.controller("users", ["$scope", "$resource", function($scope, $resource) {
                var url = window.location.href.split("/users").join("") + "/user_list";
		var users = $resource(url);
                console.log(url);
                console.log(users);
		
		$scope.getUsers = function () {
			$scope.users = users.get();
		};

		$scope.postUser = function () {
			var response = $scope.user.$save(function () {
				alert("User saved!");
			});
		};
	}]);


