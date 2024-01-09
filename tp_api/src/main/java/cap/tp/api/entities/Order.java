package cap.tp.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ORDERS")
@Data
public class Order {

    @Id
    @Column(name="id_order")
    private Integer idOrder;

    @Column(name="id_client")
    private String idClient;

    @Column(name="id_asset")
    private String idAsset;

    @Column(name="id_account")
    private String idAccount;

    @Column(name="quantity_order")
    private Integer quantityOrder;

    @Column(name="unit_price_order")
    private Double unitPriceOrder;

    @Column(name="status_order")
    private String statusOrder;

    @Column(name="date_order")
    private String dateOrder;
}
