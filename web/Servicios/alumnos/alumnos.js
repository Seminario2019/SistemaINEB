/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


     app.controller("alumnos", function($scope,$http,serveData,$timeout) {
         
           
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
    $scope.nfecha1 =new Date()    
    $scope.nfecha2 =new Date()    
    $scope.datos = {
            correlativo: 0,
            codigo : 0,
            pnombre: "",
            snombre: "",
            papellido: "",
            sapellido: "",
            nfecha:new Date()
        }
    };
    $scope.campos();
    $scope.numero_s = function(){
        $http.post("/e/SistemaIMNEB/alumno_correlativo").success(function( data ){
		$scope.datos.correlativo = data[0].id;
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
        $scope.editado == false;
        $scope.limpia(); 
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
        
        $("#modal_alumno").modal();
    }
    

    $scope.lista_alumno = function(){       
      $http.post("/e/SistemaIMNEB/alumno_lista" ).success(function(data){
             $scope.list_alumno = data; 
             //$scope.nfecha1 =  new Date(data.nfecha);
             $scope.intc++;
          }); 
      };   
      
      $scope.lista_alumno();
      
      $scope.seleccion_alumno = function(data){
          $scope.datos.correlativo  = data.correlativo;
          $scope.datos.codigo  = data.codigo;
          $scope.datos.pnombre = data.pnombre;
          $scope.datos.snombre  = data.snombre;
          $scope.datos.papellido = data.papellido;
          $scope.datos.sapellido  = data.sapellido;
          $scope.datos.nfecha = new Date(data.nfecha);
          $scope.nfecha1 = new Date(data.nfecha);
          
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
    
        var dd = $scope.nfecha1.getDate(); 
        var mm = $scope.nfecha1.getMonth() + 1; 
  
        var yyyy = $scope.nfecha1.getFullYear(); 
        if (dd < 10) { dd = '0' + dd;  } 
        if (mm < 10) { mm = '0' + mm;  } 
         $scope.datos.nfecha = yyyy + '-' + mm + '-' + dd;  
        if($scope.datos.codigo > 0 || $scope.datos.pnombre != "" || $scope.datos.papellido != ""){   
           $scope.btn_guardar = false;  
        if($scope.btn_editar1 == false){   
           $scope.btn_guardar = false;  
            $http.post("/e/SistemaIMNEB/alumno_nuevo",
            {datos:$scope.datos} )
             .success(function(response){
                    if( response[0].id > 0){
                        $scope.datos.id = response[0].id;
                        $("#modal_guardar").modal('hide');  
                        swal("¡Exito¡", response[0].mensaje, "success"); 
                 $scope.lista_alumno();        
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
            $http.post("/e/SistemaIMNEB/alumno_guadaEdit",
             {datos:$scope.datos} )
             .success(function(response){
                    if( response[0].id > 0){
                    $("#modal_guardar").modal('hide');  
                        swal("¡Exito¡", "Datos fueron ingresados", "success"); 
                        
                 $scope.lista_alumno();      
                        
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
        $scope.eliminar = function(id){
               swal({
        title: "Seguro?",
        text: "eliminar dato #"+id,
        type: "warning",
        showCancelButton: true,
        confirmButtonClass: "btn-danger",
        confirmButtonText: "si, eliminar!",
        closeOnConfirm: false
      },
      function(){
        
            $http.post("/e/SistemaIMNEB/alumno_eliminar",
             {datos:$scope.datos} )
             .success(function(response){
                    if( response[0].id > 0){
                    $("#modal_guardar").modal('hide');  
                        swal("¡Exito¡", "Datos fueron eliminados", "success"); 
                        
                 $scope.lista_alumno();      
                        
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
                  swal("Error","datos no eliminados: posible causa: .Se desconecto de la red o no tiene datos, VERIFIQUE o intentar de nuevo guardar. Error:#"+status+"-"+ data+"-", "error"); 
                  $scope.btn_guardar = true; ;
                })
                .finally(function() {
                  //$scope.btn_guardar =  false;
                });
      });   
                    
        };        
      
   var i=0; 
        $scope.generar_reporte = function(id){
             if($scope.datos.id_grado != 0){
                $scope.animmar = true;$scope.listadet++; 
                $("#modal_reporte").modal();
//                $http.post("/e/SistemaIMNEB/matricula_reporte",{id:})
//                        .success(function(data){
                 $scope.archivo = "Servicios/alumnos/zonas.jsp?id="+id;  
                        $scope.animmar = false; 
//                 })
//                 .error(function(data, status) {
//                      swal("Error","Error:#"+status+"-"+ data, "error");                   
//                    })
//                .finally(function() {scope.animmar = false;  
//                    })
                } 
                else {$("#modal_reporte").modal();}
                 i++;    
                    
        };      
      
});