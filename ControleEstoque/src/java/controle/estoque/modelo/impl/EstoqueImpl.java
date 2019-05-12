package controle.estoque.modelo.impl;

import controle.estoque.modelo.Estoque;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class EstoqueImpl {
    
    private EntityManager entityManager;

    public EstoqueImpl() {
    }

    public EstoqueImpl(EntityManager em) {
        this.entityManager = em;
    }    
    
    public Estoque salvar(Estoque estoque){
        try{
            if(estoque.getId() == null){
                entityManager.persist(estoque);
            }else{
                entityManager.merge(estoque);
            }
        return estoque;
        } catch (Exception e){
            System.out.println("Erro ao salvar estoque");
            return null;
        }finally{
            entityManager.close();
        }        
    }
    
    public Estoque consultarPorProduto(Long idProduto){
        
        try {
            return entityManager.find(Estoque.class, idProduto);
        } catch (Exception e) {
            return null;
        } finally{
            entityManager.close();
        }
    }
    
    public List<Estoque> listar(){
        try{
            String sql = "select * from estoque";
            return entityManager.createNativeQuery(sql).getResultList();
        }catch (Exception e){
            System.out.println("Erro ao buscar todos estoque");
            return Collections.emptyList();
        }finally{
            entityManager.close();
        }
    }
}
