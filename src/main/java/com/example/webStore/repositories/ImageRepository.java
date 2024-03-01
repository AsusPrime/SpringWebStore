package com.example.webStore.repositories;

import com.example.webStore.models.Image;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image, Long> {

    @Query("SELECT * FROM image")
    public List<Image> getAllImages();

    @Query("SELECT * FROM image WHERE id = :id")
    public Image getImageById(long id);

    @Query("SELECT * FROM image WHERE bookId = :id")
    public List<Image> getImageByBookId(long id);

    @Query("INSERT INTO image (source, bookId) " +
            "VALUES (:source, :bookId)")
    @Modifying
    public void addNewImage(String source, long bookId);
}
