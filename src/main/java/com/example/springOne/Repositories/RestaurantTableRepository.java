// RestaurantTableRepository.java
package com.example.springOne.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springOne.Entities.RestaurantTable;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Integer> {}
