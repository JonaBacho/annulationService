package cm.jonabacho.annulationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cm.jonabacho.annulationservice.repository.VoyageRepository;
import cm.jonabacho.annulationservice.model.Voyage;

import java.util.Optional;

@Service
public class VoyageService {

    @Autowired
    private VoyageRepository voyageRepository;

    public Iterable<Voyage> getAllVoyages() {
        return voyageRepository.findAll();
    }

    public Optional<Voyage> getVoyageById(Long id) {
        return voyageRepository.findById(id);
    }

    public Voyage saveVoyage(Voyage voyage) {
        return voyageRepository.save(voyage);
    }

    public void deleteVoyage(Long id) {
        voyageRepository.deleteById(id);
    }

    public Voyage updateVoyage(Voyage voyage) {
        return voyageRepository.save(voyage);
    }
}
