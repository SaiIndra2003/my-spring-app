package com.saiindra.my_spring_app.repository;

import com.saiindra.my_spring_app.data.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {



}
