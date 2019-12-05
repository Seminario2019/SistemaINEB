/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


app.controller('Uscontrasena', ['$http','$scope','serveData','md5', function($http,$scope,serveData,md5){
        
        $scope.usuario = serveData.data.usuario;
        $scope.dato={
            usuario:$scope.usuario,
            contrasena:'',
            contrasena1:'',
            contrasena2:''     
        };
        $scope.guardar = function refreshData() {
             $scope.dato.clave = md5.createHash($scope.dato.clave);
             $scope.dato.clave1 = md5.createHash($scope.dato.clave1); 
             $scope.dato.clave2 = md5.createHash($scope.dato.clave2);  
           $http.post("/e/SistemaIMNEB/UsconSave",{datos:$scope.dato})
             .success(function(response){
             //$window.alert(response[0].mensaje);*/swal( 'Good job!', 'You clicked the button!', 'success')
              if(response[0].mensaje == 'uno'){
                  swal( 'Exitoso!', 'Contraseña fue cambiada!', 'success')   
                  $scope.dato={
                      usuario:$scope.usuario,
                      contrasena:'',
                      contrasena1:'',
                      contrasena2:''     
                  };
              }
              else  swal("Error",response[0].mensaje, "error");    
            })
            
        };
        
}]);

