package org.fmbbva.movcor.security.oauth;

import org.fmbbva.movcor.security.oauth.AuthorizationServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AuthorizationServerApplication.class)
@WebAppConfiguration
public class AuthorizationApplicationTests {

	@Test
	public void contextLoads() {
	}

}
