package shinhan.hackathon.ssyrial.model.bank;

import lombok.Getter;
import lombok.Setter;
import shinhan.hackathon.ssyrial.model.CommonHeaderModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * InquireBankCodes 클래스는 은행 코드 검색 요청 및 응답 데이터를 담는 모델 클래스입니다.
 */
public class InquireBankCodes {

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Request {

    @NotBlank(message = "공통 헤더는 필수 입력 항목입니다.")
    @JsonProperty("Header")
    private CommonHeaderModel.Request Header;
  }

  /**
   * 은행 코드 검색 응답 데이터를 담는 내부 클래스입니다.
   */
  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Response {
    @JsonProperty("Header")
    private CommonHeaderModel.Response Header;
    @JsonProperty("REC")
    private List<BankCode> REC;

    /**
     * 은행 코드 데이터를 담는 내부 클래스입니다.
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BankCode {
      private String bankCode;
      private String bankName;
    }
  }
}
