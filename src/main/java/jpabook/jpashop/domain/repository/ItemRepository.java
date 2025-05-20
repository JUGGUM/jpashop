package jpabook.jpashop.domain.repository;

import java.util.List;
import jpabook.jpashop.domain.entity.item.Item;

public interface ItemRepository {

    void save(Item member);

    Item findOne(Long id);

    List<Item> findAll();
}
