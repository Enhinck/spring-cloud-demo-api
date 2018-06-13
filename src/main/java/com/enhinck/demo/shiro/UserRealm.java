package com.enhinck.demo.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * @author: Enhinck
 * @description: 自定义Realm
 * @date: 2018/04/03 16:00
 */
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {

	@Override
	public boolean supports(AuthenticationToken token) {
		return token instanceof ShiroExtToken;
	}

	/**
	 * 以下情况会调用此方法 1.调用subject.hasRole(“admin”) 或 subject.isPermitted(“admin”)
	 * 2.进入含注解方法@RequiresRoles("admin") 3.页面上使用 [@shiro.hasPermission name =
	 * "admin"][/@shiro.hasPermission]
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//Session session = SecurityUtils.getSubject().getSession();

	/*	// 查询用户的权限
		Long userId = (Long) session.getAttribute(GlobalConstants.SESSION_KEY_USER);
		UserVO userVoResult = userInfoCache.get(userId.toString());

		// 为当前用户设置角色和权限
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 获取当前角色code和权限code
		UserRO userRO = new UserRO();
		userRO.setId(userVoResult.getId());
		CallRemoteResult<List<RoleRO>> roleROS = roleService.selectUserRole(userRO);

		if (roleROS.isSuccessful()) {
			for (RoleRO roleRO : roleROS.getReturnObject()) {
				authorizationInfo.addRole(roleRO.getName());
			}
		}

		CallRemoteResult<List<PermissionRO>> permissions = permissionService.selectUserPermissions(userRO);
		if (permissions.isSuccessful()) {
			List<PermissionRO> permissionROS = permissions.getReturnObject();
			for (PermissionRO permissionRO : permissionROS) {
				authorizationInfo.addStringPermission(permissionRO.getPermissionCode());
			}
		}
		if (userRO.getProjectROs().size() > 1) {
			authorizationInfo.addStringPermission("group_situation");
		}*/
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		return authorizationInfo;
	}

	/**
	 * 验证当前登录的Subject UserController.login()方法中执行Subject.login()时 执行此方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		/*UserVO userVoResult = null;
		ShiroExtToken shiroExtToken = (ShiroExtToken) authcToken;
		// 已登录情况 根据token中的数据获取
		if (shiroExtToken.isCache()) {
			userVoResult = (UserVO) shiroExtToken;
		} else {
			// 未登录情况 请求数据校验
			UserRO userRO = shiroExtToken.copyPropertiesTo(new UserRO());
			CallRemoteResult<UserRO> remoteResult = null;
			remoteResult = userService.login(userRO);
			RemoteResultEnum resultEnum = remoteResult.getResultEnum();
			if (logger.isDebugEnabled()) {
				logger.debug("result:{}", resultEnum.getResultCode());
			}
			if (remoteResult.isSuccessful()) {
				UserRO staffRoResult = remoteResult.getReturnObject();
				userVoResult = staffRoResult.copyPropertiesTo(new UserVO());
			}
			if (resultEnum == RemoteResultEnum.ACCOUNT_NO_OR_PASSWORD_ERROR) {
				// 密码错误
				throw new IncorrectCredentialsException();
			}
			if (resultEnum == RemoteResultEnum.USER_NOT_EXISTS) {
				// 没找到帐号
				throw new UnknownAccountException();
			}
		}*/

		// 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
	/*	SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userVoResult.getUsername(),
				userVoResult.getPassword(),
				// ByteSource.Util.bytes("salt"), salt=username+salt,采用明文访问时，不需要此句
				getName());*/

		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
		// 将用户ID放入session中
		//SecurityUtils.getSubject().getSession().setAttribute(GlobalConstants.SESSION_KEY_USER, userVoResult.getId());

		return authenticationInfo;
	}
}
