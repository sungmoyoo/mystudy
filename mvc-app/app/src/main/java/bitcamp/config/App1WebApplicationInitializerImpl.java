package bitcamp.config;

import java.io.File;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class App1WebApplicationInitializerImpl extends
    AbstractAnnotationConfigDispatcherServletInitializer {
//  String uploadTmpDir;
//  public App1WebApplicationInitializerImpl() {
//    uploadTmpDir = new File(System.getProperty("java.io.tmpdir")).getAbsolutePath();
//  }

  private static Log log = LogFactory.getLog(App1WebApplicationInitializerImpl.class);

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] {App1Config.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/app1/*"};
  }

  @Override
  protected String getServletName() {
    return "app1";
  }

  @Override
  protected void customizeRegistration(Dynamic registration) {
    registration.setMultipartConfig(new MultipartConfigElement(
        new File("./temp").getAbsolutePath(),
        //new File(System.getProperty("java.io.tmpdir")).getAbsolutePath(),
        1024 * 1024 * 10,
        1024 * 1024 * 100,
        1024 * 1024 * 1));
  }
}


