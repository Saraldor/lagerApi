package com.example.uppgift2.lager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/lagerdb")

public class LagerController {
  private final LagerService lagerService;
@Autowired
    public LagerController(LagerService lagerService) {
        this.lagerService = lagerService;
    }

    @GetMapping
    public List<Lager> getLager() {
return lagerService.getLager();
    }
    @PostMapping
public void registerNewStudent(@RequestBody Lager lager){
    lagerService.addNewProduct(lager);
}
@DeleteMapping(path ="{productId}")
public void deleteStudent(@PathVariable("productId") Long productId) {
    lagerService.deleteProduct(productId);
}
    @PutMapping(path ="{productId}")
            public void updateStudent(
                    @PathVariable("productId") Long productId,
                    @RequestParam(required = false) String name,
                    @RequestParam(required = false)String product_id){
    lagerService.updateProduct(productId, name, product_id);

    }

    }
