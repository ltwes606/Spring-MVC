package hello.servlet.web.frontcoltroller.v3.controller;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import hello.servlet.web.frontcoltroller.v3.ControllerV3;
import hello.servlet.web.frontcoltroller.view.ModelView;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;

public class MemberSaveControllerV3 implements ControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) throws ServletException, IOException {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);
        return mv;
    }
}
