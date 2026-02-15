package com.example.ecom_proj.repository;

import com.example.ecom_proj.ProductDTO;
import com.example.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    @Query("""
       SELECT new com.example.ecom_proj.ProductDTO(
           p.id,
           p.name,
           p.descr,
           p.brand,
           p.price,
           p.category,
           p.releaseDate,
           p.available,
           p.quantity,
           p.imageName
       )
       FROM Product p
       WHERE LOWER(
           CONCAT(
               COALESCE(p.name,''),' ',
               COALESCE(p.descr,''),' ',
               COALESCE(p.brand,''),' ',
               COALESCE(p.category,'')
           )
       )
       LIKE LOWER(CONCAT('%', :keyword, '%'))
       """)
    List<ProductDTO> searchProducts(@Param("keyword")String keyword);
}
