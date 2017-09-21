angular.module('mainModule')
		.service('alumnosSrv', function($http){
			var urlGet = "http://172.17.0.1:9070/alumno/all";
			var urlPost = "http://172.17.0.1:9070/alumno/new"
			this.getAlumnos = function(){
				return $http.get(urlGet);
			};

			this.postAlumnos = function(datajson){
				return $http.post(urlPost, datajson);
			};
		});