package io.seata.samples.integration.storage.service.dao;

import io.seata.samples.integration.storage.db.tables.pojos.TStorage;
import io.seata.samples.integration.storage.db.tables.records.TStorageRecord;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.stereotype.Repository;

import static io.seata.samples.integration.storage.db.tables.TStorage.T_STORAGE;

@Repository
public class TStorageDao extends DAOImpl<TStorageRecord, TStorage, Integer> {

    public TStorageDao(Configuration configuration) {
        super(T_STORAGE, TStorage.class, configuration);
    }

    @Override
    public Integer getId(TStorage tStorage) {
        return tStorage.getId();
    }

    //update t_storage set count = count-${count} where commodity_code = #{commodityCode}
    public int decreaseStorage(String commodityCode, Integer count) {
        TStorage tStorage = fetchOne(T_STORAGE.COMMODITY_CODE, commodityCode);
        tStorage.setCount(tStorage.getCount() - count);
        update(tStorage);
        return tStorage.getCount();
    }
}
