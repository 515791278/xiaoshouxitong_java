# -*- coding: utf-8 -*-
import xlrd
import pymysql

def querySql():
    db = pymysql.connect("localhost", "root", "root", "xiaoshouxitong",charset="utf8")
    a=[]
    # 使用cursor()方法获取操作游标
    cursor = db.cursor()

    # SQL 插入语句
    sql="SELECT pro FROM tb_users$;"
    try:
        # 执行sql语句
        cursor.execute(sql)
        # 执行sql语句
        results = cursor.fetchall()
        for row in results:
            c=row[0].split(",")
            while "" in c:
                c.remove("")
            a.append(c)
        db.commit()
        return a

    except Exception:
        # 发生错误时回滚
        db.rollback()
        print("错误...............")

    db.close()
