 <?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<div class="panel-group" >
        <div class="panel panel-primary">
            <div class="panel-heading"> 
             
                       <span class="fa fa-dropbox"></span>ACTIVIDADES
            </div>
            <div class="panel-body">
            
             
                <div class="row  form-group form-group-sm form-inline " > 
                        <div class="col-md-6">  
                            
                            <table class=" table table-bordered table-sm table-hover col-md-6" style="width: 100% ; display: block; overflow-x: auto; white-space: nowrap;">
                                 <tr>    
                                     <td>Id actividad</td>
                                     <td>
                                        
                                            
                                                <input   type="text"    placeholder="id"  ng-model="datos.id" size="3" disabled style="width:50px" />
                                        
                                     </td> 
                                </tr>
                                 <tr>    <td   >Tipo actividad</td>
                                        <td>   <div  class="input-group input-group-sm" style="width: 100%"> 
                                                    <input style="width: 100%" type="text"  class="form-control" disabled  placeholder="tipo actividad"  ng-model="datos.tactividad">
                                                    <span  class="input-group-addon btn btn-info" ng-show="btn_guardar" ng-click="lista_tactividades()"><i class=" fa fa-plus"  ></i></span>
                                                 </div>
                                        </td> 
                                </tr> 
                                 <tr>    <td   >Asignatura</td>
                                        <td>   <div  class="input-group input-group-sm" style="width: 100%"> 
                                                    <input style="width: 100%" type="text"  class="form-control" disabled  placeholder="asignatura"  ng-model="datos.asignatura"  >
                                                    <span  class="input-group-addon btn btn-info" ng-show="btn_guardar" ng-click="lista_asignaturass()"><i class=" fa fa-plus"  ></i></span>
                                                 </div>
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
                            <!--a style="float:right "  ng-click="generar_reporte()" class="btn btn-success btn-sm" ng-show="btn_nuevo" ><span class="fa fa-print"> </span>IMPRIMIR</a-->
                            
                             <div ng-include="'Servicios/actividad/modal_tactividad.html'"></div> 
                             <div ng-include="'Servicios/actividad/modal_guarda.html'"></div> 
                             <div ng-include="'Servicios/actividad/modal_asignaturas.html'"></div> 
                             <div ng-include="'Servicios/actividad/modal_actividad.html'"></div> 
                 
            </div>
        </div>  
</div>

         

    




