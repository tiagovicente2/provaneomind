var populaComentarios = angular.module("populaComentarios", []);

	populaComentarios.controller('controller', ['$scope', '$http', function($scope, $http){


      $http({
       method: 'GET',
       url: 'https://jsonplaceholder.typicode.com/comments'
      }).then(function successCallback(response){
       $scope.comments = response.data
      }, function errorCallback(response){

      });

}]);
