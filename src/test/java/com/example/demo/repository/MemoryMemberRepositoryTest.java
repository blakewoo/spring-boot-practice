package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);


        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findName() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);


        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring").get();
        assertThat(member).isEqualTo(result);

        Member result2 = repository.findByName("spring2").get();
        assertThat(member2).isEqualTo(result2);
    }

    @Test
    public void findAll() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);


        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);


        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
