package com.remigiusset.magazine.repositories;


import com.remigiusset.magazine.domain.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotebookRepository extends JpaRepository<Notebook, Long> {

    List<Notebook> getByStatus(String status);
    List<Notebook> getByPreorder(String preorder);
    List<Notebook> getByRanking(String ranking);


}
