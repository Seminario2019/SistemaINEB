 <?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<div class="panel-group" >
        <div class="panel panel-primary">
            <div class="panel-heading"> 
             
                       <span class="fa fa-dropbox"></span>ASIGNATURAS
            </div>
            <div class="panel-body">
            
             
                <div class="row  form-group form-group-sm form-inline " > 
                        <div class="col-md-6">  
                            
                            <table class="table table-bordered table-sm table-hover col-md-6" style="width: 100%">
                                 <tr>    
                                     <td>Id asignatura</td>
                                     <td>
                                        
                                            
                                                <input   type="text"    placeholder="id"  ng-model="datos.id" size="3" disabled style="width:50px" />
                                        
                                     </td> 
                                </tr>
                                 <tr>    <td   >Grado</td>
                                        <td>   <div  class="input-group input-group-sm" style="width: 100%"> 
                                                    <input style="width: 100%" type="text"  class="form-control" disabled  placeholder="Grado"  ng-model="datos.grado"  >
                                                    <span  class="input-group-addon btn btn-info" ng-show="btn_guardar" ng-click="lista_grados()"><i class=" fa fa-plus"  ></i></span>
                                                 </div>
                                        </td> 
                                </tr> <tr>    <td>Nombre de curso</td>
                                        <td>    <input style="width: 100%" type="text"  class="form-control" ng-disabled="!btn_guardar"  placeholder="Nombre"  ng-model="datos.nombre"   >
                                        </td> 
                                </tr> 
                                 
                            </table>  
                        </div>    
                        <div class="col-md-6"> 
                             
                            
                        </div>  
                </div>    
                
                          
                <hr>
                
                            <!--<a  ng-click="agregarprod(factura)" class="btn btn-info" >Cargar Documento</a>-->
                            <a  ng-click="limpiar()" class="btn btn-info btn-sm"  ng-show="btn_nuevo">Nuevo</a>
                            <a  ng-click="guardar()" class="btn btn-success btn-sm"  ng-show="btn_guardar">Guardar</a>
                            <a  ng-click="editar()" class="btn btn-warning btn-sm"  ng-show="btn_editar">Editar</a>
                            <a  ng-click="buscar()" class="btn btn-default btn-sm"  ng-show="btn_buscar">Buscar</a>
                            <a  ng-click="calcelar()" class="btn btn-primary btn-sm"  ng-show="btn_cancelar">Calcelar</a>
                            
                             <div ng-include="'Servicios/asignatura/modal_grados.html'"></div> 
                             <div ng-include="'Servicios/asignatura/modal_guarda.html'"></div> 
                             <div ng-include="'Servicios/asignatura/modal_asignaturas.html'"></div> 
                 
            </div>
        </div>  
</div>

         

    




