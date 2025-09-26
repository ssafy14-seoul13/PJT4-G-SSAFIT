package ssafit.model.service;

import java.util.List;

import ssafit.model.dto.Video;
import ssafit.model.repository.SsafitVideoRepository;
import ssafit.model.repository.SsafitVideoRepositoryImpl;

public class SsafitVideoServiceImpl implements SsafitVideoService {

	private static SsafitVideoService service = new SsafitVideoServiceImpl();
	private SsafitVideoRepository repo = SsafitVideoRepositoryImpl.getInstance();

	private SsafitVideoServiceImpl() {}
	
	public static SsafitVideoService getInstance() {
		return service;
	}
	
	@Override
	public List<Video> selectAll() {
		// TODO Auto-generated method stub

		return repo.selectAll();
	}

	@Override
	public Video selectOne(String id) {
		// TODO Auto-generated method stub
		
		return repo.selectOne(id);
	}

	@Override
	public void insertVideo(Video video) {
		// TODO Auto-generated method stub
		if (repo.selectOne(video.getId()) == null) {
			repo.insertVideo(video);
		}
	}

	@Override
	public void updateVideo(Video video) {
		// TODO Auto-generated method stub
		if (repo.selectOne(video.getId()) != null) {
			repo.updateVideo(video);
		}

	}

	@Override
	public void deleteVideo(String id) {
		// TODO Auto-generated method stub
		if (repo.selectOne(id) != null) {
			repo.deleteVideo(id);
		}
	}

}
