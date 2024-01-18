// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0730 {
  public static void main(String[] args) {
    File dir = new File("bin/main");
    
    printClasses(dir);
  }

  static void printClasses(File dir) {
    File[] files = dir.listFiles( 
        p -> p.isDirectory() || (p.isFile() && p.getName().endsWith(".class"))
    );

    for (File file : files) {
      if (file.isDirectory()) {
        printClasses(file);
      } else {
        System.out.printf("%s\n", file.getName());
      }
    }
  }
}


