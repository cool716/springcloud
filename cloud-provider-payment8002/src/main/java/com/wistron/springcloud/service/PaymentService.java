package com.wistron.springcloud.service;

import com.wistron.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    int create(Payment payment);

    Payment getByPrimaryKey(@Param("id") Long id);

}
