 <div class="panel-group" >
        <div class="panel panel-primary"  >
            <div class="panel-heading">  
            <h3><strong>Perfil del Usuario</strong></h3>
        </div>
            <div class="panel-body">        
            <h4> {{usuario[0].nombre}} </h4>
            <hr>

            <div class="row">
                
                <!-- Div que contiene la imagen del usuario -->
                <div class="col-sm-3">
                    <section class="panel">
                        <div class="panel-body" align="center">
                            <img ng-src="Servicios/perfiles/img_usuarios/{{usuario[0].imagen}}/imagen.jpg?1.{{intc}}" class="img-circle" alt="" width="100px" height="100px">
                        </div>
                    </section>
                </div>

                <!-- Div, donde se mostrará la bio del usuario -->
                <div class="col-sm-9">
                    <section class="panel">
                        <div class="panel-body">
                            <strong>Biografia</strong>
                            <br>
                            <kbd><kbd>{{usuario[0].sexo}}</kbd></kbd>
                            <br>
                            {{usuario[0].telefono}}
                            <br>
                            {{usuario[0].celular}}
                            <br>
                            <address>
                              <strong>Correo Electronico</strong>
                              <br>
                              <a href="mailto:#">{{usuario[0].email}}</a>
                            </address>    
                            <br>
                            <br>
                            <button class="btn btn-primary" ng-click="mostrarModal( usuario[0].id )">Editar</button>
                        </div>
                    </section>
                </div>


            </div>


            
        </div>  
        </div>  
</div>    
      <div ng-include="'Servicios/perfiles/modal_adperfil.html'"></div>