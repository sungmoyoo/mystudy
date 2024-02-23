package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet {

  private MemberDao memberDao;
  private TransactionManager txManager;

  @Override
  public void init() {
    txManager = (TransactionManager) this.getServletContext().getAttribute("txManager");
    this.memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println(" <meta charset='UTF-8'>");
    out.println(" <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>과제 관리 시스템</h1>");
    out.println("<h2>회원</h2>");

    Member member = new Member();
    member.setName(request.getParameter("title"));
    member.setEmail(request.getParameter("content"));

    String newPassword = request.getParameter("password");

    if (!newPassword.equals(request.getParameter("confirmation"))) {
      out.println("<p>비밀번호가 일치하지 않습니다.</p>");
      out.println("</body>");
      out.println("</html>");
      return;
    }
    member.setPassword(newPassword);

    try {
      txManager.startTransaction();

      memberDao.add(member);

      txManager.commit();

      response.sendRedirect("/member/list");
      return;


    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
      out.println("<p>회원 가입 오류!</p>");
      e.printStackTrace();
    }

    out.println("</body>");
    out.println("</html>");
  }
}
