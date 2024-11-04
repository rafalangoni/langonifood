package com.langonifood.payments.controller;

import com.langonifood.payments.dto.PaymentDto;
import com.langonifood.payments.service.PaymentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping
    public Page<PaymentDto> list(@PageableDefault(size = 10) Pageable pagination) {
        return service.getAllPayments(pagination);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> detail(@PathVariable @NotNull Long id) {
        PaymentDto dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PaymentDto> create(@RequestBody @Valid PaymentDto dto, UriComponentsBuilder uriBuilder) {
        PaymentDto payment = service.createPayment(dto);
        URI address = uriBuilder.path("/payments/{id}").buildAndExpand(payment.getId()).toUri();

        return ResponseEntity.created(address).body(payment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDto> update(@NotNull @PathVariable Long id, @RequestBody @Valid PaymentDto dto) {
        PaymentDto updated = service.updatePayment(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentDto> remove(@PathVariable @NotNull Long id) {
        service.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}
