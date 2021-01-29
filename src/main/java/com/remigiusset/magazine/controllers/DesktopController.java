package com.remigiusset.magazine.controllers;

import com.remigiusset.magazine.api.model.DesktopDTO;
import com.remigiusset.magazine.api.model.DesktopListDTO;
import com.remigiusset.magazine.services.DesktopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("api/desktop/")
public class DesktopController {

    private final DesktopService desktopService;

    public DesktopController(DesktopService desktopService) {
        this.desktopService = desktopService;
    }

    @GetMapping("{id}")
    public ResponseEntity<DesktopDTO> getDesktopById(@PathVariable Long id) {
        return new ResponseEntity<DesktopDTO>(desktopService.getDesktopById(id), HttpStatus.OK);
    }

    @GetMapping("findByStatus/{status}")
    public ResponseEntity<DesktopListDTO> getDesktopsByStatus(@PathVariable String status) {
        return new ResponseEntity<DesktopListDTO>
                (new DesktopListDTO(desktopService.getDesktopByStatus(status)), HttpStatus.OK);
    }

    @GetMapping("findByCondition/{condition}")
    public ResponseEntity<DesktopListDTO> getDesktopsByCondition(@PathVariable String condition) {
        return new ResponseEntity<DesktopListDTO>
                (new DesktopListDTO(desktopService.getDesktopByCondition(condition)), HttpStatus.OK);
    }
    @GetMapping("findByPreorder/{preorder}")
    public ResponseEntity<DesktopListDTO> getDesktopsByPreorder(@PathVariable String preorder) {
        return new ResponseEntity<DesktopListDTO>
                (new DesktopListDTO(desktopService.getDesktopByPreorder(preorder)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DesktopDTO> createNewDesktop(@RequestBody DesktopDTO desktopDTO){
        return new ResponseEntity<DesktopDTO>(desktopService.createNewDesktop(desktopDTO), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<DesktopDTO>updateDesktop(@PathVariable Long id, @RequestBody DesktopDTO desktopDTO){
        return new ResponseEntity<DesktopDTO>(desktopService.updateDesktop(id, desktopDTO), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public  ResponseEntity<Void> deleteDesktop(@PathVariable Long id){
        desktopService.deleteDesktopById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

