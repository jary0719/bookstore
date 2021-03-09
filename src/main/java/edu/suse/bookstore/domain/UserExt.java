package edu.suse.bookstore.domain;

import java.util.List;

public class UserExt {
    protected List<Role> roles;

    public UserExt() {
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

