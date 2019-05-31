package ifpb.edu.dac;

import java.util.List;

public interface Carrinho<P, C> {
    public Boolean addProduto (P p);
    public Boolean removeProduto (P p);
    public List<P> getProdutos ();
    public void setCliente (C c);
    public void checkout ();
}
