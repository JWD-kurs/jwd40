var wafepaApp = angular.module("wafepaApp");
wafepaApp.controller("addActivityCtrl", function($scope, $http, $location){
	
	var baseUrl = "/api/activities";
	
	$scope.activity = {};
	$scope.activity.name = "";
	
	$scope.doAdd = function(){
		$http.post(baseUrl, $scope.activity).then(
			function success(){
				$location.path("/activities");
			},
			function error(){
				alert("Couldn't add activity!");
			}
		)
	}
	
});