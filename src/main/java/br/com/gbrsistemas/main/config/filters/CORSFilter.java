package br.com.gbrsistemas.main.config.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "CORSFilter", urlPatterns = "/api/*")
public class CORSFilter implements Filter {

	private static final List<String> ALLOWED_HOSTS = Arrays.asList(
		"localhost",
		".crvirtual.online",
		".crmsc.org.br",
		".cremers.org.br"
	);

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse resp = (HttpServletResponse) servletResponse;

		String origin = request.getHeader("Origin");
		if (origin != null) {
			addCorsHeaders(resp, origin);
		}

		// Retorna Ok se for OPTIONS
		if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
			resp.setStatus(HttpServletResponse.SC_OK);
			return;
		}

		chain.doFilter(request, servletResponse);
	}

	@Override
	public void init(FilterConfig filterConfig) {
	}

	@Override
	public void destroy() {
	}

	public static void addCorsHeaders(HttpServletResponse response, String origin) {
		if (!originAllowed(origin)) return;

		response.setHeader("Access-Control-Allow-Origin", origin);
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
		response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization, Charset");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.addHeader("Vary", "Origin");
	}

	public static boolean originAllowed(String origin) {
		try {
			URL url = new URL(origin);
			return ALLOWED_HOSTS.stream().anyMatch(host -> url.getHost().endsWith(host));
		} catch (Exception ex) {
			return false;
		}
	}

}
