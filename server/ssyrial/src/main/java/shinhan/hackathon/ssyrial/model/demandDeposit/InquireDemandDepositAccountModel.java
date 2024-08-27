/*
 * 2.4.5 계좌 조회 (단건) (p.41)
 * 
 * 설명
 * 특정 계좌에 대한 정보 조회
 * 
 * Request
 * Header - 공통 - 타입X - 길이X - 필수Y
 * accountNo - 계좌번호 - String - 길이16 - 필수Y
 * 
 * Response
 * Header - 공통 - 타입X - 길이X - 필수Y
 * REC - 계좌정보 - List - 길이X - 필수N
 * bankCode - 은행코드 - String - 길이3 - 필수Y
 * bankName - 은행명 - String - 길이20 - 필수Y
 * username - 예금주명 - String - 길이50 - 필수Y
 * accountNo - 계좌번호 - String - 길이16 - 필수Y
 * accountName - 상품명 - String - 길이20 - 필수Y
 * accountTypeCode - 상품구분코드 - String - 길이3 - 필수Y - 1:수시입출금, 2:정기예금, 3:정기적금, 4:대출
 * accountTypeName - 상품종류명 - String - 길이20 - 필수Y
 * accountCreatedDate - 계좌개설일 - String - 길이8 - 필수Y
 * accountExpiryDate - 계좌만기일 - String - 길이8 - 필수Y
 * dailyTransferLimit - 1일이체한도 - Long - 길이X - 필수Y
 * oneTimeTransferLimit - 1회이체한도 - Long - 길이X - 필수Y
 * accountBalance - 계좌잔액 - Long - 길이X - 필수Y
 * lastTransactionDate - 최종거래일 - String - 길이8 - 필수N
 * currency - 통화코드 - String - 길이8 - 필수Y
 */

package shinhan.hackathon.ssyrial.model.demandDeposit;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * InquireDemandDepositAccountModel 클래스는 특정 계좌에 대한 정보 조회 요청 및 응답 데이터를 담는 모델 클래스입니다.
 */
public class InquireDemandDepositAccountModel {

    /**
     * 특정 계좌의 정보 조회 요청 데이터를 담는 내부 클래스입니다.
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        @JsonProperty("Header")
        private CommonHeaderModel.Request Header;

        @JsonProperty("accountNo")
        private String accountNo; // 필수: 계좌번호, 길이: 16
    }

    /**
     * 특정 계좌의 정보 조회 응답 데이터를 담는 내부 클래스입니다.
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {

        @JsonProperty("Header")
        private CommonHeaderModel.Response Header;

        @JsonProperty("REC")
        private List<AccountInfo> REC; // 계좌 정보 리스트 (필수 아님)

        /**
         * 계좌 정보를 담는 내부 클래스입니다.
         */
        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class AccountInfo {
            @JsonProperty("bankCode")
            private String bankCode; // 필수: 은행코드, 길이: 3

            @JsonProperty("bankName")
            private String bankName; // 필수: 은행명, 길이: 20

            @JsonProperty("userName")
            private String userName; // 필수: 예금주명, 길이: 50

            @JsonProperty("accountNo")
            private String accountNo; // 필수: 계좌번호, 길이: 16

            @JsonProperty("accountName")
            private String accountName; // 필수: 상품명, 길이: 20

            @JsonProperty("accountTypeCode")
            private String accountTypeCode; // 필수: 상품구분코드, 길이: 3

            @JsonProperty("accountTypeName")
            private String accountTypeName; // 필수: 상품종류명, 길이: 20

            @JsonProperty("accountCreatedDate")
            private String accountCreatedDate; // 필수: 계좌개설일, 길이: 8

            @JsonProperty("accountExpiryDate")
            private String accountExpiryDate; // 필수: 계좌만기일, 길이: 8

            @JsonProperty("dailyTransferLimit")
            private Long dailyTransferLimit; // 필수: 1일이체한도

            @JsonProperty("oneTimeTransferLimit")
            private Long oneTimeTransferLimit; // 필수: 1회이체한도

            @JsonProperty("accountBalance")
            private Long accountBalance; // 필수: 계좌잔액

            @JsonProperty("lastTransactionDate")
            private String lastTransactionDate; // 선택: 최종거래일, 길이: 8

            @JsonProperty("currency")
            private String currency; // 필수: 통화코드, 길이: 8
        }
    }
}
