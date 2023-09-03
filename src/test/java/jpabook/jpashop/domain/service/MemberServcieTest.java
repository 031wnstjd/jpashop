package jpabook.jpashop.domain.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepositoryOld;
import jpabook.jpashop.service.MemberServcie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest // SpringBoot를 띄운 상태로 test하기 위해서 필요한 어노테이션
@Transactional // Test case 수행 후 자동 Rollback
public class MemberServcieTest {

    @Autowired
    MemberServcie memberServcie;
    @Autowired
    MemberRepositoryOld memberRepository;

    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("kim");
        
        // when
        Long savedId = memberServcie.join(member);

        // then
        assertEquals(member, memberRepository.findOne(savedId));
    }
    
    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");
        
        // when
        memberServcie.join(member1);
        memberServcie.join(member2); // 예외가 발생해야 한다!!

        // then
        fail("예외가 발생해야한다.");
    }
}