<!-- sidebar: style can be found in sidebar.less -->
<section class="sidebar"   >

  <!-- Sidebar user panel (optional) -->
  <div class="user-panel">
    <div class="pull-left image">
        <img ng-src="Servicios/perfiles/img_usuarios/{{usuario[0].imagen}}/imagen.jpg?1.{{intc}}" class="avatar img-circle" style="width:40px;height:40px">
    </div>
    <div class="pull-left info">
      <p>{{usuario[0].usuario}}</p>
      <!-- Status -->
      <a ui-sref="home"><i class="fa fa-circle text-success"></i> Online</a>
      <!-- <a href=""><i class="fa fa-circle text-danger"></i> Offline</a> -->
    </div>
  </div>

  <!-- search form (Optional) -->
  <form action="#" method="get" class="sidebar-form">
    <div class="input-group">
      <input type="text" name="q" ng-model="search" ng-change="filter()" placeholder="Buscar..." class="form-control" />
      <span class="input-group-btn">
        <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
      </span>
    </div>
  </form>
  <!-- /.search form -->

  <!-- Sidebar Menu -->
  <ul class="sidebar-menu sidebar-mini" ng-repeat="Grupo in menu ">
      <li class="treeview"><a class="fa fa-send" style=" background-color:  #005384" ng-click="Grupolist( Grupo.lista )"> {{Grupo.Grupo}} <i class="fa fa-angle-left pull-right"></i></a>
            <ul ng-show="Grupo{{Grupo.lista}}" class="sidebar-menu sidebar-mini" ng-repeat="men in filtered = (Grupo.menu | filter:search | orderBy : predicate :reverse) | startFrom:(currentPage-1)*entryLimit | limitTo:entryLimit">
              <!--<li class="header">Opciones</li>-->

             <li class="treeview"><a ui-sref="{{men.page}}" class="fa fa-{{men.icon}}" ng-click="tree_1( men.lista )"> {{men.nombre}} <i class="{{men.subicon}}"></i></a>
                  <ul ng-show="tree{{men.lista}}">
                      <li ng-repeat="submen in men.submenu"><a ui-sref="{{submen.subpage}}" class="fa fa-{{submen.iconsub}}"> {{submen.subnombre}}</a></li>
                  </ul>
              </li>        
            </ul><!-- /.sidebar-menu -->
      </li>
  </ul>
</section>
<!-- /.sidebar -->
