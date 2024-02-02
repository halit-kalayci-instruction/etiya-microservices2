package com.etiya.orderservice.controllers;

import com.etiya.orderservice.clients.ProductClient;
import com.etiya.orderservice.dtos.SubmitOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrdersController
{
    //private final WebClient.Builder webClientBuilder;
    private final ProductClient productClient;
    @PostMapping
    public String submitOrder(@RequestBody SubmitOrderDto orderDto)
    {
        // WebClient
        // OpenFeign
        /*Boolean response = webClientBuilder
                .build()
                .get()
                .uri("http://localhost:8080/api/v1/products",
                        (uriBuilder -> uriBuilder.queryParam("productId",orderDto.getProductId()).build()))
                .retrieve()
                .bodyToMono(Boolean.class)
                .block(); */
        Boolean response = productClient.getStockStatus(orderDto.getProductId());
        if(response)
            return "Sipariş oluşturuldu.";
        return "Sipariş oluşturulamadı.";
    }
}