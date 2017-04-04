/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibibi.repositories;

import bibibi.models.Citation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ola
 */
public interface CitationRepository extends JpaRepository<Citation, Long> {
}
