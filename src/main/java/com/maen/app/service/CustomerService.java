package com.maen.app.service;

import com.maen.app.entity.CustomerEntity;
import com.maen.app.exceptions.RequestCreatedCustomerException;
import com.maen.app.exceptions.ResponseDeleteIdException;
import com.maen.app.exceptions.ResponseGetByIdException;
import com.maen.app.repository.ICustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private ICustomerRepository customerRepository;

    /**
     * Obtiene todos los registros guardados en la base de datos.
     * @return Retorna una lista de los registros obtenidos.
     */
    public List<CustomerEntity> getAllCUstomer(){
        return this.customerRepository.findAll();
    }

    /**
     * Obtiene un registro especifico dado si Id.
     * @param id Id del registro a buscar.
     * @return Retorna el registro encontrado.
     */
    public Optional<CustomerEntity> getByIdCustomer(Integer id) throws ResponseGetByIdException {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(id);
        if (!optionalCustomer.isPresent()){
            throw new ResponseGetByIdException("Id not found");
        }
        return this.customerRepository.findById(id);
    }

    /**
     * Guarda un nuevo registro en la base de datos.
     * @param customerEntity Informacion que sera guardada en la base de datos.
     * @return Regresa la informacion guardada.
     */
    public CustomerEntity createdCustomer(CustomerEntity customerEntity){
        return this.customerRepository.save(customerEntity);
    }

    public CustomerEntity updateCustomer(Integer id, CustomerEntity customerEntity) throws RequestCreatedCustomerException {
        Optional<CustomerEntity> createdCustomer = customerRepository.findById(id);
        if (!createdCustomer.isPresent()){
            throw new RequestCreatedCustomerException("The Id you are trying to update does not exist.");
        }
        CustomerEntity updateCustomer = customerRepository.findById(id).get();
        updateCustomer.setName(customerEntity.getName());
        updateCustomer.setSurname(customerEntity.getSurname());
        updateCustomer.setPhone(customerEntity.getPhone());
        updateCustomer.setEmail(customerEntity.getEmail());
        customerRepository.save(updateCustomer);
        return updateCustomer;
    }

    /**
     * Elimina un registro de la base de datos.
     *
     * @param id Id del registro que sera eliminado.
     * @return
     */
    public void deleteCustomer(Integer id) throws ResponseDeleteIdException {
        Optional<CustomerEntity> deleteCustomer = customerRepository.findById(id);
        if (!deleteCustomer.isPresent()){
            throw new ResponseDeleteIdException("The id does not exist");
        }
        this.customerRepository.deleteById(id);
    }
}