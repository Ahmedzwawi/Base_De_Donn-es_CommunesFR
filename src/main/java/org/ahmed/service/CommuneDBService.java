package org.ahmed.service;

import java.sql.PreparedStatement;

import org.ahmed.Model.Commune;

public interface CommuneDBService {
    PreparedStatement writeCommune(Commune commune);
    Commune getCommuneById(String id);
}
