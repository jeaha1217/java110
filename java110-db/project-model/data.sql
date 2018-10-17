insert into p1_memb(mno, name, email, pwd, cdt)
values(1, 'user01', 'user01@test.com',  password('1111'), now());

insert into p1_memb(mno, name, email, pwd, cdt)
values(2, 'user02', 'user02@test.com',  password('1111'), now());

insert into p1_memb(mno, name, email, pwd, cdt)
values(3, 'user03', 'user03@test.com',  password('1111'), now());

insert into p1_memb(mno, name, email, pwd, cdt)
values(4, 'user04', 'user04@test.com',  password('1111'), now());

insert into p1_memb(mno, name, email, pwd, cdt)
values(5, 'user05', 'user05@test.com',  password('1111'), now());

insert into p1_memb(mno, name, email, pwd, cdt)
values(6, 'user06', 'user06@test.com',  password('1111'), now());

insert into p1_memb(mno, name, email, pwd, cdt)
values(7, 'user07', 'user07@test.com',  password('1111'), now());

insert into p1_memb(mno, name, email, pwd, cdt)
values(8, 'user08', 'user08@test.com',  password('1111'), now());

insert into p1_memb(mno, name, email, pwd, cdt)
values(9, 'user09', 'user09@test.com',  password('1111'), now());

insert into p1_memb(mno, name, email, pwd, cdt)
values(10, 'user10', 'user10@test.com',  password('1111'), now());

insert into p1_stud(sno, schl, work)values(1, 'Bit Unv.', 'N');
insert into p1_stud(sno, schl, work)values(2, 'BitCamp Unv.', 'Y');
insert into p1_stud(sno, schl, work)values(3, 'BitCamp Unv.', 'N');
insert into p1_stud(sno, schl, work)values(4, 'Bit Unv.', 'Y');
insert into p1_stud(sno, schl, work)values(5, '오호라 UNV.', 'Y');

insert into p1_tchr(tno, hrpay, subj)values(6, 10000, 'JAVA,C,C++');
insert into p1_tchr(tno, hrpay, subj)values(7, 12000, 'JAVA,BigData');
insert into p1_tchr(tno, hrpay, subj)values(8, 14000, 'C,C++,Adroid');

insert into p1_mgr(mrno, posi)values(9, '대리');
insert into p1_mgr(mrno, posi)values(10, '과장');


insert into p1_board(titl, cont, cnt, cdt, mno)
values('제목01', '내용01', 0, now(), 1);

insert into p1_board(titl, cont, cnt, cdt, mno)
values('제목02', '내용02', 0, now(), 1);

insert into p1_board(titl, cont, cnt, cdt, mno)
values('제목03', '내용03', 0, now(), 1);

insert into p1_board(titl, cont, cnt, cdt, mno)
values('제목04', '내용04', 0, now(), 2);

insert into p1_board(titl, cont, cnt, cdt, mno)
values('제목05', '내용05', 0, now(), 2);

insert into p1_board(titl, cont, cnt, cdt, mno)
values('제목06', '내용06', 0, now(), 4);

insert into p1_board(titl, cont, cnt, cdt, mno)
values('제목07', '내용07', 0, now(), 4);

insert into p1_board(titl, cont, cnt, cdt, mno)
values('제목08', '내용08', 0, now(), 4);


insert into p1_att_file(fi_nm, bno) values('file01.txt',1);
insert into p1_att_file(fi_nm, bno) values('file02.txt',1);
insert into p1_att_file(fi_nm, bno) values('file03.txt',2);
insert into p1_att_file(fi_nm, bno) values('file04.txt',3);
insert into p1_att_file(fi_nm, bno) values('file05.txt',3);
insert into p1_att_file(fi_nm, bno) values('file06.txt',5);
insert into p1_att_file(fi_nm, bno) values('file07.txt',8);