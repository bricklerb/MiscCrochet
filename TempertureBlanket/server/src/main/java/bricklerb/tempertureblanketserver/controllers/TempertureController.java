package bricklerb.tempertureblanketserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TempertureController
 */
@RestController
public class TempertureController {
    @GetMapping("/api/temp")
    public String temp() {
        return String.format("temp");
    }
}