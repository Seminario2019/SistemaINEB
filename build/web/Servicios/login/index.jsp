<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<div  ng-controller="login" >
     <div class="login-box"  style="background-color:  #ffffff;  height: 80%;  box-shadow: 8px 8px 10px 0px #818181;  border-radius: 20px;">
         <div >
             <div style=" text-align:  center">     
                  <img src="logo.jpeg" width="250" height="250" > 
              </div><!-- /.login-logo -->
              <div class="login-box-body">
                <p class="login-box-msg">Ingrese al Sistema</p>
                    <form  ng-submit="entrar(txtUsuario,txtContrasena)"  class="form-group" >
                        <fieldset>
                            <div class="input-group">
                                <span class="input-group-addon">  <i class="fa fa-user"></i></span> 
                              <input class="form-control" ng-model="txtUsuario" placeholder="Usuario" name="email" type="text" required>
                                
                              </div>
                            <div class="input-group">
                                <span class="input-group-addon">  <i class="fa fa-key"></i></span> 
                              <input class="form-control" ng-model="txtContrasena" placeholder="Contraseña" name="password" type="password" value=""  required>
                          </div>
                          <div class="row">
                            <div class="col-xs-12">
                              <button type="submit" 
                                class="btn btn-primary btn-block btn-flat"
                                >Ingresar al Sistemas</button>
                              </div><!-- /.col -->
                          </div>
                        </fieldset>
                     </form>
                </div>
              </div>
        
    </div> <!-- Fin del Container -->
    </div>