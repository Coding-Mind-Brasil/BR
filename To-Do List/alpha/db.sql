create database if not exists to_do_list_db;
use to_do_list_db;

drop table if exists tb_todo;
create table tb_todo(
			id int primary key auto_increment,
			task varchar(255),
            is_done boolean,
            is_trash boolean,
            insert_date timestamp,
            done_date timestamp,
            delete_date timestamp
);

show tables;
insert into tb_todo values(null, "meu 2- task3", false, false, sysdate(), null, null);
select * from tb_todo;
select * from tb_todo where is_done = false;
select * from tb_todo where is_trash = false;
select * from tb_todo where is_trash = false and is_done = false;