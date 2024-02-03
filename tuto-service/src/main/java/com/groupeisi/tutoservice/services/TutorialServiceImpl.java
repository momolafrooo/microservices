package com.groupeisi.tutoservice.services;

import com.groupeisi.tutoservice.entities.Tutorial;
import com.groupeisi.tutoservice.repositories.TutorialRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TutorialServiceImpl implements TutorialService {

    private final TutorialRepository tutorialRepository;

    @Override
    public List<Tutorial> getAllTutorials(String title) {
        if (title == null)
            return tutorialRepository.findAll();
        else
            return tutorialRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public Tutorial getTutorialById(long id) {
        return tutorialRepository.findById(id).orElseThrow(() -> new RuntimeException("Tutorial not found"));
    }

    @Override
    public Tutorial createTutorial(Tutorial tutorial) {
        return tutorialRepository.save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
    }

    @Override
    public Tutorial updateTutorial(long id, Tutorial tutorial) {
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);

        if (tutorialData.isPresent()) {
            Tutorial _tutorial = tutorialData.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setPublished(tutorial.isPublished());
            return tutorialRepository.save(_tutorial);
        } else {
            throw new RuntimeException("Tutorial not found");
        }
    }

    @Override
    public void deleteTutorial(long id) {
        tutorialRepository.deleteById(id);
    }

    @Override
    public void deleteAllTutorials() {
        tutorialRepository.deleteAll();
    }

    @Override
    public List<Tutorial> findByPublished() {
        return tutorialRepository.findByPublished(true);
    }
}
