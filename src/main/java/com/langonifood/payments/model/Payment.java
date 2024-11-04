package com.langonifood.payments.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    @Column(name = "payment_value")
    private BigDecimal paymentValue;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 16, min = 16)
    @Column(name = "cc_number")
    private String ccNumber;

    @NotNull
    @Size(max = 6, min = 4)
    @Column(name = "cc_expiration")
    private String ccExpiration;

    @NotNull
    @Size(max = 3, min = 3)
    @Column(name = "cc_code")
    private String ccCode;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

    @NotNull
    @Column(name = "order_id")
    private Long orderId;

    @NotNull
    @Column(name = "payment_method_id")
    private Long paymentMethodId;

}
