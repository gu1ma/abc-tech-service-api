package br.com.fiap.abctechservice.controller;

import br.com.fiap.abctechservice.application.PropertiesComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthCheckController {

    private PropertiesComponent propertiesComponent;
    public HealthCheckController(@Autowired PropertiesComponent propertiesComponent) {
        this.propertiesComponent = propertiesComponent;
    }

    @GetMapping("")
    public ResponseEntity<Object> status() {
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/version")
    public ResponseEntity<String> version() {
        System.out.println("name: "+this.propertiesComponent.getName());
        return ResponseEntity.ok(this.propertiesComponent.getName() +" - "+ this.propertiesComponent.getVersion());
    }
}
