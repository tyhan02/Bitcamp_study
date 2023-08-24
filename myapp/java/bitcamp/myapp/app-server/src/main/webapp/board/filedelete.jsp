<%@ page
        language="java"
        pageEncoding="UTF-8"
        contentType="text/html;charset=UTF-8"
        trimDirectiveWhitespaces="true"
        errorPage="/error.jsp"%>
<%@ page import="bitcamp.myapp.dao.BoardDao"%>
<%@ page import="bitcamp.myapp.vo.AttachedFile"%>
<%@ page import="bitcamp.myapp.vo.Board"%>
<%@ page import="bitcamp.myapp.vo.Member"%>
<%@ page import="bitcamp.util.NcpObjectStorageService"%>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory"%>




<%
    request.setAttribute("refresh", "2;url=detail.jsp?category="  + request.getParameter("category"") + "&no=" + board.getNo"
Member loginUser = (Member) request.getSession().getAttribute("loginUser");
if (loginUser == null) {
response.sendRedirect("/auth/form.html");
return;
}

int category = Integer.parseInt(request.getParameter("category"));
int fileNo = Integer.parseInt(request.getParameter("no"));

BoardDao boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) this.getServletContext().getAttribute("sqlSessionFactory");

// 첨부파일 번호로 첨부파일 데이터를 가져온다.
AttachedFile attachedFile = boardDao.findFileBy(fileNo);
//    System.out.println(attachedFile);

// 첨부파일 데이터에 있는 게시글 번호로 게시글 데이터를 가져온다.
Board board = boardDao.findBy(category, attachedFile.getBoardNo());
//    System.out.println(board);

// 게시글 데이터의 작성자와 로그인 한 작성자가 일치하는지 검사한다.
if (board.getWriter().getNo() != loginUser.getNo()) {
throw new ServletException("게시글 변경 권한이 없습니다!");
}

// 일치하면 첨부파일을 삭제한다.
try {
if (boardDao.deleteFile(fileNo) == 0) {
throw new Exception("해당 번호의 첨부파일이 없거나 삭제 권한이 없습니다.");
} else {
response.sendRedirect("/board/detail?category=" + category + "&no=" + board.getNo());
}
sqlSessionFactory.openSession(false).commit();

} catch (Exception e) {
sqlSessionFactory.openSession(false).rollback();
throw new RuntimeException(e);
}
%>













