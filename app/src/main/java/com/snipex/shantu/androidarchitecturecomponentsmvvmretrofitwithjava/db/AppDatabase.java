package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.db.dao.ArticleDao;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.db.dao.TaskDao;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.db.entity.Task;
import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article;

@Database(entities = {Task.class , Article.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
    public abstract ArticleDao articleDao();
}
