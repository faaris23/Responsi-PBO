
package DAOimplement;

import java.util.List;
import model.DataPerpustakaan;


public interface DAOImplementPerpustakaan {
    public void insert(DataPerpustakaan dp);
    public void update(DataPerpustakaan dp);
    public void delete(String judul);
    public List<DataPerpustakaan>getAll();
}
