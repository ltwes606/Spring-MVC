package hello.servlet.web.springmvc.v1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("SpringMemberFormControllerV1.process");
        return new ModelAndView("new-form");
    }
}
