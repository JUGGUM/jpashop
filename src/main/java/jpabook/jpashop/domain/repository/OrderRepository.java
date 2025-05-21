package jpabook.jpashop.domain.repository;

import java.util.List;
import jpabook.jpashop.domain.entity.Order;

public interface OrderRepository {
    void save(Order order);
    Order findOne(Long id);
    List<Order> findAll();
}
