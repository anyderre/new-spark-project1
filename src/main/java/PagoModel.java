import java.util.ArrayList;

/**
 * Created by Dany on 06/11/2016.
 */
public class PagoModel <T extends  Pago> implements  ICRUD<T> {
    @Override
    public Boolean insert(T entity) {
        return null;
    }

    @Override
    public ArrayList<T> getElements(int id) {
        return null;
    }

    @Override
    public Boolean update(T entity) {
        return null;
    }

    @Override
    public T readOne(String matricula) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }
}
