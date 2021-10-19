package com.example.hostelmanagemant.controllers;

import com.example.hostelmanagemant.services.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RespectBinding;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @RequestMapping("/")
    public String totalRoomDetails(Model model){
        System.out.println("Called /rooms/");
        model.addAttribute("rooms", roomService.findAll());

        return "room";
    }

    @RequestMapping("/add")
    public String addRoom(Model model){
        System.out.println("Called /rooms/add");
//        model.addAttribute("rooms", roomService.findAll());

        return "add-room";
    }
}
