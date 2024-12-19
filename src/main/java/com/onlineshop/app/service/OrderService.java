package com.onlineshop.app.service;

import com.onlineshop.app.model.Order;
import com.onlineshop.app.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(long id) {
        return orderRepository.findById(id);
    }
    public Order updateOrder(Long id, Order order) {
       Order orderToUpdate = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

       orderToUpdate.setUser(order.getUser());
       orderToUpdate.setOrderItems(order.getOrderItems());
       orderToUpdate.setTotal(order.getTotal());
       orderToUpdate.setDate(order.getDate());
       return orderRepository.save(orderToUpdate);
    }

    public void deleteOrder(long id) {
        Order orderToDelete = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(orderToDelete);
    }
}
