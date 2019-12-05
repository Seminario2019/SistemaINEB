    <div class="modal fade" id="modal_editjornada">
  <div class="modal-dialog">
    <div class="modal-content">


   <div class="panel-group" >
            <div class="panel panel-primary">
                    <div class="panel-heading"> 
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">Ã—</span></button>
        <h4 class="modal-title">Editar jornadas</h4>
     </div> 
                  <div class="panel-body">
          <form  class="form-inline"   style="text-align: center; background-color: #ffffff; border-color:  #FFC414;  "    >
                       
                                       
                       <table class=" table table-bordered table-sm table-hover form-group" style="text-align: left; margin-left: 2%; margin-right:2%; display: block; overflow-x: auto; white-space: nowrap;" > 
                           <tr><td>  <label style="width: 100px;  text-align: left;">Id jornada</label>  </td><td>
                            <input type="text" disabled required class="form-control" value="" placeholder="Id" size="50" ng-model="dato.id">
                            
                               </td> </tr>
                           
                           <tr><td>  <label style="width: 100px;  text-align: left;">Descripción</label>  </td><td>
                            <input type="text" ng-disabled="editado.us1" required class="form-control" value="" placeholder="Descripcion" size="50" ng-model="dato.descripcion">
                            
                               </td> </tr>                 

                     
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
