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
    private BigDecimal value;

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 16, min = 16)
    private String number;

    @NotNull
    @Size(max = 4, min = 4)
    private String expiration;

    @NotNull
    @Size(max = 3, min = 3)
    private String code;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

    @NotNull
    private Long orderId;

    @NotNull
    private Long paymentMethodId;

}
