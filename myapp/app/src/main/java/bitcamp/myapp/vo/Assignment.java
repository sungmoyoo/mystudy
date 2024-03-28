package bitcamp.myapp.vo;

import java.io.Serializable;
import java.sql.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Assignment implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String title;
  private String content;

  @Getter
  @Setter
  private Date deadline;


}
