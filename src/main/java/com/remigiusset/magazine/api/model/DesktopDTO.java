package com.remigiusset.magazine.api.model;

import lombok.Data;

@Data
public class DesktopDTO {
    Long id;
    String name;
    String status;
    String preorder;
    String condition;
}
