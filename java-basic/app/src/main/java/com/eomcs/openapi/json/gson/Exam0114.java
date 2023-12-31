// 객체 --> JSON 문자열 : 객체의 필드 값을 json 형식의 문자열로 만들기
package com.eomcs.openapi.json.gson;

import java.lang.reflect.Type;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class Exam0114 {
  public static void main(String[] args) {

    Member m = new Member();
    m.setNo(100);
    m.setName("홍길동");
    m.setEmail("hong@test.com");
    m.setPassword("1111");
    m.setPhoto("hong.gif");
    m.setTel("010-2222-1111");
    m.setRegisteredDate(new Date(System.currentTimeMillis()));
    m.setSchool(new School("학사", "비트대학교"));


    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // 익명클래스 + 메서드 체인 방식으로 호출
    Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonSerializer<Date>() {
          @Override
          public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(dateFormat.format(src));
          }
        })
        .registerTypeAdapter(School.class, new JsonSerializer<School>() {
          @Override
          public JsonElement serialize(School src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(String.format("%s(%s)", src.level, src.name));
          }
        })
        .create();


    String jsonStr = gson.toJson(m);

    System.out.println(jsonStr);
  }
}

// JSON 객체 형식 - { 객체 정보 }
// => { "프로퍼티명" : 값, "프로퍼티명": 값, ...}
//
// 값:
// - 문자열 => "값"
// - 숫자   => 값
// - 논리   => true, false
//
// 프로퍼티명은 반드시 문자열로 표현해야 한다.




