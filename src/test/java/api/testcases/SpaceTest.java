package api.testcases;

import api.core.ApiManager;
import api.core.ApiMethod;
import api.core.ApiResponse;
import api.entities.spaces.*;
import api.entities.spacesResponse.SpaceResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpaceTest extends BaseTest{

    @Test(groups = {"getTeamsData"})
    public void getSpacesWithStatusCode200(){
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.GET).withEndpoint("/team/{team_id}/space")
                .withPathParams("team_id", teamsEndToEnd.getTeams().get(0).getId().toString()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test(groups = {"getTeamsData","deleteSpace"})
    public void postCreateSpace() throws JsonProcessingException {
        Space spaceTemp = new Space();
        spaceTemp.setName("SpaceTEST");
        spaceTemp.setMultiple_assignees(true);
        Features features = new Features();
        features.setDue_dates(new DueDates(true, false, true, false));
        features.setTime_tracking(new TimeTracking(false));
        features.setTags(new Tags(true));
        features.setTime_estimates(new TimeEstimates(true));
        features.setChecklists(new Checklists(true));
        features.setCustom_fields(new CustomFields(true));
        features.setRemap_dependencies(new RemapDependencies(true));
        features.setDependency_warning(new DependencyWarning(true));
        features.setPortfolios(new Portfolios(true));
        spaceTemp.setFeatures(features);
        ObjectMapper objectMapper1 = new ObjectMapper();
        String spaceJson = objectMapper1.writeValueAsString(spaceTemp);
        System.out.println(spaceJson);

        apiRequest = apiRequestBuilder.withMethod(ApiMethod.POST).withEndpoint("/team/{team_id}/space")
                .withPathParams("team_id", teamsEndToEnd.getTeams().get(0).getId().toString())
                .withBody(new ObjectMapper().writeValueAsString(spaceTemp)).build();
        ApiResponse apiResponse = ApiManager.executeWithBody(apiRequest);
        spaceResponseEndToEnd = apiResponse.getBody(SpaceResponse.class);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test(groups = {"getTeamsData","createSpace","deleteSpace"})
    public void putUpdateSpaceName() throws JsonProcessingException {
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        Space spaceTemp = new Space();
        spaceTemp.setName("Space-Test-update");
        spaceTemp.setMultiple_assignees(true);
        Features features = new Features();
        features.setDue_dates(new DueDates(true, false, true, false));
        features.setTime_tracking(new TimeTracking(false));
        features.setTags(new Tags(true));
        features.setTime_estimates(new TimeEstimates(true));
        features.setChecklists(new Checklists(true));
        features.setCustom_fields(new CustomFields(true));
        features.setRemap_dependencies(new RemapDependencies(true));
        features.setDependency_warning(new DependencyWarning(true));
        features.setPortfolios(new Portfolios(true));
        spaceTemp.setFeatures(features);
        ObjectMapper objectMapper1 = new ObjectMapper();
        String spaceJson = objectMapper1.writeValueAsString(spaceTemp);
        System.out.println(spaceJson);

        apiRequest = apiRequestBuilder.withMethod(ApiMethod.PUT).withEndpoint("/space/{space_id}")
                .withPathParams("space_id", spaceResponseEndToEnd.getId().toString())
                .withBody(new ObjectMapper().writeValueAsString(spaceTemp)).build();
        ApiResponse apiResponse = ApiManager.executeWithBody(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test(groups = {"getTeamsData","createSpace"})
    public void deleteSpace() throws JsonProcessingException {
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.DELETE).withEndpoint("/space/{space_id}")
                .withPathParams("space_id", spaceResponseEndToEnd.getId().toString()).build();
        ApiResponse apiResponse = ApiManager.executeWithBody(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
    }
}
