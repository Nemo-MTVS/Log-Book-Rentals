package com.ohgiraffers.z_activity.util;

import com.ohgiraffers.z_activity.model.Book;
import com.ohgiraffers.z_activity.model.Member;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileStorageManager {
    public static void saveBooksToFile(List<Book> books, String filePath){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
        //Book 클래스를 정의하여 private 멤버 변수(title, author, price)를 선언하고, 생성자, getter, toString() 메서드를 구현한다.
        //도서 정보를 담은 Book 객체 리스트
            for (Book book : books){
                writer.write(book.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error occured for book writing: " + e.getMessage());
        }
    }

    //Book 클래스를 정의하여 private 멤버 변수(title, author, price)를 선언하고, 생성자, getter, toString() 메서드를 구현한다.
    //회원 정보를 담은 Member 객체 리스트
    public static void saveMembersToFile(List<Member> members, String filePath){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for (Member member : members){
                writer.write(member.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error occured while saving members : " + e.getMessage());
        }
    }
}
