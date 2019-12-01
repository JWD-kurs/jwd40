var wafepaApp = angular.module("wafepaApp");
wafepaApp.controller("editActivityCtrl", function($scope, $routeParams, $http, $location){
	
	//console.log($routeParams);
	
	$scope.activity = {};
	$scope.activity.name = "";
	
	var baseUrl = "/api/activities/" + $routeParams.aid;
	
	var getActivity = function(){
		
		var promise = $http.get(baseUrl);
		promise.then(
			function uspeh(odg){
				$scope.activity = odg.data;
			},
			function neuspeh(){
				console.log("Something went wrong!");
			}
		);
		
	}
	
	getActivity();
	
	$scope.doEdit = function(){
		
		$http.put(baseUrl, $scope.activity).then(
			function success(res){
				$location.path("/activities");
			},
			function error(){
				alert("Something went wrong!");
			}
		);
		
	}
	
});