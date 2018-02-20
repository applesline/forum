getUser
===
select * from t_user where id=#{id}

addUser
===
insert into t_user (username) values(#{username})