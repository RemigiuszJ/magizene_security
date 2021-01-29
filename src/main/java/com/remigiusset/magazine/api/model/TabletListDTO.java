package com.remigiusset.magazine.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class TabletListDTO {
    private List<TabletDTO> tabletList;
}
