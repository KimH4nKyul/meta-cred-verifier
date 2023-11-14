package proj.toy.blockchain.metacredverifier.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.toy.blockchain.metacredverifier.controller.dto.request.DidAndPresentation;
import proj.toy.blockchain.metacredverifier.controller.dto.response.VerifiedPresentation;
import proj.toy.blockchain.metacredverifier.controller.usecase.VerifierUseCase;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/verifier")
@RequiredArgsConstructor
public class VerifierController {
    private final VerifierUseCase verifierUseCase;

    @PostMapping(value = "/verify-presentation")
    public ResponseEntity<VerifiedPresentation> verify(@Valid @RequestBody final DidAndPresentation request) {
        return ResponseEntity.ok(VerifiedPresentation.from(verifierUseCase.verify(request.getDid(), request.getPresentation())));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VerifiedPresentation> findById(@PathVariable String id) {
        return ResponseEntity.ok(VerifiedPresentation.from(verifierUseCase.findById(UUID.fromString(id))));
    }
}


