
 <?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>       
        <style>
            .avatar{
                width: 55px;
                height: 55px;
            }
            .puntero{
                cursor: pointer;
            }

        </style>
 <div class="panel-group" >
        <div class="panel panel-primary"  >
            <div class="panel-heading">  
             DETALLE DE JORNADAS
           
                     </div>
     <div class="panel-body">  
         <div class=" content">
              <div class="col-md-3 input-group">
               <span class="input-group-addon"><span class="fa fa-search"></span></span><input type="text" ng-model="search" ng-change="filter()" placeholder="Buscar registros" class="form-control" />
               
                
              </div>
             <button ng-click="nuevo()" class="btn btn-success">
                          <span class="fa fa-newspaper-o" ></span> Crear Jornada 
                </button>
            <div class="col-md-4">
                Filtrado {{ filtered.length }} de {{ totalItems}} total datos   
            </div>
        <br/>
        <div class="row">
            <div class=" col-md-6">
            <table class="table table-bordered table-sm table-hover col-md-6" >
                <thead style=" background-color: lightcyan; align-content: center">
                <th>ID JORNADA&nbsp;<a ng-click="sort_by('id_jornada');"><i class="fa fa-sort"></i></a></th>
                <th>DESCRIPSIÓN&nbsp;<a ng-click="sort_by('descripcion');"><i class="fa fa-sort"></i></a></th>
                <th>EDITAR</th>
                <!--th>eliminar</th-->
                </thead>
                <tbody>
                    <tr ng-repeat="data in filtered = (list | filter:search | orderBy : predicate :reverse) | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit" >
                        
                        <td style=" text-align:  right">{{data.id}}</td>
                        <td>{{data.descripcion}}</td>
                        
                         <td style=" text-align:  center">
                            <a ng-click="mostrarModal( data.id )" class="btn btn-warning"><i class="fa fa-edit"></i></a>
			</td>
                        <!--td>
                            <a ng-click="eliminarModal( data.id )" class="btn btn-primary"><i class="fa fa-edit"></i></a>
			</td-->
                    </tr>
                </tbody>
                <tfoot style=" text-align: right;" >
                            
                            <pagination   total-items="totalItems" ng-model="currentPage"  
                                  max-size="5" boundary-links="true"  
                                  items-per-page="numPerPage" 
                                  class="pagination-sm" force-ellipses="true" 
                                  first-text="Primero"  last-text="Ultimo" 
                                  next-text="Siguiente" previous-text="Anterior"
                                >
                             </pagination>    
                 </tfoot>
                </table>
        </div> 
            </div>
         </div>
        </div>  
        </div>  
</div>      
            
      <div ng-include="'Servicios/jornadas/modal_nuejonada.html'"></div>            
      <div ng-include="'Servicios/jornadas/modal_editjornada.jsp'"></div>
      