package com.uala.services.processor;

import com.uala.lambda.support.exceptions.LambdaException;
import com.uala.lambda.support.processor.BaseObjectProcessor;
import com.uala.services.model.MiPrimerInput;
import com.uala.services.model.MiPrimerOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiPrimerProcessor extends BaseObjectProcessor<MiPrimerInput, MiPrimerOutput> {
    private static final Logger log = LoggerFactory.getLogger(MiPrimerProcessor.class);

    @Override
    public MiPrimerOutput process(MiPrimerInput miPrimerInput) throws LambdaException {
        log.info("Hola Mundo!");
        if ("MilesMorales".equals(miPrimerInput.getUsername())) {
            return new MiPrimerOutput(true);
        }
        return new MiPrimerOutput(false);
    }

    @Override
    public Class<MiPrimerInput> getMapperClass() {
        return MiPrimerInput.class;
    }
}
