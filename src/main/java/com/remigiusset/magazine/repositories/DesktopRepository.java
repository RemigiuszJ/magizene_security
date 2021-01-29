package com.remigiusset.magazine.repositories;

import com.remigiusset.magazine.domain.Desktop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DesktopRepository extends JpaRepository <Desktop, Long> {

    List<Desktop> getByPreorder(String preorder);
    List<Desktop> getByStatus(String status);
    List<Desktop> getByCondition(String condition);


}
