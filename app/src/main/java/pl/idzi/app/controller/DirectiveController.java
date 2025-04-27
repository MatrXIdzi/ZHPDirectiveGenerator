package pl.idzi.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.idzi.app.controller.dto.directive.CreateDirectiveRequest;
import pl.idzi.app.service.DirectiveBinaryService;
import pl.idzi.app.service.DirectiveService;

@RestController
@RequestMapping("/api/directive")
public class DirectiveController {
    private final DirectiveService directiveService;
    private final DirectiveBinaryService directiveBinaryService;

    @Autowired
    public DirectiveController(DirectiveService directiveService, DirectiveBinaryService directiveBinaryService) {
        this.directiveService = directiveService;
        this.directiveBinaryService = directiveBinaryService;
    }

    @RequestMapping("/create")
    public ResponseEntity<String> createDirective(@RequestBody CreateDirectiveRequest request) {
        // Implement the logic to create a directive
        return ResponseEntity.ok("Directive created");
    }
}
