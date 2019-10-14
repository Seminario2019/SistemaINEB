<?php
	//phpinfo();
require_once("../../Database.php");
$JSON       = file_get_contents("php://input");
$request    = json_decode($JSON);
$usuario    = $request->usuario; 
 
$data = array();
if( $conn ) {
	 $sql = "select  rtrim(t0.series) as id, t0.series_name as nombre, rtrim(t0.tipo) tipo
                from series t0
                inner join usuariosseries t1 on t1.series = t0.series and t0.tipo = t1.tipo
                inner join usuarios t2 on t1.usuario = t2.usuario collate SQL_Latin1_General_CP850_CI_AS
                where t2.id_user = $usuario order by t0.tipo ";
	$stmt = sqlsrv_query( $conn, $sql, array(), array( "Scrollable" => 'static' ));
       
	if( $stmt === false) {
		die( print_r( sqlsrv_errors(), true) );
	}        
         $i=0;
	print "["; 
	while( $row = sqlsrv_fetch_array( $stmt, SQLSRV_FETCH_ASSOC) ) {
         if($i!=0){ print ",";}
         print json_encode($row);
//            print  "{"
//                    . "\"id\":\"";  print $row["id"]; print "\","
//                    . "\"tipo\":\"";  print $row["tipo"]; print "\","
//                    . "\"nombre\":\"";  print $row["nombre"]; print "\""
//                    . "}";             
//                   
//                
                 $i++;
	}
        print  "]";

}else{
     die( print_r( sqlsrv_errors(), true));
     
                 // $reponse['statuslogin']=0;
}

	sqlsrv_free_stmt( $stmt);
        sqlsrv_close($conn);
        //print json_encode($data);
?>

