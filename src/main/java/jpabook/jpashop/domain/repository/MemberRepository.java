package jpabook.jpashop.domain.repository;

import java.util.List;
import jpabook.jpashop.domain.entity.Member;

public interface MemberRepository {
    void save(Member member);
    Member findOne(Long id);
    List<Member> findAll();
    List<Member> findByName(String name);
}