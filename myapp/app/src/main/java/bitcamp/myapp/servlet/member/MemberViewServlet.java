package bitcamp.myapp.servlet.member;

import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/view")
public class MemberViewServlet extends HttpServlet {

  private MemberDao memberDao;

  public MemberViewServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
    this.memberDao = new MemberDaoImpl(connectionPool);
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("  <meta charset='UTF-8'>");
    out.println("  <title>비트캠프 데브옵스 5기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Member member = memberDao.findBy(no);
      if (member == null) {
        out.println("<p>회원번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      out.println("<form action='/member/update'>");
      out.println("<div>");
      out.printf("  번호: <input readonly name='no' type='text' value='%s'>\n", member.getNo());
      out.println("</div>");
      out.println("<div>");
      out.printf("  이름: <input name='name' type='text' value='%s'>\n", member.getName());
      out.println("</div>");
      out.println("<div>");
      out.printf("  이메일: <textarea name='email'>%s</textarea>\n", member.getEmail());
      out.println("</div>");
      out.println("<div>");
      out.printf("  가입일: <input readonly name='createdDate' type='date' value='%tY-%<tm-%<td'>\n",
          member.getCreatedDate());
      out.println("</div>");

      out.println("<div>");
      out.println("  새 비밀번호: <input name='afterPassword' type='password'>");
      out.println("</div>");
      out.println("<div>");
      out.println("  2차 확인: <input name='confirmation' type='password'>");
      out.println("</div>");

      out.println("<ul>");
      out.println("  <li><button>변경</button></li>");
      out.printf("  <li><a href='/member/delete?no=%d\n'>[회원탈퇴]</a></li>", no);
      out.println("  </ul>");

      out.println("</form>");

    } catch (Exception e) {
      out.println("<p>조회 오류!</p>");
      out.println("<pre>");
      e.printStackTrace(out);
      out.println("</pre>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}
