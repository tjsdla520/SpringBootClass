package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {
    //DI = dependency injection
    //외부에서 따로 생성하지않고 직접 넎어준다.
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }


    //회원가입
    public Long join(Member member){

        //같은 이름이 있는 중복회원 x
        //Optional<Member> result = memberRepository.findByName(member.getName());
        //ifPresent null이 아니라 값이 있으면
        //result.ifPresent(m -> {
        
        //반환결과가 Optional이기때문에 생략가능
        validateDuplicateMember(member); //중복회원검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    //전체회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //한명의 회원조회회
   public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
