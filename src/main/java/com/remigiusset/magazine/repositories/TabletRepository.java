package com.remigiusset.magazine.repositories;

import com.remigiusset.magazine.domain.Notebook;
import com.remigiusset.magazine.domain.Tablet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TabletRepository extends JpaRepository<Tablet, Long>{
        List<Tablet> getByStatus(String status);
        List<Tablet> getBySize(String size);
        List<Tablet> getByColour(String colour);
}
