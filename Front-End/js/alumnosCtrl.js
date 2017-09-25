angular.module('mainModule')
		.controller('alumnosCtrl', function($scope, alumnosSrv){
			$scope.alumnos = [];
			$scope.isC = true;
			
			//Retorna todos los alumnos en el arreglo alumnos.
			function getAlumnos(){
				alumnosSrv.getAlumnos()
				.then(function(data){
					$scope.alumnos = data.data;
				})
				.catch(function(error){
					$scope.msg = "Error al acceder al servicio rest de alumnos/all";
				});
			}
			getAlumnos();
		});