package com.mickzeller.landon.data.repository;

import com.mickzeller.landon.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mick Zeller on 5/1/2017.
 */

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>
{
    Room findByNumber(String number);
}
