package net.javaguides.springboot.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import net.javaguides.springboot.model.Appointment;
import net.javaguides.springboot.service.AppointmentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class AppointmentController {
  @Autowired
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/user/addAppointment")
    public String showAddAppointmentForm(Model model) {
        model.addAttribute("appointment", new Appointment());
        return "add-appointment";
    }

    @PostMapping("/user/addAppointment")
    public String addAppointment(@ModelAttribute Appointment appointment) {
        appointmentService.addAppointment(appointment);
        return "redirect:/appointments";
    }
}
