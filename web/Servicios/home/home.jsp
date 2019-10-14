
<div   >
    <div class="wrapper" style="background-color: transparent">

      <!-- Main Header -->
      <header class="main-header" style="background-color: transparent; 
              border-bottom-left-radius: 20px;border-bottom-right-radius: 20px;">
          <a class="logo">
          <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"><b>IMNEB </b>IMNEB</span>
          <!-- logo for regular state and mobile devices -->
          <span class="logo-lg"><b> Instituto </b>IMNEB</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
          </a>
          <!-- Navbar Right Menu -->
          <div class="navbar-custom-menu">
              <div  > </div>              
          </div>
        </nav>
                  
      </header>
      <header class="main-header" style="background-color: white; 
              border-bottom-left-radius: 20px;border-bottom-right-radius: 20px;
              box-shadow: 8px 8px 10px 0px #818181; position: fixed; top: 0;left: 0;right: 0;">
          <a class="logo">
          <!-- mini logo for sidebar mini 50x50 pixels -->
          <span class="logo-mini"><b>IMNEB</b>IMNEB</span>
          <!-- logo for regular state and mobile devices -->
          <span class="logo-lg"><b>Instituto </b>IMNEB</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->
          <a href="" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
          </a>
          <!-- Navbar Right Menu -->
          <div class="navbar-custom-menu">
              <a>
                  <img src="umg.png" class="img-thumbnail" alt="" width="150px" height="40px">
                  
                </a>
              <!--ul  class="nav navbar-nav"  ui-view="header"> </ul--!>      
            <!--  <ul class="nav navbar-nav">

              <!-- Messages: style can be found in dropdown.less
              <li class="dropdown messages-menu"
                  ng-include="'Servicios/home/mensajes.jsp'">
              </li>
              <!-- /.messages-menu 

              <!-- Notifications Menu 
              <li class="dropdown notifications-menu"
                  ng-include="'Servicios/home/notificaciones.jsp'">
              </li>

              <!-- User Account Menu 
              <li class="dropdown user user-menu"
                  ng-include="'Servicios/home/usuario.jsp'">
              </li>

            </ul>  -->
          </div>
        </nav>
                  
      </header>
      
      <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar" style="background-color: transparent; position: fixed; left: 0; top: 0;">
         <div style="background-color: black; border-top-right-radius: 5px;
                border-bottom-right-radius: 5px; margin-top: 15px;
                box-shadow: 8px 8px 10px 0px #818181;  height: 80vh; /* %-height of the viewport */
      overflow-y: scroll; scrollbar-face-color: black; -moz-scrollbar-face-color: yelow"  
          ng-include="'Servicios/home/menu.jsp'">
         </div>    
      </aside>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper" style="background-color: transparent">
      
        <section class="content" ui-view="content"> 
        </section>
         
      </div><!-- /.content-wrapper -->

      <!-- Main Footer -->
      <footer class="main-footer" style='width: 100%'>
        <!-- To the right -->
        <div class="pull-right hidden-xs">
          1.0
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2019 
            <a href="" target="blank">Instituto Mixto Nocturno IMNEB</a>.
        </strong> Derechos reservados.
      </footer>

    
    </div><!-- ./wrapper -->
</div>