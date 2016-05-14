package paketbumadmin.com.service;

import java.util.List;

import paketbumadmin.com.model.Login;

public interface AdminService
{

	List<Login> validate(String email, String password, String status)
			throws Exception;

	List<Login> getUsers(int startIndx, int maxIndx, String userType)
			throws Exception;

	int getUsersNumEntries(String userType) throws Exception;

	List<Login> getUsersViaSearchParam(int startIndx, int maxIndx,
			String userType, String searchParameter) throws Exception;

			int getUsersViaSearchParamNumEntries(String userType,
					String searchParameter) throws Exception;

	List<Login> getUsersBasedId(int userId) throws Exception;

	void updateVclOwnerDetails(Login login) throws Exception;

	void updateProOwnerDetails(Login login) throws Exception;

}
