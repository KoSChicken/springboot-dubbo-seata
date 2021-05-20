package io.seata.samples.integration.order.service;

import io.seata.samples.integration.common.dto.OrderDTO;
import io.seata.samples.integration.common.response.ObjectResponse;

/**
 * <p>
 *  创建订单
 * </p>
 *
 * @author heshouyou
 * @since 2019-01-13
 */
public interface ITOrderService {

    /**
     * 创建订单
     */
    ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO);
}
