package jpabook.jpashop.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import jpabook.jpashop.domain.entity.item.Item;
import jpabook.jpashop.domain.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    @Rollback(false)
    public void 아이템_저장() throws Exception {
        //Given TODO 다시정하쇼
        Item item = null;

        //When
        itemService.saveItem(item);

        //Then
        assertEquals(item, itemRepository.findOne(item.getId()));
    }
}