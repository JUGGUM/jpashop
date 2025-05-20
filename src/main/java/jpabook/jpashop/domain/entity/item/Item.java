package jpabook.jpashop.domain.entity.item;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import jpabook.jpashop.application.exception.NotEnoughStockException;
import jpabook.jpashop.domain.entity.Category;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {
    // 구현체를 가지고할거기때문에 추상클래스로 만든다.
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    //==비즈니스 로직==//
    // 객체지향설계원칙과 응집도를 높이기위해 재고수량정보가있는 엔티티내부에
    // 재고증가/감소 로직을 두는것을 추천!

    /**
     * stock 증가 : 파라미터로 넘어온 수만큼 재고를 늘린다. 이 메서드는 재고가 증가하거나
     * 상품 주문을 취소해서 재고를 다시 늘려야할때 사용한다.
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * stock 감소 : 파라미터로 넘어온 수만큼 재고를 줄인다. 만약 재고가 부족하면
     * 예외가 발생한다. 주로 상품을 주문할때 사용한다.
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
