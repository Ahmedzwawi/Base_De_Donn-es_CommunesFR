package org.ahmed.service.impl;
import java.sql.*;
import org.ahmed.Model.*;
import org.ahmed.utils.*;
import org.ahmed.service.*;


public abstract class MysqlCommuneDBService implements CommuneDBService {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/communes";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Connection connection;
    private static final String INSERT_COMMUNE="INSERT INTO communes(codeINSEE, nomCommune, codePostal, libelleAcheminement) VALUES(?,?,?,?)";
    PreparedStatement preparedStatement=null;
    public MysqlCommuneDBService(Connection connection,PreparedStatement preparedStatement) {
    	this.connection=connection;
    	this.preparedStatement=preparedStatement;
    }
  private static final String SELECT_COMMUNE_BY_ID="SELECT * FROM communes WHERE codeINSEE =? ";

  
  public PreparedStatement writeCommune(Commune commune) {
	 
	  
        try {        	
       
            preparedStatement = connection.prepareStatement(INSERT_COMMUNE);
            
            preparedStatement.setString(1, commune.getCodeINSEE());
            preparedStatement.setString(2, commune.getNomCommune());
            preparedStatement.setString(3, commune.getCodePostal());
            preparedStatement.setString(4, commune.getLibelleAcheminement());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

  public Commune getCommuneByID(String id ) {
	  
        try {        	
        	
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COMMUNE_BY_ID);
            preparedStatement.setString(1,id);
            
            try ( ResultSet resultSet= preparedStatement.executeQuery()){
            if (resultSet.next()) {
                return new Commune(
                        resultSet.getString("codeINSEE"),
                        resultSet.getString("nomCommune"),
                        resultSet.getString("codePostal"),
                        resultSet.getString("libelleAcheminement")
                );
            }}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}