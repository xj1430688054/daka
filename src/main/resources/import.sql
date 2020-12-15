insert into tb_role (id, create_time, description, name, role_key, status, update_time) values (1, '2017-01-09 17:25:30', '超级管理员', 'administrator', 'administrator', 0, '2017-01-09 17:26:25');


insert  into `tb_user`(`id`,`address`,`birthday`,`create_time`,`delete_status`,`description`,`email`,`locked`,`nick_name`,`password`,`sex`,`telephone`,`update_time`,`user_name`) values (1,'成都','2017-01-09 17:26:39','2017-01-09 17:26:41',0,'超级管理员','whoismy8023@163.com',0,'admin','3931MUEQD1939MQMLM4AISPVNE',1,'15923930000','2017-01-09 17:27:11','admin');

insert into tb_user_role (user_id, role_id) values (1, 1);

insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (1, '2017-01-10 13:56:51', '用户管理', null, 0, 2, '用户管理', 1, 'system:user:index', '/admin/user/index', 1, '2017-01-10 13:59:01', null);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (2, '2017-01-10 13:56:51', '用户编辑', null, 0, 3, '用户编辑', 1, 'system:user:edit', '/admin/user/edit*', 2, '2017-01-10 16:26:42', 1);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (3, '2017-01-11 16:48:48', '用户添加', null, 0, 3, '用户添加', 2, 'system:user:add', '/admin/user/add', 2, '2017-01-11 16:49:26', 1);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (4, '2017-01-11 16:48:48', '用户删除', null, 0, 3, '用户删除', 3, 'system:user:deleteBatch', '/admin/user/deleteBatch', 2, '2017-01-18 14:11:41', 1);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (5, '2017-01-11 16:48:48', '角色分配', null, 0, 3, '角色分配', 4, 'system:user:grant', '/admin/user/grant/**', 2, '2017-01-18 14:11:51', 1);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (6, '2017-01-12 16:45:10', '角色管理', null, 0, 2, '角色管理', 2, 'system:role:index', '/admin/role/index', 1, '2017-01-12 16:46:52', null);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (7, '2017-01-12 16:47:02', '角色编辑', null, 0, 3, '角色编辑', 1, 'system:role:edit', '/admin/role/edit*', 2, '2017-01-18 10:24:06', 1);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (8, '2017-01-12 16:47:23', '角色添加', null, 0, 3, '角色添加', 2, 'system:role:add', '/admin/role/add', 2, '2017-01-12 16:49:16', 6);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (9, '2017-01-12 16:47:23', '角色删除', null, 0, 3, '角色删除', 3, 'system:role:deleteBatch', '/admin/role/deleteBatch', 2, '2017-01-18 14:12:03', 6);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (10, '2017-01-12 16:47:23', '资源分配', null, 0, 3, '资源分配', 4, 'system:role:grant', '/admin/role/grant/**', 2, '2017-01-18 14:12:11', 6);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (11, '2017-01-17 11:21:12', '资源管理', null, 0, 2, '资源管理', 3, 'system:resource:index', '/admin/resource/index', 1, '2017-01-17 11:21:42', null);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (12, '2017-01-17 11:21:52', '资源编辑', null, 0, 3, '资源编辑', 1, 'system:resource:edit', '/admin/resource/edit*', 2, '2017-01-17 11:22:36', 11);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (13, '2017-01-17 11:21:54', '资源添加', null, 0, 3, '资源添加', 2, 'system:resource:add', '/admin/resource/add', 2, '2017-01-17 11:22:39', 11);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (14, '2017-01-17 11:21:54', '资源删除', null, 0, 3, '资源删除', 3, 'system:resource:deleteBatch', '/admin/resource/deleteBatch', 2, '2017-01-18 14:12:31', 11);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (15, '2017-01-17 11:21:12', '成员管理', null, 0, 2, '成员管理', 3, 'system:member:index', '/admin/member/index', 1, '2017-01-17 11:21:42', null);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (16, '2017-01-17 11:21:52', '成员编辑', null, 0, 3, '成员编辑', 1, 'system:member:edit', '/admin/member/edit*', 2, '2017-01-17 11:22:36', 15);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (17, '2017-01-17 11:21:54', '成员添加', null, 0, 3, '成员添加', 2, 'system:member:add', '/admin/member/add', 2, '2017-01-17 11:22:39', 15);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (18, '2017-01-17 11:21:54', '成员删除', null, 0, 3, '成员删除', 3, 'system:member:deleteBatch', '/admin/member/deleteBatch', 2, '2017-01-18 14:12:31', 15);
insert into tb_resource (id, create_time, description, icon, is_hide, level, name, sort, source_key, source_url, type, update_time, parent_id) values (19, '2017-01-17 11:21:54', '成员测试', null, 0, 3, '成员测试', 3, 'system:member:test', '/admin/member/test', 2, '2017-01-18 14:12:31', 15);



insert into tb_role_resource (role_id, resource_id) values (1, 1);
insert into tb_role_resource (role_id, resource_id) values (1, 2);
insert into tb_role_resource (role_id, resource_id) values (1, 3);
insert into tb_role_resource (role_id, resource_id) values (1, 4);
insert into tb_role_resource (role_id, resource_id) values (1, 5);
insert into tb_role_resource (role_id, resource_id) values (1, 6);
insert into tb_role_resource (role_id, resource_id) values (1, 7);
insert into tb_role_resource (role_id, resource_id) values (1, 8);
insert into tb_role_resource (role_id, resource_id) values (1, 9);
insert into tb_role_resource (role_id, resource_id) values (1, 10);
insert into tb_role_resource (role_id, resource_id) values (1, 11);
insert into tb_role_resource (role_id, resource_id) values (1, 12);
insert into tb_role_resource (role_id, resource_id) values (1, 13);
insert into tb_role_resource (role_id, resource_id) values (1, 14);
insert into tb_role_resource (role_id, resource_id) values (1, 15);
insert into tb_role_resource (role_id, resource_id) values (1, 16);
insert into tb_role_resource (role_id, resource_id) values (1, 17);
insert into tb_role_resource (role_id, resource_id) values (1, 18);
insert into tb_role_resource (role_id, resource_id) values (1, 19);

insert into tb_member (id, createtime, name, openid, updatetime, validstatus) values (1, '1020-12-10 00:00:00', 'xujian', 'oOhAh0em_aU1EN172xVz-Cp20L9g', '1020-12-10 00:00:00', '1');

