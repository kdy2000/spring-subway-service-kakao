package subway.path.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import subway.path.application.PathService;
import subway.path.dto.PathResponse;
import subway.station.application.StationService;
import subway.station.domain.Station;

@RestController
public class PathController {
    private final PathService pathService;
    private final StationService stationService;

    public PathController(PathService pathService, StationService stationService) {
        this.pathService = pathService;
        this.stationService = stationService;
    }

    @GetMapping("/paths")
    public ResponseEntity<PathResponse> getPath(@RequestParam String source, @RequestParam String target) {
        return ResponseEntity.ok().body(
                pathService.getShortestPathOfStations(source, target));
    }
}
