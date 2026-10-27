package dio.marketplace.catalog.infrastructure.http;

import dio.marketplace.catalog.application.BrowseShowcaseUseCase;
import dio.marketplace.catalog.application.dto.EventOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/showcase")
public class ShowcaseController {
    public final BrowseShowcaseUseCase browseShowcaseUseCase;

    @GetMapping
    List<EventOutput> browserShowcase() {
        return browseShowcaseUseCase.execute();
    }
}
