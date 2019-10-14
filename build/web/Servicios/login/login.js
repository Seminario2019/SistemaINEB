
 app.controller("login",['$scope', '$http','$location','serveData','md5',function($scope, $http,$location,serveData,md5) {
                  
      $scope.rsJSON = [ ];
      // Ocultamos los divs de Alertas
      $scope.alertaLoginCorrecto = true;
      $scope.alertaLoginError    = true;
      // obtenemos el evento submit del formulario ng-submit="entrar()"
       $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";    
       
       
       /*Validamos usuario encriptando con metodo MD5*/
      $scope.entrar = function(user,pass) {  
        $http.post('/SistemaINEB/Servlet_Usuarios',{ usuario : user , contrasena : md5.createHash(pass) })
        .success(function(data) {
           // si no existe el usuario nos muestre un alerta de error
           if (data.length == 0){
             //$scope.alertaLoginError = false;   
             //$scope.alertaLoginCorrecto = true;   
             $scope.txtUsuario    = '';
             $scope.txtContrasena = ''; 
             swal("Error", "Tu usuario o contrasela son incorrectos", "error");
           }else{
             // si existe ya la hicimos y que nos ponga un mensaje de bienvenida
             if($scope.txtUsuario == data["0"].usuario){
                 serveData.data.lg = true;
                 serveData.data.usuario = $scope.txtUsuario;
                 serveData.data.id_user = data["0"].id_user;
                
                /*Nomos dirige al menu al momento de validar el usuario*/
                 $location.url("/principal");
             }else{
                 swal("Error",data, "error");
             } 
           }
        })
        .error(function(data) {
            swal("Error",data, "error");
        });   
        
      };
      // obtenemos el evento click del boton limpiar ng-click="limpiar()"
      $scope.limpiar = function() {
        $scope.alertaLoginError    = true;   
        $scope.alertaLoginCorrecto = true;   
        $scope.txtUsuario    = '';
        $scope.txtContrasena = '';   
      };
      
      
 
      }]);
