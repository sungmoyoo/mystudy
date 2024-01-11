package bitcamp.myapp.dao;

public class DaoException extends RuntimeException {

  // 이 클래스의 목적
  // - RunTimeException의 기능 확장하는 것이 목적이 아니다.
  // - 클래스 이름만으로 예외가 발생했을 때 어느 작업에서 발생했는지 알려주는 역할을 한다.
  public DaoException() {
  }

  public DaoException(String message) {
    super(message);
  }

  public DaoException(String message, Throwable cause) {
    super(message, cause);
  }

  public DaoException(Throwable cause) {
    super(cause);
  }

  public DaoException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
