package jpabook.jpashop.infrastructure.repository;

import jakarta.persistence.EntityManager;
import java.util.List;
import jpabook.jpashop.domain.entity.item.Item;
import jpabook.jpashop.domain.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {

    private final EntityManager em;

    public void save(final Item item) {
        if (item.getId() == null) {
            em.persist(item); // insert
        } else {
            em.merge(item); // update
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }
}
