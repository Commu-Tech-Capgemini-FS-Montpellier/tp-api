package cap.tp.api.repositories;

import cap.tp.api.entities.Asset;
import cap.tp.api.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepository extends JpaRepository<Asset, Integer> {

    List<Asset> findByIdAsset(String idAsset);
}
