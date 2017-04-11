/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibibi.repositories;

import bibibi.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ola
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
    
}
