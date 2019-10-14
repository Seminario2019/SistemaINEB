<?php

require_once("../Database.php");
 $value = $_GET["oridd"];
    
if( $conn ) {
	 
	 $sql = "select  id_user,rtrim(usuario) as usuario,clave ,nombre ,apellido,email,pais "
                 . ",depto,coments,rtrim(imagen) as imagen,edad,sexo,telefono ,celular,cede "
                 . ",bio, rtrim(region ) as region"
                 . " from usuarios where id_user = $value ;";

	$stmt = sqlsrv_query( $conn, $sql, array(), array( "Scrollable" => 'static' ));
        $row_count = sqlsrv_num_rows( $stmt )-1;
   
/*if ($row_count === false)
   echo "Error in retrieveing row count.";
else
   echo $row_count;*/

	if( $stmt === false) {
		die( print_r( sqlsrv_errors(), true) );
	}
         $i=0;
       print "[";
	while( $row = sqlsrv_fetch_array( $stmt, SQLSRV_FETCH_ASSOC) ) {
                print "{";
                print "\"id_user\":"; print "\"";  print $row["id_user"]; print "\",";   
                print "\"usuario\":"; print "\"";  print $row["usuario"]; print "\",";  
                print "\"nombre\":"; print "\"";  print $row["nombre"]; print "\",";   
                print "\"apellido\":"; print "\"";  print $row["apellido"]; print "\","; 
                print "\"email\":"; print "\"";  print $row["email"]; print "\",";   
                print "\"nombre\":"; print "\"";  print $row["nombre"]; print "\",";     
                print "\"pais\":"; print "\"";  print $row["pais"]; print "\",";      
                print "\"depto\":"; print "\"";  print $row["depto"]; print "\",";      
                print "\"pais\":"; print "\"";  print $row["pais"]; print "\",";  
                print "\"coments\":"; print "\"";  print $row["coments"]; print "\","; 
                print "\"imagen\":"; print "\"";  print $row["imagen"]; print "\","; 
                print "\"edad\":"; print "\"";  print $row["edad"]; print "\","; 
                print "\"sexo\":"; print "\"";  print $row["sexo"]; print "\","; 
                print "\"telefono\":"; print "\"";  print $row["telefono"]; print "\","; 
                print "\"cede\":"; print "\"";  print $row["cede"]; print "\","; 
                print "\"bio\":"; print "\"";  print $row["bio"]; print "\","; 
                print "\"region\":"; print "\"";  print $row["region"]; print "\","; 
                print "\"celular\":"; print "\"";  print $row["celular"];  
                 print "\"";  
                 
                 
                 print"}";
                 if($i!==$row_count){ print ",";
                 } 
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
