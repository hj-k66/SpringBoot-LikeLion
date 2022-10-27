package com.example.springboothello.controller;

import com.example.springboothello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName(){
        return "heejung";
    }

    @GetMapping(value = "/variable/{variable}")
    public String getVariable(@PathVariable String variable){
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    @GetMapping(value="/request1")
    public String getRequestParam1(@RequestParam String name, @RequestParam String email, @RequestParam String organization){
        return String.format("%s %s %s", name, email, organization);
    }

    @GetMapping(value="/request2")
    public String getRequestParam2(@RequestParam Map<String,String> param){
        param.entrySet().forEach((map) ->{
            System.out.printf("key : %s value : %s\n", map.getKey(), map.getValue());
        });
        return "request2가 호출 완료되었습니다.";
    }

    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }
}