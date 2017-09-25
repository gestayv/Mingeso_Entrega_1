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
                                console.log($scope.form)
				postAlumnos($scope.form, alumnosSrv);
				$window.alert("Datos enviados!");
				$window.location.reload();
			};
			
		});