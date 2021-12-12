package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MeberSaveControllerV1 implements ControllerV1 {
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        //Modelㅇㅔ 데이터를 보관한다.
        request.setAttribute("member", member);

        String viewPath = "WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
//        response.setContentType("text/html");

//        response.setContentType("text/html");
//        response.setCharacterEncoding("utf-8");
//
//        PrintWriter w = response.getWriter();
//        w.write("<html>\n" +
//                "<head>\n" +
//                " <meta charset=\"UTF-8\">\n" + "</head>\n" +
//                "<body>\n" +
//                "성공\n" +
//                "<ul>\n" +
//                "    <li>id="+member.getId()+"</li>\n" +
//                "    <li>username="+member.getUsername()+"</li>\n" +
//                " <li>age="+member.getAge()+"</li>\n" + "</ul>\n" +
//                "<a href=\"/index.html\">메인</a>\n" + "</body>\n" +
//                "</html>");
    }
}
