var wafepaApp = angular.module("wafepaApp");

wafepaApp.controller("activitiesCtrl", function($scope, $http, $location){
	
	$scope.activities = [];
	
	var baseUrl = "/api/activities";
	
	var getActivities = function(){
		
		var promise = $http.get(baseUrl);
		
		promise.then(
			function success(res){
				$scope.activities = res.data;
			},
			function error(){
				alert("Unsuccessful fetch!")
			}
		);
		
		//console.log("Poruka");
	}
	
	getActivities();
	
	$scope.goToEdit = function(aid){
		$location.path("/activities/edit/" + aid);
	}
	
	$scope.goToAdd = function(){
		$location.path("/activities/add");
	}
	
	$scope.doDelete = function(id){
		var promise = $http.delete(baseUrl + "/" + id);
		promise.then(
			function success(){
				getActivities();
			},
			function error(){
				alert("Something went wrong.");
			}
		);
	}
	
});