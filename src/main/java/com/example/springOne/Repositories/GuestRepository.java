// RestaurantTableRepository.java
package com.example.springOne.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springOne.Entities.Guest;

public interface GuestRepository extends JpaRepository<Guest, Integer> {}
