package cn.smbms.servlet.provider;

import cn.smbms.pojo.Provider;
import cn.smbms.pojo.User;
import cn.smbms.service.provider.ProviderService;
import cn.smbms.service.provider.ProviderServiceImpl;
import cn.smbms.tools.Constants;
import cn.smbms.tools.SpringContextUtil;
import com.alibaba.fastjson.JSONArray;
import com.mysql.jdbc.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ProviderServlet extends HttpServlet {
	private ProviderService providerService;

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if(method != null && method.equals("query")){
			this.query(request,response);
		}else if(method != null && method.equals("add")){
			this.add(request,response);
		}else if(method != null && method.equals("view")){
			this.getProviderById(request,response,"providerview.jsp");
		}else if(method != null && method.equals("modify")){
			this.getProviderById(request,response,"providermodify.jsp");
		}else if(method != null && method.equals("modifysave")){
			this.modify(request,response);
		}else if(method != null && method.equals("delprovider")){
			this.delProvider(request,response);
		}
	}
	
	private void delProvider(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("proid");
		HashMap<String, String> resultMap = new HashMap<String, String>();
		if(!StringUtils.isNullOrEmpty(id)){

			int flag = providerService.deleteProviderById(Integer.parseInt(id));
			if(flag == 0){//删除成功
				resultMap.put("delResult", "true");
			}else if(flag == -1){//删除失败
				resultMap.put("delResult", "false");
			}else if(flag > 0){//该供应商下有订单，不能删除，返回订单数
				resultMap.put("delResult", String.valueOf(flag));
			}
		}else{
			resultMap.put("delResult", "notexit");
		}
		//把resultMap转换成json对象输出
		response.setContentType("application/json");
		PrintWriter outPrintWriter = response.getWriter();
		outPrintWriter.write(JSONArray.toJSONString(resultMap));
		outPrintWriter.flush();
		outPrintWriter.close();
	}
	
	private void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String proName = request.getParameter("proName");
		String proContact = request.getParameter("proContact");
		String proPhone = request.getParameter("proPhone");
		String proAddress = request.getParameter("proAddress");
		String proFax = request.getParameter("proFax");
		String proDesc = request.getParameter("proDesc");
		String id = request.getParameter("id");
		Provider provider = new Provider();
		provider.setId(Integer.valueOf(id));
		provider.setProName(proName);
		provider.setProContact(proContact);
		provider.setProPhone(proPhone);
		provider.setProFax(proFax);
		provider.setProAddress(proAddress);
		provider.setProDesc(proDesc);
		provider.setModifyBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());
		provider.setModifyDate(new Date());
		boolean flag = false;

		flag = providerService.modify(provider);
		if(flag){
			response.sendRedirect(request.getContextPath()+"/jsp/provider.do?method=query");
		}else{
			request.getRequestDispatcher("providermodify.jsp").forward(request, response);
		}
	}
	
	private void getProviderById(HttpServletRequest request, HttpServletResponse response,String url)
			throws ServletException, IOException {
		String id = request.getParameter("proid");
		if(!StringUtils.isNullOrEmpty(id)){

			Provider provider = null;
			provider = providerService.getProviderById(Integer.parseInt(id));
			request.setAttribute("provider", provider);
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String proCode = request.getParameter("proCode");
		String proName = request.getParameter("proName");
		String proContact = request.getParameter("proContact");
		String proPhone = request.getParameter("proPhone");
		String proAddress = request.getParameter("proAddress");
		String proFax = request.getParameter("proFax");
		String proDesc = request.getParameter("proDesc");
		
		Provider provider = new Provider();
		provider.setProCode(proCode);
		provider.setProName(proName);
		provider.setProContact(proContact);
		provider.setProPhone(proPhone);
		provider.setProFax(proFax);
		provider.setProAddress(proAddress);
		provider.setProDesc(proDesc);
		provider.setCreatedBy(((User)request.getSession().getAttribute(Constants.USER_SESSION)).getId());
		provider.setCreationDate(new Date());
		boolean flag = false;

		flag = providerService.add(provider);
		if(flag){
			response.sendRedirect(request.getContextPath()+"/jsp/provider.do?method=query");
		}else{
			request.getRequestDispatcher("provideradd.jsp").forward(request, response);
		}
	}
	
	private void query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String queryProName = request.getParameter("queryProName");
		String queryProCode = request.getParameter("queryProCode");
		if(StringUtils.isNullOrEmpty(queryProName)){
			queryProName = "";
		}
		if(StringUtils.isNullOrEmpty(queryProCode)){
			queryProCode = "";
		}
		List<Provider> providerList = new ArrayList<Provider>();

		providerList = providerService.getProviderList(queryProName,queryProCode);
		request.setAttribute("providerList", providerList);
		request.setAttribute("queryProName", queryProName);
		request.setAttribute("queryProCode", queryProCode);
		request.getRequestDispatcher("providerlist.jsp").forward(request, response);
	}
	
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		providerService = (ProviderService) SpringContextUtil.getBean("providerService");
	}

}
