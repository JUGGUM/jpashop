package jpabook.jpashop.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import jpabook.jpashop.domain.entity.Member;
import jpabook.jpashop.domain.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional // 이게있어야 롤백이됌
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @Test
    @Rollback(false)
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setName("kim");

        //When
        Long saveId = memberService.join(member);

        //Then
        //em.flush();
        // 영속성컨텍스트에 여기부분까지 변경내용같은게있으면 해당부분을 반영한다.
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //When
        memberService.join(member1);

        //Then
        //IllegalStateException 예외가 발생하지않으면 테스트 실패
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }
}