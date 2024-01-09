package cap.tp.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ASSET")
@Data
public class Asset {

    @Id
    @Column(name="id_asset")
    private String idAsset;

    @Column(name="name_asset")
    private String nameAsset;

    @Column(name="type_asset")
    private String typeAsset;

    @Column(name="price")
    private String price;

}
