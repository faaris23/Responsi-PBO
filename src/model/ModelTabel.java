
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModelTabel extends AbstractTableModel{

    List<DataPerpustakaan> dp;

    public ModelTabel(List<DataPerpustakaan> dp) {
        this.dp = dp;
    }

    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    public String getColumnName (int column){
        switch (column) {
            case 0:
                return "Judul";
            case 1:
                return "Penulis";
            case 2:
                return "Rating";
            case 3:
                return "Harga";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return dp.get(row).getJudul();
            case 1:
                return dp.get(row).getPenulis();
            case 2:
                return dp.get(row).getRating();
            case 3:
                return dp.get(row).getHarga();
            default:
                return null;
        }
    }
    
}
