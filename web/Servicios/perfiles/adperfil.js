/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller("adperfil", function($scope,$http,$location,serveData,uploadfoto,md5) {
         $scope.listamenu =[];$scope.listaseries =[];
        $scope.dato = {};$scope.serieasig = "";$scope.menuasig = "";
        $scope.intc = 1;
    $scope.editando = false;
         $scope.usuario = [];
       $http.post("/SistemaINEB/usuarios",{ usuario : serveData.data.usuario})
           .success(function(record3){
                 $scope.usuario =  record3;
                serveData.data.imagen = "Servicios/perfiles/img_usuarios/imagen.jpg";
                  $scope.imagen1=serveData.data.imagen;
                  $scope.intc++; 
         });
         $scope.fotoModal = function(a){
                $scope.inout = a;
		// console.log( cliente );
                angular.copy();
                $("#modal_upfoto").modal();
                
	} 
        $scope.fotoModalnue = function(a){
                $scope.inout = a;
		// console.log( cliente );
                angular.copy();
                $("#modal_upfotonue").modal();
                
	}
        $scope.uploadFile = function(a)
	{
		//var name = serveData.data.usuario;
                var name =   $scope.dato.usuario;
		var file = a;
		var archivo = $scope.inout;
                if($scope.inout=="in")  archivo =  "imagen.jpg";  
		
                $scope.dato.imagen = name;
		uploadfoto.uploadFile(file, name,archivo).then(function(res)
		{       $scope.dato.imagen =  $scope.dato.usuario;
			console.log(res);
                        if(res.data == "") swal("Error","Imagen no  subio","warning");
                        else  {  $("#modal_upfoto").modal('hide'); $scope.file = "";
                                $("#modal_upfotonue").modal('hide'); $scope.file = "";
                             $scope.intc++;
                        $scope.imagen="Servicios/perfiles/img_usuarios/imagen.jpg?1."+$scope.intc;    
                            }
		})
	}
        
        $http.post("/SistemaINEB/adperfil",{ usuario : serveData.data.usuario}).success(function(data){
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
		$http.post("/SistemaINEB/adperfilEdit",{ usuario :$scope.variable})
                        .success(function(response){
                    $scope.dato = response[0];$scope.intc++;
                    $scope.imagen = "Servicios/perfiles/img_usuarios/imagen.jpg?1."+$scope.intc;
                    $scope.intc++;
                angular.copy($scope.dato);
                $("#modal_adperfil").modal();
                });
                
	}
        $scope.contrasenaModal = function( usuario ){
                $scope.datocon={
                    usuario:usuario,
                    contrasena:'',
                    contrasena1:'',
                    contrasena2:''     
                };
                angular.copy($scope.dato);
                $("#modal_contrasena").modal();
                
	}
        $scope.guardarcon = function refreshData() {
             $scope.datocon.contrasena = md5.createHash($scope.datocon.contrasena);
             $scope.datocon.contrasena1 = md5.createHash($scope.datocon.contrasena1); 
             $scope.datocon.contrasena2 = md5.createHash($scope.datocon.contrasena2); 
           $http.post("/SistemaINEB/UsconSave",{datos:$scope.datocon})
             .success(function(response){
             //$window.alert(response[0].mensaje);*/swal( 'Good job!', 'You clicked the button!', 'success')
              if(response[0].mensaje == 'uno'){
                  swal( 'Exitoso!', 'Contraseña fue cambiada!', 'success')   
                  $scope.datocon.contrasena='';
                  $scope.datocon.contrasena1='';
                  $scope.datocon.contrasena2='';
              }
              else  swal("Error",response[0].mensaje, "error");    
            })
            
        };
        $scope.menu = [];
        $scope.series = [];
        $scope.permisosModal = function( usuario ){
             //$scope.menuasig = 3; 
            $scope.listamenu =[];
                $scope.variable = usuario;
                $http.post("Servicios/perfiles/listameneu.php",{ usuario : $scope.variable})
                 .success(function(record3){ $scope.listamenu=record3; });
		// console.log( cliente );
		$http.get("Servicios/perfiles/adperfilEdit.php?oridd="+$scope.variable)
                        .success(function(response){
                    $scope.dato = response[0];$scope.intc++;
                    $scope.imagen = "Servicios/perfiles/img_usuarios/imagen.jpg?1."+$scope.intc;
                    $scope.intc++;
                      
               
                })
                .finally(function() {
                     angular.copy($scope.dato);
                    $("#modal_perfilperm").modal();
                });
                
	}
        
        $scope.seriesModal = function( usuario ){
             //$scope.menuasig = 3; 
            $scope.listaseries =[];
                $scope.variable = usuario;
                $http.post("Servicios/perfiles/series/listaseries.php",{ usuario : $scope.variable})
                 .success(function(record3){ $scope.listaseries=record3; });
		// console.log( cliente );
		$http.get("Servicios/perfiles/adperfilEdit.php?oridd="+$scope.variable)
                        .success(function(response){
                    $scope.dato = response[0];$scope.intc++;
                    $scope.imagen = "Servicios/perfiles/img_usuarios/imagen.jpg?1."+$scope.intc;
                    $scope.intc++;
                    $http.post('Servicios/perfiles/series/series.php').success(function(record4){
                        $scope.series = record4;  
                       });    
               
                })
                .finally(function() {
                     angular.copy($scope.dato);
                    $("#modal_perfilseries").modal();
                });
                
	}
        
        $scope.deleteprod = function (index) {
            $scope.listamenu.splice(index, 1);
        };
        $scope.deleteser = function (index) {
            $scope.listaseries.splice(index, 1);
        };
        $scope.agregarper = function (index) {
            $igual =0;
         if(index != "" && index != -1  && index != "undefined"){  
             for (var i=0; i< $scope.listamenu.length; i++) {
                 if( $scope.listamenu[i].id == index && $igual ==0)
                    $igual = 1; 
              }
             for (var i=0; i< $scope.menu.length; i++) {
                 if( $scope.menu[i].id_men == index && $igual ==0)
                    $scope.listamenu.push({id:$scope.menu[i].id_men,nombre:$scope.menu[i].nombre});  
              }
             $scope.menuasig = "";      
        }
        };
        $scope.agregarser = function (index) {
            $igual =0;
         if(index != "" && index != -1  && index != "undefined"){  
             for (var i=0; i< $scope.listaseries.length; i++) {
                 if( ($scope.listaseries[i].id+"-"+$scope.listaseries[i].tipo) == index && $igual ==0)
                    $igual = 1; 
              }
             for (var i=0; i< $scope.series.length; i++) {
                 if( ($scope.series[i].id_men+"-"+$scope.series[i].tipo) == index  && $igual ==0)
                    $scope.listaseries.push({id:$scope.series[i].id_men,nombre:$scope.series[i].nombre,tipo:$scope.series[i].tipo});  
              }
            $scope.serieasig = "";     
        }
        };
        $scope.guardarser = function (index,usuario) {
            $http.post("Servicios/perfiles/series/serSave.php",{datos:index,usuario:usuario}).success(function(data){
            
              if(data[0].mensaje == 'uno'){
                  $("#modal_perfilseries").modal('hide'); 
                  swal( 'Exitoso!', 'Datos Guardados!', 'success')   
                  
              }
              else  swal("Error",data[0].mensaje, "error");    
            })
        }
        
        $scope.guardarper = function (index,usuario) {
            $http.post("Servicios/perfiles/perSave.php",{datos:index,usuario:usuario}).success(function(data){
            
              if(data[0].mensaje == 'uno'){
                  $("#modal_perfilperm").modal('hide'); 
                  swal( 'Exitoso!', 'Datos Guardados!', 'success')   
                  
              }
              else  swal("Error",data[0].mensaje, "error");    
            })
        }
        
        $scope.limpia = function(){
            $scope.dato.nombre = "";  $scope.dato.apellido = "";  $scope.dato.direccion = ""; 
                $scope.dato.nombre1 = "";  $scope.dato.apellido1 = "";  
                  $scope.dato.telefono = ""; 
                   $scope.dato.region = ""; $scope.dato.usuario = ""; $scope.dato.clave = ""; 
                   $scope.imagen = "";  $scope.dato.imagen = "";
        }
        $scope.nuevo = function( ){
            $scope.limpia();   
               $scope.intc++;
                    $scope.imagen = "Servicios/perfiles/img_usuarios/imagen.jpg?1."+$scope.intc;
                    $scope.intc++;
                angular.copy($scope.dato);
                $("#modal_nueperfil").modal();                
	}
        $scope.guardarnuevo = function(dato){ 
                  dato.clave = md5.createHash(dato.clave); 
          if($scope.dato.nombre != "" &&  $scope.dato.apellido != "" && 
                  $scope.dato.usuario != "" && $scope.dato.clave != "" ){
            $http.post("/SistemaINEB/nueperfilSave",{datos:dato}).success(function(data){
            
              if(data[0].mensaje == 'uno'){
                  swal( 'Exitoso!', 'Datos Guardados!', 'success')   
                  $scope.limpia(); 
                  $("#modal_nueperfil").modal('hide'); 
                  $http.post("/SistemaINEB/adperfil",{ usuario : serveData.data.usuario}).success(function(data){
                        $scope.list= data;
                        $scope.paginas();
                    });
              }
              else  swal("Error",data[0].mensaje, "error");    
            })
                  }else swal("Error","Ingrese dato en: Usuari, Clave, Nombre o Apellido", "error");
                      
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
           $http.post("/SistemaINEB/GuardaEditado"
            ,{datos:$scope.dato})
             .success(function(response){
             //$window.alert(response[0].mensaje);*/swal( 'Good job!', 'You clicked the button!', 'success')
              if(response[0].mensaje == 'uno'){
                  swal( 'Exitoso!', 'Datos Guardados!', 'success')   
                  //$location.url("/plantilla");
                  $("#modal_adperfil").modal('hide');
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
                    $http.post("/SistemaINEB/adperfil",{ usuario : serveData.data.usuario}).success(function(data){
                        $scope.list= data;
                        $scope.paginas();
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

