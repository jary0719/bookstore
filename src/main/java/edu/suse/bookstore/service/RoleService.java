package edu.suse.bookstore.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.suse.bookstore.domain.Role;
import edu.suse.bookstore.mapper.RoleMapper;
import net.suncaper.project_api.common.PagableResponse;
import net.suncaper.project_api.common.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleMapper roleMapper;

    public RoleService(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public PagableResponse roleList(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Role> roleList = roleMapper.selectByExample(null);
        return new PagableResponse(new PageInfo<>(roleList).getTotal(), roleList);
    }

    public void deleteRoleById(Integer[] ids) {
        if (ids.length > 0){
            for (Integer id : ids) {
                roleMapper.deleteByPrimaryKey(id);
            }
        }
    }

    public Object saveRole(Role role) {
        if (role != null){
            if (role.getRoleId() != null){
                return roleMapper.updateByPrimaryKeySelective(role);
            }else {
                return roleMapper.insert(role);
            }
        }
        return -1;
    }
}
