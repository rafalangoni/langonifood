package com.langonifood.payments.service;

import com.langonifood.payments.dto.PaymentDto;
import com.langonifood.payments.http.ClientOrder;
import com.langonifood.payments.model.Payment;
import com.langonifood.payments.model.Status;
import com.langonifood.payments.repository.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ClientOrder order;

    public Page<PaymentDto> getAllPayments(Pageable pagination) {
        return repository
                .findAll(pagination)
                .map(p -> mapper.map(p, PaymentDto.class));
    }

    public PaymentDto getById(Long id) {
        Optional<Payment> payment = repository.findById(id);
        return mapper.map(payment, PaymentDto.class);
    }
//TRYING TO RETURN OPTIONAL INSTEAD OF THROWING EXCPETION
//    public PaymentDto getById(Long id) {
//        Payment payment = repository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException());
//
//        return mapper.map(payment, PaymentDto.class);
//    }

    public PaymentDto createPayment(PaymentDto dto){
        Payment payment = mapper.map(dto, Payment.class);
        payment.setStatus(Status.CREATED);
        repository.save(payment);

        return mapper.map(payment, PaymentDto.class);
    }

    public PaymentDto updatePayment(Long id, PaymentDto dto){
        Payment payment = mapper.map(dto, Payment.class);
        payment.setId(id);
        payment = repository.save(payment);
        return mapper.map(payment, PaymentDto.class);
    }

    public void deletePayment(Long id){
        repository.deleteById(id);
    }

    public void confirmPayment(Long id){
        Optional<Payment> payment =repository.findById(id);

        if(!payment.isPresent()){
            throw new EntityNotFoundException();
        }

        payment.get().setStatus(Status.CONFIRMED);
        repository.save(payment.get());
        order.updatePayment(payment.get().getOrderId());
    }

    public void changeStatus(Long id) {
        Optional<Payment> payment =repository.findById(id);

        if(!payment.isPresent()){
            throw new EntityNotFoundException();
        }

        payment.get().setStatus(Status.CONFIRMED_WITHOUT_INTEGRATION_WITH_ORDER);
        repository.save(payment.get());
    }
}
