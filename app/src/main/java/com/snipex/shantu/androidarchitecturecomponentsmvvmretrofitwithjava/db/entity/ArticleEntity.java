package com.snipex.shantu.androidarchitecturecomponentsmvvmretrofitwithjava.db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "Article")
public class ArticleEntity implements Serializable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    @ColumnInfo(name = "title")
    @SerializedName("title")
    private String title;

    @NonNull
    @ColumnInfo(name = "author")
    @SerializedName("author")
    private String author;

    @NonNull
    @ColumnInfo(name = "urlToImage")
    @SerializedName("urlToImage")
    private String urlToImage;

    @NonNull
    @ColumnInfo(name = "publishedAt")
    @SerializedName("publishedAt")
    private String publishedAt;

    @NonNull
    @ColumnInfo(name = "description")
    @SerializedName("description")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
