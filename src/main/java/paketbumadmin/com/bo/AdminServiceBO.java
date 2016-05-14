package paketbumadmin.com.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import paketbumadmin.com.dao.LoginDAO;
import paketbumadmin.com.model.Login;
import paketbumadmin.com.service.AdminService;

public class AdminServiceBO implements AdminService
{

	@Autowired
	LoginDAO loginDAO;

	@Override
	public List<Login> validate(String email, String password, String status)
			throws Exception
	{
		return loginDAO.validate(email, password, status);
	}

	@Override
	public List<Login> getUsers(int startIndx, int maxIndx, String userType)
			throws Exception
	{
		return loginDAO.getUsers(startIndx, maxIndx, userType);
	}

	public int getUsersNumEntries(String userType) throws Exception
	{
		return loginDAO.getUsersNumEntries(userType);
	}

	@Override
	public List<Login> getUsersViaSearchParam(int startIndx, int maxIndx,
			String userType, String searchParameter) throws Exception
	{
		return loginDAO.getUsersViaSearchParam(startIndx, maxIndx, userType,
				searchParameter);
	}

	@Override
	public int getUsersViaSearchParamNumEntries(String userType,
			String searchParameter) throws Exception
	{
		return loginDAO.getUsersViaSearchParamNumEntries(userType,
				searchParameter);
	}

	@Override
	public List<Login> getUsersBasedId(int userId) throws Exception
	{
		return loginDAO.getUsersBasedId(userId);
	}

	@Override
	public void updateVclOwnerDetails(Login login) throws Exception
	{
		loginDAO.updateVclOwnerDetails(login);
	}

	@Override
	public void updateProOwnerDetails(Login login) throws Exception
	{
		loginDAO.updateProOwnerDetails(login);
	}
	
}