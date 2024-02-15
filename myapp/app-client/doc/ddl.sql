-- DDL(Data Definition Language)

-- 초기화
drop table IF EXISTS boards restrict;
drop table IF EXISTS board_files restrict;
drop table IF EXISTS assignments restrict;
drop table IF EXISTS members restrict;

-- 테이블 생성/제약조건 설정
create table boards(
  board_no int not null,
  title varchar(255) not null,
  content text not null,
  writer int not null,
  category int not null,
  created_date datetime null default now()
);

alter table boards
  add constraint primary key (board_no),\
  modify column board_no int auto_increment;

alter table boards
  add constraint boards_fk foreign key (writer) references members(member_no);



create table board_files(
  file_no int not null,
  file_path varchar(255) not null,
  board_no int not null
);

alter table board_files
  add constraint primary key (file_no),
  modify column file_no int not null auto_increment,
  add constraint board_files_fk foreign key (board_no) references boards(board_no);



create table assignments(
  assignment_no int not null,
  title varchar(255) not null,
  content text not null,
  deadline date not null
);

alter table assignments
  add constraint primary key (assignment_no),
  modify column assignment_no int auto_increment;



create table members(
  member_no int not null,
  email varchar(255) not null,
  name varchar(30) not null,
  password varchar(256) not null,
  created_date datetime null default now()
);

alter table members
  add constraint primary key (member_no),
  modify column member_no int auto_increment;


