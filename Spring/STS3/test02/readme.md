
실습3

Spring + MyBatis + MVC

1. DB작업
2. 프로젝트 생성
3. pom.xml 라이브러리 추가
4. web.xml 인코딩 부분 추가
5. src/main/resources/mabatis 폴더 : mybatis_config.xml
6. board.xml
7. root_context.xml back-end 빈 추가
8. Controller 작성
9. 뷰 작성
====================================================================
1. DB작업
	
	use BoardDB;
	
	create table myboard(
	
	num int(4) not null auto_increment primary key,
	
	writer varchar(30) not null,
	
	subject varchar(50) not null,
	
	content text not null,
	
	pwd varchar(15) not null,
	
	wdate date,
	
	readcount int default 0,
	
	ip varchar(30)
	
	);

2, 프로젝트 생성

3. pom.xml 작성
4. web.xml 작성
5. src/main/resources/mabatis 폴더 : mybatis_config.xml
6. board.xml 생성

7. root_context.xml => back-end 빈 추가

src/main/java/board.model.BoardDTO.java

8. board.xml 작성

9. Controller 작성
   BoardController.java

board.xml
BoardController.java
