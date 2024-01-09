package cap.tp.api.services;

import cap.tp.api.entities.Asset;
import cap.tp.api.entities.Order;
import cap.tp.api.repositories.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    private final AssetRepository assetRepository;

    @Autowired
    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public List<Asset> getAssetById(String idAsset) {
        return assetRepository.findByIdAsset(idAsset);
    }
}
