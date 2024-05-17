package br.com.univesp.pi;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminController {

    @Autowired
    AdminService adminService;

    @CrossOrigin
    @GetMapping("/api/admin/flag/{flagName}")
    public String getFlagValue(@PathVariable(name = "flagName") String name ) {
        return adminService.getFlagValue(name);
    }
}
