package apiCalls.eupaActions.internal;

import activesupport.http.RestUtils;
import activesupport.system.Properties;
import apiCalls.Utils.eupaBuilders.internal.irhp.permit.stock.AvailableCountriesModel;
import apiCalls.Utils.generic.Utils;
import apiCalls.eupaActions.BaseAPI;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;

public class IrhpPermitStockAPI extends BaseAPI {

    private static final String baseResource = "irhp-permit-stock/";
    private static ValidatableResponse response;
    private static String apiHeader = Utils.config.getString("apiHeader");

    public static AvailableCountriesModel availableCountries() {
        String oldXPID = getHeader("x-pid"); // Needed as other calls might expect an external x-pid
        updateHeader("x-pid", apiHeader);

        URL.build(EnvironmentType.getEnum(Properties.get("env", true)), baseResource.concat("available-countries/?dto=Dvsa%5COlcs%5CTransfer%5CQuery%5CIrhpPermitStock%5CAvailableCountries"));

        response = RestUtils.get(String.valueOf(URL.getURL()), getHeaders());

        response.statusCode(HttpStatus.SC_OK);
        prettyPrintJson(response.extract().asString());

        updateHeader("x-pid", oldXPID);

        return response.extract().as(AvailableCountriesModel.class);
    }

}
