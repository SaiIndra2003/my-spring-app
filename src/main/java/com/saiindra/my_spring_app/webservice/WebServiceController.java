package com.saiindra.my_spring_app.webservice;


import com.saiindra.my_spring_app.business.ReservationService;
import com.saiindra.my_spring_app.business.RoomReservation;
import com.saiindra.my_spring_app.data.Guest;
import com.saiindra.my_spring_app.data.Room;
import com.saiindra.my_spring_app.util.DateUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebServiceController {

    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebServiceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path = "/reservations",method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value="date",required = false)String dateString){
        Date date = this.dateUtils.createDateFromDateString((dateString));
        return this.reservationService.getRoomReservationsForDate(date);
    }

    @RequestMapping(path = "/guests", method = RequestMethod.GET)
    public List<Guest> getGuests(){
        return this.reservationService.getHotelGuests();
    }

    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuest(@RequestBody Guest guest){
        this.reservationService.addGuest(guest);
    }

    @GetMapping("/rooms")
    public List<Room> getRooms(){
        return this.reservationService.getRooms();
    }


}
