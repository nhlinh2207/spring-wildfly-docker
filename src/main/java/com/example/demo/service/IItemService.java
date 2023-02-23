package com.example.demo.service;

import com.example.demo.dto.ItemDto;
import com.example.demo.dto.ResponseObject;

import java.util.List;
import java.util.Map;

public interface IItemService {
    List<Map<String, String>> getAll();
    ResponseObject delete(Long id);
    ResponseObject create(ItemDto request);
}
