package com.eomcs.io.ex01; 

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
      File dir = new File(".");
      
      printList(dir);
    }

    private static void printList(File dir) {
        
        if (!dir.exists()) {
            return;
        }

        Queue<File> queue = new LinkedList<>();
        queue.add(dir);

        while (!queue.isEmpty()) {
            File current = queue.poll();
            int depth = getDepth(current.getAbsolutePath(), dir.getAbsolutePath());
            String indent = getIndent(depth);

            // 현재 파일 또는 디렉토리 출력
            if (current.isDirectory()) {
                System.out.println(indent + current.getName() + "/");
            } else {
                System.out.println(indent + "\\-- " + current.getName());
            }

            if (current.isDirectory()) {
                File[] files = current.listFiles();
                if (files != null) {
                    for (File file : files) {
                        queue.add(file);
                    }
                }
            }
        }
    }

    private static int getDepth(String path, String root) {
        return path.substring(root.length()).split(File.separator).length - 1;
    }

    private static String getIndent(int level) {
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < level; i++) {
          strBuilder.append("  ");
        }
        return strBuilder.toString();
    }
}