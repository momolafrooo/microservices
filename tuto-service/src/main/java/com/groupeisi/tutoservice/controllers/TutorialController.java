package com.groupeisi.tutoservice.controllers;

import com.groupeisi.tutoservice.entities.Tutorial;
import com.groupeisi.tutoservice.services.TutorialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tutorials")
@AllArgsConstructor
public class TutorialController {

    private final TutorialService tutorialService;

    @GetMapping("")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
        return ResponseEntity.ok().body(tutorialService.getAllTutorials(title));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(tutorialService.getTutorialById(id));
    }

    @PostMapping("")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        return ResponseEntity.ok().body(tutorialService.createTutorial(tutorial));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        return ResponseEntity.ok().body(tutorialService.updateTutorial(id, tutorial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        tutorialService.deleteTutorial(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        tutorialService.deleteAllTutorials();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        return ResponseEntity.ok().body(tutorialService.findByPublished());
    }
}
