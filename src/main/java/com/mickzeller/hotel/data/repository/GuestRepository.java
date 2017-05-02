package com.mickzeller.hotel.data.repository;

import com.mickzeller.hotel.data.entity.Guest;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Mick Zeller on 5/2/2017.
 */
public interface GuestRepository extends PagingAndSortingRepository<Guest,Long>
{
}
