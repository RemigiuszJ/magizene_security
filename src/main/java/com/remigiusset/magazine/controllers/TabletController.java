package com.remigiusset.magazine.controllers;

import com.remigiusset.magazine.api.model.TabletDTO;
import com.remigiusset.magazine.api.model.TabletListDTO;
import com.remigiusset.magazine.services.TabletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/tablet/")
public class TabletController {

    private  final TabletService tabletService;

    public TabletController(TabletService tabletService) {
        this.tabletService = tabletService;
    }

    @GetMapping("{id}")
    public ResponseEntity<TabletDTO> getTabletById(@PathVariable Long id) {
        return new ResponseEntity<TabletDTO>(tabletService.getTabletById(id), HttpStatus.OK);
    }

    @GetMapping("findByStatus/{status}")
    public ResponseEntity<TabletListDTO> getTabletsByStatus(@PathVariable String status) {
        return new ResponseEntity<TabletListDTO>
                (new TabletListDTO(tabletService.getTabletByStatus(status)), HttpStatus.OK);
    }

    @GetMapping("findByColour/{colour}")
    public ResponseEntity<TabletListDTO> getTabletByColour(@PathVariable String colour) {
        return new ResponseEntity<TabletListDTO>
                (new TabletListDTO(tabletService.getTabletByColour(colour)), HttpStatus.OK);
    }
    @GetMapping("findBySize/{size}")
    public ResponseEntity<TabletListDTO> getTabletBySize(@PathVariable String size) {
        return new ResponseEntity<TabletListDTO>
                (new TabletListDTO(tabletService.getTabletBySize(size)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TabletDTO> createNewTablet(@RequestBody TabletDTO tabletDTO){
        return new ResponseEntity<TabletDTO>(tabletService.createNewTablet(tabletDTO), HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<TabletDTO>updateTablet(@PathVariable Long id, @RequestBody TabletDTO tabletDTO){
        return new ResponseEntity<TabletDTO>(tabletService.updateTablet(id, tabletDTO), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public  ResponseEntity<Void> deleteTablet(@PathVariable Long id){
      tabletService.deleteTabletById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
