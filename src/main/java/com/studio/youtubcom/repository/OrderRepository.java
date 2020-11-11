package com.studio.youtubcom.repository;

import com.studio.youtubcom.models.Order;
import com.studio.youtubcom.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public  interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllById(Long idUser);
//  List<Order> findAll(Optional<User> oneByEmail);
}
