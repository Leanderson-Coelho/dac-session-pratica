package ifpb.edu.dac;

import java.math.BigDecimal;
import java.util.List;

public interface ICarrinho<P, C> {
    public Boolean addProduto (P p);
    public Boolean removeProduto (P p);
    public List<P> getProdutos ();
    public void setCliente (C c);
    public BigDecimal getSubtotal ();
    public void checkout ();
}
