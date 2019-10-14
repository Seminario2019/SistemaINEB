<?php
	//phpinfo();
require_once("../../Database.php");
/*$JSON       = file_get_contents("php://input");
$request    = json_decode($JSON);
$usuario    = $request->usuario; */
 
$data = array();
if( $conn ) {
	 $sql = " select rtrim(t0.series) id_men, rtrim(t0.series_name) nombre,rtrim(t0.tipo) tipo 
                 from series t0 order by t0.tipo, t0.series
                  ; ";
	$stmt = sqlsrv_query( $conn, $sql, array(), array( "Scrollable" => 'static' ));
       
	if( $stmt === false) {
		die( print_r( sqlsrv_errors(), true) );
	}        
         $i=0;
       print "["; 
	while( $row = sqlsrv_fetch_array( $stmt, SQLSRV_FETCH_ASSOC) ) {
         if($i!=0){ print ",";}
            print  "{"
                    . "\"id_men\":\"";  print $row["id_men"]; print "\","
                    . "\"tipo\":\"";  print $row["tipo"]; print "\","
                    . "\"nombre\":\"";  print $row["nombre"]; print "\""
                    . "}";             
                   
                
                 $i++;
	}
        print  "]";
        
}else{
     die( print_r( sqlsrv_errors(), true));
     
}

	sqlsrv_free_stmt( $stmt);
        sqlsrv_close($conn);
       //print json_encode($data);
?>

