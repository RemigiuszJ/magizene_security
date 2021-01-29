package com.remigiusset.magazine.api.mapper;

import com.remigiusset.magazine.api.model.DesktopDTO;
import com.remigiusset.magazine.domain.Desktop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesktopMapperTest {
DesktopMapper desktopMapper = DesktopMapper.INSTANCE;

    @Test
    void desktopToDesktopDTO() {
    //given
        Desktop desktop = new Desktop();
        desktop.setId(1l);
        desktop.setName("Desk");
        desktop.setStatus("available");
        desktop.setPreorder("no");
        desktop.setCondition("off-leasing");
        //when
        DesktopDTO desktopDTO = desktopMapper.desktopToDesktopDTO(desktop);


    //then
    assertEquals(Long.valueOf(1L),desktopDTO.getId());
    assertEquals("Desk",desktopDTO.getName());
    assertEquals("available", desktopDTO.getStatus());
    assertEquals("no",desktopDTO.getPreorder());
    assertEquals("off-leasing", desktopDTO.getCondition());

    }
}