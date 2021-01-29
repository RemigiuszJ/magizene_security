package com.remigiusset.magazine.services;

import com.remigiusset.magazine.api.model.DesktopDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DesktopService {

    List<DesktopDTO> getAllDesktops();
    DesktopDTO getDesktopById( Long id);
    List<DesktopDTO> getDesktopByStatus(String status);
    List<DesktopDTO> getDesktopByCondition(String condition);
    List<DesktopDTO> getDesktopByPreorder(String preorder);
    DesktopDTO createNewDesktop(DesktopDTO desktopDTO);
    DesktopDTO updateDesktop(Long id , DesktopDTO desktopDTO);
    void deleteDesktopById(Long id);



}
