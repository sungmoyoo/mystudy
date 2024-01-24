package com.eomcs.concurrent.ex5;

public class Exam540 {
  public static void main(String[] args) {
    Job job1 = new Job();
    Job job2 = new Job();
    Worker w1 = new Worker("홍길동", job1);
    Worker w2 = new Worker("임꺽정", job1);
    Worker w3 = new Worker("기모찌", job1);
    Worker w4 = new Worker("아타자", job2);
    Worker w5 = new Worker("씹힌다", job2);
    Worker w6 = new Worker("이클립스장애", job2);

    w1.start();
    w2.start();
    w3.start();
    w4.start();
    w5.start();
    w6.start();
  }

  static class Job {
    synchronized void play(String threadName) throws Exception {
      System.out.println(threadName);
      Thread.sleep(10000);
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
        job.play(getName());

      }catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
