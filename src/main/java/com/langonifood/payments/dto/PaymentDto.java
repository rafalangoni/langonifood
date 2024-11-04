package com.langonifood.payments.dto;

import com.langonifood.payments.model.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentDto{
        private Long id;
        private BigDecimal paymentValue;
        private String name;
        private String ccNumber;
        private String ccExpiration;
        private String ccCode;
        private Status status;
        private Long orderId;
        private Long paymentMethodId;
}
