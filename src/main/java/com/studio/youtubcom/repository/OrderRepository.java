package com.studio.youtubcom.repository;
import com.studio.youtubcom.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public  interface OrderRepository extends JpaRepository<Order, Long> {

}
