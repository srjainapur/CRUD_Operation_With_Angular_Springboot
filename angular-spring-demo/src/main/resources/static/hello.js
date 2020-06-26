angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:9014/greeting').
        then(function(response) {
            $scope.greeting = response.data;
        });
});