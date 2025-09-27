package ssafit.model.repository;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import ssafit.model.dto.Video;

public class SsafitVideoRepositoryImpl implements SsafitVideoRepository {

    private static SsafitVideoRepository repo = new SsafitVideoRepositoryImpl();
    private List<Video> list; // 영상 데이터를 담을 리스트

    // private 생성자에서 데이터 로딩
    private SsafitVideoRepositoryImpl() {
        jsonReader(); // 프로그램 시작 시 JSON 데이터 로드
    }

    public static SsafitVideoRepository getInstance() {
        return repo;
    }

    // JSON 파일 경로 (클래스패스 기준)
    private static final String JSON_FILE_PATH = "video.json";

    // JSON 파일을 읽어 list를 초기화
    private void jsonReader() {
        list = new ArrayList<>();
        StringBuilder jsonContent = new StringBuilder();

        // 1. JSON 파일을 읽어서 문자열로 만들기 (InputStream null 체크 및 UTF-8 인코딩 명시)
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(JSON_FILE_PATH)) {
            if (is == null) {
                System.out.println("[ERROR] JSON file not found: " + JSON_FILE_PATH);
                return;
            }
            // UTF-8 인코딩을 명시하여 한글 깨짐 방지
            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    jsonContent.append(line);
                }
            }
        } catch (Exception e) {
            System.out.println("[ERROR] JSON file loading failed.");
            e.printStackTrace();
            return;
        }

        // 2. 수동 파싱 개선 (정규 표현식 사용)
        // 정규 표현식으로 키-값 쌍을 추출하기 위한 패턴: \"key\":\"value\"
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\"(.*?)\"\s*:\s*\"(.*?)\"");
        
        // JSON 문자열에서 객체 부분만 추출 (대괄호 안의 내용)
        String jsonString = jsonContent.toString();
        int startIndex = jsonString.indexOf('[');
        int endIndex = jsonString.lastIndexOf(']');

        if (startIndex == -1 || endIndex == -1) {
            System.out.println("[ERROR] Invalid JSON array format.");
            return;
        }
        
        // 객체들이 모여있는 문자열
        String objectsString = jsonString.substring(startIndex + 1, endIndex);

        // ','와 다음 '{' 사이를 기준으로 각 JSON 객체 문자열을 분리 (더 안정적인 방법)
        String[] videoObjects = objectsString.split(",(?=\s*\\{)");

        for (String objStr : videoObjects) {
            if (objStr.trim().isEmpty()) continue;

            java.util.regex.Matcher matcher = pattern.matcher(objStr);
            
            String id = null, title = null, part = null, channelName = null, url = null;

            while (matcher.find()) {
                String key = matcher.group(1);
                String value = matcher.group(2);

                switch (key) {
                    case "id": id = value; break;
                    case "title": title = value; break;
                    case "part": part = value; break;
                    case "channelName": channelName = value; break;
                    case "url": url = value; break;
                }
            }
            
            if (id != null) { // 유효한 객체 데이터가 파싱되었는지 확인
                list.add(new Video(id, title, part, channelName, url));
            }
        }
        System.out.println("JSON parsing complete. " + list.size() + " videos loaded.");
    }

    @Override
    public List<Video> selectAll() {
        return list;
    }

    @Override
    public Video selectOne(String id) {
        for (Video video : list) {
            // 문자열 비교는 .equals() 사용
            if (video.getId().equals(id)) {
                return video;
            }
        }
        return null;
    }

    @Override
    public void insertVideo(Video video) {
        list.add(video);
    }

    @Override
    public void updateVideo(Video video) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(video.getId())) {
                list.set(i, video); // 찾은 인덱스의 요소를 교체
                return;
            }
        }
    }

    @Override
    public void deleteVideo(String id) {
        // removeIf를 사용하여 안전하게 요소 제거
        list.removeIf(v -> v.getId().equals(id));
    }
}
