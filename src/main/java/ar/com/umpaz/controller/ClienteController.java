package ar.com.umpaz.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.umpaz.model.Cliente;
import ar.com.umpaz.service.ClienteService;
@RequestMapping("/cliente")
@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public Cliente save(@RequestBody Cliente cliente) {
	     return clienteService.save(cliente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id ) {
		Map<String, Object> response = new HashMap<String, Object>();
		Cliente sCliente = new Cliente();
		try {
		
			sCliente.id = id;
			sCliente =clienteService.getById(sCliente);
		    response.put("cliente",sCliente);
		    
		} catch (Exception e) {
			response.put("cliente",sCliente);
			response.put("Error", "Paso un error, que no se que es ");
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
			
		}
	
		@GetMapping
		public ResponseEntity<?>getAll(){
			 Map<String, Object> response = new HashMap<String, Object>();
			 List<Cliente> clientes = new ArrayList<Cliente>();
			 
			 clientes = clienteService.getAll();
			 response.put("clientes",clientes);
			 return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
		
		@GetMapping("/all")
		public List<Cliente> getList(){
			 return clienteService.getAll();
		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?>deleteById(@PathVariable Long id){
			Map<String, Object> response = new HashMap<String, Object>();
		    try {
		    	Cliente cliente = new Cliente();
		    	cliente.id = id;
		    	clienteService.delete(cliente);
		    	response.put("message", "Se borro correctamente");
			} catch (Exception e) {
				// TODO: handle exception
			}
		    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}
	
	
}
