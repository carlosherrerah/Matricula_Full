package com.example.p03.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.*;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private long idOrder;

    //@ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_employee", nullable = false)
    private Employee employee;  // transient
    
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;

}
