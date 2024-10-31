package com.langonifood.payments.dto;

import com.langonifood.payments.model.Status;

import java.math.BigDecimal;

public record PaymentDto(
        Long id,
        BigDecimal value,
        String name,
        String number,
        String expiration,
        String code,
        Status status,
        Long orderId,
        Long paymentMethodId
) {
}
