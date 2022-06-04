package com.spring.session.repository;

import com.spring.session.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    boolean existsByLoginId(String loginId);

    Optional<Member> findByLoginId(String loginId);
}
