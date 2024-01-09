package cap.tp.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CLIENT")
@Data
public class Client {

    @Id
    @Column(name="id_client")
    private int idClient;

    @Column(name="firstname_client")
    private String firstnameClient;

    @Column(name="lastname_client")
    private String lastnameClient;

    @Column(name="zip_code_client")
    private String zipCodeClient;

}

