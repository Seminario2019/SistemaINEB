<?php
	//phpinfo();
require_once("../../Database.php");
$JSON       = file_get_contents("php://input");
$request    = json_decode($JSON);
$user = $request->usuario;
$usuario = "";
if( $conn ) {
	  $i=0;
          foreach($request->datos as $obj){
            
            $c8 = $obj->id;
            $c9 = $obj->tipo;
            if($i == 0)$sql = " Declare @usuario as varchar(100)
                 DELETE t0
                 FROM usuariosseries t0 
                 INNER JOIN usuarios t1 on t0.usuario = t1.usuario collate SQL_Latin1_General_CP850_CI_AS
                  WHERE t1.id_user= $user; 
                 select @usuario = usuario from usuarios where id_user = $user;
                  INSERT INTO usuariosseries (usuario,series,tipo) 
                  values (@usuario,'$c8','$c9')";
            else $sql = " Declare @usuario as varchar(100)
                 select @usuario = usuario from usuarios where id_user = $user;
                  INSERT INTO usuariosseries (usuario,series,tipo) 
                  values (@usuario,'$c8','$c9')";
            //$params = array();

            $stmt = sqlsrv_query( $conn, $sql, array());
            if( $stmt === false) {
		die( print_r( sqlsrv_errors(), true) );
                }  
           $i++;
        } 
         
        
       // print  "]";
       
print "[{\"mensaje\":\"uno\"}]"; 
}else{
     die( print_r( sqlsrv_errors(), true));
     
                 // $reponse['statuslogin']=0;
}

	sqlsrv_free_stmt( $stmt);
        sqlsrv_close($conn);
       //print json_encode($data);
?>

