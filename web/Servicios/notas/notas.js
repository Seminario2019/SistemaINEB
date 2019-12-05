/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


     app.controller("notas", function($scope,$http,serveData,$state,$timeout) {
         
           
    $scope.limpia = function(){   $scope.factura = "";  $scope.envio = "0";}
    
    $scope.indexprod = -1; $scope.editarbloqueo = "liberado";
    $scope.serie = []; $scope.envio = "0";
    $scope.usuario = serveData.data.usuario;
    $scope.btn_nuevo = true;
    $scope.btn_guardar = false;
    $scope.btn_buscar = true;    
    $scope.btn_buscar1 = true;  
    $scope.btn_editar = false; 
    $scope.btn_editar1 = false;
    $scope.btn_cancelar  = false;
    $scope.bus_series  = true;
    $scope.campos = function(){ 
    $scope.datos = {
            id: 0,
            id_actividad : 0,
            actividad: "",
            id_alumno : 0,
            alumno:"",
            nota : 0,
            periodo:""
        }
    };
    $scope.campos();
    $scope.numero_s = function(){
        $http.post("/e/SistemaIMNEB/nota_correlativo").success(function( data ){
		$scope.datos.id = data[0].id;
	});
    }
    
    $scope.limpiar =  function(){
         $scope.campos();
        
        $scope.numero_s();
        
        $scope.btn_nuevo = false;
        $scope.btn_guardar = true;
        $scope.btn_buscar = false;
        $scope.btn_cancelar = true;
        $scope.btn_editar = false;
        $scope.bus_series  = false;

        $scope.btn_editar1 = false;
        $scope.editarbloqueo == "liberado"
    }
    $scope.editado = false;
    

    $scope.calcelar  = function(){
        $scope.limpiar();    
        $scope.btn_nuevo = true;
        $scope.btn_guardar = false;
        $scope.btn_buscar = true;
        $scope.btn_buscar1 = true;
        $scope.btn_cancelar = false;
        $scope.btn_editar1 = false;
        $scope.btn_editar = false; 
        $scope.bus_series  = true;
        $scope.editado == false;$scope.limpia(); 
    }
    $scope.editar = function(){
      
        $scope.btn_editar = false;
        
        $scope.btn_nuevo = false;
        $scope.btn_guardar = true;
        $scope.btn_buscar = false;
        $scope.btn_cancelar = true;
        
        $scope.btn_buscar1 = true;
        $scope.btn_editar1 = true;
        $scope.bus_series  = true;
    
    };
    $scope.buscar = function(){
        
        $scope.limpiar();
        $scope.btn_buscar1 = false;
        $scope.btn_buscar = false;    
        $scope.btn_nuevo = true;
        $scope.btn_guardar = false;
        $scope.bus_series  = false;
        $scope.btn_cancelar = true;
        
        $("#modal_notas").modal();
    }
    
           $http.post("/e/SistemaIMNEB/actividad_lista" ).success(function(data){
             $scope.list_actividad = data; 
             $scope.intc++;
          }); 
          $http.post("/e/SistemaIMNEB/alumno_lista" ).success(function(data){
             $scope.list_alumno = data; 
             //$scope.nfecha1 =  new Date(data.nfecha);
             $scope.intc++;
          }); 
   $scope.lista_alumnos = function(){       
                $("#modal_alumnos").modal();
      };
        $scope.lista_actividades = function(  ){          
                $("#modal_actividad").modal();
	};
        
    $scope.lista_notas = function(){       
      $http.post("/e/SistemaIMNEB/notas_lista" ).success(function(data){
             $scope.list_notas = data; 
             $scope.intc++;
          }); 
      };   
      
      $scope.lista_notas();
      
      $scope.seleccion_nota = function(data){
          $scope.datos.id  = data.id;
          $scope.datos.id_actividad  = data.id_actividad;
          $scope.datos.actividad = data.actividad;
          $scope.datos.id_alumno  = data.id_alumno;
          $scope.datos.alumno = data.alumno;
          $scope.datos.nota  = data.nota;
          $scope.datos.periodo = data.periodo;
          
          $scope.editarbloqueo = "liberado";
       	

            $scope.btn_buscar1 = true;
            $scope.btn_buscar =  true; 
            $scope.btn_editar = true;        
            $scope.btn_nuevo = true;
            $scope.btn_guardar = false;   
            $scope.btn_cancelar  = false;
            $scope.bus_series  = true;  
    }
        $scope.setPage = function(pageNo) {
            $scope.currentPage = pageNo;
        };
        $scope.filter = function() {
            $timeout(function() { 
                $scope.filteredItems =  $scope.filtered.length;
            }, 10);
        };
        $scope.sort_by = function(predicate) {
            $scope.predicate = predicate;
            $scope.reverse = !$scope.reverse;
        };  
        
       
       $scope.guardar= function(){
           
    $("#modal_guardar").modal();
           
        if($scope.datos.id > 0 || $scope.datos.id_asignatura > 0 || $scope.datos.id_tactividad > 0){   
           $scope.btn_guardar = false;  
        if($scope.btn_editar1 == false){   
           $scope.btn_guardar = false;  
            $http.post("/e/SistemaIMNEB/notas_nuevo",
            {datos:$scope.datos} )
             .success(function(response){
                    if( response[0].id > 0){
                        $scope.datos.id = response[0].id;
                        $("#modal_guardar").modal('hide');  
                        swal("¡Exito¡", response[0].mensaje, "success"); 
                 $scope.lista_notas();        
                $scope.btn_nuevo = true;
                $scope.btn_guardar = false;
                $scope.btn_buscar = true;    
                $scope.btn_buscar1 = true;  
                $scope.btn_editar = false; 
                $scope.btn_editar1 = false;
                $scope.btn_cancelar  = false;
                $scope.bus_series  = true;
                 }
                    else  {   $("#modal_guardar").modal('hide');swal("Error¡", response, "error");   
                            $scope.btn_guardar = true;  }
                })
                .error(function(data, status) {
                    $("#modal_guardar").modal('hide');  
                  swal("Error","datos no guardados: posible causa: .Se desconecto de la red o no tiene datos, VERIFIQUE o intentar de nuevo guardar. Error:#"+status+"-"+ data+"-", "error"); 
                  $scope.btn_guardar = true; ;
                })
                .finally(function() {
                  //$scope.btn_guardar =  false;
                });
           
        }else{
            $http.post("/e/SistemaIMNEB/nota_guadaEdit",
             {datos:$scope.datos} )
             .success(function(response){
                    if( response[0].id > 0){
                    $("#modal_guardar").modal('hide');  
                        swal("¡Exito¡", "Datos fueron ingresados", "success"); 
                        
                 $scope.lista_notas();      
                        
                $scope.btn_nuevo = true;
                $scope.btn_guardar = false;
                $scope.btn_buscar = true;    
                $scope.btn_buscar1 = true;  
                $scope.btn_editar = false; 
                $scope.btn_editar1 = false;
                $scope.btn_cancelar  = false;
                $scope.bus_series  = true;
                 }
                    else  {  
    $("#modal_guardar").modal('hide');  swal("Error¡", response, "error");   
                            $scope.btn_guardar = true; }
                })
                .error(function(data, status) {
    $("#modal_guardar").modal('hide');  
                  swal("Error","datos no guardados: posible causa: .Se desconecto de la red o no tiene datos, VERIFIQUE o intentar de nuevo guardar. Error:#"+status+"-"+ data+"-", "error"); 
                  $scope.btn_guardar = true; ;
                })
                .finally(function() {
                  //$scope.btn_guardar =  false;
                });
        }
    } else {
    $("#modal_guardar").modal('hide');  swal("¡Faltan Datos!", "Por favor verificar", "warning");
      
    }
       } 
     $scope.eshora = function (dato) {
            if (dato == true || dato == "" ) {
                        resultado= '0'
                    } else {
                        resultado= dato;
                    }
            return resultado;
        };
     $scope.esnumero = function (dato) {
            var resultado = "";var punto = 0;
            for(var i = 0;i< dato.length;i++){                
                if(dato[i] == '.' && punto ==0){
                    resultado= resultado+dato[i]; punto = 1;
                }else{
                    if (isNaN(dato[i]) || dato[i] < 0 || dato[i] > 9) {
                        resultado= resultado
                    } else {
                        resultado= resultado+dato[i];
                    }
                }    
            }  
            return resultado;
        };
        
        
        $scope.seleccion_alumno = function(data){
          $scope.datos.id_alumno = data.correlativo;
          $scope.datos.alumno = data.pnombre+" "+data.snombre+" "+data.papellido;
        }
        
        $scope.seleccion_actividad = function(data){
          $scope.datos.id_actividad = data.id;
          $scope.datos.actividad = data.tactividad+" - "+data.asignatura;
        }
        
      
});