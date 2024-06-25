package com.mycompany.bibliotecafilmes.tables;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import com.mycompany.bibliotecafilmes.model.Filme;

public class FilmeTable extends AbstractTableModel {

    private final String[] colunas = {"Nome", "Ano de Lançamento", "imdbID"};
    private final List<Filme> filmes;

    public FilmeTable(List<Filme> filmes) {
        this.filmes = filmes;
    }
    
    public Filme getFilmeAt(int rowIndex) {
    return filmes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return filmes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Filme filme = filmes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return filme.getTitulo();
            case 1:
                return filme.getAnoLançamento();
            case 2:
                return filme.getImdbID();
            default:
                return null;
        }
    }

    public void addRow(Filme filme) {
        filmes.add(filme);
        fireTableRowsInserted(filmes.size() - 1, filmes.size() - 1);
    }
}
