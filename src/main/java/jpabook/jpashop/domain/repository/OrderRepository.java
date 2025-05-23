package jpabook.jpashop.domain.repository;

import java.util.List;
import jpabook.jpashop.domain.entity.Order;
import jpabook.jpashop.domain.entity.OrderSearch;

public interface OrderRepository {
    void save(Order order);
    Order findOne(Long id);
    List<Order> findAllByString(OrderSearch orderSearch);
    List<Order> findAllByCriteria(OrderSearch orderSearch);
}
