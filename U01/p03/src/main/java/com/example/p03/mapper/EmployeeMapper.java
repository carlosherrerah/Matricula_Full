package com.example.p03.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.InjectionStrategy;

import com.example.p03.dto.CreateEmployeeDTO;
import com.example.p03.dto.EmployeeDTO;
import com.example.p03.dto.EmployeeOrderDTO;
import com.example.p03.model.Employee;
import java.util.List;

@Mapper(
  componentModel = "spring", 
  injectionStrategy = InjectionStrategy.CONSTRUCTOR, 
  nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
  uses = OrderMapper.class  
)
public interface EmployeeMapper {

  EmployeeDTO toDTO(Employee model);

  List<EmployeeDTO> toDTO(List<Employee> model);
   
  @Mapping(target = "idEmployee", ignore = true)
  @Mapping(target = "hireDate", ignore = true)
  @Mapping(target = "active", ignore = true)
  @Mapping(target = "orders", ignore = true)
  Employee toModel(CreateEmployeeDTO data);

  // List<Employee> toModel(List<EmployeeDTO> data);    // Probar

  @Mapping(source = "orders", target = "orders", qualifiedByName = "ordersDTOList")
  EmployeeOrderDTO toDTOWithOrders(Employee model);

}