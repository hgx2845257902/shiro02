package com.shiro;

import com.mapper.UserMapper;
import com.model.User;
import com.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        Set<String> rname = userService.selectRname(username);
        Set<String> pname = userService.selectPname(username);
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.setRoles(rname);
        info.setRoles(pname);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        User user = userService.selectUname(username);
        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(
                user.getUsername(),user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName()
        );
        return info;
    }
}
