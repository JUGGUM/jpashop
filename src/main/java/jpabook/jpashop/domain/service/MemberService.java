package jpabook.jpashop.domain.service;

import java.util.List;
import jpabook.jpashop.domain.entity.Member;
import jpabook.jpashop.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    /***
     * 회원가입
     * @param member
     * @return
     */
    @Transactional // 따로 적용하면 우선 적용된다.
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        // TODO 실제서버에는 똑같은이름을 동시에 호출했을경우 두개의 데이터가 들어갈수있으니 NAME 유니크조건걸것
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /***
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
