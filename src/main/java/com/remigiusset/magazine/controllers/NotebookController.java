package com.remigiusset.magazine.controllers;

import com.remigiusset.magazine.api.model.NotebookDTO;
import com.remigiusset.magazine.api.model.NotebookListDTO;
import com.remigiusset.magazine.services.NotebookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/notebook")

public class NotebookController {

    private final NotebookService notebookService;

    public NotebookController(NotebookService notebookService) {
        this.notebookService = notebookService;
    }

    @GetMapping("{id}")
    public ResponseEntity<NotebookDTO> getNotebookById(@PathVariable Long id) {
        return new ResponseEntity<NotebookDTO>(notebookService.getNotebookById(id), HttpStatus.OK);
    }

   @GetMapping("findByStatus/{status}")
   public ResponseEntity<NotebookListDTO> getNotebooksByStatus(@PathVariable String status) {
       return new ResponseEntity<NotebookListDTO>
               (new NotebookListDTO(notebookService.getNotebookByStatus(status)), HttpStatus.OK);
   }
       @GetMapping("findByPreorder/{preorder}")
       public ResponseEntity<NotebookListDTO> getNotebooksByPreorder(@PathVariable String preorder) {
           return new ResponseEntity<NotebookListDTO>
                   (new NotebookListDTO(notebookService.getNotebookByPreorder(preorder)),HttpStatus.OK);
   }
    @GetMapping("findByRanking/{ranking}")
    public ResponseEntity<NotebookListDTO> getNotebooksByRanking(@PathVariable String ranking) {
        return new ResponseEntity<NotebookListDTO>
                (new NotebookListDTO(notebookService.getNotebookByRanking(ranking)),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<NotebookDTO> createNewNotebook(@RequestBody NotebookDTO notebookDTO){
        return new ResponseEntity<NotebookDTO>(notebookService.createNewNotebook(notebookDTO), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<NotebookDTO>updateNotebook(@PathVariable Long id, @RequestBody NotebookDTO notebookDTO){
        return new ResponseEntity<NotebookDTO>(notebookService.updateNotebook(id,notebookDTO), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public  ResponseEntity<Void> deleteNotebook(@PathVariable Long id){
     notebookService.deleteNotebookById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}