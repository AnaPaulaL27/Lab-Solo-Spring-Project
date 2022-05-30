package com.bnta.nandos.controllers;

import com.bnta.nandos.models.Feedback;
import com.bnta.nandos.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//Note that RestController annotation is a convenience syntax for @Controller + @Response body combined
// it indicates that the class is a controller + that all methods marked in the marked class
//will return a JSON response
@RestController
@RequestMapping("feedbacks") //localhost:8080/feedbacks


public class FeedbackController {

    @Autowired
    FeedbackRepository feedbackRepository;


//    Handles following:
//    * GET /feedbacks
//    * GET /feedbacks?name=Melissa
//    * GET /nandocas?rating=3

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacksAndFilters(
            @RequestParam Map<String, String> requestParams, Integer rating

    ) {
        String name = requestParams.get("name");

        //      GET /feedbacks?name=Melissa
        if (name != null) {
            return new ResponseEntity<>(feedbackRepository.findFeedbackByNameContainingIgnoreCase(name),
                    feedbackRepository.findFeedbackByNameContainingIgnoreCase(name).isEmpty() ?
                            HttpStatus.NOT_FOUND :
                            HttpStatus.OK);

//                  GET/feedbacks?rating=3
        } else if (rating != null) {
            {
                return new ResponseEntity<>(feedbackRepository.findFeedbackByRatingGreaterThan(rating),
                        feedbackRepository.findFeedbackByRatingGreaterThan(rating).isEmpty() ?
                                HttpStatus.NOT_FOUND :
                                HttpStatus.OK);
            }
        }
//        GET /nandocas
        return new ResponseEntity<>(feedbackRepository.findAll(),
                feedbackRepository.findAll().isEmpty() ?
                        HttpStatus.NOT_FOUND :
                        HttpStatus.OK);
    }


    //SHOW
    @GetMapping(value = "/{id}")//localhost:8080/feedbacks/1  -- e.g. Feedback with id=1
    public ResponseEntity<Optional<Feedback>> getFeedback(@PathVariable Long id) {
        var feedback = feedbackRepository.findById(id);
        return new ResponseEntity<>(feedback, feedback.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    //UPDATE
    @PutMapping(value = "/{id}") // localhost:8080/feedbacks/1  -- e.g. Feedback with id=1
    public ResponseEntity<Optional<Feedback>> putFeedback(@RequestBody Feedback feedback, @PathVariable Long id) {
        if (feedbackRepository.findById(id).isEmpty()) {
            return new ResponseEntity<>(feedbackRepository.findById(id), HttpStatus.NOT_FOUND);
        } else {
            Feedback feedbackToUpdate = feedbackRepository.findById(id).get();
            feedbackToUpdate.setDate(feedback.getDate());
            feedbackToUpdate.setName(feedback.getName());
            feedbackToUpdate.setDescription(feedback.getDescription());
            feedbackToUpdate.setRating(feedback.getRating());
            feedbackToUpdate.setNandoca(feedback.getNandoca());
            feedbackRepository.save(feedbackToUpdate);
            return new ResponseEntity<>(feedbackRepository.findById(id), HttpStatus.OK);
        }
    }

    //POST
    @PostMapping // localhost:8080/feedbacks
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback newFeedback) {
        feedbackRepository.save(newFeedback);
        return new ResponseEntity<>(newFeedback, HttpStatus.CREATED);
    }


    //DELETE
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<Feedback>> deleteFeedback(@PathVariable("id") Long id) {
        var feedback = feedbackRepository.findById(id);
        if (feedback.isEmpty()) {
            return new ResponseEntity<>(feedback, HttpStatus.NOT_FOUND);
        } else {
            feedbackRepository.deleteById(id);
            return new ResponseEntity(feedbackRepository.findAll(), HttpStatus.OK);
        }

    }

}




