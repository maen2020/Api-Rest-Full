package com.maen.app.controller;

import com.maen.app.entity.CustomerEntity;
import com.maen.app.exceptions.RequestCreatedCustomerException;
import com.maen.app.exceptions.ResponseDeleteIdException;
import com.maen.app.exceptions.ResponseGetByIdException;
import com.maen.app.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    /**
     * Obtiene los registro de la base de datos.
     * @return Retorna los registros obtenidos.
     */
    @GetMapping
    public List<CustomerEntity> getAllCustomer(){
        return  this.customerService.getAllCUstomer();
    }

    /**
     * Obtiene un solo registro dado su id.
     * @param id Id del registro a buscar.
     * @return Regresa el registro buscado.
     */
    @GetMapping(path = "/{id}")
    public Optional<CustomerEntity> getByIdCustomer(@PathVariable Integer id) throws ResponseGetByIdException {
        return this.customerService.getByIdCustomer(id);
    }

    /**
     * Guarda un nuevo registro en la base de datos.
     * @param customerEntity Informacion que sera guardada en la base de datos.
     * @return Informacion guardada en la base de datos.
     */
    @PostMapping
    public CustomerEntity createdCustomer(@RequestBody CustomerEntity customerEntity) {
        return this.customerService.createdCustomer(customerEntity);
    }

    /**
     * Actualizar un registro dado su id.
     * @param id Id a actualizar.
     * @param customerEntity Informacion del id a actualizar.
     * @return Regresa la informacion actualizada.
     * @throws RequestCreatedCustomerException Error al tratar de actualizar un id no existente.
     */
    @PatchMapping(path = "/{id}")
    public CustomerEntity updateCustomer(@PathVariable Integer id, @RequestBody CustomerEntity customerEntity) throws RequestCreatedCustomerException{
        return this.customerService.updateCustomer(id, customerEntity);
    }

    /**
     * Elimina un registro de la base de datos dado su id.
     * @param id Id del registro que a que sera eliminado.
     */
    @DeleteMapping(path = "/{id}")
    public void deleteCustomer(@PathVariable Integer id) throws ResponseDeleteIdException {
        this.customerService.deleteCustomer(id);
    }
}
