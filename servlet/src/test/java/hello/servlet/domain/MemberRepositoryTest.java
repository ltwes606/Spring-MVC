package hello.servlet.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("hello", 20);

        // when
        Member saveMember = memberRepository.save(member);

        // then
        assertThat(saveMember).isEqualTo(member);
    }

    @Test
    void findById() {
        // given
        Member member = new Member("world", 30);
        memberRepository.save(member);

        // when
        Member findMember = memberRepository.findById(member.getId());

        // then
        assertThat(findMember).isEqualTo(member);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("member1", 10);
        Member member2 = new Member("member2", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> members = memberRepository.findAll();

        // then
        assertThat(members.size()).isEqualTo(2);
        assertThat(members).contains(member1, member2);
    }
}
