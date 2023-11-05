package proj.toy.blockchain.metacredverifier.controller.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class DidAndPresentation {
    @NotBlank(message = "DID 입력은 필수입니다.")
    @Pattern(regexp = "(did:meta:)(.[A-Za-z0-9].*)", message = "올바른 형식의 DID를 입력해야 합니다.")
    @Size(min=70, max=100, message = "DID는 최소 70자 이상, 최대 100자 이하를 허용합니다.")
    private String did;

    @NotBlank(message = "Presentation 입력은 필수입니다.")
    private String presentation;
}
