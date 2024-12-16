package tpasma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tpasma.model.Chambre;


public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
