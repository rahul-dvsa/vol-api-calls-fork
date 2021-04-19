package apiCalls.eupaActions.internal;

import activesupport.http.RestUtils;
import activesupport.system.Properties;
import apiCalls.Utils.eupaBuilders.internal.irhp.permit.stock.OpenByCountryModel;
import apiCalls.Utils.generic.Utils;
import apiCalls.eupaActions.BaseAPI;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.dvsa.testing.lib.url.api.URL;
import org.dvsa.testing.lib.url.utils.EnvironmentType;

import java.util.List;
import java.util.stream.IntStream;

public class IrhpPermitWindowAPI extends BaseAPI {

    private static String baseResource = "irhp-permit-window/";
    private static ValidatableResponse response;
    private static String apiHeader = Utils.config.getString("apiHeader");

    public static OpenByCountryModel openByCountry(String... countryIds) {
        String oldXPID = getHeader("x-pid"); // Needed as other calls might expect an external x-pid
        updateHeader("x-pid", apiHeader);
        String path = "open-by-country/?dto=Dvsa%5COlcs%5CTransfer%5CQuery%5CIrhpPermitWindow%5COpenByCountry";

        String countries = IntStream.range(0, countryIds.length)
                .mapToObj(String::valueOf)
                .reduce("", (String accumulator, String idx) -> accumulator.concat("&countries%5B" + idx + "%5D=" + countryIds[Integer.parseInt(idx)]));

        URL.build(EnvironmentType.getEnum(Properties.get("env", true)), baseResource + path.concat(countries));

        response = RestUtils.get(URL.getURL().toString().substring(0, URL.getURL().toString().length() - 1), getHeaders());

        response.statusCode(HttpStatus.SC_OK);
        updateHeader("x-pid", oldXPID);

        return response.extract().as(OpenByCountryModel.class);
    }

    public static OpenByCountryModel openByCountry() {
        List<String> countryIds = IrhpPermitStockAPI.availableCountries().getAllCountryIds();
        return openByCountry(countryIds.toArray(new String[0]));
    }

}
