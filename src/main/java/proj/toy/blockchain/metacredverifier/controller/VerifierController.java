package proj.toy.blockchain.metacredverifier.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proj.toy.blockchain.metacredverifier.controller.dto.request.DidAndPresentation;
import proj.toy.blockchain.metacredverifier.controller.usecase.VerifierUseCase;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/verifier")
@RequiredArgsConstructor
public class VerifierController {
    private final VerifierUseCase verifierUseCase;

    @PostMapping(value = "/{did}/verify-presentation")
    public ResponseEntity<Void> verify(@PathVariable final String did, @Valid @RequestBody final DidAndPresentation presentation) {
        verifierUseCase.verify(
                did,
                presentation.getPresentation()
        );

        return (ResponseEntity<Void>) ResponseEntity.ok();
    }
}


