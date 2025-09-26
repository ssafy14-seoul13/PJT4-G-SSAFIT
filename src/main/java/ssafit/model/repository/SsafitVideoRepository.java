package ssafit.model.repository;

import java.util.List;

import ssafit.model.dto.Video;

public interface SsafitVideoRepository {
	//전체 영상 가져오기
	public abstract List<Video> selectAll();
	
	//영상 조회
	public abstract Video selectOne(String id);
	
	//영상 등록
	public abstract void insertVideo(Video video);
	
	//영상 수정
	public abstract void updateVideo(Video video);
	
	//영상 삭제
	public abstract void deleteVideo(String id);
	
	
}
