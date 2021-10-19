package com.example.hostelmanagemant.controllers;

import com.example.hostelmanagemant.services.ComplainService;
import com.example.hostelmanagemant.services.RoomService;
import com.example.hostelmanagemant.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final RoomService roomService;
    private final ComplainService complianService;
    private final StudentService studentService;

    public DashboardController(RoomService roomService, ComplainService complianService, StudentService studentService) {
        this.roomService = roomService;
        this.complianService = complianService;
        this.studentService = studentService;
    }

    @RequestMapping("/main")
    public String dashboardView(Model model){
        model.addAttribute("totalRooms" , roomService.findAll().size());
        model.addAttribute("totalCapacity", roomService.findTotalCapacity());
        model.addAttribute("allocatedRooms", roomService.findAllocatedRooms().size());
        model.addAttribute("availableCapacity", roomService.findAvailableCapacity());
        model.addAttribute("totalComplains", complianService.findAll().size());
        model.addAttribute("resolvedComplains", complianService.findAllResolvedComplains());
        model.addAttribute("complains", complianService.findAll());

        System.out.println("returning dashboard page");
        return "dashboard";
    }



    @RequestMapping(value = "/student-history", method = RequestMethod.GET)
    public String studentHistory(Model model){
        model.addAttribute("students", studentService.findAll());
        System.out.println("Called /dashboard/student-history");
        return "dashboard :: #studentHistory";
    }
}
