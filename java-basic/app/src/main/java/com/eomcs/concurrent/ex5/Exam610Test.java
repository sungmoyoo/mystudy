package com.eomcs.concurrent.ex5;

public class Exam610Test {
  public static void main(String[] args) {
    Job job = new Job();

    Worker w1 = new Worker("홍길동", job);
    Worker w2 = new Worker("임꺽정", job);

    w1.start();
    w2.start();
  }

  static class Job {
    synchronized void play(String threadName) throws Exception {
      System.out.println(threadName);
      Thread.sleep(5000);
    }
    void play2(String threadName) throws Exception {
      System.out.println(threadName);
      Thread.sleep(5000);
    }
  }


  static class Worker extends Thread {
    Job job;
    public Worker(String name, Job job) {
      super(name);
      this.job = job;
    }

    @Override
    public void run() {
      try {
        job.play(getName()+"play1()");
        job.play2(getName()+"play2()");

      }catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
