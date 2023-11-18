package org.ahmed.utils;

import java.util.function.Function;
import org.ahmed.Model.Commune;


public class convertCommune {

    public static Function<String, Commune> mapToCommune = (line) -> {
        String[] p = line.split(";");
        return new Commune(p[0], p[1], p[2], p[3]);
    };

}