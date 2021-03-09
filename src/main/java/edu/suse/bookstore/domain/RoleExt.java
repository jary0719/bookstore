package edu.suse.bookstore.domain;

import java.util.List;

public class RoleExt {
    protected List<Permission> permissions;

    public RoleExt() {
    }

    public List<Permission> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
