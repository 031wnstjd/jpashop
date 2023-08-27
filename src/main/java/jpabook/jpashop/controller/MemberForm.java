package jpabook.jpashop.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 * - MemberForm은 Member와 역할이 다름. Controller에서 화면으로부터 form 요청 데이터를 전달 받는 역할
 * - Member와 같은 Entity는 오직 핵심 비즈니스 로직에만 의존성이 있도록 설계하는 게 중요함 (추후 유지보수성을 위해)
 */

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다")
    private String name;

    private String city;
    private String street;
    private String zipcode;
}
