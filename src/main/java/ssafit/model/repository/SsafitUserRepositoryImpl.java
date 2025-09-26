package ssafit.model.repository;

import java.util.ArrayList;
import java.util.List;

import ssafit.model.dto.User;

public class SsafitUserRepositoryImpl implements SsafitUserRepository {

	private List<User> list = new ArrayList<>();

	private static SsafitUserRepository repo = new SsafitUserRepositoryImpl();

	private SsafitUserRepositoryImpl() {

	}

	public static SsafitUserRepository getInstance() {
		return repo;
	}

	@Override
	public List<User> selectAll() {
		return list;
	}

	@Override
	public User selectOne(int userId) {
		for (User user : list) {
			if (user.getUserId().equals(userId))
				return user;
		}
		return null;
	}

	@Override
	public void insertUser(User user) {
		list.add(user); 
	}

	@Override
	public void updateUser(User user) {
		for (User userOrigin : list) {
			if (user.getUserId().equals(userOrigin.getUserId())) {
				list.remove(userOrigin);
				list.add(user);
				break;
			}
		}

	}

	@Override
	public void deleteUser(int userId) {
		for (User user : list) {
			if (user.getUserId().equals(userId)) {
				list.remove(user);
				break;
			}
		}
	}

}
