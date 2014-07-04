var app = angular.module("geektic", ['ngRoute']);

app.controller('TitreCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});

app.controller('MainCtrl', function($scope, $http)
		{
			$http.get('/api/main')
				.success(function(data)
				{
					$scope.nombre = data;
				});
		});

app.controller('UsersCtrl', function($scope, $http)
		{
			$http.get('/api/utilisateurs')
				.success(function(data)
				{
					$scope.users = data;
				});
		});

app.controller('RechercheCtrl', function($scope, $http)
		{
			$http.get('/api/interet')
				.success(function(data)
				{
					$scope.interets = data;
				});
			$scope.users = [];
			$scope.recherche = function()
			{
				$http.get('/api/recherche?sexe='+$scope.sexe+'&interet='+$scope.interet)
				.success(function(data)
				{
					 $scope.users = data;
				});
			};
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
              	  controller: 'RechercheCtrl'
                });
            }]);