package com.fernandolopes.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fernandolopes.domain.Cliente;
import com.fernandolopes.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	@Transactional(readOnly=true) //nao necessita se uma transação de banco de dados, deixando mais rapido resuzindo o lock
	Page<Pedido> findByCliente(Cliente cliente, Pageable pageRequest);

}
