package ssafit.model.repository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ssafit.model.dto.Video;

public class SsafitVideoRepositoryImpl implements SsafitVideoRepository {

	// JSON 데이터를 담을 리스트
	private List<Video> list;
	private Map<String, Video> map = new HashMap<>();

	// JSON 파일 경로
	private static final String json_file_path = "video.json";


	// json 파일을 읽어 videoList를 초기화
	private void JsonRedear() {
		list = new ArrayList<>();
		StringBuilder jsonContent = new StringBuilder();

		// 1. JSON 파일을 읽어서 문자열로 만들기
		try (InputStream is = getClass().getClassLoader().getResourceAsStream(json_file_path);
				BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

			String line;
			while ((line = br.readLine()) != null) {
				jsonContent.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		String jsonString = jsonContent.toString();
		// 배열 시작과 끝 '[', ']' 제거
		jsonString = jsonString.substring(jsonString.indexOf('[') + 1, jsonString.lastIndexOf(']'));
		// 각 객체를 ',' 기준으로 분리
		String[] videoObjects = jsonString.split("},\\{");

		for (String objStr : videoObjects) {
			// 각 객체 문자열을 정리
			objStr = objStr.replace("{", "").replace("}", "").replace("\"", "");

			String[] properties = objStr.split(",");
			String id = null;
			String title = null;
			String part = null;
			String channelName = null;
			String url = null;

			// 2. 키-값 쌍을 수동으로 파싱하여 VideoDTO 객체 생성
			for (String prop : properties) {
				String[] keyValue = prop.split(":");
				String key = keyValue[0].trim();
				String value = keyValue[1].trim();

				switch (key) {
				case "id":
					id = value;
					break;
				case "title":
					title = value;
					break;
				case "part":
					part = value;
					break;
				case "channelName":
					channelName = value;
					break;
				case "url":
					url = value;
					break;
				}
			}

			list.add(new Video(id, title, part, channelName, url));
		}
		System.out.println("수동 파싱 완료. 총 " + list.size() + "개의 영상이 로드되었습니다.");
	}

	// 이 아래에 VideoRepository 인터페이스의 메서드들을 구현
	@Override
	public List<Video> selectAll() {
		return list;
	}



	@Override
	public Video selectOne(String id) {
		// TODO Auto-generated method stub
		return map.get(id);
	}

	@Override
	public void insertVideo(Video video) {
		// TODO Auto-generated method stub
		list.add(video);
		map.put(video.getId(), video);
		

	}

	@Override
	public void updateVideo(Video video) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteVideo(String id) {
		// TODO Auto-generated method stub

	}





}
