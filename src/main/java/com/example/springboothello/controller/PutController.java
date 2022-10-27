package com.example.springboothello.controller;

import com.example.springboothello.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    @PutMapping("/member3")
    public ResponseEntity<MemberDto> putMember(@RequestBody MemberDto memberDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
    }

}
