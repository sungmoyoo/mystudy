-- 정보공유/자유 게시판 리스트 조회
-- 정렬은 기본 최신순, 추천순, 조회순은 order by만 바꾸면 됨
select 
  b.title,
  b.view_count,
  b.created_date,
  h.head_content,
  m.name,
  count(bl.member_no) as like_count
from 
  board b 
  inner join head h on b.head_no=h.head_no
  inner join member m on b.member_no=m.member_no
  left join board_like bl on b.board_no=bl.board_no
where
  b.board_category_no='게시판카테고리'
group by
  b.title,
  b.view_count,
  b.created_date,
  h.head_content,
  m.name
order by
  b.created_date desc;

-- 후기 게시판 리스트 조회
select 
  b.title,
  b.view_count,
  b.created_date,
  bf.ori_file_name,
  bf.uuid_file_name,
  h.head_content,
  m.name,
  count(bl.member_no) as like_count
from 
  board b 
  inner join head h on b.head_no=h.head_no
  inner join member m on b.member_no=m.member_no
  left join board_like bl on b.board_no=bl.board_no
  left join board_file bf on b.board_no=bf.board_no
where
  b.board_category_no='후기카테고리'
group by
  b.title,
  b.view_count,
  b.created_date,
  h.head_content,
  m.name
order by
  b.created_date desc;

-- 뷰 조회(공통)
select 
  b.title,
  b.view_count,
  b.created_date,
  bf.uuid_file_name,
  -- 말머리는 if문 넣어서 정보공유/자유게시판인 경우 가져옴
  h.head_content,
  m.name,
  (select COUNT(*)
    from board_like bl
    where bl.board_no = b.board_no) like_count,
  c.content comment_content,
  c.created_date comment_date,
  r.content reply_comment,
  r.created_date reply_date
  mc.name comment_writer,
  mr.name reply_writer
from 
  board b 
  inner join head h on b.head_no = h.head_no
  inner join members m on b.member_no = m.member_no
  left join board_file bf on b.board_no=bf.board_no
  left join comment c on b.board_no = c.board_no
  left join reply r on c.comment_no = r.comment_no
  left join member mc on c.member_no = mc.member_no
  left join member mr on r.member_no = mr.member_no
where
  b.board_no = '게시판카테고리';






--게시판 글 등록
insert into board(title, content, member_no, board_category, head_no) values
  ('꿀팁 공유', '와우 빡빡이 아저씨야', 1, 1, 2), 
  ('가입인사 작성법', '공지사항입니다.', 2, 1, 1),
  ('인도 한달살기 중 똥물먹고 설사한 썰', '기안은 이걸먹고 어떻게 살아남은거지', 3, 2, 3)

--게시판 첨부파일 등록
insert into board_file(ori_file_name, uuid_file_name, board_no) values
  ('a1.png','585a1429-2a79-4940-9488-6cea5bb9cb95', 1), ('a2.png','52588691-d763-45fe-8de6-8a632e08384a', 1)
  ('b1.png','00ee3655-34d0-4121-a2c0-b4b3a4f9053e', 2)

--댓글 등록
insert into comment(content, board_no, member_no) values
  ('글 잘보고 갑니다.', 1, 1), ('따봉드립니다.', 1, 3)

--답글 등록
insert into reply(content, comment_no, member_no) values
  ('ㅇㅇ', 1, 2), ('감사합니다.', 2, 2)

-- 게시글 추천수 등록
insert into board_like(board_no, member_no) values
  (1, 1), (1, 2), (1, 3)
  (2, 1), (2, 2), (2, 3)

--신고 등록
insert into board_report_detail(content, member_no, report_category_no) values
  ('혐오 댓글 신고합니다. [링크]', 1, 1), ('도배글입니다. [링크]', 2, 2)

--신고 파일 등록
insert into board_report_file(report_no, ori_file_name, uuid_file_name) values
  (1, 'r1.jpg', '8a223655-43d0-4291-b2a0-d4b3a4f9053e'), 
  (2, 'r2.jpg', '3f0f0cea-195b-4b7f-82d5-966ba4f2ab94')

-- 말머리 분류 등록
insert into board_category(category_no, category_name) values
  (1, 공지), (2, 잡담), (3, 꿀팁)







--게시글 조회수 업데이트
update 
  board
set 
  view_count = view_count + 1
where 
  board_no = '게시글번호';

--게시글 수정
update 
  board
set
  title='변경 제목',
  content='변경 내용',
  -- if문 사용, 말머리 변경 있을 때 말머리 변경
  head_no='변경 말머리번호'
where
  board_no='게시글번호'

--댓글 수정
update
  comment
set
  content='변경 내용'
where
  comment_no='댓글번호'

--답글 수정
update
  reply
set
  content='변경 내용'
where
  reply_no='답글번호'











--게시글 추천수 삭제
delete from board_like where board_no='게시글번호' --게시글이 삭제 되었을 때
delete from board_like where member_no='회원번호' --회원이 추천 취소 눌렀을 떄

--게시글 삭제
delete from board where board_no='게시글번호'

--게시글 첨부파일 삭제
delete from board_file where file_no='파일번호' --특정 파일만 삭제
delete from board_file where board_no='게시글번호' --전체 삭제

--댓글 삭제
delete from comment where comment_no='댓글번호'

--답글 삭제
delete from reply where reply_no='답글번호'


