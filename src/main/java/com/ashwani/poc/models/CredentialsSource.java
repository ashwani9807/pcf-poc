package com.ashwani.poc.models;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CredentialsSource {

    private static final Logger LOG = LoggerFactory.getLogger(CredentialsSource.class);

    private static final String VCAP_SERVICES = "VCAP_SERVICES";
    private static final String CERT_AND_KEY_JSONKEY = "certAndKey";
    private static final String KEYSORE_PASSWORD_JSONKEY = "keystorePassword";
    private static final String BASE_URI = "baseUri";

    private UserProvidedService userProvidedService;

    public CredentialsSource(String name) throws IOException {
        userProvidedService = parseUserProvidedService(name);
    }

    public String getBaseUri() {
        return (String) userProvidedService.getCredentials().get(BASE_URI);
    }

    public char[] getKeystorePassword() {
        String password = (String) userProvidedService.getCredentials().get(KEYSORE_PASSWORD_JSONKEY);
        return password.toCharArray();
    }

    public InputStream getJavaKeyStore() throws URISyntaxException {
        String encoded = (String) userProvidedService.getCredentials().get(CERT_AND_KEY_JSONKEY);

        byte[] valueDecoded = Base64.decodeBase64(encoded);
        return new ByteArrayInputStream(valueDecoded);
    }

    public Map<String, Object> getExtraCredentials() {
        return userProvidedService.getCredentials();
    }

    private UserProvidedService parseUserProvidedService(String name) throws IOException {
        try {
            String json = getEnv(VCAP_SERVICES);
            ObjectMapper objectMapper = new ObjectMapper();
            VCAPServices vcapServices = objectMapper.readValue(json, VCAPServices.class);
            return vcapServices.getUserProvidedService(name);
        } catch (final Exception e) {
            LOG.error("Failed to parse user-provided service \"" + name + "\"", e);
            throw e;
        }
    }

    protected String getEnv(String name) {
        String value = System.getenv(name);
        if (value == null) {
            throw new RuntimeException("Missing environment variable " + name);
        }
        return value;
    }

}
