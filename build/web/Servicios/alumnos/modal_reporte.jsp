   <style>  
     .odd {  
       background-color: antiquewhite;  
       color: #008b8b;  
     }  
     td th {  
       height: 30px;  
       min-width: 100px;  
     }  
     thead {  
       background-color: darkgray;  
       color: white;  
       height: 30px;  
     }  
     .preloader {
        width: 70px;
        height: 70px;
        border: 10px solid #eee;
        border-top: 10px solid #666;
        border-radius: 50%;
        animation-name: girar;
        animation-duration: 2s;
        animation-iteration-count: infinite;
        animation-timing-function: linear;
      }
        @keyframes girar {
          from {
            transform: rotate(0deg);
          }
          to {
            transform: rotate(360deg);
          }
        }
   </style> 
<div class="modal fade" id="modal_reporte" >
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
        <div class="panel-group" >
            <div class="panel panel-primary">
                    <div class="panel-heading">  
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">�</span></button>
                    <h4 class="modal-title">Reporte</h4>
                  </div> 
                  <div class="panel-body">
                      <div class="preloader" ng-show="animmar"></div>                    
                        <embed src="{{archivo}}" width="100%" height="700px" ng-show="!animmar">                       
                  </div>   
          </div><!-- /.modal-content -->
       </div><!-- /.modal-dialog -->
    </div>
  </div>
</div>
