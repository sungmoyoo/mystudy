package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {

  private MemberDao memberDao;
  private TransactionManager txManager;

  public MemberUpdateServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
    this.memberDao = new MemberDaoImpl(connectionPool);
    txManager = new TransactionManager(connectionPool);
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
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
    out.println("<h2>과제</h2>");

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      out.println("<p>로그인 후 변경할 수 있습니다.</p>");
      out.println("</body>");
      out.println("</html>");
      return;
    }

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Member member = memberDao.findBy(no);

      if (member == null) {
        out.println("<p>회원 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      member.setNo(no);
      member.setEmail(request.getParameter("email"));
      member.setName(request.getParameter("name"));
      String newPassword = request.getParameter("afterPassword");

      if (newPassword.equals(request.getParameter("confirmation"))) {
        member.setPassword(newPassword);
      } else {
        out.println("<p>비밀번호가 일치하지 않습니다. </p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      txManager.startTransaction();

      memberDao.update(member);

      txManager.commit();

      out.println("<p>회원 정보를 변경했습니다.</p>");

    } catch (Exception e) {
      try {
        txManager.rollback();
      } catch (Exception e2) {
      }
      out.printf("<p>회원 변경 오류! '%s'</p>\n", loginUser.getPassword());
      e.printStackTrace();
    }

    out.println("</body>");
    out.println("</html>");
  }
}
