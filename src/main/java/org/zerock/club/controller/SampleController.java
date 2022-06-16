package org.zerock.club.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.club.security.dto.ClubAuthMemberDTO;

@Controller
@Log4j2
@RequestMapping("/sample/")
public class SampleController {

    // 모든 사용자 접근 가능
    @GetMapping("/all")
    public void exAll() {

        log.info("exampleMember..............");
    }

    // 로그인한 사용자만 접근 가능
    @GetMapping("/member")
    public void exMember(@AuthenticationPrincipal ClubAuthMemberDTO clubAuthMember) {

        log.info("exampleMember..............");

        log.info("-------------------------------------------");

        log.info(clubAuthMember);
    }

    // 관리자 권한이 있는 사용자만 접근 가능
    @GetMapping("/admin")
    public void exAdmin() {

        log.info("exampleMember..............");
    }

}
