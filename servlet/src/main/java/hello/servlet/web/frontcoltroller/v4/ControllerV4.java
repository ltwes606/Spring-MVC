package hello.servlet.web.frontcoltroller.v4;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;

public interface ControllerV4 {

    String process(Map<String, String> paramMap, Map<String, Object> model)
            throws ServletException, IOException;
}
