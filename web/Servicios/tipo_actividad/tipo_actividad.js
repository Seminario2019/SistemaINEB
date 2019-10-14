/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller("tipo_actividad", function($scope,$http,$location,serveData,md5) {
         $scope.listamenu =[];$scope.listaseries =[];
        $scope.dato = {};$scope.serieasig = "";$scope.menuasig = "";
        $scope.intc = 1;
    $scope.editando = false;
         
     
        $http.post("/SistemaINEB/tactividad_lista" ).success(function(data){
             $scope.list = data; 
             $scope.intc++;
            })
             .error(function(data, status) {
                  swal("Error","Error:#"+status+"-"+ data, "error"); 
                  
                })
            .finally(function() {
                $scope.paginas();
             
          }); 
        
        $scope.mostrarModal = function( id ){
                $scope.variable = id;
		// console.log( cliente );
		$http.post("/SistemaINEB/tactividad_select",{ id :$scope.variable})
                        .success(function(response){
                    $scope.dato = response[0];$scope.intc++;
                    
                    $scope.intc++;
                angular.copy($scope.dato);
                $("#modal_edittipo_actividad").modal();
                });
                
	}
        
       
        
        
        
        
        
        
        $scope.limpia = function(){
            $scope.dato.id = "";  $scope.dato.descripcion = "";  
        }
        $scope.nuevo = function( ){
            $scope.limpia();   
                angular.copy($scope.dato);
                $("#modal_nuetipo_actividad").modal();                
	}
        $scope.guardarnuevo = function(dato){ 
          if($scope.dato.nombre != "" &&  $scope.dato.seccion != "" ){
            $http.post("/SistemaINEB/tactividad_nuevo",{datos:dato}).success(function(data){
            
              if(data[0].mensaje == 'uno'){
                  swal( 'Exitoso!', 'Datos Guardados!', 'success')   
                  $scope.limpia(); 
                  $("#modal_nuegrados").modal('hide'); 
                   $http.post("/SistemaINEB/tactividad_lista" ).success(function(data){
                    $scope.list = data; 
                    $scope.intc++;
                   });
              }
              else  swal("Error",data[0].mensaje, "error");    
            })
                  }else swal("Error","Faltan datos, Verificar", "error");
                      
        };
        $scope.editado = {
            us1:true,
            us2:true,
            us3:true,
            us4:true,
            us5:true,
            us6:true,
            us7:true,
            us8:true,
            us9:true,
            us10:true,
            us11:true,
            us12:true,
            us13:true,
            us14:true,
            btn:true,
            btn2:true,
            btn1:false
        };
        $scope.editar = function(id,opcion){
            $scope.editado.btn = !$scope.editado.btn;
            $scope.editado.btn1 = !$scope.editado.btn1;
            $scope.editado.btn2 = !$scope.editado.btn2;
          
            $scope.editado.us1 = !$scope.editado.us1;
            $scope.editado.us2 = !$scope.editado.us2;
            $scope.editado.us3 = !$scope.editado.us3;
            $scope.editado.us4 = !$scope.editado.us4;
            $scope.editado.us5 = !$scope.editado.us5;
            $scope.editado.us6 = !$scope.editado.us6;
            $scope.editado.us7 = !$scope.editado.us7;
            $scope.editado.us8 = !$scope.editado.us8;
            $scope.editado.us9 = !$scope.editado.us9;
            $scope.editado.us10 = !$scope.editado.us10;
            $scope.editado.us11 = !$scope.editado.us11;
            $scope.editado.us12 = !$scope.editado.us12;
            $scope.editado.us13 = !$scope.editado.us13;
            $scope.editado.us14 = !$scope.editado.us14;
        }
        ;
        $scope.guardar = function refreshData() {
          
           $http.post("/SistemaINEB/tactividad_guadaEdit"
            ,{datos:$scope.dato})
             .success(function(response){
             //$window.alert(response[0].mensaje);*/swal( 'Good job!', 'You clicked the button!', 'success')
              if(response[0].mensaje == 'uno'){
                  swal( 'Exitoso!', 'Datos Guardados!', 'success')   
                  //$location.url("/plantilla");
                  $("#modal_edittipo_actividad").modal('hide');
                  $scope.editado = {
                        us1:true,
                        us2:true,
                        us3:true,
                        us4:true,
                        us5:true,
                        us6:true,
                        us7:true,
                        us8:true,
                        us9:true,
                        us10:true,
                        us11:true,
                        us12:true,
                        us13:true,
                        us14:true,
                        btn:true,
                        btn1:false,
                        btn2:true
                    };
                      $http.post("/SistemaINEB/tactividad_lista" ).success(function(data){
                        $scope.list = data; 
                        $scope.intc++;
                       });
              }
              else  swal("Error",response[0].mensaje, "error");    
            })
            
        };
        $scope.paginas = function(){
            $scope.entryLimit = 9; //max no of items to display in a page
             $scope.filteredItems = $scope.list.length; //Initially for no filter  
             $scope.totalItems = $scope.list.length; 
             
             $scope.predicate = 'name';  
            $scope.reverse = true;  
            $scope.currentPage = 1;  
            $scope.order = function (predicate) {  
              $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;  
              $scope.predicate = predicate;  
            };    
            $scope.numPerPage = $scope.entryLimit;  
            $scope.paginate = function (value) {  
                var begin, end, index;  
                begin = ($scope.currentPage - 1) * $scope.numPerPage;  
                end = begin + $scope.numPerPage;  
                index = $scope.students.indexOf(value);  
                return (begin <= index && index < end);  
              }; 

               $scope.filter = function() {
                   $timeout(function() { 
                       $scope.filteredItems =  $scope.filteredItems.length;
                   }, 10);
               };
               $scope.sort_by = function(predicate) {
                   $scope.predicate = predicate;
                   $scope.reverse = !$scope.reverse;
               };
               
                     $scope.animmar1 = false;
                     $scope.animmar = true;
        }
        
});

