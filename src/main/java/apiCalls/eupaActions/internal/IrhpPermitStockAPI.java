package apiCalls.eupaActions.internal;

import activesupport.http.RestUtils;
import activesupport.system.Properties;
import apiCalls.Utils.eupaBuilders.internal.irhp.permit.stock.AvailableCountriesModel;
import apiCalls.Utils.generic.Utils;
import apiCalls.actions.AccessToken;
import apiCalls.enums.UserRoles;
import apiCalls.eupaActions.BaseAPI;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;

public class IrhpPermitStockAPI extends BaseAPI {

    private static final String baseResource = "irhp-permit-stock/";

    public static AvailableCountriesModel availableCountries() {
        AccessToken accessToken = new AccessToken();
        updateHeader( "Authorization", "Bearer " + accessToken.getToken(Utils.config.getString("adminUser"), Utils.config.getString("adminPassword"), UserRoles.INTERNAL.asString()));

        URL.build(EnvironmentType.getEnum(Properties.get("env", true)), baseResource.concat("available-countries/?dto=Dvsa%5COlcs%5CTransfer%5CQuery%5CIrhpPermitStock%5CAvailableCountries"));

        ValidatableResponse response = RestUtils.get(String.valueOf(URL.getURL()), getHeaders());

        response.statusCode(HttpStatus.SC_OK);
        prettyPrintJson(response.extract().asString());

        return response.extract().as(AvailableCountriesModel.class);
    }
}
