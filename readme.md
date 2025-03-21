**미션 1: 도서 및 회원 정보를 파일에 저장하는 기능 구현**
- **입력:**
    - 도서 정보를 담은 Book 객체 리스트
    - 회원 정보를 담은 Member 객체 리스트
- **기능:**
    1. Book 객체와 Member 객체의 정보를 파일(예: "books.txt", "members.txt")에 저장한다.
    2. 파일 입출력 과정에서 발생할 수 있는 예외를 처리하여, 파일 저장 실패 시 적절한 메시지를 출력한다.
- **출력 예:**
    - "books.txt" 파일에 각 도서의 정보가 한 줄씩 저장됨
    - "members.txt" 파일에 각 회원의 정보가 한 줄씩 저장됨

<개발 순서>  
**미션 1 (도서 및 회원 정보 파일 저장):**
1. `Book` 클래스를 정의하여 private 멤버 변수(title, author, price)를 선언하고, 생성자, getter, toString() 메서드를 구현한다.
2. `Member` 클래스를 정의하여 private 멤버 변수(name, membershipId)를 선언하고, 생성자, getter, toString() 메서드를 구현한다.
3. `FileStorageManager` 클래스를 정의하여:
    - `saveBooksToFile(List<Book> books, String filePath)` 메서드 구현 (파일에 각 도서 정보를 한 줄씩 저장)
    - `saveMembersToFile(List<Member> members, String filePath)` 메서드 구현 (파일에 각 회원 정보를 한 줄씩 저장)
    - 파일 입출력 시 발생하는 IOException을 try-catch로 처리한다.
4. main() 메서드에서 샘플 데이터를 이용하여 파일 저장 기능을 시연한다.

---
*미션 2: 대출/반납 기록을 로그 파일로 저장하는 기능 구현**
- **입력:**
    - 대출 또는 반납 거래 기록을 나타내는 문자열
- **기능:**
    1. 입력받은 거래 기록을 로그 파일(예: "transaction.log")에 추가(append) 모드로 저장한다.
    2. 파일 입출력 과정에서 발생할 수 있는 예외를 처리하며, 잘못된 파일 경로 등의 예외 상황에 대해 assertThrows를 이용한 테스트를 진행한다.
- **출력 예:**
    - "transaction.log" 파일에 대출/반납 기록이 추가되어 저장됨


**미션 2 (대출/반납 로그 파일 저장):**
1. `LogManager` 클래스를 정의하여:
    - `logTransaction(String record, String filePath)` 메서드 구현
    - 파일 입출력 시 발생하는 IOException을 try-catch로 처리한다.
2. main() 메서드에서 샘플 거래 기록을 이용하여 로그 파일 저장 기능을 시연한다.

## 나의 접근 방법

### 회원 별 도서 대출 기록 로그 저장
````
{ 일단 이렇다고 가정 :
대출 현황 정보 필요 없음
대출 제한 없음
반납 완료 해도 또 반납 가능
같은 책 무한히 대출 가능 - 재고 권수 정보 없음.
}
````
## 서비스 폴더 생성
logManager 클래스 생성
logTransaction(String record, String filepath) 메서드 넣기

- Book book, Member members 는 아까 Lesson 때 만들어둔 코드 그냥 재활용

## 스캐너 기능 구현
회원번호 받기.
책 제목 받기 (대소문자 정확히)
반납 및 대출 여부 (True or False_)

## 람다 -> 이용하여
책 제목 title 이 제대로 입력됐는지,
멤버 id 가 제대로 입력 됐는지 확인

## StringBuilder 사용
멤버 id 에 따른 회원 이름 따내기.
책 제목 사용.
record string = "회원 000 이 책 000을 대출/반납 하였다"

## 해당 record 를 파일에 저장.

