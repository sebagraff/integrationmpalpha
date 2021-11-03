package com.tiendaecommerce.tienda.controllers;

import com.tiendaecommerce.tienda.dtos.ProductDTO;
import com.tiendaecommerce.tienda.dtos.WebHookDTO;
import com.tiendaecommerce.tienda.models.Product;
import com.tiendaecommerce.tienda.models.WebHook;
import com.tiendaecommerce.tienda.repositories.WebHookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WebHookController {
    @Autowired
    WebHookRepository webHookRepository;

    @GetMapping("/webhooksmp")
    public List<WebHookDTO> getAll(){
        return this.webHookRepository.findAll().stream().map(WebHookDTO::new).collect(Collectors.toList());
    }

    @PostMapping("/webhooksmp")
    public ResponseEntity<?> createWebHook(@RequestBody WebHookDTO webHookDTO){
        WebHook webHook = webHookRepository.save(new WebHook(webHookDTO.getId(), webHookDTO.isLive_mode(), webHookDTO.getType(), webHookDTO.getDate_created(), webHookDTO.getApplication_id(), webHookDTO.getUser_id(), webHookDTO.getVersion(), webHookDTO.getApi_version(), webHookDTO.getAction(), webHookDTO.getData()));
        return new ResponseEntity<>("Received", HttpStatus.OK);

    }
}