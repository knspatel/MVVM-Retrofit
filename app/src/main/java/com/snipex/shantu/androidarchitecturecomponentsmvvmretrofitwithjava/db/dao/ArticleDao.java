package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.db.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.model.Article;

import java.util.List;

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM Article")
    List<Article> getAll();

    @Insert
    void insert(Article article);

    @Delete
    void delete(Article article);

    @Update
    void update(Article article);


//    @Query("SELECT * FROM characters")
//    fun getAllCharacters() : LiveData<List<Character>>
//
//    @Query("SELECT * FROM characters WHERE id = :id")
//    fun getCharacter(id: Int): LiveData<Character>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertAll(characters: List<Character>)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(character: Character)

}
