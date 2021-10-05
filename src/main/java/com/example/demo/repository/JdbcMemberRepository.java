package com.example.demo.repository;

import com.example.demo.domain.Member;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JdbcMemberRepository implements MemberRepository {

    private final DataSource datasource;

    public JdbcMemberRepository(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public Member save(Member member) {
        String sql = "insert into member(name) values(?)";
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
