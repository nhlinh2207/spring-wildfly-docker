package com.example.demo.service.impl;

import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ResponseObject;
import com.example.demo.entity.Item;
import com.example.demo.repository.IItemRepo;
import com.example.demo.service.IItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ItemService implements IItemService {

    private final IItemRepo itemRepo;

    public List<Map<String, String>> getAll(){
        List<Map<String, String>> res = new ArrayList<>();
        List<Item> data = itemRepo.findAll();
        for (Item i : data){
            Map<String, String> item = new LinkedHashMap<>();
            item.put("id", i.getId()+"");
            item.put("value", i.getItemValue()+"");
            res.add(item);
        }
        return  res;
    }

    @Override
    public ResponseObject delete(Long id) {
        try{
            itemRepo.deleteById(id);
            return ResponseObject.builder()
                    .status(200)
                    .message("Success")
                    .build();
        }catch (Exception e){
            return ResponseObject.builder()
                    .status(500)
                    .message("Fail")
                    .build();
        }
    }

    @Override
    public ResponseObject create(ItemDto request) {
        try{
            itemRepo.save(Item.builder()
                    .itemValue(request.getItemValue())
                    .build()
            );
            return ResponseObject.builder()
                    .status(200)
                    .message("Success")
                    .build();
        }catch (Exception e){
            return ResponseObject.builder()
                    .status(500)
                    .message("Fail")
                    .build();
        }
    }
}
