package ssafit.model.service;

import java.util.List;

import ssafit.model.dto.User;

public interface SsafitUserService {
	//전체 회원 조회
	public abstract List<User> selectAll();

	//회원 정보 조회
	public abstract User selectOne(String userId);

	//회원 가입
	public abstract void insertUser(User user);

	//회원 정보 수정
	public abstract void updateUser(User user);

	//회원 탈퇴 
	public abstract void deleteUser(String userId);
}
