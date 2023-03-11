package hello.servlet.web.frontcoltroller.v2;

import hello.servlet.web.frontcoltroller.view.MyView;
import hello.servlet.web.frontcoltroller.view.MyViewJsp;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFormControllerV2 implements ControllerV2{

    public MyView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        return new MyViewJsp(viewPath);
    }
}
