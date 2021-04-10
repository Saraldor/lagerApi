package com.example.uppgift2.lager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LagerRepository extends JpaRepository <Lager,Long>{

    @Query("Select s From Product S Where s.product_id =?1 ")
    default Optional<Lager> findProductByProduct_id(String product_id) {
        return null;
    }

}
