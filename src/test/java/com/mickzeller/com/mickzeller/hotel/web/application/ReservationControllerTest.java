package com.mickzeller.com.mickzeller.hotel.web.application;

import com.mickzeller.hotel.business.domain.RoomReservation;
import com.mickzeller.hotel.business.service.ReservationService;
import com.mickzeller.hotel.web.application.ReservationController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by Mick Zeller on 5/2/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ReservationController.class)

public class ReservationControllerTest
{
    @MockBean
    private ReservationService reservationService;
    @Autowired
    private MockMvc mockMvc;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void getReservations() throws Exception
    {
        Date date = DATE_FORMAT.parse("2017-05-02");
        ArrayList<RoomReservation> mockReservationList = new ArrayList<>();
        RoomReservation mockReservation = new RoomReservation();
        mockReservation.setLastName("Test");
        mockReservation.setFirstName("Junit");
        mockReservation.setDate(date);
        mockReservation.setRoomNumber("J1");
        mockReservation.setGuestId(1);
        mockReservation.setRoomId(100);
        mockReservation.setRoomName("Junit Room");
        mockReservationList.add(mockReservation);

        given(reservationService.getRoomReservationsForDate(date)).willReturn(mockReservationList);
        this.mockMvc.perform(get("/reservations?date=2017-05-02")).andExpect(status().isOk()).andExpect(content().string(containsString("Test, Junit")));

    }
}
