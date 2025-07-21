package com.arantes.hexagonal.application.core.usecase;

import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.arantes.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arantes.hexagonal.application.ports.out.InsertCostumerOutputPort;
import com.arantes.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustumerUseCase implements InsertCustomerInputPort {
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCostumerOutputPort insertCostumerOutputPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustumerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCostumerOutputPort insertCostumerOutputPort, SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCostumerOutputPort = insertCostumerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer costumer, String zipCode) {
        //preciso acessar outro microserviço para buscar o endereço
        //atraves do portout
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        costumer.setAddress(address);
        insertCostumerOutputPort.insert(costumer);
        sendCpfForValidationOutputPort.send(costumer.getCpf());
    }
}
