package io.seata.samples.integration.account.service;

import io.seata.samples.integration.account.service.dao.TAccountDao;
import io.seata.samples.integration.common.dto.AccountDTO;
import io.seata.samples.integration.common.enums.RspStatusEnum;
import io.seata.samples.integration.common.response.ObjectResponse;
import io.seata.spring.annotation.GlobalLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author heshouyou
 * @since 2019-01-13
 */
@Service
public class TAccountServiceImpl implements ITAccountService {

    @Autowired
    private TAccountDao tAccountDao;

    @Override
    public ObjectResponse decreaseAccount(AccountDTO accountDTO) {
        int account = tAccountDao.decreaseAccount(accountDTO.getUserId(), accountDTO.getAmount().doubleValue());
        ObjectResponse<Object> response = new ObjectResponse<>();
        if (account > 0){
            response.setStatus(RspStatusEnum.SUCCESS.getCode());
            response.setMessage(RspStatusEnum.SUCCESS.getMessage());
            return response;
        }
        response.setStatus(RspStatusEnum.FAIL.getCode());
        response.setMessage(RspStatusEnum.FAIL.getMessage());
        return response;
    }

    @Override
    @GlobalLock
    @Transactional(rollbackFor = {Throwable.class})
    public void testGlobalLock() {
        tAccountDao.testGlobalLock("1");
        System.out.println("Hi, i got lock, i will do some thing with holding this lock.");
    }
}
