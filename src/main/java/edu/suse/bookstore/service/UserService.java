package edu.suse.bookstore.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.suse.bookstore.domain.*;
import edu.suse.bookstore.mapper.RoleMapper;
import edu.suse.bookstore.mapper.UserMapper;
import edu.suse.bookstore.mapper.UserRoleMapper;
import net.suncaper.project_api.common.PagableResponse;
import net.suncaper.project_api.common.PageRequest;
import net.suncaper.project_api.common.utils.IDGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private final UserRoleMapper userRoleMapper;

    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, UserMapper userMapper, RoleMapper roleMapper, UserRoleMapper userRoleMapper) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
        this.userRoleMapper = userRoleMapper;
    }


    public Object saveUser(User user) {
        if (StringUtils.isNotBlank(user.getPassword())) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        if (user.getUserId() == null || user.getUserId().equals("")) {
            user.setUserId(IDGenerator.getUUID());
        }
        if (findUserById(user.getUserId()) == null) {
            user.setCreateTime(new Date());
            user.setStatus(0);
            UserRoleKey key = new UserRoleKey();
            key.setUserId(user.getUserId());
            key.setRoleId(3);
            int i = userMapper.insert(user);
            userRoleMapper.insert(key);
            return i;
        } else {
            return userMapper.updateByPrimaryKeySelective(user);
        }

    }

    public User findUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public UserDetails loadUserByUsername(String username) {
        User user = userMapper.findUserWithRole(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        if (user.getStatus() == -1){
            return null;
        }
        user.setLastLoginTime(new Date());
        userMapper.updateByPrimaryKeySelective(user);
        return new SystemUser(user);
    }


    public PagableResponse userList(PageRequest request, String keyword) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<User> allUser = userMapper.selectByKeyword("%"+keyword+"%");
        List<User> userList = customer(allUser);
        return new PagableResponse(new PageInfo<>(userList).getTotal(), userList);
    }

    @Transactional
    public void deleteUserById(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (String id : ids){
                userMapper.deleteById(id);
            }
        }
    }

    public boolean findUserName(String id, String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        if (id != null && id.length() > 0){
            criteria.andUserIdEqualTo(id);
        }
        List<User> users = userMapper.selectByExample(example);
        if (users.size() > 0){
            for (User user : users) {
                if (id != null && id.length() > 00) {
                    if (user.getUserId().equals(id) && user.getUsername().equals(username)){
                        return true;
                    }
                }
            }
        }
        return users.size()== 0;
    }

    public PagableResponse clerkList(PageRequest request, String keyword) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<User> allUser = userMapper.selectByKeyword("%"+keyword+"%");
        List<User> clerkList = new ArrayList<>();
        for (User user : allUser) {
            List<Role> roles = user.getRoles();
            for (Role role : roles) {
                if (role.getRole().equals("CLERK")){
                    clerkList.add(user);
                }
            }
        }
        return new PagableResponse(new PageInfo<>(clerkList).getTotal(), clerkList);
    }

    public List<User> customerList() {
        List<User> users = userMapper.selectByKeyword("%%");
        return customer(users);
    }

    private List<User> customer(List<User> allUser){
        if (allUser == null || allUser.size() == 0){
            return null;
        }
        List<User> customers = new ArrayList<>(allUser);
        for (User user : allUser) {
            List<Role> roles = user.getRoles();
            if (roles != null && roles.size() > 0){
                for (Role role : roles) {
                    if (role.getRoleId() == 1 || role.getRoleId() == 2){
                        customers.remove(user);
                    }
                }
            }
        }
        return customers;
    }

    @Transactional
    public Object saveClerk(String userId) {
        UserRoleKey key = new UserRoleKey();
        key.setUserId(userId);
        key.setRoleId(2);
        return userRoleMapper.insert(key);
    }

    public Object expelClerkById(String id) {
        UserRoleKey key = new UserRoleKey();
        key.setRoleId(3);
        key.setUserId(id);
        UserRoleExample example = new UserRoleExample();
        example.createCriteria().andUserIdEqualTo(id);
        userRoleMapper.deleteByExample(example);
        return userRoleMapper.insert(key);
    }
}
