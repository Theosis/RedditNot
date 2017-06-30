use Group_3_RedditNot;

insert into user(enabled,password,username) values(true,"password","user");

insert into role(role) values("ADMIN");
insert into role(role) values("USER");

insert into user_roles(user_id,role_id) values(1,1);
