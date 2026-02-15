package com.example.ecom_proj;

import java.math.BigDecimal;
import java.util.Date;

public record ProductDTO(
        Integer id,
        String name,
        String descr,
        String brand,
        BigDecimal price,
        String category,
        Date releaseDate,
        Boolean available,
        Integer quantity,
        String imageName
) {}
