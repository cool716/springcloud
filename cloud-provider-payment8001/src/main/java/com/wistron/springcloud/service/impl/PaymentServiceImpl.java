package com.wistron.springcloud.service.impl;

import com.wistron.springcloud.dao.PaymentDao;
import com.wistron.springcloud.entities.Payment;
import com.wistron.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: springCloud
 * @description: 订单
 * @author: Cool
 * @create: 2021-01-02 14:08
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;



    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getByPrimaryKey(Long id) {
        return paymentDao.getByPrimaryKey(id);
    }
}
