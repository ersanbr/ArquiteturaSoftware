// create the module and name it scotchApp
var SmallBIApp = angular.module('SmallBI', [ 'ngRoute' ]);

// configure our routes
SmallBIApp.config(function($routeProvider) {
	$routeProvider

	// route for the home page
	.when('/', {
		templateUrl : 'pages/home.html',
		controller : 'mainController'
	})

	// route for the about page
	.when('/cadastraCliente', {
		templateUrl : 'pages/cadastraCliente.html',
		controller : 'ClienteController'
	})

	// route for the contact page
	.when('/cadastraPlano', {
		templateUrl : 'pages/cadastraPlano.html',
		controller : 'PlanoController'
	});
});

// create the controller and inject Angular's $scope
SmallBIApp.controller('mainController', function($scope) {
	// create a message to display in our view
	$scope.message = 'Everyone come and see how good I look!';

});

SmallBIApp.controller('ClienteController', function($scope, $http) {
	$scope.message = 'Contact us! JK. This is just a demo.';
	$scope.BuscarClientes = function() {
		$http.get('http://localhost:8081/SmallBI/rest/smallbi/clientes/list')
				.success(function(data) {
					$scope.clientes = data.clientes;
				});
	};
	$scope.BuscarClientes();

	$scope.EnviarCliente = function() {

		var parameter = JSON.stringify({
			type : "clientes",
			nome : $scope.nome,
			rg : $scope.rg,
			cpf : $scope.cpf
		});

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.post(
				'http://localhost:8081/SmallBI/rest/smallbi/clientes/create',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Empresa Salva com Sucesso!';
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = "Data: " + data + "<hr />status: "
							+ status + "<hr />headers: " + header
							+ "<hr />config: " + config;
				});
	};
});

SmallBIApp.controller('PlanoController', function($scope, $http) {
	$scope.message = 'Look! I am an about page.';
	$scope.BuscarPlanos = function() {
		$http.get('http://localhost:8081/SmallBI/rest/smallbi/planos/list')
				.success(function(data) {
					$scope.planos = data.planos;
				});
	};
	$scope.BuscarPlanos();

	$scope.EnviarPlano = function() {

		var parameter = JSON.stringify({
			type : "planos",
			nome : $scope.nome,
			descricao : $scope.descricao,
			valor : $scope.valor
		});

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.post(
				'http://localhost:8081/SmallBI/rest/smallbi/planos/create',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Plano Salva com Sucesso!';
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = "Data: " + data + "<hr />status: "
							+ status + "<hr />headers: " + header
							+ "<hr />config: " + config;
				});
	};
});