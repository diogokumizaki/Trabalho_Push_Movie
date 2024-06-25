package com.mycompany.bibliotecafilmes;

import com.mycompany.bibliotecafilmes.model.Filme;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArquivoCsv {
    
    private static final String FILE_PATH = "filmes_assistidos_da_api.csv";
     
    public static void writeFilmeToCSV(Filme filme) {
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
             PrintWriter pw = new PrintWriter(fw)) {
             
            pw.println(filmeToCSV(filme));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String filmeToCSV(Filme filme) {
        return String.format("%s,%s,%s", filme.getTitulo(), filme.getAnoLançamento(), filme.getImdbID());
    }
}
