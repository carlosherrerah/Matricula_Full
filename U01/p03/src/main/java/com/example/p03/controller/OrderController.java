package com.example.p03.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.p03.dto.OrderDTO;
import com.example.p03.dto.OrderDTOsimple;
import com.example.p03.exception.ExcepcionRecursoNoEncontrado;
import com.example.p03.service.OrderService;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endpoints de Ordenes", description = "CRUD de Ordenes")
@RestController
@RequestMapping("/orders")
public class OrderController {
  private OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @GetMapping("/{orderId}")
  @ResponseStatus(HttpStatus.OK)
  public OrderDTO findById(@PathVariable long orderId) throws ExcepcionRecursoNoEncontrado {
    return orderService.findById(orderId);
  }

  @GetMapping("/simple/{orderId}")
  @ResponseStatus(HttpStatus.OK)
  public OrderDTOsimple findByIdsimple(@PathVariable long orderId) throws ExcepcionRecursoNoEncontrado {
    return orderService.findByIdsimple(orderId);
  }

}
