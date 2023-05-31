# 개발환경
1. IDE: IntelliJ IDEA Community
2. Spring Boot 2.6.13 
3. JDK 11
4. mysql
5. Spring Data JPA
6. Thymeleaf

# 게시판 주요기능
1. 메인페이지 및 글목록(/)
2. 글쓰기(/board/write)
   - 메인페이지에서 글작성 버튼 클릭
   - 작성자, 비밀번호, 제목, 글내용 작성 후 
   - 작성하기 버튼을 클릭하여 처리
3. 글조회(/board/{id})
    - 게시글 제목 클릭
    - 서버에서 해당 게시글 정보를 갖고 화면에 출력
4. 글수정(/board/update/{id})
    - 글조회 화면에서 수정버튼 클릭
    - 서버에서 해당 게시글 정보를 갖고 화면에 출력
    - 제목, 내용을 수정하고 입력받아서 서버로 요청
    - 수정 처리
5. 글삭제(/board/delete/{id})
   - 글조회 화면에서 삭제버튼 클릭
   - 삭제처리 후 redirect 처리하여 메인페이지(글목록) 출력
6. 페이징(/board/paging)
   - /board/paging?page=2