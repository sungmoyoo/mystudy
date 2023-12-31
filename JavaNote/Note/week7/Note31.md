<span style="font-size:133%">

# 중첩 클래스(nested class) 
**중첩 클래스: 클래스 사용범위를 제한하는 문법**
- 코드의 가독성 up
- 이해도 up
=> 유지보수성 향상

LinkedList.java 파일
```
class LinkedList{
  void add(){-}
  Object[] toArray(){-}
  Object get(){-}
  Object set(){-}
  void add(int,Object){-}
  Object remove(){-}

  static class Node{
    ...
  }
}
```
----> 컴파일 시
```
LinkedList.class
LinkedList$Node.class

클래스 블록당 클래스 파일이 생성된다.
```

## ArrayList vs LinkedList
- ArrayList 

- LinkedList












</span>