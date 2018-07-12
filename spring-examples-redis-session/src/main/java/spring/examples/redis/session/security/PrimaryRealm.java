package spring.examples.redis.session.security;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.DigestUtils;
import spring.examples.redis.session.domain.User;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashSet;
import java.util.UUID;

public class PrimaryRealm extends AuthorizingRealm implements InitializingBean {

    public PrimaryRealm() {
        super();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setCredentialsMatcher(new HashedCredentialsMatcher("MD5"));
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(Collections.singleton("ROLE_ADMIN"));
        info.setStringPermissions(new HashSet<>());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        if (token instanceof UsernamePasswordToken) {
            final String username = ((UsernamePasswordToken) token).getUsername();
            final String password = new String(((UsernamePasswordToken) token).getPassword());

            final User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setUsername(username);

            final String hashedPwd = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
            return new SimpleAuthenticationInfo(Principal.of(user, "ROLE_ADMIN"), hashedPwd, getName());
        }

        throw new UnsupportedTokenException();
    }

}
