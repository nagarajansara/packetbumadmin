package paketbumadmin.com.controller;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import paketbumadmin.com.service.*;
import paketbumadmin.com.dao.*;
import paketbumadmin.com.model.*;
import paketbumadmin.com.util.*;

@SuppressWarnings(
{ "unchecked", "unused" })
public class BaseController
{

	public final String ATTR_USER_ID = "userId";
	public final String ATTR_FNAME = "fName";
	public final String ATTR_LNAME = "lName";
	public final String ATTR_EMAIL = "email";
	public final String ATTR_ROLE = "role";
	public final String ATTR_EMAIL_VERIFIED = "emailverified";
	public final String ATTR_PROFILE_IMAGE = "profileimage";
	public final String ATTR_COUNTRY = "country";
	public final String ATTR_MOBILE_NO = "mobileno";

	public final String ATTR_CT_CITY_NAME = "ATTR_CT_CITY_NAME";
	public final String ATTR_CT_CITY_ID = "ATTR_CT_CITY_ID";

	public int getUserId(HttpServletRequest request) throws ConstException
	{
		int userId = 0;
		HttpSession session = request.getSession();
		if (session != null)
		{
			Object obj = session.getAttribute(ATTR_USER_ID);
			if (obj != null)
			{
				userId = ((Integer) obj).intValue();
			}
		}

		if (userId == 0)
		{
			throw new ConstException(ConstException.ERR_CODE_INVALID_LOGIN,
					ConstException.ERR_MSG_SESSION_EXP);
		}
		return userId;
	}

	public int getUserId_WHOUT_Exception(HttpServletRequest request)
			throws ConstException
	{
		int userId = 0;
		HttpSession session = request.getSession();
		if (session != null)
		{
			Object obj = session.getAttribute(ATTR_USER_ID);
			if (obj != null)
			{
				userId = ((Integer) obj).intValue();
			}
		}
		return userId;
	}

	public String getSessionAttr(HttpServletRequest request, String attr)
	{
		String val = null;
		HttpSession session = request.getSession();
		if (session != null)
		{
			Object obj = session.getAttribute(attr);
			if (obj != null)
			{
				val = ((String) obj);
			}
		}
		return val;
	}

	public String getRole(HttpServletRequest request) throws ConstException
	{
		String role = null;
		HttpSession session = request.getSession();
		if (session != null)
		{
			Object obj = session.getAttribute(ATTR_ROLE);
			if (obj != null)
			{
				role = (String) obj;
			}
		}

		if (role == null)
		{
			throw new ConstException(ConstException.ERR_CODE_INVALID_LOGIN,
					ConstException.ERR_MSG_SESSION_EXP);
		}
		return role;
	}

	public void setUserSession(HttpServletRequest request, Login user)
			throws ConstException
	{
		if (user != null && user.getId() > 0)
		{
			HttpSession session = request.getSession();
			session.setAttribute(ATTR_USER_ID, user.getId());
			session.setAttribute(ATTR_ROLE, user.getRole());
			session.setAttribute(ATTR_LNAME, user.getLastname());
			session.setAttribute(ATTR_FNAME, user.getFirstname());
			session.setAttribute(ATTR_EMAIL, user.getEmail());
			session.setAttribute(ATTR_MOBILE_NO, user.getMobile());
		}
	}

	
	public int getStartIdx(int currPage, int maxEntriesPerPage)
			throws ConstException
	{
		return (currPage * maxEntriesPerPage);
	}

	public void destroySession(HttpServletRequest request)
			throws ConstException
	{
		HttpSession session = request.getSession(false);
		if (session != null)
		{
			session.invalidate();
		}
	}
}
