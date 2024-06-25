package com.mycompany.bibliotecafilmes.tables;

import com.mycompany.bibliotecafilmes.model.Filme;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TabelaListaFilmes extends AbstractTableModel{
    
    private final List<Filme> filmes;
    private final String[] colunas = {"Nome", "Ano de Lançamento", "imdbID"};

    public TabelaListaFilmes(List<Filme> filmes) {
        this.filmes = filmes;
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

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void addFilme(Filme filme) {
        filmes.add(filme);
        fireTableRowsInserted(filmes.size() - 1, filmes.size() - 1);
    }
    
    public List<Filme> getFilmes() {
        return filmes;
    }
    
    public void limparCampo() {
        filmes.clear();
        fireTableDataChanged();
    }
}
