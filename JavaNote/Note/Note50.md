# 스레드

## 스레드 생명주기(Lifecycle)
```
new Thread()    start()              sleep()/wait()
  준비 -------------------> Running ---------------> Not Runnable
                              ^  |    <---------------
                              |  |    timeout/notify()
                              X  |
                              |  |  run() 메서드 종료
                              |  V
                              Dead
``` 
**Running 상태**
CPU를 받아서 실행 중이거나 CPU를 받을 수 있는 상태

**Not Runnable 상태**
CPU를 받지 않는 상태

**Dead 상태**
run() 메서드 실행종료된 상태

> run() 메서드 종료 후 다시 running 상태로 돌아갈 수 없다. 새 스레드를 실행하는 방법 밖에 없다.

### 스레드 상태 조작 메서드
*join(): 메서드를 호출한 스레드가 종료될 때까지 나머지 스레드를 기다리게 한다.  
*sleep(): 지정한 millis 동안 not runnable 상태로 만든다.

## 스레드 우선 순위
**1. 조회**
getPriority()
```java
// 현재 실행 중인 스레드의 우선 순위 조회
Thread.currenThread().getPriority();
```
- 부모 스레드와 자식 스레드는 같은 값을 갖는다.
- 우선 순위가 높으면 CPU 사용 배분을 좀 더 받는다.
- Unix계열에서는 Priority 방식을 사용해서 우선순위에 따라 사용을 배분한다.
- Window OS에서는 우선 순위를 크게 고려하지 않는다(Round-Robin Scheduling)
- OS에 영향을 덛 받는 방식으로 코딩하려면 우선순위를 고려하는 방식으로 프로그래밍 하면 안된다.