package io.seata.samples.integration.account.service.dao;

import io.seata.samples.integration.account.db.tables.pojos.TAccount;
import io.seata.samples.integration.account.db.tables.records.TAccountRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static io.seata.samples.integration.account.db.tables.TAccount.T_ACCOUNT;

@Repository
public class TAccountDao extends DAOImpl<TAccountRecord, TAccount, Integer> {

    @Autowired
    private DSLContext dslContext;

    protected TAccountDao(Configuration configuration) {
        super(T_ACCOUNT, TAccount.class, configuration);
    }

    @Override
    public Integer getId(TAccount tAccount) {
        return tAccount.getId();
    }

    //update t_account set amount = amount-${amount} where user_id = #{userId}
    public int decreaseAccount(String userId, Double amount ) {
        TAccount tAccount = dslContext.selectFrom(T_ACCOUNT).where(T_ACCOUNT.USER_ID.eq(userId)).fetchOneInto(TAccount.class);
        tAccount.setAmount(tAccount.getAmount() - amount);
        update(tAccount);
        return tAccount.getId();
    }

    // select * from t_account where user_id = #{userId} for update
    public void testGlobalLock(String userId) {
        dslContext.selectFrom(T_ACCOUNT).where(T_ACCOUNT.USER_ID.eq(userId)).fetchOne();
    }
}
