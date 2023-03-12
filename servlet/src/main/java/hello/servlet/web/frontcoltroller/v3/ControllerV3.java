package hello.servlet.web.frontcoltroller.v3;

import hello.servlet.web.frontcoltroller.view.ModelView;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap)
            throws ServletException, IOException;
}
