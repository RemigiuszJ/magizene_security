package com.remigiusset.magazine.repositories;

import com.remigiusset.magazine.domain.Notebook;
import com.remigiusset.magazine.domain.RuggedNotebook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RuggedNotebookRepository  extends JpaRepository<RuggedNotebook, Long> {

    List<RuggedNotebook> getByStatus(String status);
    List<RuggedNotebook> getByMade(String made);
    List<RuggedNotebook> getByWaterproof(String waterproof);
}
