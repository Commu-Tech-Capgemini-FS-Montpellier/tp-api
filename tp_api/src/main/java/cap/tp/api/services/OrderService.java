package cap.tp.api.services;

import cap.tp.api.entities.Order;
import cap.tp.api.models.ClientOrders;
import cap.tp.api.repositories.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByStatusOrder(String statusOrder) {
        return orderRepository.findByStatusOrder(statusOrder);
    }

    public List<Order> getOrdersByIdClient(String idClient) {
        return orderRepository.findByIdClient(idClient);
    }

    public List<Order> getOrdersByIdClientAndStatusOrder(String idClient,String statusOrder) {
        return orderRepository.findByIdClientAndStatusOrder(idClient,statusOrder);
    }

    public ClientOrders getQuantityOrdersForAClient(String idClient) {
        var orders  = orderRepository.findByIdClientAndStatusOrder(idClient,"EXECUTED");
        Map<String,Integer> ordersMap = new HashMap<>();
        for(var order : orders){
            var idAsset = order.getIdAsset();
            var quantityOrder = order.getQuantityOrder();
            if(!ordersMap.containsKey(idAsset)){
                ordersMap.put(idAsset,quantityOrder);
            }
            else{
                var quantityOrderInMap = ordersMap.get(idAsset);
                var newQuantityOrderInMap = quantityOrderInMap + quantityOrder;
                ordersMap.put(idAsset,newQuantityOrderInMap);

            }
        }
        return new ClientOrders(idClient,ordersMap);

    }

    public void insertOrder(List<Order> orders){
        //passer a null idoreder et status
        orderRepository.saveAll(orders);


    }


}
