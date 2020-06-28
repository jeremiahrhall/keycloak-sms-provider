package io.github.mths0x5f.keycloak.providers.sms.spi.impl;

import io.github.mths0x5f.keycloak.providers.sms.spi.PhoneMessageService;
import io.github.mths0x5f.keycloak.providers.sms.spi.PhoneMessageServiceProviderFactory;
import org.keycloak.Config.Scope;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class PhoneMessageServiceProviderFactoryImpl implements PhoneMessageServiceProviderFactory {

    private Scope config;

    @Override
    public PhoneMessageService create(KeycloakSession session) {
        return new PhoneMessageServiceImpl(session, config);
    }

    @Override
    public void init(Scope config) {
        this.config = config;
    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {
    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return "default";
    }
}
