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

	// route for the cliente page
	.when('/cadastraCliente', {
		templateUrl : 'pages/cadastraCliente.html',
		controller : 'ClienteController'
	})

	// route for the plano page
	.when('/cadastraPlano', {
		templateUrl : 'pages/cadastraPlano.html',
		controller : 'PlanoController'
	})
	// route for the usuario page
	.when('/cadastraUsuario', {
		templateUrl : 'pages/cadastraUsuario.html',
		controller : 'UsuarioController'
	})
});

// create the controller and inject Angular's $scope
SmallBIApp.controller('mainController', function($scope) {
	// create a message to display in our view
	$scope.message = 'Everyone come and see how good I look!';

});

SmallBIApp.controller('ClienteController', function($scope, $http) {
	$scope.message = 'Cadastro de Cliente';
	$scope.BuscarClientes = function() {
		$http.get('http://smallbi.jelasticlw.com.br/rest/smallbi/clientes/list')
				.success(function(data) {
					if (data.clientes.length == undefined){
						$scope.clientes = data;
					} else {
						$scope.clientes = data.clientes;
					}
					
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
				'http://smallbi.jelasticlw.com.br/rest/smallbi/clientes/create',
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
	$scope.message = 'Cadastro de Planos';
	$scope.BuscarPlanos = function() {
		$http.get('http://smallbi.jelasticlw.com.br/rest/smallbi/planos/list')
				.success(function(data) {
					if (data.planos.length == undefined){
						$scope.planos = data;
					} else {
						$scope.planos = data.planos;
					}
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
				'http://smallbi.jelasticlw.com.brr/rest/smallbi/planos/create',
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

SmallBIApp.controller('UsuarioController', function($scope, $http) {
	$scope.message = 'Cadastro de Usuário.';
	$scope.BuscarUsuarios = function() {
		$http.get('http://smallbi.jelasticlw.com.br/rest/smallbi/usuarios/list')
				.success(function(data) {
					if (data.usuarios.length == undefined){
						$scope.usuarios = data;
					} else {
						$scope.usuarios = data.usuarios;
					}
				});
	};
	$scope.BuscarUsuarios();

	$scope.EnviarUsuario = function() {

		var parameter = JSON.stringify({
			type : "usuarios",
			nome : $scope.nome,
			login : $scope.login,
			senha : $scope.senha
		});

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.post(
				'http://node115243-smallbi.jelasticlw.com.br/rest/smallbi/usuarios/create',
				parameter, config).success(
				function(data, status, headers, config) {
					$scope.Resposta = 'Usuário Salvo com Sucesso!';
				}).error(
				function(data, status, header, config) {
					$scope.Resposta = "Data: " + data + "<hr />status: "
							+ status + "<hr />headers: " + header
							+ "<hr />config: " + config;
				});
	};
});