package cap.tp.api.models;

import lombok.Data;

import java.util.Map;
@Data
public class ClientOrders {

    public final String idClient;
    public final Map<String, Integer> quantityOrders;


}
