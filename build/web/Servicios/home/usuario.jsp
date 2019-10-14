<!-- Menu Toggle Button -->
<a href="" class="dropdown-toggle" data-toggle="dropdown">
  <!-- The user image in the navbar-->
  <img src="Servicios/perfiles/img_usuarios/{{usuario[0].imagen}}/imagen.jpg?1.{{intc}}" class="user-image" alt="User Image">
  <!-- hidden-xs hides the username on small devices so only the image appears. -->
  <span class="hidden-xs">{{ usuario[0].usuario }}</span>
</a>
<ul class="dropdown-menu">
  <!-- The user image in the menu -->
  <li class="user-header">
    <img src="{{imagen1}}" class="img-circle" alt="User Image" width="100px" height="100px">
    <p>
      {{ usuario[0].nombre }} - Web Developer
      <small>Member since Nov. 2012</small>
    </p>
  </li>
  <!-- Menu Body -->
  <li class="user-body">
    <div class="col-xs-4 text-center">
      <a href="">Followers</a>
    </div>
    <div class="col-xs-4 text-center">
      <a href="">Sales</a>
    </div>
    <div class="col-xs-4 text-center">
      <a href="">Friends</a>
    </div>
  </li>
  <!-- Menu Footer-->
  <li class="user-footer">
    <div class="pull-left">
      <a ui-sref='perfil' class="btn btn-default btn-flat">Perfil</a>
    </div>
    <div class="pull-right">
        <a href="" ng-click="salir()" class="btn btn-default btn-flat">Salir</a>
    </div>
  </li>
</ul>