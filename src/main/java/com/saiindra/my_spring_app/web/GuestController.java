package com.saiindra.my_spring_app.web;

import com.saiindra.my_spring_app.business.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/guests")
public class GuestController {

    private final ReservationService reservationService;

    public GuestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String GetGuests(Model model){

        model.addAttribute("guestList",this.reservationService.getHotelGuests());
        return "guest";

    }
}
