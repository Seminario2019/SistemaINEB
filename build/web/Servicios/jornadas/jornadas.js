/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller("jornadas", function($scope,$http,$location,serveData,uploadfoto,md5) {
         $scope.listamenu =[];$scope.listaseries =[];
        $scope.dato = {};$scope.serieasig = "";$scope.menuasig = "";
        $scope.intc = 1;
    $scope.editando = false;
         
     
        $http.post("/e/SistemaIMNEB/Jornada_lista",{ usuario : serveData.data.usuario}).success(function(data){
             $scope.list = data; 
             $scope.intc++;
            })
             .error(function(data, status) {
                  swal("Error","Error:#"+status+"-"+ data, "error"); 
                  
                })
            .finally(function() {
                $scope.paginas();
             
          }); 
        
        $scope.mostrarModal = function( usuario ){
                $scope.variable = usuario;
		// console.log( cliente );
		$http.post("/e/SistemaIMNEB/Jornada_seljornada",{ id :$scope.variable})
                        .success(function(response){
                    $scope.dato = response[0];$scope.intc++;
                    
                  $scope.dato.id2= $scope.dato.id;
                    $scope.intc++;
                angular.copy($scope.dato);
                $("#modal_editjornada").modal();
                });
                
	}
        
       $scope.eliminarModal = function( usuario ){
                $scope.variable = usuario;
		// console.log( cliente );
		$http.post("/e/SistemaIMNEB/Jornada_elimina",{ id :$scope.variable})
                        .success(function(response){
                    if(response[0].mensaje == 'uno'){
                  swal( 'Exitoso!', 'Dato Eliminado!', 'success')   
                  //$location.url("/plantilla");
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
                     $http.post("/e/SistemaIMNEB/Jornada_lista",{ usuario : serveData.data.usuario}).success(function(data){
                            $scope.list = data; 
                            $scope.intc++;
                       });
              }
              else  swal("Error","Dato no se puede eliminar, esta asignado a otro modulo", "error");   
                });
                
	}    
        
        
        
        
        
        $scope.limpia = function(){
            $scope.dato.id = "";  $scope.dato.descripcion = "";  
        }
        $scope.nuevo = function( ){
            $scope.limpia();   
                angular.copy($scope.dato);
                $("#modal_nuejonada").modal();                
	}
        $scope.guardarnuevo = function(dato){ 
          if($scope.dato.descripcion != "" ){
            $http.post("/e/SistemaIMNEB/Jornada_nuevo",{datos:dato}).success(function(data){
            
              if(data[0].mensaje == 'uno'){
                  swal( 'Exitoso!', 'Datos Guardados!', 'success')   
                  $scope.limpia(); 
                  $("#modal_nuejonada").modal('hide'); 
                  $http.post("/e/SistemaIMNEB/Jornada_lista",{ usuario : serveData.data.usuario}).success(function(data){
                        $scope.list= data;
                        $scope.paginas();
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
          
           $http.post("/e/SistemaIMNEB/Jornada_guadaEdit"
            ,{datos:$scope.dato})
             .success(function(response){
             //$window.alert(response[0].mensaje);*/swal( 'Good job!', 'You clicked the button!', 'success')
              if(response[0].mensaje == 'uno'){
                  swal( 'Exitoso!', 'Datos Guardados!', 'success')   
                  //$location.url("/plantilla");
                  $("#modal_editjornada").modal('hide');
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
                     $http.post("/e/SistemaIMNEB/Jornada_lista",{ usuario : serveData.data.usuario}).success(function(data){
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

