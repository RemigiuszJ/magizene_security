package com.remigiusset.magazine.controllers;

import com.remigiusset.magazine.api.model.RuggedNotebookDTO;
import com.remigiusset.magazine.api.model.RuggedNotebookListDTO;
import com.remigiusset.magazine.services.RuggedNotebookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/ruggedNotebook")
public class RuggedNotebookController {

    private final RuggedNotebookService ruggedNotebookService;

    public RuggedNotebookController(RuggedNotebookService ruggedNotebookService) {
        this.ruggedNotebookService = ruggedNotebookService;
    }

    @GetMapping("{id}")
    public ResponseEntity<RuggedNotebookDTO> getRuggedNotebookById(@PathVariable Long id) {
        return new ResponseEntity<RuggedNotebookDTO>(ruggedNotebookService.getRuggedNotebookById(id), HttpStatus.OK);
    }

    @GetMapping("findByStatus/{status}")
    public ResponseEntity<RuggedNotebookListDTO> getRuggedNotebooksByStatus(@PathVariable String status) {
        return new ResponseEntity<RuggedNotebookListDTO>
                (new RuggedNotebookListDTO(ruggedNotebookService.getRuggedNotebookByStatus(status)), HttpStatus.OK);
    }
    @GetMapping("findByMade/{made}")
    public ResponseEntity<RuggedNotebookListDTO> getRuggedNotebooksByMade(@PathVariable String made) {
        return new ResponseEntity<RuggedNotebookListDTO>
                (new RuggedNotebookListDTO(ruggedNotebookService.getRuggedNotebookByMade(made)),HttpStatus.OK);
    }
    @GetMapping("findByWaterproof/{waterproof}")
    public ResponseEntity<RuggedNotebookListDTO> getRuggedNotebooksByWaterproof(@PathVariable String waterproof) {
        return new ResponseEntity<RuggedNotebookListDTO>
                (new RuggedNotebookListDTO(ruggedNotebookService.getRuggedNotebookByWaterproof(waterproof)),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<RuggedNotebookDTO> createNewRuggedNotebook(@RequestBody RuggedNotebookDTO ruggedNotebookDTO){
        return new ResponseEntity<RuggedNotebookDTO>(ruggedNotebookService.createNewRuggedNotebook(ruggedNotebookDTO), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<RuggedNotebookDTO>updateRuggedNotebook(@PathVariable Long id, @RequestBody RuggedNotebookDTO ruggedNotebookDTO){
        return new ResponseEntity<RuggedNotebookDTO>(ruggedNotebookService.updateRuggedNotebook(id,ruggedNotebookDTO), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public  ResponseEntity<Void> deleteRuggedNotebook(@PathVariable Long id){
        ruggedNotebookService.deleteRuggedNotebookById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
