var swapApp = angular.module('swapApp', []);

swapApp.controller('swapAppController', function($scope, $http) {
	$http.get('api/getSwapItems').success(function(data) {
		$scope.swapItems = data;
	});
});