package it.corso.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import it.corso.model.Album;

public interface AlbumDao extends CrudRepository<Album, Integer>
{
	List<Album> findByTipologia(String tipologia);
//	
//	@Query(value = "SELECT * FROM album WHERE anno >= :annoFrom and anno <= :annoTo", nativeQuery = true)
//	List<Album> findAnnoFromTo(@Param("annoFrom") int annoFrom, @Param("annoTo") int annoTo);
//	
//	@Query(value = "SELECT * FROM album WHERE quantita > 0", nativeQuery = true)
//	List<Album> findDisponibili();
	
	@Query(value=
			"SELECT * FROM album a WHERE "
			+ "(:tipologia is null or a.tipologia = :tipologia) and "
			+ "(:annoFrom = 0 or a.anno >= :annoFrom) and "
			+ "(:annoTo = 0 or a.anno <= :annoTo) and "
			+ "(:disponibile is null or a.quantita > 0)"
	, nativeQuery = true)
	List<Album> findByTipologiaAndAnnoFromToAndDisponibile(
			@Param("tipologia") String tipologia,
			@Param("annoFrom") int annoFrom,
			@Param("annoTo") int annoTo,
			@Param("disponibile") String disponibile
	);
}
