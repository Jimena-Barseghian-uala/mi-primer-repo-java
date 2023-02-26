package com.uala.services.handler;


import com.uala.lambda.support.exceptions.LambdaException;
import com.uala.lambda.support.handler.ObjectProcessorHandlerSupport;
import com.uala.lambda.support.utils.validator.InputValidator;
import com.uala.services.error.MiPrimerError;
import com.uala.services.processor.MiPrimerProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MiPrimerHandler extends ObjectProcessorHandlerSupport {
    private static final Logger log = LoggerFactory.getLogger(MiPrimerHandler.class);

    public MiPrimerHandler(MiPrimerProcessor processor) {
        this.processor = processor;
    }

    public MiPrimerHandler() {
        this.processor = new MiPrimerProcessor();
    }

    @Override
    public void validateInput(Map input) throws LambdaException {
        InputValidator.requireNonEmpty(input.getOrDefault("username", "").toString(),
                MiPrimerError.INVALID_USERNAME);
        super.validateInput(input);
    }
}
