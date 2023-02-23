package com.example.demo.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemDto {

    private Long id;

    private Long itemValue;
}
