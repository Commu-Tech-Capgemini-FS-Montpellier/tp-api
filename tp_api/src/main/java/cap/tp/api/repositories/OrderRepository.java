package cap.tp.api.repositories;

import cap.tp.api.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByStatusOrder(String statusOrder);

    List<Order> findByIdClient(String idClient);
    List<Order> findByIdClientAndStatusOrder(String idClient,String statusOrder);


}
