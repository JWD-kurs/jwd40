var wafepaApp = angular.module("wafepaApp");
wafepaApp.controller("recordsCtrl", function($scope, $http, $location){
	
	
	
	$scope.records = [];
	
	$scope.activities = [];
	$scope.users = [];
	
	$scope.newRecord = {};
	$scope.newRecord.time = "";
	$scope.newRecord.duration = "";
	$scope.newRecord.intensity = "";
	$scope.newRecord.description = "";
	
	$scope.newRecord.userId = "";
	$scope.newRecord.activityId = "";
	
	$scope.searchParams = {};
	$scope.searchParams.activity = $location.search().activityName != undefined ? $location.search().activityName  : "";
	$scope.searchParams.minDuration = $location.search().minDuration != undefined ? $location.search().minDuration : "";
	$scope.searchParams.intensity = $location.search().intensity != undefined ? $location.search().intensity  : "";;
	
	$scope.pageNum = 0;
	$scope.totalPages = 1
	
	var recordsUrl = "/api/records";
	
	var activitiesUrl = "/api/activities";
	var usersUrl = "/api/users";
	
	var getRecords = function(){
		
		var config = { params: {} };
		
		//Dakle, polja config.params objekta moraju da se zovu kako back-end ocekuje
		if($scope.searchParams.activity != ""){
			$location.search("activityName", $scope.searchParams.activity);
			config.params.activityName = $scope.searchParams.activity;
		}
		
		if($scope.searchParams.minDuration != ""){
			config.params.minDuration = $scope.searchParams.minDuration;
		}
		
		if($scope.searchParams.intensity != ""){
			config.params.intensity = $scope.searchParams.intensity;
		}		
		
		config.params.pageNum = $scope.pageNum;
		
		$http.get(recordsUrl, config).then(
			function success(res){
				$scope.records = res.data;
				$scope.totalPages = res.headers("totalPages");
			},
			function error(){
				alert("Something went wrong.");
			}
		);
	}
	
	getRecords();
	
	
	var getActivities = function(){
		$http.get(activitiesUrl).then(
			function success(res){
				$scope.activities = res.data;
			},
			function error(){
				alert("Something went wrong.");
			}
		);
	}
	
	var getUsers = function(){
		$http.get(usersUrl).then(
			function success(res){
				$scope.users = res.data;
			},
			function error(){
				alert("Something went wrong.");
			}
		);
	}
	
	getActivities();
	getUsers();
	
	$scope.doAdd = function(){
		//console.log($scope.newRecord);
		
		$http.post(recordsUrl, $scope.newRecord).then(
			function success(){
				getRecords();
				
				$scope.newRecord = {};
				$scope.newRecord.time = "";
				$scope.newRecord.duration = "";
				$scope.newRecord.intensity = "";
				$scope.newRecord.description = "";
				
				$scope.newRecord.userId = "";
				$scope.newRecord.activityId = "";
			},
			function error(){
				alert("Could not save the record!");
			}
		);
	}
	
	$scope.goToEdit = function(id){
		$location.path("/records/edit/" + id);
	}
	
	$scope.doSearch = function(){

		var params =  {};
		
		if($scope.searchParams.activity != ""){
			params.activityName = $scope.searchParams.activity;
		}
		
		if($scope.searchParams.minDuration != ""){
			params.minDuration = $scope.searchParams.minDuration;
		}
		
		if($scope.searchParams.intensity != ""){
			params.intensity = $scope.searchParams.intensity;
		}
		
		$location.search(params);
	}
	
	$scope.changePage = function(direction){
		$scope.pageNum = $scope.pageNum + direction;
		getRecords();
	}
	
});