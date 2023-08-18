package bitcamp.myapp.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/form")
public class BoardFormServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Overridepackage bitcamp.myapp.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp.vo.Member;

  public class MySQLMemberDao implements MemberDao {

    SqlSessionFactory sqlSessionFactory;

    public MySQLMemberDao(SqlSessionFactory sqlSessionFactory) {
      this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void insert(Member member) {
      SqlSession sqlSession = sqlSessionFactory.openSession(false);
      sqlSession.insert("bitcamp.myapp.dao.MemberDao.insert", member);
    }

    @Override
    public List<Member> findAll() {
      SqlSession sqlSession = sqlSessionFactory.openSession(false);
      return sqlSession.selectList("bitcamp.myapp.dao.MemberDao.findAll");
    }

    @Override
    public Member findBy(int no) {
      SqlSession sqlSession = sqlSessionFactory.openSession(false);
      return sqlSession.selectOne("bitcamp.myapp.dao.MemberDao.findBy", no);
    }

    @Override
    public Member findByEmailAndPassword(Member member) {
      SqlSession sqlSession = sqlSessionFactory.openSession(false);
      return sqlSession.selectOne("bitcamp.myapp.dao.MemberDao.findByEmailAndPassword", member);
    }

    @Override
    public int update(Member member) {
      SqlSession sqlSession = sqlSessionFactory.openSession(false);
      return sqlSession.update("bitcamp.myapp.dao.MemberDao.update", member);
    }

    @Override
    public int delete(int no) {
      SqlSession sqlSession = sqlSessionFactory.openSession(false);
      return sqlSession.delete("bitcamp.myapp.dao.MemberDao.delete", no);
    }

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    int category = Integer.parseInt(request.getParameter("category"));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>비트캠프</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글</h1>");
    out.println("<form action='/board/add' method='post' enctype='multipart/form-data'>");
    out.println("제목 <input type='text' name='title'><br>");
    out.println("내용 <textarea name='content'></textarea><br>");
    out.println("파일 <input type='file' name='files' multiple><br>");
    out.printf("<input type='hidden' name='category' value='%d'>\n", category);
    out.println("<button>등록</button>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");

  }
}











