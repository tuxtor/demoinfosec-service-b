package io.academik.demoinfosec;

import io.academik.demoinfosec.util.RolesEnum;
import org.eclipse.microprofile.auth.LoginConfig;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/data")
@ApplicationScoped

@LoginConfig(authMethod = "MP-JWT")
@DeclareRoles({RolesEnum.Constants.MOBILE_VALUE, RolesEnum.Constants.WEB_VALUE})
public class DemoinfosecRestApplication extends Application {
}
