var app = angular.module("geektic", ['ngRoute']);

app.controller('TitreCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});

app.controller('MainCtrl', function($scope, $http, $location, $cookieStore)
		{
			$http.get('/api/main')
				.success(function(data)
				{
					$scope.users = data;
				})
		});

app.config(['$routeProvider',
            function($routeProvider) {
              $routeProvider
              	.when('/', {
                  templateUrl: 'views/main.html',
                  controller: 'MainCtrl'
                })
                .when('/utilisateurs', {
              	  templateUrl: 'views/utilisateurs.html',
              	  controller: 'UsersCtrl'
                })
                .when('/recherche', {
              	  templateUrl: 'views/recherche.html',
              	  controller: 'rechercheCtrl'
                });
            }]);