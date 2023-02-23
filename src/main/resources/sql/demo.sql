create table if not exists tbl_item
(
    Id                  int auto_increment
        primary key,
    ItemValue         int not null
);

INSERT INTO tbl_item
VALUES (1, 20000)