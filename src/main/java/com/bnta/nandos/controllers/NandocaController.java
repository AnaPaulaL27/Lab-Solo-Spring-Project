package com.bnta.nandos.controllers;

import com.bnta.nandos.models.Nandoca;
import com.bnta.nandos.repositories.NandocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("nandocas") //localhost:8080/nandocas

public class NandocaController {

    @Autowired
    NandocaRepository nandocaRepository;

//INDEX and Multiple FILTERS
    //    Handles following:
    //    * GET /nandocas
    //    * GET /nandocas?name=Sandra
    //    * GET /nandocas?yearsExperience=2

    @GetMapping
    public ResponseEntity<List<Nandoca>> getAllNandocasAndFilters(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "yearsExperience") Integer yearsExperience
    ) {
//        String name = requestParams.get("name");

//      GET/nandocas?name= SaNdRa
        if (name != null) {
            return new ResponseEntity<>(nandocaRepository.findNandocaByNameContainingIgnoreCase(name),
                    nandocaRepository.findNandocaByNameContainingIgnoreCase(name).isEmpty() ?
                            HttpStatus.NOT_FOUND :
                            HttpStatus.OK);
        }
//      GET/nandocas?yearsExperienceGreaterThan=2
        else if (yearsExperience != null) {
            {
                return new ResponseEntity<>(nandocaRepository.findNandocaByYearsExperienceGreaterThan(yearsExperience),
                        nandocaRepository.findNandocaByYearsExperienceGreaterThan(yearsExperience).isEmpty() ?
                                HttpStatus.NOT_FOUND :
                                HttpStatus.OK);
            }
//       GET/ nandocas
        }else
            return new ResponseEntity<>(nandocaRepository.findAll(),nandocaRepository.findAll().isEmpty() ?
                        HttpStatus.NOT_FOUND :
                        HttpStatus.OK);
    }






//    @GetMapping
//    public ResponseEntity<List<Nandoca>> getAllNandocasAndFilters(
//            @RequestParam Map<String, String> requestParams, Integer yearsExperience
//
//    ) {
//
//        String name = requestParams.get("name");
//
//        //      GET /nandocas?name=Sandra
//        if (name != null) {
//            return new ResponseEntity<>(nandocaRepository.findNandocaByNameContainingIgnoreCase(name),
//                    nandocaRepository.findNandocaByNameContainingIgnoreCase(name).isEmpty() ?
//                            HttpStatus.NOT_FOUND :
//                            HttpStatus.OK);
//
//        //      GET/nandocas?yearsExperienceGreaterThan=2
//        } else if (yearsExperience != null) {
//            {
//                return new ResponseEntity<>(nandocaRepository.findNandocaByYearsExperienceGreaterThan(yearsExperience),
//                        nandocaRepository.findNandocaByYearsExperienceGreaterThan(yearsExperience).isEmpty() ?
//                                HttpStatus.NOT_FOUND :
//                                HttpStatus.OK);
//            }
//        }
//        //       GET /nandocas
//        return new ResponseEntity<>(nandocaRepository.findAll(),
//                nandocaRepository.findAll().isEmpty() ?
//                        HttpStatus.NOT_FOUND :
//                        HttpStatus.OK);
//    }



    //SHOW
    @GetMapping(value = "/{id}")//localhost:8080/nandocas/1  -- e.g. Nandoca with id=1
    public ResponseEntity<Optional<Nandoca>> getNandoca(@PathVariable Long id) {
        var nandoca = nandocaRepository.findById(id);
        return new ResponseEntity<>(nandoca, nandoca.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    //UPDATE
    @PutMapping(value="/{id}") // localhost:8080/nandocas/1  -- e.g. Nandoca with id=1
    public ResponseEntity<Optional<Nandoca>> putNandoca(@RequestBody Nandoca nandoca, @PathVariable Long id){
        if(nandocaRepository.findById(id).isEmpty()) {
            return new ResponseEntity<>(nandocaRepository.findById(id), HttpStatus.NOT_FOUND);
        }else {
            Nandoca nandocaToUpdate = nandocaRepository.findById(id).get();
            nandocaToUpdate.setName(nandoca.getName());
            nandocaToUpdate.setDOB(nandoca.getDOB());
            nandocaToUpdate.setYearsExperience(nandoca.getYearsExperience());
            nandocaToUpdate.setEmployeeNumber(nandoca.getEmployeeNumber());
            nandocaRepository.save(nandocaToUpdate);
            return new ResponseEntity<>(nandocaRepository.findById(id), HttpStatus.OK);
        }
    }


    //POST
    @PostMapping // localhost:8080/nandocas
    public ResponseEntity<Nandoca> createNandoca(@RequestBody Nandoca newNandoca) {
        nandocaRepository.save(newNandoca);
        return new ResponseEntity<>(newNandoca, HttpStatus.CREATED);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Nandoca>>deleteNandoca(@PathVariable("id") Long id) {
        var nandoca = nandocaRepository.findById(id);
        if (nandoca.isEmpty()) {
            return new ResponseEntity<>(nandoca, HttpStatus.NOT_FOUND);
        } else {
            nandocaRepository.deleteById(id);
            return new ResponseEntity(nandocaRepository.findAll(), HttpStatus.OK);
        }
    }
}



