package cm.jonabacho.annulationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cm.jonabacho.annulationservice.service.VoyageService;
import cm.jonabacho.annulationservice.model.Voyage;
import cm.jonabacho.annulationservice.controller.ResourceNotFoundException;

import java.util.Optional;

@RestController
@RequestMapping("/api/voyages")
public class VoyageController {

    @Autowired
    private VoyageService voyageService;

    @GetMapping
    public Iterable<Voyage> getAllVoyages() {
        return voyageService.getAllVoyages();
    }

    @GetMapping("/{id}")
    public Optional<Voyage> getVoyageById(@PathVariable Long id) {
        return voyageService.getVoyageById(id);
    }

    @PostMapping
    public Voyage createVoyage(@RequestBody Voyage voyage) {
        return voyageService.saveVoyage(voyage);
    }

    @PutMapping("/{id}")
    public Voyage updateVoyage(@PathVariable Long id, @RequestBody Voyage voyageDetails) {
        Voyage voyage = voyageService.getVoyageById(id).orElseThrow(() -> new ResourceNotFoundException("Voyage not found for this id :: " + id));
        voyage.setDestination(voyageDetails.getDestination());
        voyage.setDateVoyage(voyageDetails.getDateVoyage());
        voyage.setAnnule(voyageDetails.isAnnule());
        return voyageService.updateVoyage(voyage);
    }

    @DeleteMapping("/{id}")
    public void deleteVoyage(@PathVariable Long id) {
        voyageService.deleteVoyage(id);
    }
}
