package filmstudio.gui;

import filmstudio.movies.Movie;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * MovieModel-luokka, joka perii AbstractTableModel-luokan ja määrittää sen,
 * mitä elokuvia käsittelevät taulukot pitävät sisällään.
 *
 * @author Eversor
 */
public class MovieModel extends AbstractTableModel {

    private List<Movie> movies;
    private String[] columnNames = {"Title", "Year", "Genre", "Rating"};

    /**
     * Konstruktori, jolla asetetaan parametrina annettu lista elokuvista sen
     * private muuttujaan.
     * 
     * @param movies Lista elokuvista, jotka taulukossa näytetään
     */
    public MovieModel(List<Movie> movies) {
        this.movies = movies;
    }
    
    /**
     * Metodi, jolla päivitetään taulukon näkymä sille parametrina annetun
     * elokuvalistan perusteella. Ensin asetetaan annettu lista sen private
     * muuttujaan, jonka jälkeen ilmoitetaan taulukolle datan muuttumisesta.
     * 
     * @param movies Lista elokuvista, jotka taulukossa näytetään
     */
    public void updateMovies(List<Movie> movies) {
        this.movies = movies;
        fireTableDataChanged();
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Movie.class;
        } else if (columnIndex == 1) {
            return Integer.class;
        } else if (columnIndex == 3) {
            return Double.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        if (movies == null) {
            return 0;
        }
        return movies.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (movies != null) {
            if (columnIndex == 0) {
                return movies.get(rowIndex);
            } else if (columnIndex == 1) {
                return movies.get(rowIndex).getYear();
            } else if (columnIndex == 2) {
                return movies.get(rowIndex).getGenre();
            } else if (columnIndex == 3) {
                return movies.get(rowIndex).getRatings();
            }
        }
        return null;
    }
}
