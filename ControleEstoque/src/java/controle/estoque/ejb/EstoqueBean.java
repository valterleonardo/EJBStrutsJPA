package controle.estoque.ejb;

import controle.estoque.modelo.impl.EstoqueImpl;
import controle.estoque.modelo.Estoque;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@EJB
@Stateless
public class EstoqueBean implements EstoqueRemote {

    @PersistenceContext(unitName = "EstoquePU")
    private EntityManager entityManager;
    
    @Override
    public Estoque salvar(Estoque estoque) throws Exception {
        
        EstoqueImpl estoqueImpl = new EstoqueImpl(entityManager);
        
        return estoqueImpl.salvar(estoque);
       
        
    }
    
    @Override
    public List<Estoque> listar() throws Exception {
        
        EstoqueImpl estoqueImpl = new EstoqueImpl(entityManager);
        
        return estoqueImpl.listar();
       
        
    }
    
}
