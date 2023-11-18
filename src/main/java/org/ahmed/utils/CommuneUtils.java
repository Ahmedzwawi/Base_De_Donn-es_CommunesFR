package org.ahmed.utils;
import org.ahmed.Model.Commune; 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.util.function.Function;

public class CommuneUtils { 
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/communes";
	private static final String USER = "root"; 
	private static final String PASSWORD = "root"; 
	
	public static Function <String ,Commune>ligneCSVVersCommune = ligne ->{ String[] valeur = ligne.split(";"); 
	
	String codeINSEE = valeur[0];
	String nomCommune = valeur[1];
	String codePostal = valeur[2];
	String libelleAcheminement = valeur[3];
	
	return new Commune(codeINSEE, nomCommune, codePostal, libelleAcheminement); };
	



}