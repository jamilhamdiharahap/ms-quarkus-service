package org.icp.dto.response;

import java.io.Serializable;
import java.util.List;

public class MaterialSoaDto {
    private String parentId;
    private String id;
    private String value;


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
