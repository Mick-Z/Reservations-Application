package com.mickzeller.hotel.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mick Zeller on 5/2/2017.
 */
@Controller
@RequestMapping(value = "/reservations")
public class ReservationController
{
    @RequestMapping(method = RequestMethod.GET)
    public String getReservations()
    {
        return "reservations"; //will be translated by the tymeleaf engine into the reservations page
    }
}
