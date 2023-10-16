package com.barca.ecommerce.dtos;

import java.util.Set;

import com.barca.ecommerce.models.OrderItem;

public record UserCartDto(Set<OrderItem> cart) {
}
