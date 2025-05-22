package jpabook.jpashop.domain.service;

import java.util.List;
import jpabook.jpashop.domain.entity.item.Item;
import jpabook.jpashop.domain.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true) // 읽기 작업 성능 최적화
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        //저장할떄 ID갈취할수있기때문에 요즘에는 세션객체를 안쓰므로
        //해당물건에대해 유저가 권한이있는지를 한번체크하는로직필요
        itemRepository.save(item);
    }

    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
