angular.module('mainModule')
		.controller('alumnosCtrl', function($scope, alumnosSrv){
			$scope.alumnos = [];
			$scope.isC = true;
			$scope.test = [
			{
				nombre: "asd",
				rut: "123",
				ingreso: "2002"
			},
			{
				nombre: "asdasd",
				rut: "1123123",
				ingreso: "2004"
			}
			];

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
			console.log($scope.alumnos);
		});