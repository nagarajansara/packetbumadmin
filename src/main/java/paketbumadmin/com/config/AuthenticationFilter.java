package paketbumadmin.com.config;

import java.io.IOException;
import java.util.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import paketbumadmin.com.controller.BaseController;
import paketbumadmin.com.util.Utilities;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter extends BaseController implements Filter

{

	public String SERVER_NAME = "www.paketbum.si";

	private String SESSION_FAILURE_URL = "http://" + SERVER_NAME
			+ "/travel/view/jsp/v1/home.jsp";
	private String SESSION_FAILURE_PATH = "/view/jsp/v1/login.jsp";

	private List<String> AUTHENTICATED_URL = new ArrayList<String>();
	private List<String> AUTHENTICATED_URL_INDEXOF = new ArrayList<String>();
	private List<String> ROLE_CUSTOMER_URL = new ArrayList<String>();
	private List<String> ROLE_VENDOR_URL = new ArrayList<String>();
	private final String ROLE_CUSTOMER = "ROLE_CUSTOMER";
	private final String ROLE_VENDOR = "ROLE_VENDOR";

	private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException
	{
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");

		/************ View pages *****************************/
		AUTHENTICATED_URL.add("login.jsp");
		AUTHENTICATED_URL.add("validate");
		AUTHENTICATED_URL.add("validate");

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();

		HttpSession session = req.getSession(false);
		Object userDetails =
				(session != null) ? session.getAttribute(ATTR_USER_ID) : null;

		String lastURIWord = uri.substring(uri.lastIndexOf("/") + 1);

		if (userDetails == null
				&& !(AUTHENTICATED_URL.indexOf(lastURIWord) >= 0))
		{

			boolean isAuthntificated = false;
			String lastURLIndex = uri.substring(0, uri.lastIndexOf("/"));
			String[] params = lastURLIndex.split("/");
			for (int i = 0; i < params.length; i++)
			{
				if (AUTHENTICATED_URL_INDEXOF.indexOf(params[i]) >= 0)
				{
					isAuthntificated = true;
					break;
				}
			}
			lastURLIndex =
					lastURLIndex.substring(lastURLIndex.lastIndexOf("/") + 1,
							lastURLIndex.length());

			if (AUTHENTICATED_URL_INDEXOF.indexOf(lastURLIndex) >= 0
					|| isAuthntificated)
			{
				chain.doFilter(request, response);
			} else
			{
				// res.sendRedirect(SESSION_FAILURE_URL);
				RequestDispatcher requestDispatcher =
						request.getRequestDispatcher(SESSION_FAILURE_PATH);
				requestDispatcher.forward(request, response);

			}

		} else
		{
			String role = getSessionAttr(req, ATTR_ROLE);

			if (role != null && ROLE_CUSTOMER_URL.indexOf(lastURIWord) >= 0)
			{
				if (role.indexOf(ROLE_CUSTOMER) >= 0)
				{
					chain.doFilter(request, response);
				} else
				{
					// res.sendRedirect(SESSION_FAILURE_URL);
					RequestDispatcher requestDispatcher =
							request.getRequestDispatcher(SESSION_FAILURE_PATH);
					requestDispatcher.forward(request, response);
				}
			} else if (role != null
					&& ROLE_VENDOR_URL.indexOf(lastURIWord) >= 0)
			{
				if (role.indexOf(ROLE_VENDOR) >= 0)
				{
					chain.doFilter(request, response);
				} else
				{
					// res.sendRedirect(SESSION_FAILURE_URL);
					RequestDispatcher requestDispatcher =
							request.getRequestDispatcher(SESSION_FAILURE_PATH);
					requestDispatcher.forward(request, response);
				}
			} else
			{
				chain.doFilter(request, response);
			}
		}

	}

	public void destroy()
	{

	}

}
