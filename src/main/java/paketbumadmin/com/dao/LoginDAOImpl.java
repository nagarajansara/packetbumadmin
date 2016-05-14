package paketbumadmin.com.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import paketbumadmin.com.model.Login;

@SuppressWarnings(
{ "unused", "unchecked" })
public class LoginDAOImpl implements LoginDAO
{

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	final String ROLE_ADMIN = "admin";

	final String LOGIN_VALIDATE =
			"Select * from user where email =:email AND password =:password AND role =:role";

	final String GET_USERS =
			"SELECT id, email, username, isactive, shortname, IF(isactive = 1, 'Active', 'Deactive') as status, "
					+ "REPLACE('<button pk_id=\"user_id\" title=\"User Info\" class=\"btn btn-success btn-xs btn-perspective pkUserInfo\">"
					+ "<i class=\"fa fa-info-circle\"></i> </button>', 'user_id', id) AS manage from user where role =:role "
					+ "LIMIT :startIndx, :endIndx";

	final String GET_USERS_NUMENTRIES =
			"SELECT count(*) from user where role =:role";

	final String GET_USERS_VIA_SEARCHPARAM =
			"SELECT email, username, isactive, shortname, IF(isactive = 1, 'Active', 'Deactive') as status, "
					+ "REPLACE('<button pk_id=\"user_id\" title=\"User Info\" class=\"btn btn-success btn-xs btn-perspective pkUserInfo\">"
					+ "<i class=\"fa fa-info-circle\"></i> </button>', 'user_id', id) AS manage "
					+ "from user where role =:role "
					+ " AND (email like :searchParam OR username like :searchParam OR shortname  like :searchParam)"
					+ "LIMIT :startIndx, :endIndx";

	final String GET_USERS_VIA_SEARCHPARAM_NUMENTRIES =
			"SELECT count(*) from user where role =:role "
					+ " AND (email like :searchParam OR username like :searchParam OR shortname  like :searchParam)";

	final String GET_USER_BASED_ID = "SELECT u.*, ud.* FROM USER u "
			+ "INNER JOIN userdetails ud " + "ON ud.userid = u.id "
			+ "WHERE u.id =:userid";

	// Update Vclowner
	final String UPDATE_VLC_OWNER_USER =
			"Update user set username =:username,  isactive =:isactive where id =:userid";

	final String UPDATE_VLC_OWNER_USER_DETAILS =
			"Update userdetails set mobile =:mobile WHERE userid =:userid";

	// Update Proowner
	final String UPDATE_PRO_OWNER_USER =
			"Update user set username =:username,  isactive =:isactive where id =:userid";

	final String UPDATE_PRO_OWNER_USER_DETAILS =
			"Update userdetails set firstname =:firstname, "
					+ " lastname =:lastname, telephone =:telephone, city =:city, address1 =:address1, address2 =:address2, postcode =:postcode, "
					+ "companyname =:companyname, taxnumber =:taxnumber, vehiclenumber =:vehiclenumber, mobile =:mobile WHERE userid =:userid";

	@Override
	public List<Login> validate(String email, String password, String status)
			throws Exception
	{
		Map paramMap = new HashMap();
		paramMap.put("email", email);
		paramMap.put("password", password);
		paramMap.put("role", ROLE_ADMIN);

		return namedParameterJdbcTemplate.query(LOGIN_VALIDATE, paramMap,
				new BeanPropertyRowMapper<Login>(Login.class));
	}

	@Override
	public List<Login> getUsers(int startIndx, int maxIndx, String userType)
			throws Exception
	{
		Map paramMap = new HashMap();
		paramMap.put("role", userType);
		paramMap.put("startIndx", startIndx);
		paramMap.put("endIndx", maxIndx);

		return namedParameterJdbcTemplate.query(GET_USERS, paramMap,
				new BeanPropertyRowMapper<Login>(Login.class));
	}

	@Override
	public int getUsersNumEntries(String userType) throws Exception
	{
		Map paramMap = new HashMap();
		paramMap.put("role", userType);

		return namedParameterJdbcTemplate.queryForInt(GET_USERS_NUMENTRIES,
				paramMap);
	}

	@Override
	public List<Login> getUsersViaSearchParam(int startIndx, int maxIndx,
			String userType, String searchParameter) throws Exception
	{
		Map paramMap = new HashMap();
		paramMap.put("role", userType);
		paramMap.put("startIndx", startIndx);
		paramMap.put("endIndx", maxIndx);
		paramMap.put("searchParam", searchParameter + "%");

		return namedParameterJdbcTemplate.query(GET_USERS_VIA_SEARCHPARAM,
				paramMap, new BeanPropertyRowMapper<Login>(Login.class));
	}

	@Override
	public int getUsersViaSearchParamNumEntries(String userType,
			String searchParameter) throws Exception
	{
		Map paramMap = new HashMap();
		paramMap.put("role", userType);
		paramMap.put("searchParam", searchParameter + "%");

		return namedParameterJdbcTemplate.queryForInt(
				GET_USERS_VIA_SEARCHPARAM_NUMENTRIES, paramMap);
	}

	@Override
	public List<Login> getUsersBasedId(int userId) throws Exception
	{
		Map paramMap = new HashMap();
		paramMap.put("userid", userId);

		return namedParameterJdbcTemplate.query(GET_USER_BASED_ID, paramMap,
				new BeanPropertyRowMapper<Login>(Login.class));
	}

	@Override
	public void updateVclOwnerDetails(Login login) throws Exception
	{
		Map paramMap = new HashMap();
		paramMap.put("userid", login.getId());
		paramMap.put("username", login.getUsername());
		paramMap.put("id", login.getId());
		paramMap.put("isactive", login.getIsactive());
		paramMap.put("mobile", login.getMobile());

		namedParameterJdbcTemplate.update(UPDATE_VLC_OWNER_USER, paramMap);
		namedParameterJdbcTemplate.update(UPDATE_VLC_OWNER_USER_DETAILS,
				paramMap);
	}

	@Override
	public void updateProOwnerDetails(Login login) throws Exception
	{
		Map paramMap = new HashMap();
		paramMap.put("username", login.getUsername());
		paramMap.put("isactive", login.getIsactive());
		paramMap.put("firstname", login.getFirstname());
		paramMap.put("lastname", login.getLastname());
		paramMap.put("telephone", login.getTelephone());
		paramMap.put("city", login.getCity());
		paramMap.put("address1", login.getAddress1());
		paramMap.put("address2", login.getAddress2());
		paramMap.put("postcode", login.getPostcode());
		paramMap.put("companyname", login.getCompanyname());
		paramMap.put("taxnumber", login.getTaxnumber());
		paramMap.put("mobile", login.getMobile());
		paramMap.put("userid", login.getId());
		paramMap.put("vehiclenumber", login.getVehiclenumber());

		namedParameterJdbcTemplate.update(UPDATE_PRO_OWNER_USER, paramMap);
		namedParameterJdbcTemplate.update(UPDATE_PRO_OWNER_USER_DETAILS,
				paramMap);

	}

}
