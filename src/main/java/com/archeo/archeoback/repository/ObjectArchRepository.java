package com.archeo.archeoback.repository;

import com.archeo.archeoback.model.ObjectArch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectArchRepository extends JpaRepository<ObjectArch, Long> {

    // Ajouter un objet archéologique
    ObjectArch save(ObjectArch objetArcheologique);

    // Supprimer un objet archéologique par ID
    void deleteById(Long id);

    // Modifier un objet archéologique
    ObjectArch saveAndFlush(ObjectArch objetArcheologique);
}
