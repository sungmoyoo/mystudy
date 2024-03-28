package bitcamp.myapp.vo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class Member implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String email;
  private String name;
  private String password;
  private String photo;

  @Getter
  @Setter
  private Date createdDate;

}
