package org.mimba.bao.dao;

import org.mimba.bao.entities.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	public Page<Utilisateur> findById(@Param("id") Long id, Pageable pageable);

	public Page<Utilisateur> findByMotDePasse(@Param("motDePasse") String motDePasse, Pageable pageable);

	public Page<Utilisateur> findByActiver(@Param("activer") boolean activer, Pageable pageable);

	public Page<Utilisateur> findByPresence(@Param("presence") boolean presence, Pageable pageable);

	@Query("select u from Utilisateur u where u.personne.id=:idPersonne")
	public Page<Utilisateur> personneUtilisateurParId(@Param("idPersonne") Long idPersonne, Pageable pageable);
	
	@Query("select u from Utilisateur u where u.rolle.id=:idRolle")
	public Page<Utilisateur> RolleUtilisateurParId(@Param("idRolle") Long idRolle, Pageable pageable);
}
