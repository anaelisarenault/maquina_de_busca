package com.maquinadebusca.app.model.repository;

import com.maquinadebusca.app.model.Link;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Lucas Silva
 */
public interface LinkRepository extends JpaRepository<Link, Long> {

    @Override
    List<Link> findAll();

    Link findById(long id);

    Link findByUrl(String url);

    @Override
    Link save(Link link);

    List<Link> findByUrlIgnoreCaseContaining(String url);

    @Query(value = "SELECT * FROM link ORDER BY url", nativeQuery = true)
    List<Link> getInLexicalOrder();

    @Query(value = "SELECT * FROM link", nativeQuery = true)
    public Slice<Link> getPage(Pageable pageable);

    @Query(value = "SELECT * FROM link WHERE id between ?1 and ?2", nativeQuery = true)
    List<Link> findLinkByIdRange(Long id1, Long id2);

    @Query(value = "SELECT COUNT(*) FROM Link WHERE id between :identificador1 and :identificador2", nativeQuery = true)
    Long countLinkByIdRange(@Param("identificador1") Long id1, @Param("identificador2") Long id2);
}
