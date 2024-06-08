package hyoung.hello_spring.repository;

import hyoung.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

// 회원 리포지토리 인터페이스
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // null일 수도 있어서 optional로 감싸서 반환?
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
