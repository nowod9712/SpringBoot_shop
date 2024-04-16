package com.shop.entity;

import com.shop.constant.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseEntity {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate;   //주문일

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;  //주문상태

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL,fetch = FetchType.LAZY,
               orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();
}
