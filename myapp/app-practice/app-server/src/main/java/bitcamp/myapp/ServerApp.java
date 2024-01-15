package bitcamp.myapp;

import bitcamp.myapp.dao.json.AssignmentDaoImpl;
import bitcamp.myapp.dao.json.BoardDaoImpl;
import bitcamp.myapp.dao.json.MemberDaoImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerApp {

  HashMap<String, Object> daoMap = new HashMap<>();
  Gson gson;

  ServerApp() {
    daoMap.put("board", new BoardDaoImpl("board.json"));
    daoMap.put("assignment", new AssignmentDaoImpl("assignment.json"));
    daoMap.put("greeting", new BoardDaoImpl("greeting.json"));
    daoMap.put("member", new MemberDaoImpl("member.json"));

    gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
  }

  public static void main(String[] args) {
    new ServerApp().run();
  }


  void run() {
    try {
      ServerSocket serverSocket = new ServerSocket(8888);
      System.out.println("서버 실행");

      System.out.println("클라이언트 연결 대기중..");
      Socket socket = serverSocket.accept();
      System.out.println("대기목록에서 클라이언트 연결 정보를 꺼냄");

      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());
      System.out.println("입출력 준비 완료");

      while (true) {
        String dataName = in.readUTF();
        String command = in.readUTF();
        String value = in.readUTF();

        //dataName으로 DAO 찾기
        Object dao = daoMap.get(dataName);
        System.out.printf("데이터명: %s", dataName);

        //command 이름으로 메서드 찾기
        Method[] methods = dao.getClass().getDeclaredMethods();
        Method commandHandler = null;

        for (Method method : methods) {
          if (method.getName().equals(command)) {
            commandHandler = method;
            break;
          }
        }
        System.out.printf("메서드명: %s", commandHandler);

        Parameter[] params = commandHandler.getParameters();

        // 메서드를 호출할 때 파라미터에 넘겨줄 데이터를 담을 배열을 준비한다.
        Object[] args = new Object[params.length];

        // 아규먼트 값 준비하기
        // => 현재 모든 DAO의 메서드는 파라미터가 최대 1개만 있다.
        // => 1개만 있다는 가정하에서 아규먼트 값을 준비한다.
        if (params.length > 0) {
          // 파라미터 타입을 알아낸다.
          Class<?> paramType = params[0].getType();

          // 클라이언트가 보낸 JSON 문자열을 해당 파라미터 타입 객체로 변환한다.
          Object paramValue = gson.fromJson(value, paramType);

          // 아규먼트 배열에 저장한다.
          args[0] = paramValue;
        }

        // 메서드의 리턴 타입을 알아낸다.
        Class<?> returnType = commandHandler.getReturnType();
        System.out.printf("리턴: %s\n", returnType.getName());

        // 메서드를 호출한다.
        Object returnValue = commandHandler.invoke(dao, args);

        out.writeUTF("200");
        out.writeUTF(gson.toJson(returnValue));
        System.out.println("클라이언트에게 응답 완료!");
      }

    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
  }
}
