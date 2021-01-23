package com.wistron.springcloud.dao;

import com.wistron.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PaymentDao {
    int deleteByPrimaryKey(Long id);

    int create(Payment payment);

    Payment getByPrimaryKey(@Param("id") Long id);

    int updateByPrimaryKey(Payment payment);
}