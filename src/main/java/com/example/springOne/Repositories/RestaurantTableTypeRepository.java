// RestaurantTableRepository.java
package com.example.springOne.Repositories;

import com.example.springOne.Entities.RestaurantTableType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTableTypeRepository extends JpaRepository<RestaurantTableType, Integer> {}
