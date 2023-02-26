package com.uala.services.handler;

import com.uala.lambda.support.exceptions.LambdaException;
import com.uala.lambda.support.handler.ObjectProcessorHandlerSupport;
import com.uala.lambda.support.utils.validator.InputValidator;
import com.uala.services.processor.ContactProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.uala.services.error.ContactError;

import java.util.Map;

public class ContactHandler extends ObjectProcessorHandlerSupport {
    private static final Logger log = LoggerFactory.getLogger(ContactHandler.class);

    public ContactHandler(ContactProcessor processor) {
        this.processor = processor;
    }

    public ContactHandler() {
        this.processor = new ContactProcessor();
    }

    @Override
    public void validateInput(Map input) throws LambdaException {
        InputValidator.requireNonEmpty(input.getOrDefault("firstName", "").toString(),
                ContactError.INVALID_FIRSTNAME);
        InputValidator.requireNonEmpty(input.getOrDefault("lastName", "").toString(),
                ContactError.INVALID_LASTNAME);
        super.validateInput(input);
    }
}
