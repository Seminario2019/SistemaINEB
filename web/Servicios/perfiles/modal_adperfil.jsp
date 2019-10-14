    <div class="modal fade" id="modal_adperfil">
  <div class="modal-dialog">
    <div class="modal-content">

       
<div class="panel-group" >
            <div class="panel panel-primary">
                    <div class="panel-heading"> 
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
        <h4 class="modal-title">Editar Perfil</h4>
         </div> 
                  <div class="panel-body">
          <div class="col-sm-3">
                        
                            <img ng-src="{{imagen}}" class="img-circle" alt="" width="50px" height="50px">
                            
                     
                     <button class="btn btn-danger  btn-sm fa fa-upload "   ng-click="fotoModal('in')" ng-disabled="editado.btn2">. Fotografia </button>
                   
                </div>
          <form  class="form-inline"   style="text-align: center; background-color: #ffffff; border-color:  #FFC414;  "    >
                                                 
                       <table class=" table table-bordered table-sm table-hover form-group" style="text-align: left; margin-left: 2%; margin-right:2%;"  > 
                           <tr><td>  <label style="width: 100px;  text-align: left;">Primer nombre</label>  </td><td>
                            <input type="text" ng-disabled="editado.us1" required class="form-control" value="" placeholder="Nombre" size="50" ng-model="dato.nombre">
                            
                               </td> </tr>
                           
                           <tr><td>  <label style="width: 100px;  text-align: left;">Segundo nombre</label>  </td><td>
                            <input type="text" ng-disabled="editado.us1" required class="form-control" value="" placeholder="Nombre" size="50" ng-model="dato.nombre1">
                            
                               </td> </tr>
                           
                        <tr>     <td ><label style="width: 100px;text-align: left;">Primer apellido:</label></td><td>
                                   <input type="text" ng-disabled="editado.us2" required  class="form-control" placeholder="Apellido:" value="" size="50" ng-model="dato.apellido">
                        </td> </tr> 
                        <tr>     <td ><label style="width: 100px;text-align: left;">Segundo apellido:</label></td><td>
                                   <input type="text" ng-disabled="editado.us2" required  class="form-control" placeholder="Apellido:" value="" size="50" ng-model="dato.apellido1">
                        </td> </tr> 
                        <tr>     <td ><label style="width: 100px;text-align: left;">Direccion</label></td><td>
                                   <input type="text" ng-disabled="editado.us3" required  class="form-control" placeholder="Email:" value="" size="50" ng-model="dato.direccion">
                         </td></tr> 
                        <tr>     <td ><label style="width: 100px;text-align: left;">Telefono:</label></td><td>
                                   <input type="text" ng-disabled="editado.us10" required class="form-control" placeholder="Telefono:" value="" size="50" ng-model="dato.telefono">
                        </td></tr> 

                     
                      </table>
                      <br/>                      
                      <button ng-click="guardar()" class="btn btn-success" ng-disabled="editado.btn" >
                          <span class="fa fa-save" ></span> Guardar 
                      </button> 
                      <button ng-click="editar()" class="btn btn-primary" ng-disabled="editado.btn1" >
                          <span class="fa fa-save" ></span> Editar
                      </button>                    
                  </form>
                  </div>   
          </div><!-- /.modal-content -->
       </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
  
      <div ng-include="'Servicios/perfiles/modal_upfoto.html'"></div>
</div>
