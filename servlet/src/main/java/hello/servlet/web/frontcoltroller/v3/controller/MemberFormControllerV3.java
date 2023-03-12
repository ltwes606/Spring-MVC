package hello.servlet.web.frontcoltroller.v3.controller;

import hello.servlet.web.frontcoltroller.v3.ControllerV3;
import hello.servlet.web.frontcoltroller.view.ModelView;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) throws ServletException, IOException {
        return new ModelView("new-form");
    }
}
