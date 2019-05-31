package ifpb.edu.dac;

import java.util.List;

public interface Carrinho<T> {
    public Boolean add (T t);
    public Boolean remove (T t);
    public List<T> getAll ();
}
