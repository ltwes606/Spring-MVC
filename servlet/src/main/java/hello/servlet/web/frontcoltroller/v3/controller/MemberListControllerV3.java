package hello.servlet.web.frontcoltroller.v3.controller;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import hello.servlet.web.frontcoltroller.v3.ControllerV3;
import hello.servlet.web.frontcoltroller.view.ModelView;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;

public class MemberListControllerV3 implements ControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);
        return mv;
    }
}
