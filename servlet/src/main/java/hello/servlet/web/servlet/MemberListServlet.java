package hello.servlet.web.servlet;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        List<Member> members = memberRepository.findAll();

        PrintWriter write = response.getWriter();
        write.write("<html>\n");
        write.write("<head>\n");
        write.write("    <meta charset=\"UTF-8\">\n");
        write.write("    <title>Title</title>\n");
        write.write("</head>\n");
        write.write("<body>\n");
        write.write("<a href=\"/index.html\">메인</a>\n");
        write.write("<table>\n");
        write.write("    <thead>\n");
        write.write("    <th>id</th>\n");
        write.write("    <th>username</th>\n");
        write.write("    <th>age</th>\n");
        write.write("    </thead>\n");
        write.write("    <tbody>\n");

        for (Member member : members) {
            write.write("    <tr>\n");
            write.write("        <td>" + member.getId() + "</td>\n");
            write.write("        <td>" + member.getUsername() + "</td>\n");
            write.write("        <td>" + member.getAge() + "</td>\n");
            write.write("    </tr>\n");
        }

        write.write("    </tbody>\n");
        write.write("</table>\n");
        write.write("</body>\n");
        write.write("</html>\n");
    }
}
