package tpasma.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpasma.model.Chambre;
import tpasma.repository.ChambreRepository;

@Service
public class ChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    // Ajouter une chambre
    public Chambre ajouterChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    // Lire toutes les chambres
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    // Lire une chambre par son id
    public Optional<Chambre> getChambreById(Long id) {
        return chambreRepository.findById(id);
    }

    // Mettre à jour une chambre
    public Chambre updateChambre(Long id, Chambre chambreDetails) {
        Chambre chambre = chambreRepository.findById(id).orElseThrow(() -> new RuntimeException("Chambre non trouvée"));
        chambre.setEtat(chambreDetails.getEtat());
        chambre.setCapacite(chambreDetails.getCapacite());
        return chambreRepository.save(chambre);
    }

    // Supprimer une chambre
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }
    
    public Chambre getChambreById2(Long id) {
        return chambreRepository.findById(id).orElseThrow(() -> new RuntimeException("Chambre non trouvée"));
    }
    
    public Chambre updateEtatChambre(Long id, String etat) {
        Chambre chambre = getChambreById2(id);
        chambre.setEtat(etat);
        return chambreRepository.save(chambre);
    }
}
