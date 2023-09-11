package repository.base;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractCrudRepository<T> {

    protected Class<T> persistentClass;

    @PersistenceContext(unitName = "primary")
    protected EntityManager em;

    @PostConstruct
    @SuppressWarnings("unchecked")
    public void init() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected EntityQuery<T> createEntityQuery() {
        return EntityQuery.create(this.em, this.persistentClass);
    }

    protected EntityQuery<T> createCountQuery() {
        return EntityQuery.createCount(this.em, this.persistentClass);
    }

    protected TupleQuery<T> createTupleQuery() {
        return TupleQuery.create(this.em, this.persistentClass);
    }

    public T consultar(Integer id) {
        return this.em.find(persistentClass, id);
    }

    public List<T> pesquisarTodos() {
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(this.persistentClass);
        Root<T> root = criteria.from(this.persistentClass);
        criteria.select(root);
        return em.createQuery(criteria).getResultList();
    }

    @Transactional
    public void inserir(T entity) {
        this.em.persist(entity);
    }

    @Transactional
    public void atualizar(T entity) {
        this.em.merge(entity);
    }

    @Transactional
    public void remover(T entity) {
        this.em.remove(entity);
    }

    @Transactional
    public void remover(Integer entityId) {
        T entity = this.consultar(entityId);
        if (entity != null) {
            this.remover(entity);
        }
    }

    private Integer getIdValue(T entity){
        return (Integer) this.em.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
    }

}
