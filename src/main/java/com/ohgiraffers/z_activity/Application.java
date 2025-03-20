package com.ohgiraffers.z_activity;

import com.ohgiraffers.z_activity.model.Book;
import com.ohgiraffers.z_activity.model.Member;
import com.ohgiraffers.z_activity.service.LogManager;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Clean Code", "Robert C. Martin", 45.0),
                new Book("Effective Java", "Joshua Bloch", 55.0)
        );
        List<Member> members = List.of(
                new Member("Alice", "LM001"),
                new Member("Bob", "LM002")
        );

        // scanner 선언.
        Scanner scanner = new Scanner(System.in);
        // 회원 번호, 책 제목, 대출/반납 여부 입력 받음.

        System.out.println("회원 번호를 입력해 주세요 : ");
        String id = scanner.nextLine();

        System.out.println("대출 도서를 입력해 주세요 : ");
        String title = scanner.nextLine();

        System.out.println("대출은 Y, 반납은 N을 입력 해 주세요 : ");
        boolean bool = scanner.nextBoolean();
        // book title 및 member id 정보는 Application 정보 입력 단계에서 메모리 저장됨.
        Optional<Book> bookSearchResult = books.stream().filter(b -> b.getTitle().equals(title)).findFirst();
        if (bookSearchResult.isPresent()) {
            System.out.println("Book found \n");

        }
        String memberName = "";
        Optional<Member> memberSearchResult = members.stream().filter(m -> m.getMembershipId().equals(id)).findFirst();
        if (memberSearchResult.isPresent()) {
            System.out.println("Member found \n");
            memberName = memberSearchResult.get().getName();
        }
        String record = "";
        record = getRentalString(bool, memberName, title);
        System.out.println(record);
        LogManager.logTransaction(record, "rentalAndReturnLog.txt");

    };

    public static String getRentalString(Boolean rent, String memberName, String title) {
        StringBuilder sb = new StringBuilder();
            if(rent) {
                sb.append("Member ").append(memberName).append(" rented the book").append(title);
            } else {
                sb.append("Member ").append(memberName).append(" returned").append(title);
            }
            return sb.toString();
    }

}
