package org.ahmed.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.ahmed.service.impl.MysqlCommuneDBService;

public class Main {
	
private static final String PATH ="data/communes.csv";
private static final String URL="jbcd:mysqli//localhost:3306/communes";

private static void main (String[] args){
	try (Connection connection =DriverManager.getConnection(URL,"root","root");){
		//MysqlCommuneDBService importCommuneService= new MysqlCommuneDBService(connection);
		
		//CommuneImportClass c= new c (connection,)
		//importCommuneService.importCommunes(PATH);
	}catch(SQLException e) {
		e.printStackTrace();
	}
	

}

}
