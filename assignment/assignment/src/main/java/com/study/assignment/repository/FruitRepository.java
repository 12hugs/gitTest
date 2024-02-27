package com.study.assignment.repository;

import com.study.assignment.domain.entity.Fruit;
import com.study.assignment.dto.response.FruitStatResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
    @Query("select new com.study.assignment.dto.response.FruitStatResponseDTO(f.state, sum(f.price)) " +
            " from Fruit f " +
            "where f.name = :fruitName " +
            "group by f.state")
    List<FruitStatResponseDTO> response(@Param("fruitName") String fruitName);

    Long countByName(String name);

    List<Fruit> findByPriceLessThan(Integer price);

    List<Fruit> findByPriceGreaterThan(Integer price);

}
