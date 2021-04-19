package apiCalls.Utils.eupaBuilders.external.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public enum SignatureType {
    Physical("sig_physical_signature");

    String type;

    SignatureType(String type) {
        this.type = type;
    }

    public static SignatureType getEnum(@NotNull String type) {
        SignatureType signatureType;

        switch(StringUtils.deleteWhitespace(type).toLowerCase()){
            case "sig_physical_signature":
                signatureType = Physical;
                break;
            default:
                throw new IllegalArgumentException("Unsupported enum type: ".concat(type));
        }

        return signatureType;
    }

    @Override
    @JsonValue
    public String toString(){
        return type;
    }

}
