 <?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<div class="panel-group" >
        <div class="panel panel-primary">
            <div class="panel-heading"> 
             
                       <span class="fa fa-dropbox"></span>INGRESO DE NOTAS
            </div>
            <div class="panel-body">
            
             
                <div class="row  form-group form-group-sm form-inline " > 
                        <div class="col-md-6">  
                            
                            <table class="table table-bordered table-sm table-hover col-md-6" style="width: 100%">
                                 <tr>    
                                     <td>Id nota</td>
                                     <td>
                                        
                                            
                                                <input   type="text"    placeholder="id"  ng-model="datos.id" size="3" disabled style="width:50px" />
                                        
                                     </td> 
                                </tr>
                                 <tr>    <td   >Actividad</td>
                                        <td>   <div  class="input-group input-group-sm" style="width: 100%"> 
                                                    <input style="width: 100%" type="text"  class="form-control" disabled  placeholder="actividad"  ng-model="datos.actividad">
                                                    <span  class="input-group-addon btn btn-info" ng-show="btn_guardar" ng-click="lista_actividades()"><i class=" fa fa-plus"  ></i></span>
                                                 </div>
                                        </td> 
                                </tr> 
                                 <tr>    <td   >Alumnos</td>
                                        <td>   <div  class="input-group input-group-sm" style="width: 100%"> 
                                                    <input style="width: 100%" type="text"  class="form-control" disabled  placeholder="alumnos"  ng-model="datos.alumno"  >
                                                    <span  class="input-group-addon btn btn-info" ng-show="btn_guardar" ng-click="lista_alumnos()" ><i class=" fa fa-plus"  ></i></span>
                                                 </div>
                                        </td> 
                                </tr>
                                <tr>       
                                     <td>Nota</td>
                                     <td>  
                                         <input   type="text"    placeholder="nota"  ng-model="datos.nota" ng-change="datos.nota = esnumero(datos.nota)" size="3" ng-disabled="!btn_guardar" style="width:100%" />
                                     </td> 
                                </tr>
                                <tr>       
                                     <td>Periodo</td>
                                     <td>  
                                         <input   type="text"    placeholder="periodo"  ng-model="datos.periodo" size="3" ng-disabled="!btn_guardar" style="width:100%" />
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
                            
                             <div ng-include="'Servicios/notas/modal_actividad.html'"></div> 
                             <div ng-include="'Servicios/actividad/modal_guarda.html'"></div> 
                             <div ng-include="'Servicios/notas/modal_alumnos.html'"></div> 
                             <div ng-include="'Servicios/notas/modal_notas.html'"></div> 
                 
            </div>
        </div>  
</div>

         

    




