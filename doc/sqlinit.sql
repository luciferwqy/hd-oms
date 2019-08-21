------权限------
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('1', '0', '商品', null, null, '0', null, '1', '2018-09-29 16:15:14', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('2', '1', '商品列表', 'pms:product:read', null, '1', '/pms/product/index', '1', '2018-09-29 16:17:01', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('3', '1', '添加商品', 'pms:product:create', null, '1', '/pms/product/add', '1', '2018-09-29 16:18:51', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('4', '1', '商品分类', 'pms:productCategory:read', null, '1', '/pms/productCate/index', '1', '2018-09-29 16:23:07', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('5', '1', '商品类型', 'pms:productAttribute:read', null, '1', '/pms/productAttr/index', '1', '2018-09-29 16:24:43', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('6', '1', '品牌管理', 'pms:brand:read', null, '1', '/pms/brand/index', '1', '2018-09-29 16:25:45', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('7', '2', '编辑商品', 'pms:product:update', null, '2', '/pms/product/updateProduct', '1', '2018-09-29 16:34:23', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('8', '2', '删除商品', 'pms:product:delete', null, '2', '/pms/product/delete', '1', '2018-09-29 16:38:33', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('9', '4', '添加商品分类', 'pms:productCategory:create', null, '2', '/pms/productCate/create', '1', '2018-09-29 16:43:23', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('10', '4', '修改商品分类', 'pms:productCategory:update', null, '2', '/pms/productCate/update', '1', '2018-09-29 16:43:55', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('11', '4', '删除商品分类', 'pms:productCategory:delete', null, '2', '/pms/productAttr/delete', '1', '2018-09-29 16:44:38', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('12', '5', '添加商品类型', 'pms:productAttribute:create', null, '2', '/pms/productAttr/create', '1', '2018-09-29 16:45:25', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('13', '5', '修改商品类型', 'pms:productAttribute:update', null, '2', '/pms/productAttr/update', '1', '2018-09-29 16:48:08', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('14', '5', '删除商品类型', 'pms:productAttribute:delete', null, '2', '/pms/productAttr/delete', '1', '2018-09-29 16:48:44', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('15', '6', '添加品牌', 'pms:brand:create', null, '2', '/pms/brand/add', '1', '2018-09-29 16:49:34', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('16', '6', '修改品牌', 'pms:brand:update', null, '2', '/pms/brand/update', '1', '2018-09-29 16:50:55', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('17', '6', '删除品牌', 'pms:brand:delete', null, '2', '/pms/brand/delete', '1', '2018-09-29 16:50:59', '0');
INSERT INTO ums_permission(id,pid,name,value,icon,type,uri,status,create_time,sort) VALUES ('18', '0', '首页', null, null, '0', null, '1', '2018-09-29 16:51:57', '0');

--------用户--------
INSERT INTO ums_admin(id,username,bange,password,icon,email,nick_name,create_time,login_time,status) VALUES ('1', '测试人员','test', '$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG', 'http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg', null, '测试账号', '2018-09-29 13:55:30', '2018-09-29 13:55:39', '1');

--------用户角色绑定--------
INSERT INTO ums_admin_role_relation VALUES ('1', '1', '1');


--------角色权限绑定--------
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('1', '1', '1');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('2', '1', '2');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('3', '1', '3');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('4', '1', '7');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('5', '1', '8');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('6', '1', '4');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('7', '1', '9');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('8', '1', '10');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('9', '1', '11');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('10', '1', '5');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('11', '1', '12');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('12', '1', '13');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('13', '1', '14');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('14', '1', '6');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('15', '1', '15');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('16', '1', '16');
INSERT INTO ums_role_permission_relation(id,role_id,permission_id) VALUES ('17', '1', '17');

--------角色--------
INSERT INTO ums_role VALUES ('1', '0','系统管理员',  '2018-09-30 15:46:11','系统管理员', '1');


--------用户权限绑定--------
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('1', '1', '1');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('2', '1', '2');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('3', '1', '3');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('4', '1', '7');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('5', '1', '8');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('6', '1', '4');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('7', '1', '9');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('8', '1', '10');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('9', '1', '11');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('10', '1', '5');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('11', '1', '12');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('12', '1', '13');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('13', '1', '14');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('14', '1', '6');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('15', '1', '15');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('16', '1', '16');
INSERT INTO UMS_ADMIN_PERMISSION_RELATION(id,admin_id,permission_id) VALUES ('17', '1', '17');
