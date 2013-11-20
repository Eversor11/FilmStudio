package filmstudio.gui;

import filmstudio.persons.Person;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * PersonModel-luokka, joka perii AbstractTableModel-luokan ja määrittää sen,
 * mitä henkilöitä käsittelevät taulukot pitävät sisällään.
 *
 * @author Eversor
 */
public class PersonModel extends AbstractTableModel {

    private List<Person> persons;
    private String[] columnNames = {"Name", "Age", "Position", "Movies"};

    /**
     * Konstruktori, jolla asetetaan parametrina annettu lista henkilöistä sen
     * private muuttujaan.
     * 
     * @param persons Lista henkilöistä, jotka taulukossa näytetään
     */
    public PersonModel(List<Person> persons) {
        this.persons = persons;
    }

    /**
     * Metodi, jolla päivitetään taulukon näkymä sille parametrina annetun
     * henkilölistan perusteella. Ensin asetetaan annettu lista sen private
     * muuttujaan, jonka jälkeen ilmoitetaan taulukolle datan muuttumisesta.
     * 
     * @param persons Lista henkilöistä, jotka taulukossa näytetään
     */
    public void updatePersons(List<Person> persons) {
        this.persons = persons;
        fireTableDataChanged();
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Person.class;
        } else if (columnIndex == 1 || columnIndex == 3) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        if (persons == null) {
            return 0;
        }
        return persons.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (persons != null) {
            if (columnIndex == 0) {
                return persons.get(rowIndex);
            } else if (columnIndex == 1) {
                return persons.get(rowIndex).getAge();
            } else if (columnIndex == 2) {
                return persons.get(rowIndex).getPosition();
            } else if (columnIndex == 3) {
                return persons.get(rowIndex).getMoviesSize();
            }
        }
        return null;
    }
}
