package com.saiindra.my_spring_app.repository;

import com.saiindra.my_spring_app.data.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
