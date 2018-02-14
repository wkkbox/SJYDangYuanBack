package com.telecom.jx.sjy.dangyuanback.realms;


import com.telecom.jx.sjy.dangyuanback.pojo.po.User;
import com.telecom.jx.sjy.dangyuanback.service.UserService;
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

public class SecurityRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        String accountName = (String) principal.getPrimaryPrincipal();
        System.out.println("doGetAuthorizationInfo accountName = " + accountName);
        User user = null;
        try {
            user = userService.getUserByAccountName(accountName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        try {
            System.out.println(user);
            //Set<String> roles = userService.getUserRolesByUserId(user.getId());
            //Set<String> perms = userService.getUserPermissionsByUserId(user.getId());
            //System.out.println("角色有：" + roles);
            //System.out.println("权限有：" + perms);
            //authorizationInfo.setRoles(roles);
            //authorizationInfo.setStringPermissions(perms);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return authorizationInfo;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accountName = (String) token.getPrincipal();
        System.out.println("accountName="+accountName);
        User user = null;
        try {
            user = userService.getUserByAccountName(accountName);
            System.out.println("user="+user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        if (user != null) {
            ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());//这里的参数要给个唯一的;
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getAccountName(), user.getPassword(), credentialsSalt, getName());
            return authcInfo;
        } else {
            return null;
        }
    }
}
