package serverapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import serverapp.dao.BoardDao;
import serverapp.dao.BoardListDao;
import serverapp.dao.MemberDao;
import serverapp.dao.MemberListDao;
import common.RequestEntity;
import common.ResponseEntity;
public class ServerApp {

  int port;
  ServerSocket serverSocket;

  MemberDao memberDao = new MemberListDao("member.json");
  BoardDao boardDao = new BoardListDao("board.json");
  BoardDao readingDao = new BoardListDao("reading.json");

  public ServerApp(int port) throws Exception {
    this.port = port;
  }

  public void close() throws Exception {
    serverSocket.close();
  }

  public static void main(String[] args) throws Exception {
    if (args.length < 1) {
      System.out.println("실행 예) java ... bitcamp.myapp.ServerApp 포트번호");
      return;
    }

    ServerApp app = new ServerApp(Integer.parseInt(args[0]));
    app.execute();
    app.close();
  }

  @SuppressWarnings("unchecked")
  public void execute() throws Exception {
    System.out.println("[MyList 서버 애플리케이션]");

    this.serverSocket = new ServerSocket(port);
    System.out.println("서버 실행 중...");

    Socket socket = serverSocket.accept();
    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    Gson gson = new Gson();

    while (true) {
      Map<String,Object> request = RequestEntity.fromJson(in.readUTF(), Map.class);

      String command = (String) request.get("command");
      System.out.println(command);

      HashMap<String,String> response = new HashMap<>();

      if (command.equals("quit")) {
        break;
      } else if (command.equals("board/list")) {
        response.put("status", "success");
        response.put("result", gson.toJson(boardDao.list()));
      } else if (command.equals("board/insert")) {

      } else {
        response.put("status", "failure");
        response.put("result", "nono!");
      }

      out.writeUTF(gson.toJson(response));
    }

    in.close();
    out.close();
    socket.close();
  }
}

}
