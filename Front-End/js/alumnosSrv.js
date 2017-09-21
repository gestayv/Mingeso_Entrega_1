angular.module('mainModule')
		.service('alumnosSrv', function($http){
			var urlBase = "http://172.17.0.1:9070/alumno/all";

			this.getAlumnos = function(){
				return $http.get(urlBase);
			};
		});