angular.module('mainModule')
		.controller('formularioCtrl', function($scope, $window, alumnosSrv){
			$scope.form = {};

			function postAlumnos(data, alumnosSrv){
				alumnosSrv.postAlumnos(data)
				.then(function(){
					$scope.msj = "Post Correcto :)";
				})
				.catch(function(){
					$scope.msj = "Post Incorrecto :(";
				});
			};
			$scope.onSubmit = function(){
				postAlumnos($scope.form, alumnosSrv);
				$window.location.reload();
			};
			
		});