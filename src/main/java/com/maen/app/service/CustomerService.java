package com.maen.app.service;

import com.maen.app.entity.CustomerEntity;
import com.maen.app.repository.ICustomeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private ICustomeRepository customeRepository;

    /**
     * Obtiene todos los registros guardados en la base de datos.
     * @return Retorna una lista de los registros obtenidos.
     */
    public List<CustomerEntity> getAllCUstomer(){
        return this.customeRepository.findAll();
    }

    /**
     * Obtiene un registro especifico dado si Id.
     * @param id Id del registro a buscar.
     * @return Retorna el registro encontrado.
     */
    public Optional<CustomerEntity> getByIdCustomer(Integer id){
        return this.customeRepository.findById(id);
    }

    /**
     * Guarda un nuevo registro en la base de datos.
     * @param customerEntity Informacion que sera guardada en la base de datos.
     * @return Regresa la informacion guardada.
     */
    public CustomerEntity createdCustomer(CustomerEntity customerEntity){
        return this.customeRepository.save(customerEntity);
    }

    /**
     * Elimina un registro de la base de datos.
     * @param id Id del registro que sera eliminado.
     */
    public void deleteCustomer(Integer id){
        this.customeRepository.deleteById(id);
    }
}
