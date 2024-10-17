package product.demojenkins.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dashboard {
    
   
    @GetMapping("/dashboard")
    public String getDashboard() {
        var s = "<h1>this is dashboard</h1>";
        return s;
    }
}
