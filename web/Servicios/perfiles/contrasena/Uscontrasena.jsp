<ol class="breadcrumb animated fadeIn fast">
    <li class="active"><strong>CAMBIO DE CONTRASEÑA</strong></li>
</ol>                   
                <form ng-submit="guardar()" class="form-inline"   style="text-align: center; background-color: #ffffff; border-color:  #FFC414;  "    >
                                                 
                       <div class="form-group" style="text-align: left; margin-left: 2%; margin-right:2%;"  > 
                        <br>   <i class="input-group "  >
                            <span class="input-group-addon"><label style="width: 160px;">Usuario:</label></span>
                            <input type="text" disabled="" required class="form-control"  placeholder="Estatus" size="50" ng-model="dato.usuario">
                           </i> 
                        <br>     <i class=" input-group "  >
                                   <span class="input-group-addon"><label style="width: 160px;">Contrase�a Antigua:</label></span>
                                   <input type="password" required  class="form-control" placeholder="Contrase�a Antigua" value="" size="50" ng-model="dato.contrasena">
                           </i> 
                        <br>     <i class=" input-group "  >
                                   <span class="input-group-addon"><label style="width: 160px;">Contraseña Neva:</label></span>
                                   <input type="password"  required  class="form-control" placeholder="Contrase�a Neva" value="" size="50" ng-model="dato.contrasena1">
                           </i> 
                        <br>     <i class=" input-group "  >
                                   <span class="input-group-addon"><label style="width: 160px;">Repetir Contraseña Nueva:</label></span>
                                   <input type="password" required class="form-control" placeholder="Repetir Contrase�a Nueva" value="" size="50" ng-model="dato.contrasena2">
                           </i> 

                     
                      </div>
                      <br/>                      
                      <button type="submit" class="btn btn-success">
                          <span class="fa fa-save" ></span> Cambiar contraseña
                      </button>                    
                  </form>