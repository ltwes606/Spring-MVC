package hello.servlet.web.frontcoltroller.v3;

import hello.servlet.web.frontcoltroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcoltroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcoltroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcoltroller.view.ModelView;
import hello.servlet.web.frontcoltroller.view.MyView;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        System.out.println("FrontControllerServletV3.service : " + requestURI);

        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // mapping
        Map<String, String> paramMap = createParamMap(request);
        // controller
        ModelView mv = controller.process(paramMap);

        // viewResolver
        MyView view = viewResolver(mv.getViewName());
        // MyView
        view.render(mv.getModel(), request, response);
    }

    private static Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(
                        paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
