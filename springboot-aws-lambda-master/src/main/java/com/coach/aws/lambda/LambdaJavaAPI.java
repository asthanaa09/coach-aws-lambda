package com.coach.aws.lambda;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.coach.aws.lambda.domain.Catalog;
import com.coach.aws.lambda.respository.CatalogRepository;
import com.coach.aws.lambda.respository.StudentRepository;

@SpringBootApplication
public class LambdaJavaAPI implements RequestHandler<APIGatewayProxyRequestEvent, GatewayResponse> {

	StudentRepository studentRepository;
	CatalogRepository catalogRepository;
	
	private ApplicationContext getApplicationContext(String [] args) {
        return new SpringApplicationBuilder(LambdaJavaAPI.class)
                .run(args);
    }
	
	/**
     * Parameters:
     * 	id = 1 - for given id delete user
     * 
     */
    @Override
    public GatewayResponse handleRequest(APIGatewayProxyRequestEvent event, Context context) {
    	initRepositories();
    	Map<String, String> parameters = event.getQueryStringParameters();
    	System.out.println("0 "+  parameters);
    	Long stydentID = Long.parseLong(parameters.get("studentID"));
    	Long subjectID = Long.parseLong(parameters.get("subjectID"));
    	
    	if(stydentID == null || subjectID == null)
    		return buildResponse("Missing student/subject ids", HttpStatus.BAD_REQUEST.value(), Collections.singletonMap("X-Powered-By", "Test App"), false);
    	
		Catalog catalog = catalogRepository.findByStudentIDAndSubjectID(stydentID, subjectID);
		catalog.setRemoved(true);
		catalogRepository.save(catalog);
		String message = "Successfully Deleted";
         
        return buildResponse(message, 200, Collections.singletonMap("X-Powered-By", "Test App"), false);
    }
    
    private GatewayResponse buildResponse(String message, Integer statusCode, Map<String, String> headers, boolean isBase64Encoded) {
    	 return new GatewayResponse(
                 message,
                 statusCode,
                 headers,
                 isBase64Encoded
         );
    }
    
    private void initRepositories() {
    	ApplicationContext ctx = getApplicationContext(new String[]{});
 		studentRepository= ctx.getBean(StudentRepository.class);
 		catalogRepository = ctx.getBean(CatalogRepository.class);
    }
}
