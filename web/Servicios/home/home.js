
   
    app.controller("home", function (  $http, $scope,$location,serveData,$state) {
        
   
   /*Variables del Menu*/
      $scope.tree1 = false; $scope.tree6 = false;$scope.tree11 = false; $scope.tree16 = false;
      $scope.tree2 = false; $scope.tree7 = false;$scope.tree12 = false; $scope.tree17 = false;
      $scope.tree3 = false; $scope.tree8 = false;$scope.tree13 = false; $scope.tree18 = false;
      $scope.tree4 = false; $scope.tree9 = false;$scope.tree14 = false; $scope.tree19 = false;
      $scope.tree5 = false; $scope.tree10 = false;$scope.tree15 = false; $scope.tree20 = false;
      $scope.Grupo1 = false; $scope.Grupo6 = false;$scope.Grupo11 = false; $scope.Grupo16 = false;
      $scope.Grupo2 = false; $scope.Grupo7 = false;$scope.Grupo12 = false; $scope.Grupo17 = false;
      $scope.Grupo3 = false; $scope.Grupo8 = false;$scope.Grupo13 = false; $scope.Grupo18 = false;
      $scope.Grupo4 = false; $scope.Grupo9 = false;$scope.Grupo14 = false; $scope.Grupo19 = false;
      $scope.Grupo5 = false; $scope.Grupo10 = false;$scope.Grupo15 = false; $scope.Grupo20 = false;
      
      
   /* Estructura del menu
   */
    $scope.tree_1 = function (menu) {
        if (menu == 1) $scope.tree1 = !$scope.tree1;
        if (menu == 2) $scope.tree2 = !$scope.tree2;
        if (menu == 3) $scope.tree3 = !$scope.tree3;        
        if (menu == 4) $scope.tree4 = !$scope.tree4;       
        if (menu == 5) $scope.tree5 = !$scope.tree5;       
        if (menu == 6) $scope.tree6 = !$scope.tree6;       
        if (menu == 7) $scope.tree7 = !$scope.tree7;       
        if (menu == 8) $scope.tree8 = !$scope.tree8;       
        if (menu == 9) $scope.tree9 = !$scope.tree9;       
        if (menu == 10) $scope.tree10 = !$scope.tree10;       
        if (menu == 11) $scope.tree11 = !$scope.tree11;       
        if (menu == 12) $scope.tree12 = !$scope.tree12;       
        if (menu == 13) $scope.tree13 = !$scope.tree13;       
        if (menu == 14) $scope.tree14 = !$scope.tree14;       
        if (menu == 15) $scope.tree15 = !$scope.tree15;       
        if (menu == 16) $scope.tree16 = !$scope.tree16;       
        if (menu == 17) $scope.tree17 = !$scope.tree17;       
        if (menu == 18) $scope.tree18 = !$scope.tree18;       
        if (menu == 19) $scope.tree19 = !$scope.tree19;      
        if (menu == 20) $scope.tree20 = !$scope.tree20;
        }  
     $scope.Grupolist = function (menu) {
        if (menu == 1) $scope.Grupo1 = !$scope.Grupo1;
        if (menu == 2) $scope.Grupo2 = !$scope.Grupo2;
        if (menu == 3) $scope.Grupo3 = !$scope.Grupo3;        
        if (menu == 4) $scope.Grupo4 = !$scope.Grupo4;       
        if (menu == 5) $scope.Grupo5 = !$scope.Grupo5;       
        if (menu == 6) $scope.Grupo6 = !$scope.Grupo6;       
        if (menu == 7) $scope.Grupo7 = !$scope.Grupo7;       
        if (menu == 8) $scope.Grupo8 = !$scope.Grupo8;       
        if (menu == 9) $scope.Grupo9 = !$scope.Grupo9;       
        if (menu == 10) $scope.Grupo10 = !$scope.Grupo10;       
        if (menu == 11) $scope.Grupo11 = !$scope.Grupo11;       
        if (menu == 12) $scope.Grupo12 = !$scope.Grupo12;       
        if (menu == 13) $scope.Grupo13 = !$scope.Grupo13;       
        if (menu == 14) $scope.Grupo14 = !$scope.Grupo14;       
        if (menu == 15) $scope.Grupo15 = !$scope.Grupo15;       
        if (menu == 16) $scope.Grupo16 = !$scope.Grupo16;       
        if (menu == 17) $scope.Grupo17 = !$scope.Grupo17;       
        if (menu == 18) $scope.Grupo18 = !$scope.Grupo18;       
        if (menu == 19) $scope.Grupo19 = !$scope.Grupo19;      
        if (menu == 20) $scope.Grupo20 = !$scope.Grupo20;
        }  
        
       serveData.data.imagen = ""; 
        
        $scope.intc = 1;
        $scope.valor = false;  $scope.barramenu = true 
        
        /*Nos muestra pagina de inicio*/
        $state.go("home",{},{});
          
       
        if(serveData.data.lg == true) {
           $scope.valor =  serveData.data.lg;
           serveData.data.lg = false;
         
        $scope.activamenu = function()
        {
            if($scope.barramenu == true)  $scope.barramenu = false
            else  $scope.barramenu = true
        }        
        
        
       /*obtenemos los datos del usuario */
        $http.post('/SistemaINEB/usuario',{ usuario : serveData.data.usuario })
           .success(function(record3){
               $scope.intc++;
                 $scope.usuario =  record3;
                $scope.intc++; 
               serveData.data.imagen = "Servicios/perfiles/img_usuarios/"+$scope.usuario[0].imagen+"/imagen.jpg?1."+$scope.intc;
               $scope.imagen1=serveData.data.imagen;
               serveData.data.usuarioN = $scope.usuario[0].nombre;
               $scope.intc++; 
         });
         
         /*obtenemos las opciones del menu que tiene permisos el usuario*/
          $http.post('/SistemaINEB/menu').success(function(record4){
           $scope.menu = record4;  
           
             $scope.currentPage = 1; //current page
             $scope.entryLimit = 1000; //max no of items to display in a page
             $scope.filteredItems = $scope.menu.length; //Initially for no filter  
             $scope.totalItems = $scope.menu.length;              
          });
       $scope.setPage = function(pageNo) {
            $scope.currentPage = pageNo;
        };
        $scope.filter = function() {
            $timeout(function() { 
                $scope.filteredItems =  $scope.filtered.length;
            }, 10);
        };
        $scope.sort_by = function(predicate) {
            $scope.predicate = predicate;
            $scope.reverse = !$scope.reverse;
        }; 
        $scope.salir = function (){
            $location.url("/");
        };
        
     }  
        else {$location.url("/");}   
        
        
        
    //-- MENU--    
    /*    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
     $("#menu-toggle-2").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled-2");
        $('#menu ul').hide();
    });
 
     function initMenu() {
      $('#menu ul').hide();
      $('#menu ul').children('.current').parent().show();
      //$('#menu ul:first').show();
      $('#menu li a').click(
        function() {
          var checkElement = $(this).next();
          if((checkElement.is('ul')) && (checkElement.is(':visible'))) {
            return false;
            }
          if((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
            $('#menu ul:visible').slideUp('normal');
            checkElement.slideDown('normal');
            return false;
            }
          }
        );
      }
    $(document).ready(function() {initMenu();});*/
        
      function _init(){"use strict";$.AdminLTE.layout={activate:function(){var a=this;a.fix(),a.fixSidebar(),$(window,".wrapper").resize(function(){a.fix(),a.fixSidebar()})},fix:function(){var a=$(".main-header").outerHeight()+$(".main-footer").outerHeight(),b=$(window).height(),c=$(".sidebar").height();if($("body").hasClass("fixed"))$(".content-wrapper, .right-side").css("min-height",b-$(".main-footer").outerHeight());else{var d;b>=c?($(".content-wrapper, .right-side").css("min-height",b-a),d=b-a):($(".content-wrapper, .right-side").css("min-height",c),d=c);var e=$($.AdminLTE.options.controlSidebarOptions.selector);"undefined"!=typeof e&&e.height()>d&&$(".content-wrapper, .right-side").css("min-height",e.height())}},fixSidebar:function(){return $("body").hasClass("fixed")?("undefined"==typeof $.fn.slimScroll&&window.console&&window.console.error("Error: the fixed layout requires the slimscroll plugin!"),void($.AdminLTE.options.sidebarSlimScroll&&"undefined"!=typeof $.fn.slimScroll&&($(".sidebar").slimScroll({destroy:!0}).height("auto"),$(".sidebar").slimscroll({height:$(window).height()-$(".main-header").height()+"px",color:"rgba(0,0,0,0.2)",size:"3px"})))):void("undefined"!=typeof $.fn.slimScroll&&$(".sidebar").slimScroll({destroy:!0}).height("auto"))}},$.AdminLTE.pushMenu={activate:function(a){var b=$.AdminLTE.options.screenSizes;$(a).on("click",function(a){a.preventDefault(),$(window).width()>b.sm-1?$("body").hasClass("sidebar-collapse")?$("body").removeClass("sidebar-collapse").trigger("expanded.pushMenu"):$("body").addClass("sidebar-collapse").trigger("collapsed.pushMenu"):$("body").hasClass("sidebar-open")?$("body").removeClass("sidebar-open").removeClass("sidebar-collapse").trigger("collapsed.pushMenu"):$("body").addClass("sidebar-open").trigger("expanded.pushMenu")}),$(".content-wrapper").click(function(){$(window).width()<=b.sm-1&&$("body").hasClass("sidebar-open")&&$("body").removeClass("sidebar-open")}),($.AdminLTE.options.sidebarExpandOnHover||$("body").hasClass("fixed")&&$("body").hasClass("sidebar-mini"))&&this.expandOnHover()},expandOnHover:function(){var a=this,b=$.AdminLTE.options.screenSizes.sm-1;$(".main-sidebar").hover(function(){$("body").hasClass("sidebar-mini")&&$("body").hasClass("sidebar-collapse")&&$(window).width()>b&&a.expand()},function(){$("body").hasClass("sidebar-mini")&&$("body").hasClass("sidebar-expanded-on-hover")&&$(window).width()>b&&a.collapse()})},expand:function(){$("body").removeClass("sidebar-collapse").addClass("sidebar-expanded-on-hover")},collapse:function(){$("body").hasClass("sidebar-expanded-on-hover")&&$("body").removeClass("sidebar-expanded-on-hover").addClass("sidebar-collapse")}},$.AdminLTE.tree=function(a){var b=this,c=$.AdminLTE.options.animationSpeed;$(document).on("click",a+" li a",function(a){var d=$(this),e=d.next();if(e.is(".treeview-menu")&&e.is(":visible"))e.slideUp(c,function(){e.removeClass("menu-open")}),e.parent("li").removeClass("active");else if(e.is(".treeview-menu")&&!e.is(":visible")){var f=d.parents("ul").first(),g=f.find("ul:visible").slideUp(c);g.removeClass("menu-open");var h=d.parent("li");e.slideDown(c,function(){e.addClass("menu-open"),f.find("li.active").removeClass("active"),h.addClass("active"),b.layout.fix()})}e.is(".treeview-menu")&&a.preventDefault()})},$.AdminLTE.controlSidebar={activate:function(){var a=this,b=$.AdminLTE.options.controlSidebarOptions,c=$(b.selector),d=$(b.toggleBtnSelector);d.on("click",function(d){d.preventDefault(),c.hasClass("control-sidebar-open")||$("body").hasClass("control-sidebar-open")?a.close(c,b.slide):a.open(c,b.slide)});var e=$(".control-sidebar-bg");a._fix(e),$("body").hasClass("fixed")?a._fixForFixed(c):$(".content-wrapper, .right-side").height()<c.height()&&a._fixForContent(c)},open:function(a,b){b?a.addClass("control-sidebar-open"):$("body").addClass("control-sidebar-open")},close:function(a,b){b?a.removeClass("control-sidebar-open"):$("body").removeClass("control-sidebar-open")},_fix:function(a){var b=this;$("body").hasClass("layout-boxed")?(a.css("position","absolute"),a.height($(".wrapper").height()),$(window).resize(function(){b._fix(a)})):a.css({position:"fixed",height:"auto"})},_fixForFixed:function(a){a.css({position:"fixed","max-height":"100%",overflow:"auto","padding-bottom":"50px"})},_fixForContent:function(a){$(".content-wrapper, .right-side").css("min-height",a.height())}},$.AdminLTE.boxWidget={selectors:$.AdminLTE.options.boxWidgetOptions.boxWidgetSelectors,icons:$.AdminLTE.options.boxWidgetOptions.boxWidgetIcons,animationSpeed:$.AdminLTE.options.animationSpeed,activate:function(a){var b=this;a||(a=document),$(a).on("click",b.selectors.collapse,function(a){a.preventDefault(),b.collapse($(this))}),$(a).on("click",b.selectors.remove,function(a){a.preventDefault(),b.remove($(this))})},collapse:function(a){var b=this,c=a.parents(".box").first(),d=c.find("> .box-body, > .box-footer, > form  >.box-body, > form > .box-footer");c.hasClass("collapsed-box")?(a.children(":first").removeClass(b.icons.open).addClass(b.icons.collapse),d.slideDown(b.animationSpeed,function(){c.removeClass("collapsed-box")})):(a.children(":first").removeClass(b.icons.collapse).addClass(b.icons.open),d.slideUp(b.animationSpeed,function(){c.addClass("collapsed-box")}))},remove:function(a){var b=a.parents(".box").first();b.slideUp(this.animationSpeed)}}}if("undefined"==typeof jQuery)throw new Error("AdminLTE requires jQuery");$.AdminLTE={},$.AdminLTE.options={navbarMenuSlimscroll:!0,navbarMenuSlimscrollWidth:"3px",navbarMenuHeight:"200px",animationSpeed:500,sidebarToggleSelector:"[data-toggle='offcanvas']",sidebarPushMenu:!0,sidebarSlimScroll:!0,sidebarExpandOnHover:!1,enableBoxRefresh:!0,enableBSToppltip:!0,BSTooltipSelector:"[data-toggle='tooltip']",enableFastclick:!0,enableControlSidebar:!0,controlSidebarOptions:{toggleBtnSelector:"[data-toggle='control-sidebar']",selector:".control-sidebar",slide:!0},enableBoxWidget:!0,boxWidgetOptions:{boxWidgetIcons:{collapse:"fa-minus",open:"fa-plus",remove:"fa-times"},boxWidgetSelectors:{remove:'[data-widget="remove"]',collapse:'[data-widget="collapse"]'}},directChat:{enable:!0,contactToggleSelector:'[data-widget="chat-pane-toggle"]'},colors:{lightBlue:"#3c8dbc",red:"#f56954",green:"#00a65a",aqua:"#00c0ef",yellow:"#f39c12",blue:"#0073b7",navy:"#001F3F",teal:"#39CCCC",olive:"#3D9970",lime:"#01FF70",orange:"#FF851B",fuchsia:"#F012BE",purple:"#8E24AA",maroon:"#D81B60",black:"#222222",gray:"#d2d6de"},screenSizes:{xs:480,sm:768,md:992,lg:1200}},$(function(){"use strict";$("body").removeClass("hold-transition"),"undefined"!=typeof AdminLTEOptions&&$.extend(!0,$.AdminLTE.options,AdminLTEOptions);var a=$.AdminLTE.options;_init(),$.AdminLTE.layout.activate(),$.AdminLTE.tree(".sidebar"),a.enableControlSidebar&&$.AdminLTE.controlSidebar.activate(),a.navbarMenuSlimscroll&&"undefined"!=typeof $.fn.slimscroll&&$(".navbar .menu").slimscroll({height:a.navbarMenuHeight,alwaysVisible:!1,size:a.navbarMenuSlimscrollWidth}).css("width","100%"),a.sidebarPushMenu&&$.AdminLTE.pushMenu.activate(a.sidebarToggleSelector),a.enableBSToppltip&&$("body").tooltip({selector:a.BSTooltipSelector}),a.enableBoxWidget&&$.AdminLTE.boxWidget.activate(),a.enableFastclick&&"undefined"!=typeof FastClick&&FastClick.attach(document.body),a.directChat.enable&&$(document).on("click",a.directChat.contactToggleSelector,function(){var a=$(this).parents(".direct-chat").first();a.toggleClass("direct-chat-contacts-open")}),$('.btn-group[data-toggle="btn-toggle"]').each(function(){var a=$(this);$(this).find(".btn").on("click",function(b){a.find(".btn.active").removeClass("active"),$(this).addClass("active"),b.preventDefault()})})}),function(a){"use strict";a.fn.boxRefresh=function(b){function c(a){a.append(f),e.onLoadStart.call(a)}function d(a){a.find(f).remove(),e.onLoadDone.call(a)}var e=a.extend({trigger:".refresh-btn",source:"",onLoadStart:function(a){return a},onLoadDone:function(a){return a}},b),f=a('<div class="overlay"><div class="fa fa-refresh fa-spin"></div></div>');return this.each(function(){if(""===e.source)return void(window.console&&window.console.log("Please specify a source first - boxRefresh()"));var b=a(this),f=b.find(e.trigger).first();f.on("click",function(a){a.preventDefault(),c(b),b.find(".box-body").load(e.source,function(){d(b)})})})}}(jQuery),function(a){"use strict";a.fn.activateBox=function(){a.AdminLTE.boxWidget.activate(this)}}(jQuery),function(a){"use strict";a.fn.todolist=function(b){var c=a.extend({onCheck:function(a){return a},onUncheck:function(a){return a}},b);return this.each(function(){"undefined"!=typeof a.fn.iCheck?(a("input",this).on("ifChecked",function(){var b=a(this).parents("li").first();b.toggleClass("done"),c.onCheck.call(b)}),a("input",this).on("ifUnchecked",function(){var b=a(this).parents("li").first();b.toggleClass("done"),c.onUncheck.call(b)})):a("input",this).on("change",function(){var b=a(this).parents("li").first();b.toggleClass("done"),a("input",b).is(":checked")?c.onCheck.call(b):c.onUncheck.call(b)})})}}(jQuery);  
    });
     