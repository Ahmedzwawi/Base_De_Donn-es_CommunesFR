package org.ahmed.service.impl;

import org.ahmed.service.CommuneDBService;
import org.ahmed.service.*;
import org.ahmed.utils.convertCommune;
import org.ahmed.Model.Commune;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;


public class CommuneImportClass implements CommuneImporter{

    private final Connection connection;
    private final CommuneDBService communeService;

    public CommuneImportClass(Connection connection, CommuneDBService communeService) {
        this.connection = connection;
        this.communeService = communeService;
    }

    @Override
    public void importCommunes(String path) {
        Set<String> codeINSEESet = new HashSet<>();
        String sql = "INSERT INTO Commune (codeINSEE, nomCommune, codePostal, libelleAcheminement) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = null ;

        try (BufferedReader br = new BufferedReader(new FileReader(path))
             )
        {

            String line;
            while ((line = br.readLine()) != null) {
                Commune commune = convertCommune.mapToCommune.apply(line);
                String codeINSEE = commune.getCodeINSEE();
                if (!codeINSEESet.contains(codeINSEE)) {
                    codeINSEESet.add(codeINSEE);

                    preparedStatement= communeService.writeCommune(commune);

                } else {
                    System.out.println("Doublon trouvé pour le code INSEE : " + codeINSEE);
                }
            }
            preparedStatement.executeBatch();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}