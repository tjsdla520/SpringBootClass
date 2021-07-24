package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//인터페이스 구현체 생성
public class MemoryMemberRepository implements MemberRepository{
    //저장하기 위한 Map 구현
    private static Map<Long, Member> store = new HashMap<>();
    //키값으 생성하는 시퀀스 생성
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {

        return Optional.ofNullable(store.get(id)); //null이라도 감싸서 반환 가능
    }

    @Override
    public Optional<Member> findByName(String name) {
       return store.values().stream()
                .filter(member -> member.getName().equals(name)) //람다가 파라미터로 넘어온 name과 getName의 값이 같을때만 필터링이 된다.
                .findAny(); //찾으면 반환
    }

    @Override
    public List<Member> findAll() {

        return new ArrayList<>(store.values()); //values() = member
    }

    public void clearStore() {

        store.clear();
    }
}
