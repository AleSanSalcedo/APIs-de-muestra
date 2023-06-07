package ar.com.umpaz.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.umpaz.model.Cliente;

@Repository
public interface ClienteRepository  extends CrudRepository<Cliente, Long>{

}
