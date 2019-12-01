var wafepaApp = angular.module("wafepaApp");
wafepaApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/components/home/home.html',
			controller: 'homeCtrl'
		})
		.when('/activities', {
			templateUrl : '/app/components/activities/activities.html'
		})
		.when('/activities/add', {
			templateUrl : '/app/components/add-activity/add-activity.html'
		})
		.when('/activities/edit/:aid', {
			templateUrl : '/app/components/edit-activity/edit-activity.html'
		})
		.when('/records', {
			templateUrl : '/app/components/records/records.html'
		})
		.when('/records/edit/:id', {
			templateUrl : '/app/components/edit-record/edit-record.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);