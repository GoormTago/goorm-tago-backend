package com.example.kakao.sample;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api") 
public class SampleRestController {

    private final SampleDataRepository sampleDataRepository;

    @GetMapping("/test")
    public ResponseEntity<?> pingTest() {
        return ResponseEntity.ok(true);
    }

    @GetMapping("/db")
    public ResponseEntity<?> dbTest() {
        List<SampleData> sampleDataList = sampleDataRepository.findAll();
        return ResponseEntity.ok(sampleDataList);
    }
    
    @GetMapping("/json-data")
    public String getJsonData() {
    	String jsonData =  "[\n" +
                "  {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"김철수\",\n" +
                "    \"phone_number\": \"010-1234-5678\",\n" +
                "    \"bookmarks\": [\n" +
                "      {\n" +
                "        \"location_name\": \"아들집 \",\n" +
                "        \"road_address\": \"제주특별자치도 제주시 한라산길 123\",\n" +
                "        \"longitude\": \"126.533008\",\n" +
                "        \"latitude\": \"33.361667\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"location_name\": \"구름 정형외과\",\n" +
                "        \"road_address\": \"제주특별자치도 서귀포시 성산읍 일출로 1\",\n" +
                "        \"longitude\": \"126.930418\",\n" +
                "        \"latitude\": \"33.458598\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"location_name\": \"감귤시장\",\n" +
                "        \"road_address\": \"제주특별자치도 제주시 중앙로 45\",\n" +
                "        \"longitude\": \"126.564689\",\n" +
                "        \"latitude\": \"33.498493\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"location_name\": \"동사무소\",\n" +
                "        \"road_address\": \"제주특별자치도 서귀포시 중문로 22\",\n" +
                "        \"longitude\": \"126.409244\",\n" +
                "        \"latitude\": \"33.248778\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"location_name\": \"제주은행 성산점\",\n" +
                "        \"road_address\": \"제주특별자치도 서귀포시 병원로 15\",\n" +
                "        \"longitude\": \"126.456012\",\n" +
                "        \"latitude\": \"33.255121\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"location_name\": \"시흥리 마을 회관\",\n" +
                "        \"road_address\": \"제주특별자치도 제주시 신대로 7\",\n" +
                "        \"longitude\": \"126.528301\",\n" +
                "        \"latitude\": \"33.499999\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"name\": \"박영희\",\n" +
                "    \"phone_number\": \"010-9876-5432\",\n" +
                "    \"bookmarks\": [\n" +
                "      {\n" +
                "        \"location_name\": \"한림공원\",\n" +
                "        \"road_address\": \"제주특별자치도 제주시 한림읍 한림로 300\",\n" +
                "        \"longitude\": \"126.264606\",\n" +
                "        \"latitude\": \"33.396131\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"location_name\": \"오설록 티 뮤지엄\",\n" +
                "        \"road_address\": \"제주특별자치도 서귀포시 안덕면 녹차로 15\",\n" +
                "        \"longitude\": \"126.289416\",\n" +
                "        \"latitude\": \"33.305493\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"location_name\": \"동사무소\",\n" +
                "        \"road_address\": \"제주특별자치도 제주시 동문로 20\",\n" +
                "        \"longitude\": \"126.560912\",\n" +
                "        \"latitude\": \"33.512600\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"location_name\": \"곽지 해수욕장\",\n" +
                "        \"road_address\": \"제주특별자치도 제주시 한림읍 곽지로 28\",\n" +
                "        \"longitude\": \"126.239655\",\n" +
                "        \"latitude\": \"33.418384\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"location_name\": \"병원\",\n" +
                "        \"road_address\": \"제주특별자치도 서귀포시 중앙로 50\",\n" +
                "        \"longitude\": \"126.573876\",\n" +
                "        \"latitude\": \"33.245780\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"location_name\": \"제주 항공우주박물관\",\n" +
                "        \"road_address\": \"제주특별자치도 서귀포시 박물관로 5\",\n" +
                "        \"longitude\": \"126.300895\",\n" +
                "        \"latitude\": \"33.395619\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";

        return jsonData;
    }
}
