package org.mimba.bao.dao;

import org.mimba.bao.entities.Rolle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IRoleRepository extends JpaRepository<Rolle, Long> {

	public Page<org.mimba.bao.entities.Rolle> findByid(@Param("id") Long id, Pageable pageable);

	public Page<org.mimba.bao.entities.Rolle> findByNom(@Param("nom") String nom, Pageable pageable);

	public Page<org.mimba.bao.entities.Rolle> findByDroit(@Param("droit") String droit, Pageable pageable);

	@Query("select r from Rolle r where r.description like:mc")
	public Page<org.mimba.bao.entities.Rolle> descriptionRoleParMC(@Param("mc") String mc, Pageable pageable);
}
