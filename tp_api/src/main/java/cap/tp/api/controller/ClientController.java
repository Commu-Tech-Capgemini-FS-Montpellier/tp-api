package cap.tp.api.controller;

import cap.tp.api.entities.Asset;
import cap.tp.api.entities.Client;
import cap.tp.api.entities.Order;
import cap.tp.api.models.ClientOrders;
import cap.tp.api.services.AssetService;
import cap.tp.api.services.ClientService;
import cap.tp.api.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;
    private final OrderService orderService;
    private final AssetService assetService;

    @Autowired
    public ClientController(ClientService clientService, OrderService orderService,AssetService assetService) {
        this.clientService = clientService;
        this.orderService = orderService;
        this.assetService = assetService;
    }

    @GetMapping("/clients")
    public List<Client> getAllClients(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "rows" , required = false) Integer rows) {
        if(!ObjectUtils.isEmpty(page) && !ObjectUtils.isEmpty(rows) ){
            return clientService.getAllClientsWithPagination(page,rows);
        }
        return clientService.getAllClients();
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders(@RequestParam(value ="status_order", required = false) String statusOrder,@RequestParam(value ="id_client", required = false) String idClient) {

        if(!ObjectUtils.isEmpty(statusOrder) && !ObjectUtils.isEmpty(idClient) ){
            return orderService.getOrdersByIdClientAndStatusOrder(idClient,statusOrder);
        }

        if(!ObjectUtils.isEmpty(idClient)){
            return orderService.getOrdersByIdClient(idClient);
        }

        if(!ObjectUtils.isEmpty(statusOrder)){
            return orderService.getOrdersByStatusOrder(statusOrder);
        }

        return orderService.getAllOrders();
    }


    @GetMapping("/orders-quantity")
    public ClientOrders getQuantityOrdersForAClient(@RequestParam(value ="id_client") String getByIdClient) {
        return orderService.getQuantityOrdersForAClient(getByIdClient);
    }

    @PostMapping("/orders")
    public void insertOrders(@RequestBody List<Order> orders) {
        orderService.insertOrder(orders);
    }

    @GetMapping("/assets")
    public List<Asset> getAsset(@RequestParam(value ="id_asset", required = false) String idAsset) {
        if(!ObjectUtils.isEmpty(idAsset)){
            return assetService.getAssetById(idAsset);
        }
            return assetService.getAllAssets();
    }
}
