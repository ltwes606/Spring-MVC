package hello.servlet.web.frontcoltroller.v4.controller;

import hello.servlet.web.frontcoltroller.v4.ControllerV4;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;

public class MemberFormControllerV4 implements ControllerV4 {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model)
            throws ServletException, IOException {
        return "new-form";
    }
}
