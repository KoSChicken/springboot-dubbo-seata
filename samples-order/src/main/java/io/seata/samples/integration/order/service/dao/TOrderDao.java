package io.seata.samples.integration.order.service.dao;

import io.seata.samples.integration.order.db.tables.pojos.TOrder;
import io.seata.samples.integration.order.db.tables.records.TOrderRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static io.seata.samples.integration.order.db.tables.TOrder.T_ORDER;

@Repository
public class TOrderDao extends DAOImpl<TOrderRecord, TOrder, Integer> {

    @Autowired
    private DSLContext dslContext;

    public TOrderDao(Configuration configuration) {
        super(T_ORDER, TOrder.class, configuration);
    }

    @Override
    public Integer getId(TOrder tOrder) {
        return tOrder.getId();
    }
}
