package io.seata.samples.integration.storage.service;

import io.seata.samples.integration.common.dto.CommodityDTO;
import io.seata.samples.integration.common.enums.RspStatusEnum;
import io.seata.samples.integration.common.response.ObjectResponse;
import io.seata.samples.integration.storage.service.dao.TStorageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  库存服务实现类
 * </p>
 *
 * @author heshouyou
 * @since 2019-01-13
 */
@Service
public class TStorageServiceImpl implements ITStorageService {

    @Autowired
    private TStorageDao tStorageDao;

    @Override
    public ObjectResponse decreaseStorage(CommodityDTO commodityDTO) {
        int storage = tStorageDao.decreaseStorage(commodityDTO.getCommodityCode(), commodityDTO.getCount());
        ObjectResponse<Object> response = new ObjectResponse<>();
        if (storage > 0){
            response.setStatus(RspStatusEnum.SUCCESS.getCode());
            response.setMessage(RspStatusEnum.SUCCESS.getMessage());
            return response;
        }

        response.setStatus(RspStatusEnum.FAIL.getCode());
        response.setMessage(RspStatusEnum.FAIL.getMessage());
        return response;
    }
}
