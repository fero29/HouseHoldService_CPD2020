package sk.fri.uniza.db;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import sk.fri.uniza.model.IotNode;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class IotNodeDAO extends AbstractDAO<IotNodeDAO> {
    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public IotNodeDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public IotNode create(IotNode iotNode) {
        currentSession().save(iotNode);
        return iotNode;
    }

    public IotNode findById(Long id) {
        return currentSession().get(IotNode.class, id);
    }

    public IotNode update(IotNode iotNode) {
        return (IotNode)currentSession().merge(iotNode);
    }

    public List<IotNode> findByHouseHold(Long houseHoldId) {

        return (List<IotNode>)list(namedQuery("IotNode_findByHouseHold").setParameter("houseHold", houseHoldId));
    }

    @SuppressWarnings("unchecked")
    public List<IotNode> allIotNodes() {
        return list(namedQuery("IotNode_findAll"));
    }
}
