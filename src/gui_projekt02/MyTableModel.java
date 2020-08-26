package gui_projekt02;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {
    ArrayList<Magazyn> magazyny;
    ArrayList<TableModelListener> listeners;

    MyTableModel() {
        listeners = new ArrayList<>();
    }

    public void addMagazyn(ArrayList<Magazyn> magazyny) {
        this.magazyny = magazyny;
        inform();
    }

    public int getRowCount() {
        return magazyny.size();
    }

    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Magazyn Id";
            case 1:
                return "Powierzchnia magazynu";
            case 2:
                return "Lokalizacja magazynu";
            default:
                return "Podane dane sa niepoprawne";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return Integer.class;
            case 2:
                return String.class;
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 3) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        Magazyn m = magazyny.get(row);
        switch (column) {
            case 0:
                return m.id;
            case 1:
                return m.powierzchnia;
            case 2:
                return m.lokalizacja;
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Magazyn m = magazyny.get(rowIndex);
        switch (columnIndex) {
            case 0:
                m.id = (int)aValue;
                break;
            case 1:
                m.powierzchnia = (int) aValue;
                break;
            case 2:
                m.lokalizacja = (String)aValue;
        }
        inform();
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }

    public void inform() {
        TableModelEvent tme = new TableModelEvent(this, 0, getRowCount());

        listeners.forEach(
                (l) -> l.tableChanged(tme)
        );
    }
}
