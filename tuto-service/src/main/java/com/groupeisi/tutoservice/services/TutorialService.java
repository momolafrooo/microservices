package com.groupeisi.tutoservice.services;

import com.groupeisi.tutoservice.entities.Tutorial;

import java.util.List;

public interface TutorialService {
    List<Tutorial> getAllTutorials(String title);

    Tutorial getTutorialById(long id);

    Tutorial createTutorial(Tutorial tutorial);

    Tutorial updateTutorial(long id, Tutorial tutorial);

    void deleteTutorial(long id);

    void deleteAllTutorials();

    List<Tutorial> findByPublished();
}
