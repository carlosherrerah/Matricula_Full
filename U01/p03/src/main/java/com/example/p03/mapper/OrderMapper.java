package com.example.p03.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.example.p03.dto.OrderDTO;
import com.example.p03.model.Order;

import java.util.List;

import org.mapstruct.InjectionStrategy;

@Mapper(
  componentModel = "spring", 
  injectionStrategy = InjectionStrategy.CONSTRUCTOR, 
  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)

public interface OrderMapper {
  OrderDTO toDTO(Order model);

  @Named("ordersDTOList")
  default List<OrderDTO> toOrderDtoList(List<Order> sourceList) {
    return sourceList
        .stream()
        .map(this::toDTO)
        .toList();
  }

}
