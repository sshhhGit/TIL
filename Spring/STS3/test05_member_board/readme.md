DB : ch20

drop table board;

create table board(  
  num int not null primary key auto_increment,  
  writer varchar(30) not null,  
  subject varchar(7) not null,  
  pw varchar(20) not null,  
  regdate datetime,  
  readcount int default 0,   
  ref int not null,  
  re_step int not null,  
  re_level int not null,  
  content text not null,  
  ip varchar(20) not null  
);

desc board;
--------------------------------------
설명
--------------------------------------
+-----------+-------------+      
| Field     | Type        |    
+-----------+-------------+      
| num       | 글번호       |   
| writer    | 글쓴이      	|   
| subject   | 글제목    	  |   
| pw        | 암호       	 |  
| regdate   | 날짜       	 |  
| readcount | 조회수   	  |   
| ref       | 답글 그룹 	 |  
| re_step   | 글순서    	  |  
| re_level  | 답글 깊이    |  
| content   | 글내용       |  
| ip        | 아이피       |   
+-----------+-------------+  
