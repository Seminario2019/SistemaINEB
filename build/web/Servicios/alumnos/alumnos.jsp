 <?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<div class="panel-group" >
        <div class="panel panel-primary">
            <div class="panel-heading"> 
             
                       <span class="fa fa-dropbox"></span>REGISTRO DE ALUMNOS
            </div>
            <div class="panel-body">
            
             
                <div class="row  form-group form-group-sm form-inline " > 
                        <div class="col-md-6">  
                            
                            <table class="table table-bordered table-sm table-hover col-md-6" style="width: 100%">
                                 <tr>    
                                     <td>Correlativo</td>
                                     <td>  
                                         <input   type="text"  class="form-control"  placeholder="Correlativo"  ng-model="datos.correlativo" size="3" disabled style="width:150px" />
                                     </td>   
                                </tr><tr>        
                                     <td>Código</td>
                                     <td>  
                                         <input   type="text" class="form-control"   placeholder="Codigo"  ng-model="datos.codigo" ng-change="datos.codigo = esnumero(datos.codigo)" size="3" ng-disabled="!btn_guardar" style="width:150px" />
                                     </td>  
                                </tr><tr>       
                                     <td>Primer nombre</td>
                                     <td>  
                                         <input   type="text"  class="form-control"  placeholder="pnombre"  ng-model="datos.pnombre" size="3" ng-disabled="!btn_guardar" style="width:100%" />
                                     </td>  
                                </tr><tr>       
                                     <td>Segundo nombre</td>
                                     <td>  
                                         <input   type="text"  class="form-control"  placeholder="snombre"  ng-model="datos.snombre" size="3" ng-disabled="!btn_guardar" style="width:100%" />
                                     </td> 
                                </tr><tr>                                           
                                     <td>Primer apellido</td>
                                     <td>  
                                         <input   type="text"  class="form-control"  placeholder="papellido"  ng-model="datos.papellido" size="3" ng-disabled="!btn_guardar" style="width:100%" />
                                     </td>  
                                </tr><tr>       
                                     <td>Segundo apellido</td>
                                     <td>  
                                         <input   type="text"   class="form-control" placeholder="sapellido"  ng-model="datos.sapellido" size="3" ng-disabled="!btn_guardar" style="width:100%" />
                                     </td> 
                                </tr><tr>       
                                    <td>Fecha de nacimiento</td>
                                    <td>    <input type="date"  class="form-control" ng-disabled="!btn_guardar"  placeholder=""  ng-model="nfecha1"  >
                                    </td>                                 
                                </tr><tr>       
                                    <td>Edad</td>
                                    <td>    {{(((((((nfecha2-nfecha1)/1000)/60)/60)/24)/30)/12) | number:0}} años   </td>                                 
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
                            
                             <div ng-include="'Servicios/alumnos/modal_alumno.html'"></div> 
                             <div ng-include="'Servicios/actividad/modal_guarda.html'"></div> 
                 
            </div>
        </div>  
</div>

         

    




