-- boards 테이블 데이터
insert into boards(board_no,title,content,writer, category)
  values(1, '제목1','내용1',101, 1);
insert into boards(board_no,title,content,writer, category)
  values(2, '제목2','내용2',102, 1);
insert into boards(board_no,title,content,writer, category)
  values(3, '제목3','내용3',102, 2);
insert into boards(board_no,title,content,writer, category)
  values(4, '제목4','내용4',104, 2);
insert into boards(board_no,title,content,writer, category)
  values(5, '제목5','내용5',104, 2);


insert into board_files(file_no,file_path,board_no) values
  (1,'a1.gif', 1), (2,'a2.gif', 1), (3,'a3.gif', 1),
  (4,'b1.gif', 2), (5,'b2.gif', 2),
  (6,'c1.gif', 4), (7,'c2.gif', 4), (8,'c3.gif', 4), (9,'c4.gif', 4),
  (10,'d1.gif', 5);

-- assignments 테이블 데이터
insert into assignments(title, content, deadline)
  values('정보처리기사',' 필기', '2024-2-23');
insert into assignments(content, deadline)
  values('복습',' 노트', '2024-5-22');
insert into assignments(title, content, deadline)
  values('linux','online', '2024-6-23');
insert into assignments(title, content, deadline)
  values('blog','포스팅', '2024-1-31');

-- members 테이블 데이터
insert into members(member_no, email,name,password,created_date)
  values(101, 'user1@test.com','user1',sha2('1111',256),'2024-1-1');
insert into members(member_no, email,name,password,created_date)
  values(102, 'user2@test.com','user2',sha2('1111',256),'2024-2-2');
insert into members(member_no, email,name,password,created_date)
  values(103, 'user3@test.com','user3',sha2('1111',256),'2024-3-3');
insert into members(member_no, email,name,password,created_date)
  values(104, 'user4@test.com','user4',sha2('1111',256),'2024-4-4');
insert into members(member_no, email,name,password,created_date)
  values(105, 'user5@test.com','user5',sha2('1111',256),'2024-5-5');


select
  b.board_no,
  b.title,
  b.writer,
  b.created_date,
  count(file_no) file_count
from
  boards b left outer join board_files bf on b.board_no = bf.board_no
where
   category=?
group by
  b.board_no
order by
  board_no desc


select
  b.board_no,
  b.title,
  b.writer,
  b.created_date,
  bf.file_path
from
  boards b left outer join board_files bf on b.board_no = bf.board_no
where
   category=? and board_no=?
order by
  board_no desc