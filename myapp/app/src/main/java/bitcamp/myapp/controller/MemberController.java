package bitcamp.myapp.controller;

import bitcamp.myapp.service.MemberService;
import bitcamp.myapp.service.StorageService;
import bitcamp.myapp.vo.Member;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController implements InitializingBean {

  private static final Log log = LogFactory.getLog(MemberController.class);

  private final MemberService memberService;
  private final StorageService storageService;
  private String uploadDir;

  @Value("${ncp.ss.bucketname}")
  private String bucketName;

  @Override
  public void afterPropertiesSet() throws Exception {
    uploadDir = "member/";
    log.debug(String.format("uploadDir: %s", uploadDir));
    log.debug(String.format("bucketname: %s", bucketName));
  }


  @GetMapping("/form")
  public void form() throws Exception {
  }

  @PostMapping("/add")
  public String add(Member member, MultipartFile file) throws Exception {
    if (file.getSize() > 0) {
      String filename = storageService.upload(this.bucketName, this.uploadDir, file);
      member.setPhoto(filename);
    }
    memberService.add(member);
    return "redirect:list";
  }

  @GetMapping("/list")
  public void list(Model model) throws Exception {
    model.addAttribute("list", memberService.list());
  }

  @GetMapping("/view")
  public void view(
      int no,
      Model model) throws Exception {

    Member member = memberService.get(no);
    if (member == null) {
      throw new Exception("회원 번호가 유효하지 않습니다.");
    }
    model.addAttribute("member", member);
  }

  @PostMapping("/update")
  public String update(Member member, MultipartFile file) throws Exception {

    Member old = memberService.get(member.getNo());
    if (old == null) {
      throw new Exception("회원 번호가 유효하지 않습니다.");
    }
    member.setCreatedDate(old.getCreatedDate());

    if (file.getSize() > 0) {
      String filename = storageService.upload(this.bucketName, this.uploadDir, file);
      member.setPhoto(filename);
      storageService.delete(this.bucketName, this.uploadDir, member.getPhoto());
    } else {
      member.setPhoto(old.getPhoto());
    }

    memberService.update(member);
    return "redirect:list";
  }

  @GetMapping("/delete")
  public String delete(int no) throws Exception {
    Member member = memberService.get(no);
    if (member == null) {
      throw new Exception("회원 번호가 유효하지 않습니다.");
    }

    memberService.delete(no);
    String filename = member.getPhoto();
    if (filename != null) {
      storageService.delete(this.bucketName, this.uploadDir, member.getPhoto());
    }
    return "redirect:list";
  }
}
