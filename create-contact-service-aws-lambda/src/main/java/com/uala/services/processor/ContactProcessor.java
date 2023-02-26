package com.uala.services.processor;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.uala.lambda.support.exceptions.LambdaException;
import com.uala.lambda.support.processor.BaseObjectProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.uala.services.model.ContactInput;
import com.uala.services.model.ContactOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ContactProcessor extends BaseObjectProcessor<ContactInput, ContactOutput> {
    private static final Logger log = LoggerFactory.getLogger(ContactProcessor.class);
    private AmazonDynamoDB amazonDynamoDB;
    private String DYNAMODB_TABLE_NAME = "Contacts";
    private Regions REGION = Regions.US_EAST_1;

    @Override
    public ContactOutput process(ContactInput contactInput) throws LambdaException {
        log.info("Create Contact");
        this.initDynamoDbClient();

        persistData(contactInput);
        return new ContactOutput("Contact Saved.");
    }

    private void persistData(ContactInput contactRequest) throws ConditionalCheckFailedException {
        Map<String, AttributeValue> attributesMap = new HashMap<>();

        attributesMap.put("id", new AttributeValue(String.valueOf(UUID.randomUUID())));
        attributesMap.put("firstName", new AttributeValue(contactRequest.getFirstName()));
        attributesMap.put("lastName", new AttributeValue(contactRequest.getLastName()));
        attributesMap.put("status", new AttributeValue("CREATED"));

        amazonDynamoDB.putItem(DYNAMODB_TABLE_NAME, attributesMap);
    }

    private void initDynamoDbClient() {
        this.amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withRegion(REGION)
                .build();
    }

    @Override
    public Class<ContactInput> getMapperClass() {
        return ContactInput.class;
    }
}
