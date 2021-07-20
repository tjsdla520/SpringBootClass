package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //각 메소드가 끝날때마다 실행이되는 콜백메소드
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    //저장이 잘되는지 테스트
    @Test
    public  void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        //repository에 저장된값 가져오기
        Member result = repository.findById(member.getId()).get();

        // 값 검증
        //System.out.println("result = " + (result == member)); //눈으로 확인
        //Assertions.assertEquals(member, result);
        //요즘 많이사용
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
