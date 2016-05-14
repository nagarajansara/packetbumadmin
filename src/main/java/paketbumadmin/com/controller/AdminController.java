package paketbumadmin.com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import paketbumadmin.com.datatable.CommonDataTableJsonObj;
import paketbumadmin.com.model.Login;
import paketbumadmin.com.service.AdminService;
import paketbumadmin.com.util.ConstException;
import paketbumadmin.com.util.Response;
import paketbumadmin.com.util.Utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("/admin")
@SuppressWarnings(
{ "unused", "unchecked" })
public class AdminController extends BaseController
{
	private static final Logger logger = Logger.getLogger(AdminController.class
			.getName());

	@Autowired
	@Qualifier("utilities")
	Utilities utilities;

	@Autowired
	@Qualifier("response")
	Response response;

	@Autowired
	@Qualifier("adminService")
	AdminService adminService;

	@RequestMapping(value = "/ping", method =
	{ RequestMethod.GET, RequestMethod.POST })
	public Response getContacts(HttpServletRequest request,
			HttpServletResponse res, ModelMap model)
	{
		try
		{

		} catch (Exception ex)
		{
			logger.error("getContacts :" + ex.getMessage());
			utilities.setErrResponse(ex, response);
		}
		model.addAttribute("model", response);
		return response;
	}

	@RequestMapping(value = "/validate", method =
	{ RequestMethod.GET, RequestMethod.POST })
	public String validate(HttpServletRequest request, HttpServletResponse res,
			ModelMap model) throws Exception
	{
		try
		{
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String isApproved = "yes";

			String[] params =
			{ "email", "password" };

			if (!utilities.isChkRequsetParamsNull(request, params))
			{
				List<Login> list =
						adminService.validate(email, password, isApproved);
				if (list != null && list.size() > 0)
				{
					Login login = (Login) list.get(0);
					setUserSession(request, login);
					utilities.setSuccessResponse(response);
				} else
				{
					throw new ConstException("Invalid Login");
				}
			} else
			{
				throw new ConstException(ConstException.ERR_CODE_BLANK_DATA,
						ConstException.ERR_MSG_BLANK_DATA);
			}

		} catch (Exception ex)
		{
			logger.error("validate :" + ex.getMessage());
			utilities.setErrResponse(ex, response);
		}
		model.addAttribute("model", response);
		return "login";
	}

	@RequestMapping(value = "/logout", method =
	{ RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpServletRequest request, ModelMap model)
	{
		new Response();
		try
		{
			destroySession(request);
		} catch (Exception ex)
		{
			logger.error("logout :" + ex.getMessage(), ex);
		}
		return "login";
	}

	@RequestMapping(value = "/getUsers/{UserType}", method =
	{ RequestMethod.GET, RequestMethod.POST }, produces = "application/json")
	public @ResponseBody String getUsers(HttpServletRequest request,
			HttpServletResponse res, ModelMap model,
			@PathVariable("UserType") String UserType)
	{

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json2 = "";
		try
		{

			Integer pageNumber = 0;
			if (null != request.getParameter("iDisplayStart"))
				pageNumber =
						(Integer.valueOf(request.getParameter("iDisplayStart")) / utilities
								.getDefaultMaxIndx()) + 1;
			String searchParameter = request.getParameter("sSearch");
			Integer pageDisplayLength =
					Integer.valueOf(request.getParameter("iDisplayLength"));

			int startIndx = pageNumber - 1;
			int maxIndx = pageDisplayLength;

			startIndx = getStartIdx(startIndx, maxIndx);

			List<Login> userList = new ArrayList<Login>();
			int numEntries = 0;

			if (null != searchParameter && !searchParameter.equals(""))
			{
				userList =
						adminService.getUsersViaSearchParam(startIndx, maxIndx,
								UserType, searchParameter);
				numEntries =
						adminService.getUsersViaSearchParamNumEntries(UserType,
								searchParameter);
			} else
			{

				userList = adminService.getUsers(startIndx, maxIndx, UserType);
				numEntries = adminService.getUsersNumEntries(UserType);

			}
			CommonDataTableJsonObj<List<Login>> employeeCategoryJsonObj =
					new CommonDataTableJsonObj<List<Login>>();

			employeeCategoryJsonObj.setiTotalDisplayRecords(numEntries);

			employeeCategoryJsonObj.setiTotalRecords(numEntries);
			employeeCategoryJsonObj.setAaData(userList);
			json2 = gson.toJson(employeeCategoryJsonObj);

		} catch (Exception ex)
		{
			logger.error("getUsers :" + ex.getMessage());
			utilities.setErrResponse(ex, response);
		}
		model.addAttribute(json2);
		return json2;

	}

	@RequestMapping(value = "/getUsersBasedId/{userId}/{role}", method =
	{ RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpServletRequest request, ModelMap model,
			@PathVariable("userId") int userId,
			@PathVariable("role") String role)
	{
		try
		{
			List<Login> userList = adminService.getUsersBasedId(userId);
			Map<String, Object> map = new HashMap<String, Object>();
			if (userList != null)
			{
				map.put("userList", userList);
				map.put("role", role);
				utilities.setSuccessResponse(response, map);

			} else
			{
				throw new ConstException();
			}

		} catch (Exception ex)
		{
			logger.error("getUsersBasedId :" + ex.getMessage());
			utilities.setErrResponse(ex, response);
		}
		model.addAttribute("model", response);
		return "userdetails";
	}

	@RequestMapping(value = "/updateVclOwnerDetails", method =
	{ RequestMethod.GET, RequestMethod.POST })
	public String updateVclOwnerDetails(HttpServletRequest request,
			ModelMap model, @RequestParam(value = "email") String email,
			@RequestParam(value = "username") String username, @RequestParam(
					value = "isactive") boolean isactive, @RequestParam(
					value = "mobile") String mobile, @RequestParam(
					value = "userid") int userid)
	{
		try
		{
			int status = 0;
			if (isactive)
			{
				status = 1;
			}
			Login login = new Login(userid, email, username, status, mobile);
			adminService.updateVclOwnerDetails(login);
			utilities.setSuccessResponse(response);

		} catch (Exception ex)
		{
			logger.error("updateVclOwnerDetails :" + ex.getMessage());
			utilities.setErrResponse(ex, response);
		}
		model.addAttribute("model", response);
		return "userdetails";
	}

	@RequestMapping(value = "/updateProOwnerDetails", method =
	{ RequestMethod.GET, RequestMethod.POST })
	public String updateProOwnerDetails(HttpServletRequest request,
			ModelMap model, @RequestParam(value = "email") String email,
			@RequestParam(value = "username") String username, @RequestParam(
					value = "fName") String fName, @RequestParam(
					value = "lName") String lName, @RequestParam(
					value = "companyName") String companyName, @RequestParam(
					value = "telephoneNo") String telephoneNo, @RequestParam(
					value = "taxNo") String taxNo,
			@RequestParam(value = "city") String city, @RequestParam(
					value = "address1") String address1, @RequestParam(
					value = "address2") String address2, @RequestParam(
					value = "postCode") String postCode, @RequestParam(
					value = "isactive") boolean isactive, @RequestParam(
					value = "mobile") String mobile, @RequestParam(
					value = "vehiclenumber") String vehiclenumber,
			@RequestParam(value = "userid") int userid)
	{
		try
		{
			int status = 0;
			if (isactive)
			{
				status = 1;
			}
			Login login =
					new Login(email, username, fName, lName, companyName,
							telephoneNo, taxNo, city, address1, address2,
							postCode, status, mobile, userid, vehiclenumber);
			adminService.updateProOwnerDetails(login);
			utilities.setSuccessResponse(response);

		} catch (Exception ex)
		{
			logger.error("updateProOwnerDetails :" + ex.getMessage());
			utilities.setErrResponse(ex, response);
		}
		model.addAttribute("model", response);
		return "userdetails";
	}
}
