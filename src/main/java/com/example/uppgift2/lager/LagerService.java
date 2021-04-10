package com.example.uppgift2.lager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LagerService {
    private final LagerRepository lagerRepository;
@Autowired
    public LagerService(LagerRepository lagerRepository) {
        this.lagerRepository = lagerRepository;
    }

    public List<Lager> getLager() {
    return lagerRepository.findAll();
    }

    public void addNewProduct(Lager lager) {
    Optional<Lager> productOptional = lagerRepository.findProductByProduct_id(lager.getProduct_id());
    if (productOptional.isPresent()) throw new IllegalStateException(("ID är taget"));

lagerRepository.save(lager);

    }
    public void deleteProduct(Long productId){
boolean exists = lagerRepository.existsById(productId);
if(!exists){
    throw new IllegalStateException("Produkten med  id " + productId+ "finns inte!");

}
lagerRepository.deleteById(productId);
    }

    public void updateProduct(Long productId, String name, String product_id){
    Lager lager = lagerRepository.findById(productId)
            .orElseThrow(()-> new IllegalStateException("Produkt meed ID " + productId + "finns inte!"));
   if (name != null &&
   name.length() >0 &&
       !Objects.equals(lager.getName(), name)){
    lager.setName(name);
        }
        if (lager.category != null &&
                product_id.length() >0 &&
                !Objects.equals(lager.getProduct_id(), product_id)){
           Optional<Lager> productOptional = lagerRepository
                   .findProductByProduct_id(product_id);

           if (productOptional.isPresent()) {
               throw new IllegalStateException("Id Taken");
           }
            lager.setProduct_id(product_id);
           }
        }
}

