package jpabook.jpashop.infrastructure.repository;

import jakarta.persistence.EntityManager;
import java.util.List;
import jpabook.jpashop.domain.entity.Member;
import jpabook.jpashop.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
        // 영속성 컨텍스트에 넣는다는건데 트랜잭션 커밋시점에 디비에 반영이됌
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    // JPQL
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name).getResultList();
    }

}
