package com.mickzeller.hotel.data.repository;

import com.mickzeller.hotel.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Mick Zeller on 5/2/2017.
 */
public interface ReservationRepository extends CrudRepository<Reservation, Long>
{
    List<Reservation> findByDate(Date date);
}
