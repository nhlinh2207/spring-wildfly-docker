package com.example.demo.api;

import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ResponseObject;
import com.example.demo.service.IItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@Slf4j
public class ItemAPI {

    private final IItemService itemService;

    @GetMapping(path = "/getAll")
    public List<Map<String, String>> getAllItems(){
        return itemService.getAll();
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseObject delete(@PathVariable Long id){
        return itemService.delete(id);
    }

    @PostMapping(path = "/create")
    public ResponseObject create(@RequestBody ItemDto request){
        return itemService.create(request);
    }
}
