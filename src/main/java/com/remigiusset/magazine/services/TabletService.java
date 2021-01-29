package com.remigiusset.magazine.services;

import com.remigiusset.magazine.api.model.TabletDTO;

import java.util.List;

public interface TabletService {

    List<TabletDTO> getAllTablets();
    TabletDTO getTabletById(Long id);

    List<TabletDTO>getTabletByStatus(String status);
    List<TabletDTO>getTabletByColour(String colour);
    List<TabletDTO>getTabletBySize(String size);

    TabletDTO createNewTablet(TabletDTO tabletDTO);
    TabletDTO updateTablet(Long id , TabletDTO tabletDTO);
    void deleteTabletById(Long id);
}
