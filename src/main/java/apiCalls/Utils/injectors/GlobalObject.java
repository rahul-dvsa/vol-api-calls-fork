package apiCalls.Utils.injectors;

import apiCalls.actions.CreateApplication;
import apiCalls.actions.GetApplicationDetails;
import apiCalls.actions.GetUserDetails;
import apiCalls.actions.RegisterUser;

public class GlobalObject {
    public CreateApplication createApplication;
    public RegisterUser registerUser;
    public GetApplicationDetails getApplicationDetails;
    public GetUserDetails getUserDetails;
}