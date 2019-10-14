<ol class="breadcrumb animated fadeIn fast">
    <li class="active"><strong>CAMBIO DE CONTRASE√ëA</strong></li>
</ol>                   
                <form ng-submit="guardar()" class="form-inline"   style="text-align: center; background-color: #ffffff; border-color:  #FFC414;  "    >
                                                 
                       <div class="form-group" style="text-align: left; margin-left: 2%; margin-right:2%;"  > 
                        <br>   <i class="input-group "  >
                            <span class="input-group-addon"><label style="width: 160px;">Usuario:</label></span>
                            <input type="text" disabled="" required class="form-control"  placeholder="Estatus" size="50" ng-model="dato.usuario">
                           </i> 
                        <br>     <i class=" input-group "  >
                                   <span class="input-group-addon"><label style="width: 160px;">ContraseÒa Antigua:</label></span>
                                   <input type="password" required  class="form-control" placeholder="ContraseÒa Antigua" value="" size="50" ng-model="dato.contrasena">
                           </i> 
                        <br>     <i class=" input-group "  >
                                   <span class="input-group-addon"><label style="width: 160px;">Contrase√±a Neva:</label></span>
                                   <input type="password"  required  class="form-control" placeholder="ContraseÒa Neva" value="" size="50" ng-model="dato.contrasena1">
                           </i> 
                        <br>     <i class=" input-group "  >
                                   <span class="input-group-addon"><label style="width: 160px;">Repetir Contrase√±a Nueva:</label></span>
                                   <input type="password" required class="form-control" placeholder="Repetir ContraseÒa Nueva" value="" size="50" ng-model="dato.contrasena2">
                           </i> 

                     
                      </div>
                      <br/>                      
                      <button type="submit" class="btn btn-success">
                          <span class="fa fa-save" ></span> Cambiar contrase√±a
                      </button>                    
                  </form>