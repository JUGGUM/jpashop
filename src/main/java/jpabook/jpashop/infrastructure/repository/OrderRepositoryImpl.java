package jpabook.jpashop.infrastructure.repository;

import jakarta.persistence.EntityManager;
import java.util.List;
import jpabook.jpashop.domain.entity.Order;
import jpabook.jpashop.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final EntityManager em;

    @Override
    public void save(Order order) {
        em.persist(order);
    }

    @Override
    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    //TODO
    @Override
    public List<Order> findAll() {
        return List.of();
    }

}
