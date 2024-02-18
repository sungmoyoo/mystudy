package bitcamp.myapp.servlet.assignment;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.vo.Assignment;
import bitcamp.myapp.vo.Member;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.TransactionManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/assignment/update")
public class AssignmentUpdateServlet extends HttpServlet {

  private AssignmentDao assignmentDao;
  private TransactionManager txManager;

  public AssignmentUpdateServlet() {
    DBConnectionPool connectionPool = new DBConnectionPool(
        "jdbc:mysql://localhost/studydb", "study", "Bitcamp!@#123");
    this.assignmentDao = new AssignmentDaoImpl(connectionPool);
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

      Assignment assignment = assignmentDao.findBy(no);
      if (assignment == null) {
        out.println("<p>과제 번호가 유효하지 않습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      assignment.setTitle(request.getParameter("title"));
      assignment.setContent(request.getParameter("content"));
      assignment.setDeadline(Date.valueOf(request.getParameter("deadline")));

      txManager.startTransaction();

      assignmentDao.update(assignment);

      txManager.commit();

      out.println("<p>게시글을 변경했습니다.</p>");

      } catch (Exception e) {
        try {
          txManager.rollback();
        } catch (Exception e2) {
        }
        out.println("<p>게시글 변경 오류!</p>");
        e.printStackTrace();
    }

    out.println("</body>");
    out.println("</html>");
  }
}
