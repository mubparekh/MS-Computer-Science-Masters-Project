package net.sf.lavalamp.site;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Request;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;

public class UrlGetterTest {
	static int port;
	static Server server;

	@Mock
	GetMethod method;
	@Mock
	HttpClient client;

	@Mock
	HttpState state;

	@Mock
	AuthScope scope;
	@Mock
	UsernamePasswordCredentials credentials;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}

	@BeforeClass
	public static void setUpClass() throws Exception {

		Handler handler = new AbstractHandler() {
			public void handle(String target, HttpServletRequest request,
					HttpServletResponse response, int dispatch)
					throws IOException, ServletException {
				response.setContentType("text/html");
				if (target.equals("/x")) {
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

				} else if (target.equals("/y")) {
					response
							.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

				} else {

					response.setStatus(HttpServletResponse.SC_OK);
					response.getWriter().println("<h1>Hello</h1>");
				}
				((Request) request).setHandled(true);

			}

		};

		server = new Server(8083);
		server.setHandler(handler);
		server.start();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		server.stop();
	}

	@Test
	public void shouldGetMaskedUrl() {
		assertThat(new UrlGetter().getMaskedUrl("http://google.se?password=",
				"mypassword".toCharArray()),
				is("http://google.se?password=*****"));
	}
	
	@Test(expected = LoginRequiredException.class)
	public void shouldBeExceptionWhenUnauthorized() throws IOException,
			LoginRequiredException {
		new UrlGetter().handleStatusCode(method, HttpStatus.SC_UNAUTHORIZED);
	}

	@Test(expected = LoginRequiredException.class)
	public void shouldBeExceptionWhenForbidden() throws IOException,
			LoginRequiredException {
		new UrlGetter().handleStatusCode(method, HttpStatus.SC_FORBIDDEN);
	}

	@Test
	public void shouldSetAuthType() throws IOException, LoginRequiredException {
		when(client.getState()).thenReturn(state);
		UrlGetter getter = new UrlGetter();
		getter.setCredentials(credentials);
		getter.setAuthType(method, client, scope);
		verify(method).setDoAuthentication(true);
		verify(state).setCredentials(any(AuthScope.class), any(UsernamePasswordCredentials.class));
	}

}
