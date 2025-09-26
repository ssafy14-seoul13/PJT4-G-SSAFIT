package ssafit.model.service;

import java.util.List;

import ssafit.model.dto.User;
import ssafit.model.repository.SsafitUserRepository;
import ssafit.model.repository.SsafitUserRepositoryImpl;

public class SsafitUserServiceImpl implements SsafitUserService{
	
	private static SsafitUserService service = new SsafitUserServiceImpl();
	
	private SsafitUserRepository repo = SsafitUserRepositoryImpl.getInstance();
	
	public static SsafitUserService getInstance() {
		return service;
	}

	@Override
	public List<User> selectAll() {
		return repo.selectAll();
	}

	@Override
	public User selectOne(String userId) {
		return repo.selectOne(userId);
	}

	@Override
	public void insertUser(User user) {
		if (repo.selectOne(user.getUserId()) == null)
			repo.insertUser(user);
		
	}

	@Override
	public void updateUser(User user) {
		if (repo.selectOne(user.getUserId()) != null)
			repo.updateUser(user);
		
	}

	@Override
	public void deleteUser(String userId) {
		if (repo.selectOne(userId) != null)
			repo.deleteUser(userId);
		
	}
	

}
