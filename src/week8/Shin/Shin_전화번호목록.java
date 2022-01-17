package week8.Shin;

import java.util.Arrays;

// 전화번호 목록: https://programmers.co.kr/learn/courses/30/lessons/42577
public class Shin_전화번호목록 {

    public static void main(String[] args) {
        String[] phoneBook = {"119", "1191123123123123", "97674223", "1195524421"};
        System.out.println(solution(phoneBook));
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
