package api.testcases;

import api.core.ApiManager;
import api.core.ApiMethod;
import api.core.ApiResponse;
import api.entities.tasks.Task;
import api.entities.tasksResponse.TaskResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskTest extends BaseTest{
    @Test(groups = {"getTeamsData","createSpace","createList","deleteSpace"})
    public void getTasksWithStatusCode200(){
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.GET).withEndpoint("/list/{list_id}/task")
                .withPathParams("list_id", listResponseEndToEnd.getId().toString()).build();
        ApiResponse apiResponse = ApiManager.execute(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test(groups = {"getTeamsData","createSpace","createList","deleteSpace"})
    public void createTask() throws JsonProcessingException {
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        Task taskTemp = new Task();
        taskTemp.setName("task-Test");
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.POST).withEndpoint("/list/{list_id}/task")
                .withPathParams("list_id", listResponseEndToEnd.getId().toString())
                .withBody(new ObjectMapper().writeValueAsString(taskTemp)).build();
        taskResponseEndToEnd =  ApiManager.executeWithBody(apiRequest).getBody(TaskResponse.class);
        System.out.println(taskResponseEndToEnd.getId()+" "+taskResponseEndToEnd.getName());
        Assert.assertEquals(taskResponseEndToEnd.getName(), "task-Test");
    }

    @Test(groups = {"getTeamsData","createSpace","createList","createTask","deleteSpace"})
    public void updateTask() throws JsonProcessingException {
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();
        Task taskTemp = new Task();
        taskTemp.setName("task-Test-update");
        apiRequest = apiRequestBuilder.withMethod(ApiMethod.PUT).withEndpoint("/task/{task_id}")
                .withPathParams("task_id", taskResponseEndToEnd.getId().toString())
                .withBody(new ObjectMapper().writeValueAsString(taskTemp)).build();
        taskResponseEndToEnd =  ApiManager.executeWithBody(apiRequest).getBody(TaskResponse.class);
        System.out.println(taskResponseEndToEnd.getId()+" "+taskResponseEndToEnd.getName());
        Assert.assertEquals(taskResponseEndToEnd.getName(), "task-Test-update");
    }

    @Test(groups = {"getTeamsData","createSpace","createList","createTask","deleteSpace"})
    public void deleteTask() throws JsonProcessingException {
        apiRequest.clearPathParams();
        apiRequest.clearQueryParams();

        apiRequest = apiRequestBuilder.withMethod(ApiMethod.DELETE).withEndpoint("/task/{task_id}")
                .withPathParams("task_id", taskResponseEndToEnd.getId().toString()).build();

        ApiResponse apiResponse  =  ApiManager.executeWithBody(apiRequest);
        Assert.assertEquals(apiResponse.getStatusCode(), HttpStatus.SC_NO_CONTENT);

    }
}
