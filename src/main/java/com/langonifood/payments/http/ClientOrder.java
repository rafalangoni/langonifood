package com.langonifood.payments.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("orders-ms")
public interface ClientOrder {
    @RequestMapping(method = RequestMethod.PUT, value = "/orders/{id}/paid")
    void updatePayment(@PathVariable Long id);
}
