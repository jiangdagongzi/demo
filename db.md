# 后端模块



## User表

| 字段        | 属性        | 说明                    |
| ----------- | ----------- | ----------------------- |
| id          | bigint      | 自增                    |
| user_name   | varchar(20) |                         |
| auth        | bigint      | add,delete,modify,check |
| password    | varchar(50) |                         |
| create_time | timestamp   |                         |
| last_login  | timestamp   |                         |

### SecKill表

| 字段        | 属性         | 说明 |
| ----------- | ------------ | ---- |
| seckill_id  | bigint       | 自增 |
| name        | varchar(120) |      |
| number      | int          |      |
| start_time  | timestamp    | 非空 |
| end_time    | timestamp    | 非空 |
| create_time | timestamp    |      |

### Success_Kill表

| 字段       | 属性   | 说明 |
| ---------- | ------ | ---- |
| seckill_id | bigint |      |
| id         | bigint |      |
| state      | int    |      |

