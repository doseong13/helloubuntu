package com.controller;

import com.entity.Member;
import com.repository.MemberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostMapping
    public Member create(@RequestBody MemberRequest request) {
        return memberRepository.save(new Member(request.name()));
    }

    @GetMapping
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public record MemberRequest(String name) {
    }
}