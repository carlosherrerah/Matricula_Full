package com.example.p03.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.p03.dto.OrderDTO;
import com.example.p03.dto.OrderDTOsimple;
import com.example.p03.exception.ExcepcionRecursoNoEncontrado;
import com.example.p03.mapper.OrderMapper;
import com.example.p03.model.Order;
import com.example.p03.repository.EmployeeRepository;
import com.example.p03.repository.OrderRepository;

@Service
public class OrderService {
  private OrderRepository orderRepository;
  private EmployeeRepository employeeRepository;
  private OrderMapper orderMapper;

  public OrderService(OrderRepository orderRepository, EmployeeRepository employeeRepository, OrderMapper orderMapper) {
    this.orderRepository = orderRepository;
    this.employeeRepository = employeeRepository;
    this.orderMapper = orderMapper;
  }

  public OrderDTO findById(long orderId) throws ExcepcionRecursoNoEncontrado {
    Optional<Order> optionalOrder = orderRepository.findById(orderId);

    if (!optionalOrder.isPresent()) {
      throw new ExcepcionRecursoNoEncontrado("" + orderId);
    }
    return optionalOrder.stream().map(orderMapper::toDTO).toList().get(0);
  }

  public OrderDTOsimple findByIdsimple(long orderId) throws ExcepcionRecursoNoEncontrado {
    Optional<Order> optionalOrder = orderRepository.findById(orderId);

    if (!optionalOrder.isPresent()) {
      throw new ExcepcionRecursoNoEncontrado("" + orderId);
    }
    OrderDTO orderDTO;
    orderDTO = optionalOrder.stream().map(orderMapper::toDTO).toList().get(0);
    OrderDTOsimple simple = new OrderDTOsimple();
    simple.setIdOrder(orderDTO.getIdOrder());
    simple.setIdEmployee(orderDTO.getEmployee().getIdEmployee());  // idEmployee
    simple.setOrderDate(orderDTO.getOrderDate());
    return simple;
  }

}
