package com.study.assignment.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Service service = new Service();

        service.result(service.diceFaceCollector(12), service.enterNumber());
    }
}

class Service{
    // 숫자를 입력받아 주사위의 면 갯수를 만들어주는 메소드 list를 반환
    public List<Integer> diceFaceCollector(int num){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i<num; i++){
            list.add(0);
        }
        return list;
    }

    // 주사위 면을 가진 리스트와 횟수를 매개변수로 받는다.
    public int enterNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하세요 : ");
        return scanner.nextInt();
    }

    public void result(List<Integer> list, int num){
        Random random = new Random();
        for(int i = 0; i < num; i++){
            int randomIndex = random.nextInt(list.size()); // 난수생성
            int oldValue = list.get(randomIndex); // 난수에 해당하는 인덱스 번호의 리스트 가져오기
            list.set(randomIndex, oldValue+=1); // 가져온 난수인덱스 리스트값 변경하기
        }
        for(int i = 0; i < list.size(); i++){ // 출력문
            System.out.printf("%s은 %s번 나왔습니다. \n", i+1, list.get(i));
        }
    }
}