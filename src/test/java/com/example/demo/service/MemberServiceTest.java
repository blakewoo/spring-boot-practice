package com.example.demo.service;

import com.example.demo.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void join() {
        //given
        Member member =new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void duplicateJoin() {
        //given
        Member member =new Member();
        member.setName("hello");

        Member member2 =new Member();
        member2.setName("hello");

        //when
        memberService.join(member);
        try{
            memberService.join(member2);
            fail("");
        }
        catch(IllegalStateException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }

        //then


    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}