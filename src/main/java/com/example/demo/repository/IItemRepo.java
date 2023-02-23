package com.example.demo.repository;

import com.example.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepo extends JpaRepository<Item, Long> {
}
