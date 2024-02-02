package com.yuil.handler;

import com.util.Prompt;

public class Choice {
  Prompt prompt;

  public Choice(Prompt prompt) {
    this.prompt = prompt;
  }

  private String[] typeList= {"소고기", "돼지고기", "닭고기", "양고기"};

  private void typeDisplay() {
    System.out.println("[고기 종류]");
    for (int i = 0; i < typeList.length; i++) {
      System.out.printf("%d. %s\n", i+1, typeList[i]);
    }
  }

  public String getTypeChoice() {
    typeDisplay();

    int choiceNo;
    while (true) {
      choiceNo = prompt.inputInt("종류 선택: ");
      if (choiceNo < 1 || choiceNo > typeList.length) {
        System.out.println("유효하지 않은 번호입니다.");
      } else {
        break;
      }
    }
    return typeList[choiceNo-1];
  }
}
